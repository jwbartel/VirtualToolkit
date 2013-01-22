package bus.uigen.widgets.distributed.nongwt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.server.NameServerStarter;
import bus.uigen.widgets.distributed.server.RmiServerEnd;
import bus.uigen.widgets.events.VirtualListener;

public class AnRmiClientEnd extends UnicastRemoteObject implements RmiClientEnd {
	private static final long serialVersionUID = 1L;

	Set<DirectCommunicator> directCommunicators = new HashSet<DirectCommunicator>();
	ArrayList<CallsListener> listeners = new ArrayList<CallsListener>();

	ProgramDescription programDescription;
	String replicaID;
	String uniqueReplicaID;
	String uniqueRmiID;

	public AnRmiClientEnd() throws RemoteException {
		// init(userDefinedID);
	}

	private void init(ProgramDescription programDescription, String replicaID,
			String uniqueIdOnServer, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws RemoteException {
		this.programDescription = programDescription;
		this.uniqueReplicaID = uniqueIdOnServer;

		if (this.uniqueRmiID == null) {
			// Update the unique RMI id byase on the unique ID on the server
			int endPt = uniqueIdOnServer.lastIndexOf("_");

			if (endPt != -1
					&& uniqueIdOnServer.substring(endPt + 1).matches("\\d+")) {
				this.uniqueRmiID = uniqueIdOnServer.substring(0, endPt);
			} else {
				this.uniqueRmiID = uniqueIdOnServer;
			}
		}

		// Register the RMI client end with the registrar
		NameServerStarter.getRegistrar(programDescription.getServer(),
				programDescription.getPort()).registerRmiClientEnd(
				uniqueReplicaID, this, programDescription, replicaID,
				communicationCentralized, widgetsReplicated, isCentralProgram);

	}

	public void close() throws RemoteException {
		try {
			Naming.unbind(uniqueRmiID);
			// TODO:remove from RmiServerEnd
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public void send(Command command) throws RemoteException {

		RmiServerEnd registrar = NameServerStarter.getRegistrar(
				programDescription.getServer(), programDescription.getPort());

		if (!command.isInitial()) {
			command.setSequenceNumber(registrar
					.getGlobalSequenceNumber(command));

			Iterator<DirectCommunicator> directCommunicatorsIter = directCommunicators
					.iterator();
			while (directCommunicatorsIter.hasNext()) {

				DirectCommunicator communicator = directCommunicatorsIter
						.next();
				try {
					RmiClientEnd rmiCommunicator = (RmiClientEnd) Naming
							.lookup(ADistributedRMIWidgetServer
									.getRmiID(communicator.getUniqueReplicaID()));
					CallSender sender = new CallSender(rmiCommunicator,
							command, communicator.getUniqueReplicaID());
					sender.start();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				}
			}
		}

		registrar.broadcastCommand(command);
	}

	public void join(ProgramDescription programDescription, String replicaID,
			String uniqueIdOnServer, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws RemoteException {
		this.replicaID = replicaID;
		init(programDescription, replicaID, uniqueIdOnServer,
				communicationCentralized, widgetsReplicated, isCentralProgram);
	}

	/*
	 * public synchronized void updateCommands(ArrayList<Command> commands){
	 * for(int i=0; i<listeners.size(); i++){
	 * listeners.get(i).updateCommands(commands); } }
	 */

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program)
			throws RemoteException {
		NameServerStarter.getRegistrar(programDescription.getServer(),
				programDescription.getPort()).broadcastListener(listener, id,
				application, session, program);
	}

	public void receiveListener(VirtualListener listener, String listenerID,
			String program, String destination) {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).listenerReceived(listener, listenerID, program,
					destination);
		}
	}

	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		for (int i = 0; i < listeners.size(); i++) {
			this.listeners.get(i).updateListeners(vlisteners);
		}
	}

	public void addCallsListener(CallsListener listener) throws RemoteException {
		listeners.add(listener);
	}

	public ArrayList<Command> getCommands() throws RemoteException {
		return NameServerStarter.getRegistrar(programDescription.getServer(),
				programDescription.getPort()).getCommands();
	}

	/*
	 * public Map<String, VirtualListener> getListeners() throws
	 * RemoteException{ return RegistrarStarter.getRegistrar(server,
	 * port).getListeners(); }
	 */

	public void addDirectCommunicator(String replicaID, String uniqueReplicaID)
			throws RemoteException {
		directCommunicators.add(new DirectCommunicator(replicaID,
				uniqueReplicaID));
	}

	public void receiveCommand(Command command, String recipient)
			throws RemoteException {

		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).commandReceived(command, recipient);
		}
	}

}
