package bus.uigen.widgets.distributed.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.nongwt.ADistributedRMIWidgetServer;
import bus.uigen.widgets.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.distributed.server.ApplicationStarter.Argument;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;
import bus.uigen.widgets.exceptions.DuplicateRegistrationException;

public class AnRmiServerEnd extends UnicastRemoteObject implements RmiServerEnd {
	private static final long serialVersionUID = 1L;

	String firstClient;
	ArrayList<String> clients = new ArrayList<String>();
	ArrayList<Command> commands = new ArrayList<Command>();
	Map<String, Boolean> isBuildingApplication = new TreeMap<String, Boolean>();
	// Map<String, VirtualListener> listeners = new TreeMap<String,
	// VirtualListener>();
	Map<String, SessionServer> sessionServerMap = new TreeMap<String, SessionServer>();

	public AnRmiServerEnd() throws RemoteException {

	}

	public synchronized void registerRmiClientEnd(String uniqueRegistrarEndID,
			RmiClientEnd rmiClientEnd, ProgramDescription programDescription,
			String replicaID, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws RemoteException {

		// Look up the session server
		SessionServer sessionServer = sessionServerMap.get(programDescription
				.getApp());
		if (sessionServer == null) {
			// Create one if a session server does not exist
			sessionServer = new SessionServer();
			sessionServerMap.put(programDescription.getApp(), sessionServer);
		}

		try {
			// Determine the rmiClientID
			String rmiClientID;
			int end = uniqueRegistrarEndID.lastIndexOf('_');
			if (end >= 0
					&& uniqueRegistrarEndID.substring(end + 1).matches("\\d+")) {
				rmiClientID = uniqueRegistrarEndID.substring(0, end);
			} else {
				rmiClientID = uniqueRegistrarEndID;
			}

			// Bind the the rmiClient to its ID
			Naming.rebind(rmiClientID, rmiClientEnd);

			// Check for duplicate client IDs
			if (!clients.contains(uniqueRegistrarEndID)) {
				clients.add(uniqueRegistrarEndID);
				sessionServer.registerRmiClientEnd(uniqueRegistrarEndID,
						programDescription, replicaID,
						communicationCentralized, widgetsReplicated,
						isCentralProgram);
			} else {
				throw new DuplicateRegistrationException(
						"Duplicate unique client ID");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (CollaborativeException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public synchronized void broadcastCommand(Command command)
			throws RemoteException {
		try {

			SessionServer sessionServer = sessionServerMap.get(command
					.getApplication());
			sessionServer.broadcastCommand(command);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		/*
		 * //System.out.print("broadcasting command: "+command +"..."); String
		 * text = command.getText(); String src = command.getSource();
		 * 
		 * if(text.indexOf(VirtualToolkit.COMMAND_LABEL+VirtualToolkit.COMMAND_START
		 * )==0){ isBuildingApplication.put(src, false);
		 * if(!src.equals(firstClient)){ return; } }
		 * 
		 * 
		 * if(!src.equals(firstClient) && isBuildingApplication.get(src)){
		 * return; }
		 * 
		 * commands.add(command);
		 * 
		 * for(int i=0; i<clients.size(); i++){
		 * 
		 * try {
		 * 
		 * RmiClientEnd rmiClient = (RmiClientEnd)
		 * Naming.lookup(clients.get(i)); Thread messageSender = new
		 * CallSender(rmiClient, commands); messageSender.start();
		 * 
		 * } catch (Exception e) { //e.printStackTrace(); } }
		 * 
		 * //System.out.println("finished");
		 */
	}

	public void broadcastListener(VirtualListener listener, String id,
			String application, String session, String program)
			throws RemoteException {
		try {
			SessionServer sessionServer = sessionServerMap.get(application);
			sessionServer.sendListener(listener, id, session, program);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}

		/*
		 * listeners.put(id, listener);
		 * 
		 * 
		 * for(int i=0; i<clients.size(); i++){ try { String client =
		 * clients.get(i);
		 * 
		 * RmiClientEnd rmiClient = (RmiClientEnd) Naming.lookup(client);
		 * rmiClient.updateListeners(listeners); } catch (Exception e) {
		 * //e.printStackTrace(); } }
		 */
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}

	/*
	 * public Map<String, VirtualListener> getListeners(){ return listeners; }
	 */

	public void registerApplication(String applicationName,
			ArrayList<String> programs,
			ArrayList<String> sharedListenerWidgets, ArrayList<Argument> args)
			throws RemoteException, CollaborativeException {

		SessionServer sessionServer = sessionServerMap.get(applicationName);
		if (sessionServer == null) {
			sessionServer = new SessionServer(true);
			sessionServerMap.put(applicationName, sessionServer);
		} else {
			throw new DuplicateRegistrationException("Application "
					+ applicationName + " already exists on the server");
		}

		sessionServer
				.registerApplication(programs, sharedListenerWidgets, args);
	}

	public int getGlobalSequenceNumber(Command command) {
		SessionServer sessionServer = sessionServerMap.get(command
				.getApplication());
		return sessionServer.getGlobalSequenceNumber(command);
	}

	public PipingReplica getPipingReplica(String joinDescription) {
		String[] joinDescriptionElements = ADistributedRMIWidgetServer
				.parseJoinDescription(joinDescription);
		return getPipingReplica(joinDescriptionElements[1],
				joinDescriptionElements[2], joinDescriptionElements[3]);
	}

	public PipingReplica getPipingReplica(String application, String session,
			String program) {
		SessionServer sessionServer = sessionServerMap.get(application);
		return sessionServer.getPipingReplica(session, program);

	}

	public ArrayList<String> getCentralizedListenerWidgets(String application)
			throws RemoteException {
		SessionServer sessionServer = sessionServerMap.get(application);
		if (sessionServer == null)
			return null;
		return sessionServer.getCentralizedListenerWidgets();
	}

}