package bus.uigen.widgets.distributed.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.distributed.server.ApplicationStarter.Argument;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.CollaborativeException;

public interface RmiServerEnd extends Remote {

	public void registerRmiClientEnd(String rmiClientEndID,
			RmiClientEnd rmiClientEnd, ProgramDescription programDescription,
			String replicaID, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws RemoteException;

	public void broadcastCommand(Command command) throws RemoteException;

	public void broadcastListener(VirtualListener listener, String id,
			String application, String session, String program)
			throws RemoteException;

	public int getGlobalSequenceNumber(Command command) throws RemoteException;

	public ArrayList<Command> getCommands() throws RemoteException;

	// public Map<String, VirtualListener> getListeners() throws
	// RemoteException;

	public void registerApplication(String applicationName,
			ArrayList<String> programs, ArrayList<String> sharedListeners,
			ArrayList<Argument> args) throws RemoteException,
			CollaborativeException;

	public ArrayList<String> getCentralizedListenerWidgets(String application)
			throws RemoteException;
}
