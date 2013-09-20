package bus.uigen.widgets.distributed.gwt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.client.GWTServerEnd;
import bus.uigen.widgets.distributed.client.GWTServerEndAsync;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class GWTProxyGWTServerEnd implements ProxyGWTServerEnd {

	public final static String GWT_ENTRY_POINT = "GWTServerEnd";

	String ID;
	String uniqueID;
	String nameOnServer;

	ProgramDescription programDescription;
	String replicaID;

	GWTServerEndAsync async;
	ArrayList<Command> initialCommands = new ArrayList<Command>();
	ArrayList<Command> updateCommands = new ArrayList<Command>();
	ArrayList<Command> sendCommandsQueue = new ArrayList<Command>();
	ArrayList<CallsListener> listeners = new ArrayList<CallsListener>();
	Map<String, VirtualListener> vlisteners = new TreeMap<String, VirtualListener>();

	private AsyncCallback<Void> voidCallback = new AsyncCallback<Void>() {
		public void onFailure(Throwable caught) {
		}

		public void onSuccess(Void result) {
		}
	};

	/*
	 * private AsyncCallback<String> idCallback = new AsyncCallback<String>(){
	 * public void onFailure(Throwable caught) {} public void onSuccess(String
	 * result) { ID = result; } };
	 */

	private AsyncCallback<String> uniqueIDCallback = new AsyncCallback<String>() {
		public void onFailure(Throwable caught) {
		}

		public void onSuccess(String result) {
			uniqueID = result;

			nameOnServer = "//" + programDescription.getServer();
			if (programDescription.getPort() == null)
				nameOnServer += ":" + VirtualToolkit.PORT;
			nameOnServer += "/" + uniqueID;

			System.out.println("received unique ID: " + uniqueID);

			VirtualToolkit.dequeueCreatedListeners();
			dequeueSendCommands();
			checkCommandsAndListeners(nameOnServer,
					programDescription.getKind());
		}
	};

	public GWTProxyGWTServerEnd() {// String joinDescription, String replicaID,
									// boolean communicationCentralized, boolean
									// widgetsReplicated){//GWTServerEndAsync
									// async){
		// init(joinDescription, replicaID, communicationCentralized,
		// widgetsReplicated);
	}

	private void init(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {
		this.replicaID = replicaID;
		this.programDescription = programDescription;

		async = (GWTServerEndAsync) GWT.create(GWTServerEnd.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) async;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + GWT_ENTRY_POINT);

		async.join(programDescription, replicaID, communicationCentralized,
				widgetsReplicated, isCentralProgram, uniqueIDCallback);
		ID = replicaID;

		// async.getUniqueID(uniqueIDCallback);
	}

	private class DelayedCommandSend extends Timer {
		Command command;

		public DelayedCommandSend(Command command) {
			this.command = command;
		}

		public void run() {
			// System.out.println("Send:"+ System.currentTimeMillis());
			async.send(command, voidCallback);
		}

	}

	public synchronized void send(Object commandObj) {
		Command command = (Command) commandObj;
		String comparisonString = "//" + programDescription.getServer();
		if (programDescription.getPort() == null)
			comparisonString += ":" + VirtualToolkit.PORT;
		comparisonString += "/null";
		if (command.getSource().equals(comparisonString)) {
			sendCommandsQueue.add(command);
			return;
		}
		Timer timer = new DelayedCommandSend(command);
		// System.out.println("Send:"+ System.currentTimeMillis());
		timer.schedule(1);
		// timer.run();

	}

	public void dequeueSendCommands() {
		while (sendCommandsQueue.size() > 0) {
			Command command = sendCommandsQueue.get(0);
			command.setSource(VirtualToolkit.getDefaultNameOnServer());
			send(command);
			sendCommandsQueue.remove(0);
		}
	}

	private class DelayedListenerSend extends Timer {
		VirtualListener listener;
		String id;
		String application;
		String session;
		String program;

		public DelayedListenerSend(VirtualListener listener, String id,
				String application, String session, String program) {
			this.listener = listener;
			this.id = id;
			this.application = application;
			this.session = session;
			this.program = program;
		}

		public void run() {
			async.sendListener(listener, id, application, session, program,
					voidCallback);
		}

	}

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		Timer timer = new DelayedListenerSend(listener, id, application,
				session, program);
		timer.schedule(2);

	}

	boolean foundSetIDResult = false;
	boolean setIDResult = false;

	public void join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		init(programDescription, replicaID, communicationCentralized,
				widgetsReplicated, isCentralProgram);

		// async.join(joinDescription, replicaID, communicationCentralized,
		// widgetsReplicated, uniqueIDCallback);

		// async.getID(idCallback);

		// async.getUniqueID(uniqueIDCallback);

	}

	public void checkCommandsAndListeners(String receiver, String program) {

		Timer timer = new RepeatedCommandChecker(receiver, program, async, this);
		timer.scheduleRepeating(100);
	}

	/*
	 * (public void checkListeners() {
	 * 
	 * Timer timer = new Timer(){ AsyncCallback<Map<String, VirtualListener>>
	 * callback = new AsyncCallback<Map<String, VirtualListener>>() {
	 * 
	 * public void onFailure(Throwable caught) { caught.printStackTrace(); }
	 * 
	 * public void onSuccess(Map<String, VirtualListener> result) {
	 * updateListeners(result); }
	 * 
	 * };
	 * 
	 * public void run(){ async.getListeners(callback);
	 * 
	 * } }; timer.scheduleRepeating(100); }
	 */

	/*
	 * private void updateCommands(ArrayList<Command> commands){ if(commands !=
	 * null && (this.commands == null || this.commands.size() <=
	 * commands.size()) ){ this.commands = commands;
	 * 
	 * for(int i=0; i<listeners.size(); i++){
	 * listeners.get(i).updateCommands(commands); } } }
	 */

	public void updateInitialCommands(ArrayList<Command> commands,
			String recipient) {
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);

			boolean forward = false;

			if (this.initialCommands.size() <= i) {
				this.initialCommands.add(command);
				if (command != null)
					forward = true;
			} else if (command != null) {
				Command oldCommand = this.initialCommands.get(i);
				if (oldCommand == null || !oldCommand.equals(command)) {
					this.initialCommands.set(i, command);
					forward = true;
				}
			}

			if (forward) {
				for (int j = 0; j < listeners.size(); j++) {
					listeners.get(j).commandReceived(command, recipient);
				}
			}

		}
	}

	public void updateUpdateCommands(ArrayList<Command> commands,
			String recipient) {
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);

			boolean forward = false;

			if (this.updateCommands.size() <= i) {
				this.updateCommands.add(command);
				if (command != null)
					forward = true;
			} else if (command != null) {
				Command oldCommand = this.updateCommands.get(i);
				if (oldCommand == null || !oldCommand.equals(command)) {
					this.updateCommands.set(i, command);
					forward = true;
				}
			}

			if (forward) {
				for (int j = 0; j < listeners.size(); j++) {
					listeners.get(j).commandReceived(command, recipient);
				}
			}

		}
	}

	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		Iterator<String> vlistenerIter = vlisteners.keySet().iterator();
		while (vlistenerIter.hasNext()) {
			String listenerID = vlistenerIter.next();
			VirtualListener listener = vlisteners.get(listenerID);

			if (listener != null) {
				for (int i = 0; i < listeners.size(); i++) {
					listeners.get(i).listenerReceived(listener, listenerID,
							this.programDescription.getKind(),
							this.nameOnServer);
				}
			}
		}
	}

	public void addCommandsListener(CallsListener listener, String program,
			String nameOnServer) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
		Iterator<String> vlistenerIDIter = vlisteners.keySet().iterator();
		while (vlistenerIDIter.hasNext()) {
			String vlistenerID = vlistenerIDIter.next();
			VirtualListener vlistener = vlisteners.get(vlistenerID);
			listener.listenerReceived(vlistener, vlistenerID, program,
					nameOnServer);
		}
	}

	public String getID() {
		return this.ID;
	}

	public String getUniqueID() {
		return this.uniqueID;
	}

}
