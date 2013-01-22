package bus.uigen.widgets.distributed.nongwt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.server.GWTServerEndImpl;
import bus.uigen.widgets.events.VirtualListener;

public class NonGwtProxyGWTServerEnd implements ProxyGWTServerEnd,
		CallsListener {
	String uniqueID;
	String replicaID;
	GWTServerEndImpl impl;
	ArrayList<CallsListener> listeners = new ArrayList<CallsListener>();
	Map<String, VirtualListener> vlistenersMap = new TreeMap<String, VirtualListener>();

	public NonGwtProxyGWTServerEnd() {// GWTServerEndImpl impl){
		this.impl = new GWTServerEndImpl();
		impl.addCommandsListener(this);
	}

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		impl.sendListener(listener, id, application, session, program);
	}

	public void send(Object commandObj) {
		Command command = (Command) commandObj;
		impl.send(command);
	}

	public void join(ProgramDescription programDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {

		this.replicaID = replicaID;

		// Join this proxy to the implimentation and return the assigned unique
		// ID
		this.uniqueID = impl.join(programDescription, replicaID,
				communicationCentralized, widgetsReplicated, isCentralProgram);
	}

	/*
	 * public void updateCommands(ArrayList<Command> commands){
	 * 
	 * if(commands != null ){
	 * 
	 * for(int i=0; i<listeners.size(); i++){
	 * listeners.get(i).updateCommands(commands); } }
	 * 
	 * }
	 */

	public void commandReceived(Object command, String destination) {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).commandReceived(command, destination);
		}
	}

	public synchronized void listenerReceived(VirtualListener listener,
			String listenerID, String program, String destination) {
		vlistenersMap.put(listenerID, listener);
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).listenerReceived(listener, listenerID, program,
					destination);
		}
	}

	public void updateListeners(Map<String, VirtualListener> vlisteners) {

		if (listeners != null) {

			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).updateListeners(vlisteners);
			}
		}

	}

	/*
	 * public void checkCommands() { ArrayList<Command> commands =
	 * impl.getCommands(); if(commands != null && commands.size() > 0){
	 * updateCommands(commands); }
	 * 
	 * }
	 */

	/*
	 * public void checkListeners() { Map<String, VirtualListener> vlisteners =
	 * impl.getListeners(); if(vlisteners != null && vlisteners.size() > 0){
	 * updateListeners(vlisteners); } }
	 */

	public void addCommandsListener(CallsListener listener, String program,
			String nameOnServer) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
		Iterator<String> vlistenerIDIter = vlistenersMap.keySet().iterator();
		while (vlistenerIDIter.hasNext()) {
			String vlistenerID = vlistenerIDIter.next();
			VirtualListener vlistener = vlistenersMap.get(vlistenerID);
			listener.listenerReceived(vlistener, vlistenerID, program,
					nameOnServer);
		}
	}

	public String getUniqueID() {
		return this.uniqueID;
	}

	public String getID() {
		return this.replicaID;
	}

}
