package bus.uigen.widgets.distributed.nongwt;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;

public interface RmiClientEnd extends Remote, Serializable {

	public void join(ProgramDescription programDescription, String replicaID,
			String uniqueReplicaID, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram)
			throws RemoteException;

	// public String getID() throws RemoteException;
	// public String getUniqueID() throws RemoteException;
	public void close() throws RemoteException;

	public ArrayList<Command> getCommands() throws RemoteException;

	// public Map<String, VirtualListener> getListeners() throws
	// RemoteException;

	public void send(Command command) throws RemoteException;

	// public void updateCommands(ArrayList<Command> commands) throws
	// RemoteException;
	public void addCallsListener(CallsListener listener) throws RemoteException;

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program)
			throws RemoteException;

	public void receiveListener(VirtualListener listener, String listenerID,
			String program, String destination) throws RemoteException;

	public void updateListeners(Map<String, VirtualListener> listeners)
			throws RemoteException;

	public void addDirectCommunicator(String replicaID, String rmiClientID)
			throws RemoteException;

	public void receiveCommand(Command command, String recipient)
			throws RemoteException;

}
