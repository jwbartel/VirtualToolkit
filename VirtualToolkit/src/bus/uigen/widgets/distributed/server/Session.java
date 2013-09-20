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

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;
import bus.uigen.widgets.distributed.nongwt.CallSender;
import bus.uigen.widgets.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.distributed.server.ApplicationStarter.Argument;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;
import bus.uigen.widgets.exceptions.DuplicateRegistrationException;
import bus.uigen.widgets.exceptions.UndefinedPipingReplica;

public class Session {

	String sessionName;
	ArrayList<String> sharedListeners;
	ArrayList<Argument> args;

	boolean fromConfigFile;
	Map<String, APipingReplica> pipingReplicaMap = new TreeMap<String, APipingReplica>();

	Set<String[]> members = new HashSet<String[]>();
	Map<String, ClientEndAndProgramPackage> directCommunicators = new TreeMap<String, ClientEndAndProgramPackage>();// Those
																													// who
																													// have
																													// identified
																													// replicaIDs
																													// and
																													// don't
																													// require
																													// centralized
																													// communication

	ArrayList<Command> globalBuffer = new ArrayList<Command>();

	public ArrayList<String> getCentralizedListenerWidgets() {
		return sharedListeners;
	}

	private static class ClientEndAndProgramPackage {
		public String uniqueRegistrarID;
		public String program;

		public ClientEndAndProgramPackage(String uniqueRegistrarID,
				String program) {
			this.uniqueRegistrarID = uniqueRegistrarID;
			this.program = program;
		}
	}

	public Session(boolean fromConfigFile, String name) {
		this.fromConfigFile = fromConfigFile;
		this.sessionName = name;
	}

	public void registerRmiClientEnd(String uniqueRegistrarID,
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) throws CollaborativeException,
			MalformedURLException, RemoteException, NotBoundException {

		// Look up the piping replica
		APipingReplica pipingReplica = pipingReplicaMap.get(programDescription
				.getKind());
		if (pipingReplica == null) {

			// If this was set up from a config file and now piping replica is
			// found,
			// then there is an exception
			if (fromConfigFile) {
				throw new UndefinedPipingReplica("The piping replica for "
						+ programDescription.getKind()
						+ " is not defined in the config file");
			}

			// Create and register a new piping replica for this kind
			pipingReplica = new APipingReplica(programDescription.getKind(),
					this);
			pipingReplicaMap.put(programDescription.getKind(), pipingReplica);
		}

		if (!communicationCentralized && replicaID != null) {
			if (directCommunicators.containsKey(replicaID)) {
				throw new DuplicateRegistrationException(
						"Duplicate replica id:" + replicaID + " in session:"
								+ sessionName);
			}

			Iterator<String> directCommsIter = directCommunicators.keySet()
					.iterator();
			while (directCommsIter.hasNext()) {
				String directCommunicator = directCommsIter.next();

				if (!directCommunicator.equals(replicaID)) {

					String otherCommunicatorUniqueID = directCommunicators
							.get(directCommunicator).uniqueRegistrarID;

					String thisRmiID = ADistributedRMIWidgetServer
							.getRmiID(uniqueRegistrarID);
					String otherCommunicatorRmiID = ADistributedRMIWidgetServer
							.getRmiID(otherCommunicatorUniqueID);

					RmiClientEnd thisCommunicator = (RmiClientEnd) Naming
							.lookup(thisRmiID);
					RmiClientEnd otherCommunicator = (RmiClientEnd) Naming
							.lookup(otherCommunicatorRmiID);

					thisCommunicator.addDirectCommunicator(directCommunicator,
							otherCommunicatorUniqueID);
					otherCommunicator.addDirectCommunicator(replicaID,
							uniqueRegistrarID);

				}
			}

			directCommunicators.put(replicaID, new ClientEndAndProgramPackage(
					uniqueRegistrarID, programDescription.getKind()));
		}

		String[] member = { replicaID, uniqueRegistrarID };
		members.add(member);

		pipingReplica.registerRmiClientEnd(uniqueRegistrarID,
				programDescription, replicaID, widgetsReplicated,
				isCentralProgram);

	}

	public void initFromConfig(ArrayList<String> programs,
			ArrayList<String> sharedListenerWidgets, ArrayList<Argument> args) {
		this.sharedListeners = sharedListenerWidgets;
		this.args = args;

		for (int i = 0; i < programs.size(); i++) {
			APipingReplica pipingReplica = new APipingReplica(programs.get(i),
					this);
			pipingReplicaMap.put(programs.get(i), pipingReplica);
		}
	}

	public void broadcastCommand(Command command) throws MalformedURLException,
			RemoteException, NotBoundException {

		boolean directCommunicationCapable = command.getReplicaID() != null
				&& directCommunicators.containsKey(command.getReplicaID());

		PipingReplica pipingReplica = pipingReplicaMap.get(command.getKind());
		pipingReplica.broadcastCommand(command, directCommunicationCapable);

	}

	public boolean canDirectlyCommunicate(String replicaID) {
		return replicaID != null && directCommunicators.containsKey(replicaID);
	}

	public synchronized int getGlobalSequenceNumber(Command command) {
		if (command.getSequenceNumber() != -1
				&& command.getSequenceNumber() < globalBuffer.size()) {
			Command bufferedCommand = globalBuffer.get(command
					.getSequenceNumber());
			if (bufferedCommand != null && bufferedCommand.equals(command)) {
				return command.getSequenceNumber();
			}
		}

		int seqNum = globalBuffer.size();
		command.setSequenceNumber(seqNum);
		globalBuffer.add(command);
		return seqNum;
	}

	public void broadcastUpdateCommand(Command command)
			throws MalformedURLException, RemoteException, NotBoundException {

		if (command.getSequenceNumber() == -1) {
			command.setSequenceNumber(getGlobalSequenceNumber(command));
		}

		boolean srcDirectCommunicator = canDirectlyCommunicate(command
				.getReplicaID());

		Iterator<String[]> membersIter = members.iterator();
		while (membersIter.hasNext()) {
			String[] member = membersIter.next();

			String replicaID = member[0];
			String uniqueReplicaID = member[1];

			if (srcDirectCommunicator && canDirectlyCommunicate(replicaID)
					&& !command.getSource().equals(uniqueReplicaID)) {
				continue;
			}

			RmiClientEnd memberClient = (RmiClientEnd) Naming
					.lookup(ADistributedRMIWidgetServer
							.getRmiID(uniqueReplicaID));

			CallSender sender = new CallSender(memberClient, command,
					uniqueReplicaID);
			sender.start();
		}

		// TODO:
	}

	public void sendListener(VirtualListener listener, String id, String program)
			throws MalformedURLException, RemoteException, NotBoundException {
		PipingReplica pipingReplica = pipingReplicaMap.get(program);
		pipingReplica.sendListener(listener, id);
	}

	public PipingReplica getPipingReplica(String program) {
		return pipingReplicaMap.get(program);
	}

	public ArrayList<Command> getGlobalBuffer() {
		return globalBuffer;
	}
}
