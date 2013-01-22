package bus.uigen.widgets.distributed.server;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.server.ApplicationStarter.Argument;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;

public class SessionServer {

	boolean fromConfigFile;
	Map<String, Session> sessionMap = new TreeMap<String, Session>();
	ArrayList<String> programs, sharedListeners;
	ArrayList<Argument> args;

	public SessionServer() {
		fromConfigFile = false;
	}

	public SessionServer(boolean fromConfigFile) {
		this.fromConfigFile = fromConfigFile;
	}

	public ArrayList<String> getCentralizedListenerWidgets() {
		return sharedListeners;
	}

	public void registerRmiClientEnd(String uniqueRegistrarID,
			ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) throws CollaborativeException,
			MalformedURLException, RemoteException, NotBoundException {

		// Look up the session
		Session sessionObj = sessionMap.get(programDescription.getSession());
		if (sessionObj == null) {

			// Create and register session if it does not exist
			sessionObj = new Session(fromConfigFile,
					programDescription.getSession());

			if (fromConfigFile) {

				sessionObj.initFromConfig(programs, sharedListeners, args);
			}

			sessionMap.put(programDescription.getSession(), sessionObj);

		}

		// Register the client with the session
		sessionObj.registerRmiClientEnd(uniqueRegistrarID, programDescription,
				replicaID, communicationCentralized, widgetsReplicated,
				isCentralProgram);
	}

	@SuppressWarnings("unchecked")
	public void registerApplication(ArrayList<String> programs,
			ArrayList<String> sharedListeners, ArrayList<Argument> args) {
		this.programs = (ArrayList<String>) programs.clone();
		this.sharedListeners = (ArrayList<String>) sharedListeners.clone();
		this.args = (ArrayList<Argument>) args.clone();
	}

	public void broadcastCommand(Command command) throws MalformedURLException,
			RemoteException, NotBoundException {
		Session session = sessionMap.get(command.getSession());
		session.broadcastCommand(command);
	}

	public int getGlobalSequenceNumber(Command command) {
		Session session = sessionMap.get(command.getSession());
		return session.getGlobalSequenceNumber(command);
	}

	public void sendListener(VirtualListener listener, String id,
			String session, String program) throws MalformedURLException,
			RemoteException, NotBoundException {
		Session sessionObj = sessionMap.get(session);
		sessionObj.sendListener(listener, id, program);
	}

	public PipingReplica getPipingReplica(String session, String program) {
		Session sessionObj = sessionMap.get(session);
		if (sessionObj == null) {
			sessionObj = new Session(fromConfigFile, session);
			if (fromConfigFile) {
				sessionObj.initFromConfig(programs, sharedListeners, args);
			}
		}
		return sessionObj.getPipingReplica(program);

	}
}
