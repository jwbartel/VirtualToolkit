package bus.uigen.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.exceptions.SynchronizationException;

//import bus.uigen.widgets.universal.AUniversalWidget;

public abstract class VirtualToolkit {

	protected UniversalWidgetRegisterer registerer;

	protected WidgetServer widgetServer;

	public static final String COMMAND_LABEL = "VIRTUALTOOLKIT:";
	public static final String COMMAND_START = "start(";

	public static String PORT = "1099";
	public static final String REGISTRAR_NAME = "RmiServerEnd";

	static VirtualToolkit defaultToolkit;// = new GWTToolkit();

	static boolean widgetsRegistered = false;
	Map<String, Object> idToWidget = new TreeMap<String, Object>();

	Map<String, VirtualListener> idToListener = new TreeMap<String, VirtualListener>();

	static boolean started = false;
	static boolean shouldStart = false;
	static String frameToStart;

	protected ProgramDescription programDescription;
	protected String replicaID;
	/*
	 * protected String server; protected String application; protected String
	 * session; protected String program;
	 */

	ArrayList<String> sentCommands = new ArrayList<String>();
	static ArrayList<String> receivedCommands = new ArrayList<String>();

	// ArrayList<Command> remoteBuildCommands;
	// ArrayList<String> localBuildCommands = new ArrayList<String>();
	// boolean locallyBuilding = true;

	public static Map<VirtualListener, String> listenerCreators = new HashMap<VirtualListener, String>();

	public static boolean isSynchronized = false;

	static ArrayList<VirtualListener> createdListenersQueue = new ArrayList<VirtualListener>();

	static Synchronizer synchronizer = new DefaultSynchronizer();

	public static void setSynchronizer(Synchronizer s) {
		synchronizer = s;
	}

	public static boolean getIsSynchronized() {
		return isSynchronized;
	}

	protected void init(boolean isDistributed, String joinDescription,
			String replicaID, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram) {

		select();
		if (isDistributed) {
			// Only connect if the application is distributed

			// Parse the elements of the url
			programDescription = new ProgramDescription(joinDescription);
			replicaID = replicaID;

			// Create and connect the widget server
			widgetServer = WidgetServerSelector.createWidgetServer(
					programDescription, replicaID, communicationCentralized,
					widgetsReplicated, isCentralProgram);
		}
	}

	protected void checkCommandsAndListeners() {
		widgetServer.checkCommandsAndListeners();
	}

	protected boolean maybeRegisterWidgets() {
		if (widgetsRegistered)
			return false;
		// AUniversalWidget.registerUniversalWidgetClasses();
		widgetsRegistered = true;
		return true;
	}

	public void select() {
	}

	public static boolean defaultCentralizesListeners(String widgetID) {
		return defaultToolkit.centralizesListeners(widgetID);
	}

	public abstract boolean centralizesListeners(String widgetID);

	public abstract void startFrame(VirtualFrame frame);

	public abstract void receiveStartFrameCommand(VirtualFrame frame);

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
		if (VirtualToolkit.isDistributedByDefault()) {
			defaultToolkit.checkCommandsAndListeners();
			// widgetServer.checkListeners();
			// widgetServer.checkCommands();
		}
	}

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

	public static void start(VirtualFrame frame) {
		if (!VirtualToolkit.isDistributedByDefault() || frame != null) {
			defaultToolkit.receiveStartFrameCommand(frame);
			defaultToolkit.startFrame(frame);

		} else {
			defaultToolkit.startFrame(frame);
		}
	}

	public static void execStart(VirtualFrame frame) {
		/*
		 * if(started) return; started = true; defaultToolkit.startFrame(frame);
		 */
		if (defaultToolkit != null) {
			defaultToolkit.receiveStartFrameCommand(frame);
		}
	}

	public static boolean isDistributedByDefault() {
		return defaultToolkit != null && defaultToolkit.isDistributed();
	}

	public boolean isDistributed() {
		return widgetServer != null;
	}

	public static void sendListenerToDefault(VirtualListener listener, String id) {
		defaultToolkit.sendListener(listener, id);
	}

	public void sendListener(VirtualListener listener, String id) {
		widgetServer.sendListener(listener, id, programDescription.getApp(),
				programDescription.getSession(), programDescription.getKind());
	}

	public static void sendCommandByDefault(String command) {
		if (isDistributedByDefault()) {
			defaultToolkit.sendCommand(command);
		}
	}

	public void sendCommand(String command) {

		// TODO: this breaks multiple kinds because the same synchronizer is
		// used by all kinds
		synchronizer.sendCommand(command, replicaID, programDescription);
	}

	public static void sendEventThroughDefault(String event) {
		defaultToolkit.sendEvent(event);
	}

	public void sendEvent(String event) {
		synchronizer.sendEvent(event, replicaID, programDescription);
		// widgetServer.send(new Command(event,
		// VirtualToolkit.getDefaultNameOnServer(), replicaID, application,
		// session, program, false));
	}

	public static String getDefaultObjectID() {
		return defaultToolkit.getObjectID();
	}

	public synchronized String getObjectID() {
		String prefix = "obj";
		String id = prefix + idToWidget.size();
		return id;
	}

	public static void defaultReassociate(String oldID, String newID, Object obj) {
		defaultToolkit.reassociate(oldID, newID, obj);
	}

	public void reassociate(String oldID, String newID, Object obj) {
		if (newID != null) {
			if (oldID != null) {
				idToWidget.remove(oldID);
			}
			idToWidget.put(newID, obj);
		}
	}

	public static void defaultAssociate(String widgetID, Object obj) {
		defaultToolkit.associate(widgetID, obj);
	}

	public void associate(String widgetID, Object obj) {
		idToWidget.put(widgetID, obj);
	}

	public static boolean containObjIDByDefault(String id) {
		return defaultToolkit.containObjID(id);
	}

	public boolean containObjID(String id) {
		return id != null && idToWidget.containsKey(id);
	}

	public static Object getDefaultObjectByID(String widgetID) {
		return defaultToolkit.getObjectByID(widgetID);
	}

	public Object getObjectByID(String widgetID) {
		return idToWidget.get(widgetID);
	}

	public static String getDefaultVirtualListenerID() {
		return defaultToolkit.getVirtualListenerID();
	}

	public synchronized String getVirtualListenerID() {
		String prefix = "listener";
		String id = prefix + idToListener.size();
		return id;
	}

	public static void defaultAssociate(String listenerID,
			VirtualListener listener) {
		defaultToolkit.associate(listenerID, listener);
	}

	public void associate(String listenerID, VirtualListener listener) {
		idToListener.put(listenerID, listener);
	}

	public static boolean containVirtualListenerIDInDefault(String id) {
		return defaultToolkit.containVirtualListenerID(id);
	}

	public boolean containVirtualListenerID(String id) {
		return id != null && idToListener.containsKey(id);
	}

	public static VirtualListener getDefaultVirtualListenerByID(
			String listenerID) {
		return defaultToolkit.getVirtualListenerByID(listenerID);
	}

	public VirtualListener getVirtualListenerByID(String listenerID) {
		return idToListener.get(listenerID);
	}

	public static String getIDByDefault() {
		return defaultToolkit.getID();
	}

	public String getID() {
		return widgetServer.getProxy().getID();
	}

	public static String getUniqueIDByDefault() {
		return defaultToolkit.getUniqueID();
	}

	public String getUniqueID() {
		if (widgetServer != null) {
			return widgetServer.getProxy().getUniqueID();
		} else {
			return "";
		}
	}

	public static String getDefaultNameOnServer() {
		return defaultToolkit.getNameOnServer();
	}

	public String getNameOnServer() {
		String port = programDescription.getPort();

		String retVal = "//" + programDescription.getServer();
		if (programDescription.getPort() == null)
			retVal += ":" + VirtualToolkit.PORT;
		retVal += "/" + getUniqueIDByDefault();
		return retVal;
	}

	public static void runCommand(String command) {
		command = command.substring(COMMAND_LABEL.length());

		if (command.startsWith(COMMAND_START)) {
			String frameID = command.substring(COMMAND_START.length(),
					command.lastIndexOf(')'));
			VirtualFrame frame = (VirtualFrame) VirtualToolkit
					.getDefaultObjectByID(frameID);

			VirtualToolkit.execStart(frame);
		}

	}

	public static void addReceivedCommand(String command) {
		receivedCommands.add(command);
	}

	public static void addReceivedCommands(ArrayList<String> commands) {
		receivedCommands.addAll(commands);
	}

	public static void setDefaultRemoteBuildCommands(ArrayList buildCommands)
			throws SynchronizationException {
		defaultToolkit.setRemoteBuildCommands(buildCommands);
	}

	public void setRemoteBuildCommands(ArrayList buildCommands)
			throws SynchronizationException {
		synchronizer.setRemoteBuildCommands(buildCommands);
		/*
		 * remoteBuildCommands = buildCommands; if(!locallyBuilding){
		 * synchronizeBuildCommandsInDefault(); }
		 */
	}

	public static void synchronizeBuildCommandsInDefault()
			throws SynchronizationException {
		defaultToolkit.synchronizeBuildCommands();
	}

	public void synchronizeBuildCommands() throws SynchronizationException {
		synchronizer.synchronizeBuildCommands(replicaID, programDescription);

		/*
		 * System.out.println("SYNCHRONIZE ATTEMPTED"); ArrayList<String> lbc =
		 * localBuildCommands; ArrayList<Command> rbc = remoteBuildCommands;
		 * if(localBuildCommands.size() != remoteBuildCommands.size()){
		 * 
		 * if(localBuildCommands.size() == 2){
		 * 
		 * String localCommandText = localBuildCommands.get(0); Command
		 * localCommand = new Command(localCommandText,
		 * VirtualToolkit.getDefaultNameOnServer(), replicaID, application,
		 * session, program, true); boolean synchedFrame = false;
		 * 
		 * for(int i=0; i<remoteBuildCommands.size(); i++){ Command
		 * remoteCommand = remoteBuildCommands.get(i);
		 * 
		 * if(!VirtualToolkit.getDefaultNameOnServer().equals(remoteCommand.
		 * getSource())){ if(!synchedFrame &&
		 * comandsMatch(localCommand.getText(), remoteCommand.getText())){
		 * synchedFrame = true; synchronize(localCommand, remoteCommand); }else{
		 * widgetServer.runCommand(remoteCommand); }
		 * 
		 * } } //TODO: handle generic program
		 * 
		 * }else{
		 * 
		 * for(int i=0; i<remoteBuildCommands.size() &&
		 * i<localBuildCommands.size(); i++){ String localCmd =
		 * localBuildCommands.get(i); String remoteCmd =
		 * remoteBuildCommands.get(i).getText(); if(!comandsMatch(localCmd,
		 * remoteCmd)){ throw new
		 * SynchronizationException("mismatched programs for synchronization");
		 * } } throw new
		 * SynchronizationException("mismatched programs for synchronization");
		 * }
		 * 
		 * }else{ for(int i=0; i<localBuildCommands.size(); i++){ String
		 * localCommandText = localBuildCommands.get(i); Command localCommand =
		 * new Command(localCommandText,
		 * VirtualToolkit.getDefaultNameOnServer(), replicaID, application,
		 * session, program, true); Command remoteCommand =
		 * remoteBuildCommands.get(i);
		 * 
		 * 
		 * 
		 * if(!VirtualToolkit.getDefaultNameOnServer().equals(remoteCommand.
		 * getSource()) && comandsMatch(localCommand.getText(),
		 * remoteCommand.getText())){ try{ synchronize(localCommand,
		 * remoteCommand); }catch(NullPointerException e){ e.printStackTrace();
		 * } }
		 * 
		 * } }
		 * 
		 * isSynchronized = true; widgetServer.runCommands();
		 */
	}

	public static String objIdRegex = "((obj\\d+)|(listener\\d+))";

	/*
	 * private static boolean comandsMatch(String c1, String c2){ String[]
	 * c1NoIDs = c1.split(objIdRegex); String[] c2NoIDs = c2.split(objIdRegex);
	 * 
	 * if(c1NoIDs.length != c2NoIDs.length){ return false; }
	 * 
	 * 
	 * for(int i=0; i<c1NoIDs.length; i++){ if(!c1NoIDs[i].equals(c2NoIDs[i])){
	 * return false; } }
	 * 
	 * return true; }
	 */

	/*
	 * private void synchronize(Command oldCmd, Command newCmd){
	 * synchronizer.synchronize(oldCmd, newCmd); }
	 */

	public static void foundPossibleListenerCreator(VirtualListener listener,
			String creator) {
		if (!listenerCreators.containsKey(listener)) {
			if (creator.equals("//" + getHostName() + ":" + PORT + "/null")) {
				createdListenersQueue.add(listener);
				return;
			}
			listenerCreators.put(listener, creator);
		}
	}

	public static void dequeueCreatedListeners() {
		while (createdListenersQueue.size() > 0) {
			listenerCreators.put(createdListenersQueue.get(0),
					getDefaultNameOnServer());
			createdListenersQueue.remove(0);
		}
	}

	public static String getCreator(VirtualListener listener) {
		return listenerCreators.get(listener);
	}

	public static String getFullRegistrarName(String server, String port) {
		String retVal = "//" + server;
		if (port == null) {
			retVal += ":" + VirtualToolkit.PORT;
		}
		retVal += "/" + VirtualToolkit.REGISTRAR_NAME;

		return retVal;
	}

	public static String getFullRegistrarName() {
		return "//" + getHostName() + ":" + PORT + "/"
				+ VirtualToolkit.REGISTRAR_NAME;
	}

	// TODO: remove
	public static String getHostName() {
		/*
		 * String toReturn = ""; try { toReturn =
		 * InetAddress.getLocalHost().getCanonicalHostName(); } catch
		 * (UnknownHostException e) { e.printStackTrace(); } return toReturn;
		 */

		// return "192.168.100.4";
		// return "152.2.142.146";
		// return "127.0.0.1";
		return "localhost";
	}

	public static boolean defaultIsCentralProgram() {
		return defaultToolkit.isCentralProgram();
	}

	public boolean isCentralProgram() {
		return this.widgetServer != null
				&& this.widgetServer.isCentralProgram();
	}

	public static Map<String, Object> getIdToWidget() {
		return defaultToolkit.idToWidget;
	}

	public static Map<VirtualListener, String> getlistenerCreators() {
		return defaultToolkit.listenerCreators;
	}

	public static WidgetServer getWidgetServer() {
		return defaultToolkit.widgetServer;
	}
}