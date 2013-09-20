package bus.uigen.widgets.distributed.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;
import bus.uigen.widgets.distributed.nongwt.CallSender;
import bus.uigen.widgets.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;
import bus.uigen.widgets.exceptions.DuplicateRegistrationException;
import bus.uigen.widgets.exceptions.WrapperException;
import bus.uigen.widgets.forwarder.ForwarderToolkit;

public class APipingReplica implements PipingReplica {

	String centralProgramID;
	WidgetServer centralProgram;

	String programKind;
	String firstBuiltClient;
	Session session;

	ArrayList<String> sharedListenerWidgets;

	Set<String[]> members = new HashSet<String[]>();

	ArrayList<Command> commands = new ArrayList<Command>();

	Map<String, Boolean> isBuildingApplication = new TreeMap<String, Boolean>();
	Map<String, ArrayList<Command>> clientBuildingBuffers = new TreeMap<String, ArrayList<Command>>();
	ArrayList<Command> buildingBuffer = new ArrayList<Command>();
	Set<String> unbuiltGenericClients = new TreeSet<String>();

	Map<String, VirtualListener> listeners = new TreeMap<String, VirtualListener>();

	public APipingReplica(String programKind, Session session) {
		this.programKind = programKind;
		this.session = session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#buildGenericCentralProgram()
	 */
	@Override
	public void buildGenericCentralProgram(ProgramDescription programDescription) {
		// Create a program that only contains a frame with no UI elements
		VirtualToolkit.setDefaultToolkit(new ForwarderToolkit(
				programDescription, this));
		VirtualFrame frame = FrameSelector.createFrame();
		VirtualToolkit.start(frame);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#setSharedListenerWidgets(java
	 * .util.ArrayList)
	 */
	@Override
	public void setSharedListenerWidgets(ArrayList<String> sharedListenerWidgets) {
		this.sharedListenerWidgets = sharedListenerWidgets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#getSharedListenerWidgets()
	 */
	@Override
	public ArrayList<String> getSharedListenerWidgets() {
		return sharedListenerWidgets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#registerRmiClientEnd(java.
	 * lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	public void registerRmiClientEnd(String rmiClientEndID,
			ProgramDescription programDescription, String replicaID,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws CollaborativeException {

		if (isCentralProgram) {
			if (centralProgramID != null || centralProgram != null) {
				// If this marks itself as the central program, but there
				// already exists one,
				// throw an exception due to the duplication
				throw new DuplicateRegistrationException(
						"Duplicate central program");
			}
			centralProgramID = rmiClientEndID;
		} else {
			if (centralProgramID == null && centralProgram == null) {
				// If there is no central program for this kind, generate a
				// generic central program
				// for this kind that contains no UI elements
				buildGenericCentralProgram(programDescription);
			}
		}

		String[] member = { replicaID, rmiClientEndID };
		members.add(member);

		if (!isBuildingApplication.containsKey(rmiClientEndID)) {
			isBuildingApplication.put(rmiClientEndID, true);
			clientBuildingBuffers.put(rmiClientEndID, new ArrayList<Command>());
		} else {
			throw new DuplicateRegistrationException("Duplicate rmiClientID");
		}

		Iterator<String> listenerIdIter = listeners.keySet().iterator();
		while (listenerIdIter.hasNext()) {
			String listenerID = listenerIdIter.next();
			VirtualListener listener = listeners.get(listenerID);

			try {
				RmiClientEnd client = (RmiClientEnd) Naming
						.lookup(ADistributedRMIWidgetServer
								.getRmiID(rmiClientEndID));
				client.receiveListener(listener, listenerID, programKind,
						rmiClientEndID);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (java.rmi.RemoteException e) {
				throw new WrapperException(e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#broadcastCommand(bus.uigen
	 * .widgets.Command, boolean)
	 */
	@Override
	public void broadcastCommand(Command command,
			boolean directCommunicationCapable) throws CollaborativeException {

		String text = command.getText();
		String src = command.getSource();

		if (text.indexOf(VirtualToolkit.COMMAND_LABEL
				+ VirtualToolkit.COMMAND_START) == 0) {
			if (firstBuiltClient == null
					&& clientBuildingBuffers.get(command.getSource()).size() > 1) {
				// Mark when a client completes building the application the
				// first time
				firstBuiltClient = command.getSource();
				buildingBuffer = clientBuildingBuffers.get(command.getSource());
				// command.setSequenceNumber(buildingBuffer.size()+1);
				while (buildingBuffer.size() < command.getSequenceNumber()) {
					buildingBuffer.add(null);
				}
				buildingBuffer.set(command.getSequenceNumber() - 1, command);
			}
			isBuildingApplication.put(src, false); // The src is no longer
													// building an application

			if (firstBuiltClient != null
					&& firstBuiltClient.equals(command.getSource())) {
				// command.setSequenceNumber(clientBuildingBuffers.get(command.getSource()).size());

				// If this has found a client that has completed building the
				// program, alert everyone else

				Iterator<String[]> membersIter = members.iterator();
				while (membersIter.hasNext()) {
					String[] member = membersIter.next();

					String memberUniqueID = member[1];

					if (memberUniqueID.equals(programKind
							+ ForwarderToolkit.NAME_SUFFIX)) {

						for (int i = 0; i < buildingBuffer.size(); i++) {

							centralProgram.commandReceived(
									buildingBuffer.get(i), memberUniqueID);
						}

					} else {

						String memberClientRmiID = ADistributedRMIWidgetServer
								.getRmiID(memberUniqueID);// genericClientUniqueID;
						// if(genericClientRmiID.lastIndexOf('_')>=0 &&
						// genericClientRmiID.substring(genericClientRmiID.lastIndexOf('_')+1).matches("\\d+")){
						// genericClientRmiID = genericClientRmiID.substring(0,
						// genericClientRmiID.lastIndexOf('_'));
						// }
						RmiClientEnd rmiClient;
						try {
							rmiClient = (RmiClientEnd) Naming
									.lookup(memberClientRmiID);
						} catch (MalformedURLException e) {
							throw new WrapperException(e.getMessage());
						} catch (RemoteException e) {
							throw new WrapperException(e.getMessage());
						} catch (NotBoundException e) {
							throw new WrapperException(e.getMessage());
						}

						for (int i = 0; i < buildingBuffer.size(); i++) {
							if (buildingBuffer.get(i) == null)
								continue;
							CallSender sender = new CallSender(rmiClient,
									buildingBuffer.get(i), memberUniqueID);
							sender.start();
						}
					}

				}

				/*
				 * membersIter = members.iterator();
				 * while(membersIter.hasNext()){
				 * 
				 * String[] member = membersIter.next();
				 * 
				 * String memberUniqueReplicaID = member[1]; //String
				 * memberRmiID = memberUniqueReplicaID;
				 * 
				 * if(!src.equals(memberUniqueReplicaID)){
				 * 
				 * String memberRmiID =
				 * WidgetServer.getRmiID(memberUniqueReplicaID);
				 * 
				 * RmiClientEnd client = (RmiClientEnd)
				 * Naming.lookup(memberRmiID);
				 * 
				 * CallSender sender = new CallSender(rmiClient, command,
				 * memberUniqueID); sender.start();
				 * 
				 * 
				 * } }
				 */

			} else if (firstBuiltClient != null) {// &&
													// clientBuildingBuffers.get(src).size()
													// == 1){

				RmiClientEnd sourceEnd;
				try {
					sourceEnd = (RmiClientEnd) Naming
							.lookup(ADistributedRMIWidgetServer.getRmiID(src));
				} catch (MalformedURLException e) {
					throw new WrapperException(e.getMessage());
				} catch (RemoteException e) {
					throw new WrapperException(e.getMessage());
				} catch (NotBoundException e) {
					throw new WrapperException(e.getMessage());
				}

				for (int i = 0; i < buildingBuffer.size(); i++) {
					CallSender sender = new CallSender(sourceEnd,
							buildingBuffer.get(i), src);
					sender.start();
				}

			} else if (clientBuildingBuffers.get(command.getSource()).size() == 1) {
				unbuiltGenericClients.add(src);
			}

			ArrayList<Command> globalBuffer = session.getGlobalBuffer();
			for (int i = 0; i < globalBuffer.size(); i++) {
				if (src.equals(programKind + ForwarderToolkit.NAME_SUFFIX)) {

					for (int j = 0; j < globalBuffer.size(); j++) {

						centralProgram
								.commandReceived(globalBuffer.get(j), src);
					}

				} else {

					String clientRmiID = ADistributedRMIWidgetServer
							.getRmiID(src);
					RmiClientEnd rmiClient;
					try {
						rmiClient = (RmiClientEnd) Naming.lookup(clientRmiID);
					} catch (MalformedURLException e) {
						throw new WrapperException(e.getMessage());
					} catch (RemoteException e) {
						throw new WrapperException(e.getMessage());
					} catch (NotBoundException e) {
						throw new WrapperException(e.getMessage());
					}

					for (int j = 0; j < globalBuffer.size(); j++) {
						if (globalBuffer.get(i) == null)
							continue;
						CallSender sender = new CallSender(rmiClient,
								globalBuffer.get(i), src);
						sender.start();
					}
				}
			}

			return;
		}

		if (command.isInitial()) {
			// Is an initial call

			ArrayList<Command> buffer = clientBuildingBuffers.get(src);
			while (buffer.size() < command.getSequenceNumber()) {
				buffer.add(null);
			}
			buffer.set(command.getSequenceNumber() - 1, command);
			if (buffer == buildingBuffer) {

				Iterator<String[]> membersIter = members.iterator();
				while (membersIter.hasNext()) {

					String[] member = membersIter.next();

					String memberUniqueReplicaID = member[1];
					// String memberRmiID = memberUniqueReplicaID;

					if (!src.equals(memberUniqueReplicaID)) {

						if (memberUniqueReplicaID.equals(programKind
								+ ForwarderToolkit.NAME_SUFFIX)) {
							centralProgram.commandReceived(command,
									memberUniqueReplicaID);
						} else {
							String memberRmiID = ADistributedRMIWidgetServer
									.getRmiID(memberUniqueReplicaID);

							RmiClientEnd client;
							try {
								client = (RmiClientEnd) Naming
										.lookup(memberRmiID);
							} catch (MalformedURLException e) {
								throw new WrapperException(e.getMessage());
							} catch (RemoteException e) {
								throw new WrapperException(e.getMessage());
							} catch (NotBoundException e) {
								throw new WrapperException(e.getMessage());
							}

							CallSender sender = new CallSender(client, command,
									memberUniqueReplicaID);
							sender.start();
						}

					}
				}

			}
		} else {
			// Is an update call

			try {
				session.broadcastUpdateCommand(command);
			} catch (MalformedURLException e) {
				throw new WrapperException(e.getMessage());
			} catch (RemoteException e) {
				throw new WrapperException(e.getMessage());
			} catch (NotBoundException e) {
				throw new WrapperException(e.getMessage());
			}
			// TODO: use forwarder toolkit
			// TODO: foward to session to hold in global buffer and send out
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#sendListener(bus.uigen.widgets
	 * .events.VirtualListener, java.lang.String)
	 */
	@Override
	public void sendListener(VirtualListener listener, String id)
			throws CollaborativeException {
		if (listener == null || id == null)
			return;
		Iterator<String[]> membersIter = members.iterator();

		listeners.put(id, listener);
		while (membersIter.hasNext()) {
			String[] member = membersIter.next();

			String memberUniqueReplicaID = member[1];

			if (memberUniqueReplicaID.equals(programKind
					+ ForwarderToolkit.NAME_SUFFIX)) {
				centralProgram.listenerReceived(listener, id, programKind,
						memberUniqueReplicaID);
			} else {
				String memberRmiID = ADistributedRMIWidgetServer
						.getRmiID(memberUniqueReplicaID);

				RmiClientEnd client;
				try {
					client = (RmiClientEnd) Naming.lookup(memberRmiID);
					client.receiveListener(listener, id, programKind,
							memberUniqueReplicaID);
				} catch (MalformedURLException e) {
					throw new WrapperException(e.getMessage());
				} catch (RemoteException e) {
					throw new WrapperException(e.getMessage());
				} catch (NotBoundException e) {
					throw new WrapperException(e.getMessage());
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bus.uigen.distributed.server.PipingReplica#getProgramName()
	 */
	@Override
	public String getProgramKind() {
		return programKind;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.distributed.server.PipingReplica#setCentralWidgetServer(bus
	 * .uigen.widgets.forwarder.ForwarderWidgetServer)
	 */
	@Override
	public void setCentralWidgetServer(WidgetServer widgetServer) {
		this.centralProgram = widgetServer;
		String[] member = { null, programKind + ForwarderToolkit.NAME_SUFFIX };
		members.add(member);
		isBuildingApplication.put(member[1], true);
		clientBuildingBuffers.put(member[1], new ArrayList<Command>());
	}

}
