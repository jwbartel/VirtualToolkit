package bus.uigen.widgets.distributed.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.client.GWTServerEnd;
import bus.uigen.widgets.distributed.nongwt.AnRmiClientEnd;
import bus.uigen.widgets.distributed.nongwt.RmiClientEnd;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GWTServerEndImpl extends RemoteServiceServlet implements
		GWTServerEnd, CallsListener {
	private static final long serialVersionUID = 1L;

	Map<String, ArrayList<Command>> initialCommandLists = new TreeMap<String, ArrayList<Command>>();
	Map<String, ArrayList<Command>> updateCommandLists = new TreeMap<String, ArrayList<Command>>();
	Map<String, Map<String, VirtualListener>> programListeners = new TreeMap<String, Map<String, VirtualListener>>();
	// ArrayList<Command> commands = new ArrayList<Command>();
	ArrayList<CallsListener> listeners = new ArrayList<CallsListener>();
	Map<String, VirtualListener> vlisteners;

	RmiClientEnd rmiClient;
	Set<String> uniqueReplicaIDs = new TreeSet<String>();

	public GWTServerEndImpl() {
	}

	// May need to handle different requests from web server through same
	// GWTServerEndImpl
	public String join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		// Identify the server and port from the program description
		String server = programDescription.getServer();
		String port = programDescription.getPort();

		// Look up the rmi server end
		RmiServerEnd rmiServerEnd = NameServerStarter
				.getRegistrar(server, port);
		if (rmiServerEnd == null) {
			// Start the name server if none exists
			NameServerStarter starter = new NameServerStarter(server);
			starter.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Generate the unique ID for the replica
		String uniqueReplicaID = replicaID + System.currentTimeMillis() + "_"
				+ uniqueReplicaIDs.size();

		// Generate the address for the replica fom its unique ID
		String uniqueIdOnServer = "//" + server;
		if (port == null)
			uniqueIdOnServer += ":" + VirtualToolkit.PORT;
		uniqueIdOnServer += "/" + uniqueReplicaID;

		try {
			// Generate the rmiClient if one does not exist
			if (rmiClient == null)
				rmiClient = new AnRmiClientEnd();

			// Add this as a receive of all received calls
			rmiClient.addCallsListener(this);

			// Join the rmiClient to the server
			rmiClient.join(programDescription, replicaID, uniqueIdOnServer,
					communicationCentralized, widgetsReplicated,
					isCentralProgram);
		} catch (RemoteException e) {
			throw new RuntimeException(e.getMessage());
		}

		// Record the unique ID of a successful connection
		uniqueReplicaIDs.add(uniqueIdOnServer);

		return uniqueReplicaID;
	}

	public void send(Command command) {
		try {
			// System.out.println("Receive:"+ System.currentTimeMillis());
			while (!uniqueReplicaIDs.contains(command.getSource())) {
			}
			rmiClient.send(command);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		try {
			rmiClient.sendListener(listener, id, application, session, program);
			;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void addCommandsListener(CallsListener listener) {
		listeners.add(listener);
	}

	/*
	 * public void updateCommands(ArrayList<Command> commands){ if(commands !=
	 * null && (this.commands == null || this.commands.size() <=
	 * commands.size()) ){ this.commands = commands;
	 * 
	 * for(int i=0; i<listeners.size(); i++){
	 * listeners.get(i).updateCommands(commands); } } }
	 */

	public synchronized void commandReceived(Object commandObj,
			String destination) {

		Command command = (Command) commandObj;
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).commandReceived(command, destination);
		}

		if (command.isInitial()) {
			ArrayList<Command> commandList = initialCommandLists
					.get(destination);
			if (commandList == null) {
				commandList = new ArrayList<Command>();
				initialCommandLists.put(destination, commandList);
			}

			for (int i = commandList.size(); i < command.getSequenceNumber(); i++) {
				commandList.add(null);
			}

			commandList.set(command.getSequenceNumber() - 1, command);
		} else {

			ArrayList<Command> commandList = updateCommandLists
					.get(destination);
			if (commandList == null) {
				commandList = new ArrayList<Command>();
				updateCommandLists.put(destination, commandList);
			}

			while (commandList.size() < command.getSequenceNumber() + 1) {
				commandList.add(null);
			}

			commandList.set(command.getSequenceNumber(), command);

			// TODO: handle non-initial commands
		}
	}

	public synchronized void listenerReceived(VirtualListener listener,
			String listenerID, String program, String destination) {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).listenerReceived(listener, listenerID, program,
					destination);
		}

		Map<String, VirtualListener> listenerIdMap = programListeners
				.get(program);
		if (listenerIdMap == null) {
			listenerIdMap = new TreeMap<String, VirtualListener>();
			programListeners.put(program, listenerIdMap);
		}
		listenerIdMap.put(listenerID, listener);
	}

	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		if (vlisteners != null
				&& (this.vlisteners == null || this.vlisteners.size() <= vlisteners
						.size())) {
			this.vlisteners = vlisteners;

			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).updateListeners(vlisteners);
			}
		}
	}

	public ArrayList<Command> getInitialCommands(String recipient) {
		/*
		 * if(commands == null){ try { commands = rmiClient.getCommands(); }
		 * catch (RemoteException e) {} }
		 */
		ArrayList<Command> commands = initialCommandLists.get(recipient);
		if (commands == null)
			return new ArrayList<Command>();
		return commands;
	}

	public ArrayList<Command> getUpdateCommands(String recipient) {
		ArrayList<Command> commands = updateCommandLists.get(recipient);
		if (commands == null)
			return new ArrayList<Command>();
		return commands;
	}

	public Map<String, VirtualListener> getListeners(String program) {
		Map<String, VirtualListener> listeners = programListeners.get(program);
		return listeners;
	}

}
