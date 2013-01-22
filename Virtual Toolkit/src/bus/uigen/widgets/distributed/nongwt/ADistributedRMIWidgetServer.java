package bus.uigen.widgets.distributed.nongwt;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.CallsListener;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.ProxyGWTServerEnd;
import bus.uigen.widgets.ProxyGWTServerEndSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualGridLayout;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServer;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.distributed.server.NameServerStarter;
import bus.uigen.widgets.distributed.server.RmiServerEnd;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.events.VirtualListenerFactory;
import bus.uigen.widgets.exceptions.SynchronizationException;

public class ADistributedRMIWidgetServer implements WidgetServer, CallsListener {
	private static final long serialVersionUID = 1L;

	ProgramDescription programDescription;
	protected String id;

	protected boolean isCentralProgram;

	// ArrayList<Command> commands;
	Map<String, VirtualListener> vlisteners = new TreeMap<String, VirtualListener>();
	int updateCommandsCompleted = 0;
	int buildingCommandsCompleted = 0;

	ProxyGWTServerEnd proxy;

	// ArrayList<VirtualToolkit> clients = new ArrayList<VirtualToolkit>();

	ArrayList<Command> buildCommands = new ArrayList<Command>();
	ArrayList<Command> updateCommands = new ArrayList<Command>();
	boolean building = true;

	public ADistributedRMIWidgetServer() {
	}

	public ADistributedRMIWidgetServer(ProgramDescription programDescription,
			String replicaID, boolean communicationCentralized,
			boolean widgetsReplicated, boolean isCentralProgram) {
		// Create and then connect a distributed widget server that connects
		// through RMI

		// Store the program description
		this.programDescription = programDescription;
		this.isCentralProgram = isCentralProgram;

		// Create the proxy for connecting to the GWT server end
		proxy = ProxyGWTServerEndSelector.create();

		// Join the proxy to the GWT server end
		proxy.join(programDescription, replicaID, communicationCentralized,
				widgetsReplicated, isCentralProgram);

	}

	public String getServer() {
		return programDescription.getServer();
	}

	public String getPort() {
		return programDescription.getPort();
	}

	public String getApplication() {
		return programDescription.getApp();
	}

	public boolean isCentralProgram() {
		return isCentralProgram;
	}

	public String getUniqueID() {
		return proxy.getUniqueID();
	}

	public void setID(String id) {
		this.id = id;
	}

	public void checkCommandsAndListeners() {
		String uniqueID = proxy.getUniqueID();
		String nameOnServer = "//" + programDescription.getServer();
		if (programDescription.getPort() == null)
			nameOnServer += ":" + VirtualToolkit.PORT;
		nameOnServer += "/" + uniqueID;
		proxy.addCommandsListener(this, programDescription.getKind(),
				nameOnServer);
	}

	public static String extractPort(String server) {
		int colonPos = server.lastIndexOf(':');
		if (colonPos >= 0) {
			return server.substring(colonPos + 1);
		} else {
			return null;
		}
	}

	public static String getRmiID(String uniqueID) {
		int end = uniqueID.lastIndexOf('_');
		if (end >= 0 && uniqueID.substring(end + 1).matches("\\d+")) {
			return uniqueID.substring(0, end);
		} else {
			return uniqueID;
		}
	}

	public static String[] parseJoinDescription(String joinDescription) {
		String[] retVal = new String[4];

		int argPos = joinDescription.indexOf('?');
		String serverAndApp = joinDescription.substring(0, argPos);
		String sessionAndKind = joinDescription.substring(argPos + 1);

		while (serverAndApp.charAt(serverAndApp.length() - 1) == '/') {
			serverAndApp = serverAndApp.substring(0, serverAndApp.length() - 1);
		}

		int serverEnd = serverAndApp.lastIndexOf('/');
		String server = serverAndApp.substring(0, serverEnd);
		String app = serverAndApp.substring(serverEnd + 1);

		int sessionEnd = sessionAndKind.indexOf('&');
		String session = sessionAndKind.substring(0, sessionEnd);
		session = session.substring("session=".length());

		String kind = sessionAndKind.substring(sessionEnd + 1);
		kind = kind.substring("kind=".length());

		retVal[0] = server;
		retVal[1] = app;
		retVal[2] = session;
		retVal[3] = kind;
		return retVal;
	}

	/*
	 * public void updateCommands(ArrayList<Command> commands) { if(commands !=
	 * null && (this.commands == null || this.commands.size() <
	 * commands.size())){ this.commands = commands; runCommands(); } }
	 */

	public synchronized void commandReceived(Object commandObj,
			String destination) {
		// TODO: handle destination
		Command command = (Command) commandObj;
		if (command != null) {
			System.out.println("receivedCommand: " + command.isInitial()
					+ command.getSequenceNumber());
			if (command.isInitial()) {
				if (buildCommands == null) {
					buildCommands = new ArrayList<Command>();
				}
				for (int i = buildCommands.size(); i < command
						.getSequenceNumber(); i++) {
					buildCommands.add(null);
				}

				buildCommands.set(command.getSequenceNumber() - 1, command);
			} else {

				if (updateCommands == null) {
					updateCommands = new ArrayList<Command>();
				}
				while (updateCommands.size() < command.getSequenceNumber() + 1) {
					updateCommands.add(null);
				}
				updateCommands.set(command.getSequenceNumber(), command);
				// TODO: handle update commands
			}
			runCommands();
		}
	}

	public synchronized void listenerReceived(VirtualListener listener,
			String listenerID, String program, String destination) {
		if (listener == null || listenerID == null
				|| !destination.equals(VirtualToolkit.getDefaultNameOnServer()))
			return;
		VirtualToolkit.defaultAssociate(listenerID, listener);
	}

	public void updateListeners(Map<String, VirtualListener> vlisteners) {
		if (vlisteners != null
				&& (this.vlisteners == null || this.vlisteners.size() < vlisteners
						.size())) {
			this.vlisteners = vlisteners;
		}
	}

	public void runCommands() {
		while (true) {
			if (!building && !VirtualToolkit.getIsSynchronized())
				return;
			if (building) {
				if (buildingCommandsCompleted >= buildCommands.size()
						|| buildCommands.get(buildingCommandsCompleted) == null)
					break;
				buildingCommandsCompleted++;
				try {
					processCommand(buildCommands
							.get(buildingCommandsCompleted - 1));
				} catch (SynchronizationException e) {
					buildingCommandsCompleted--;
					e.printStackTrace();
				}

			} else {
				if (updateCommandsCompleted >= updateCommands.size()
						|| updateCommands.get(updateCommandsCompleted) == null)
					break;
				updateCommandsCompleted++;
				try {
					processCommand(updateCommands
							.get(updateCommandsCompleted - 1));
				} catch (SynchronizationException e) {
					updateCommandsCompleted--;
					e.printStackTrace();
				}
			}

		}
	}

	public void sendListener(VirtualListener listener, String id,
			String application, String session, String program) {
		proxy.sendListener(listener, id, application, session, program);
	}

	public void send(Object commandObj) {
		Command command = (Command) commandObj;
		System.out.println(command.getText() + "\t" + command.getSource());
		proxy.send(command);
	}

	/*
	 * public void checkCommands(){ proxy.checkCommands(); }
	 */

	/*
	 * public void checkListeners(){ proxy.checkListeners(); }
	 */

	public ProxyGWTServerEnd getProxy() {
		return proxy;
	}

	private void runComponentCommand(Command command) {

		String commandText = command.getText();
		commandText = commandText.substring(VirtualComponent.COMMAND_LABEL
				.length());

		int commandStart = commandText.indexOf('.');
		String widgetID = commandText.substring(0, commandStart);
		commandText = commandText.substring(commandStart);

		VirtualComponent widget = (VirtualComponent) VirtualToolkit
				.getDefaultObjectByID(widgetID);

		if (commandText.startsWith(VirtualComponent.SET_SIZE_COMMAND)) {
			String argsStr = commandText.substring(
					VirtualComponent.SET_SIZE_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			if (args.length == 2) {
				widget.execSetSize(Integer.parseInt(args[0]),
						Integer.parseInt(args[1]));
			}
		} else if (commandText.startsWith(VirtualComponent.SET_NAME_COMMAND)) {
			String argsStr = commandText.substring(
					VirtualComponent.SET_NAME_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }
			if (args.length == 1) {
				widget.execSetName(args[0]);
			}
		}

	}

	private void runFrameCommand(String command) {
		command = command.substring(VirtualFrame.COMMAND_LABEL.length());

		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);

		if (command.startsWith(FrameSelector.COMMAND)) {
			String args = command.substring(FrameSelector.COMMAND.length(),
					command.lastIndexOf(')'));
			if (args.length() == 0) {
				FrameSelector.execCreate(widgetID);
			} else {
				FrameSelector.execCreate(widgetID, args);
			}
		}

	}

	private void runTextFieldCommand(Command command) {
		String commandText = command.getText();
		commandText = commandText.substring(VirtualTextField.COMMAND_LABEL
				.length());

		int commandStart = commandText.indexOf('.');
		String widgetID = commandText.substring(0, commandStart);
		commandText = commandText.substring(commandStart);

		if (commandText.startsWith(TextFieldSelector.COMMAND)) {
			String args = commandText.substring(
					TextFieldSelector.COMMAND.length(),
					commandText.lastIndexOf(')'));
			if (args.length() == 0) {
				TextFieldSelector.execCreate(widgetID);
			} else {
				TextFieldSelector.execCreate(widgetID, args);
			}
		} else if (commandText
				.startsWith(VirtualTextField.ADD_ACTION_LISTENER_COMMAND)) {
			VirtualTextField widget = (VirtualTextField) VirtualToolkit
					.getDefaultObjectByID(widgetID);

			String argsStr = commandText.substring(
					VirtualTextField.ADD_ACTION_LISTENER_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			String listenerID = args[0];
			// while(!vlisteners.containsKey(listenerID)){};

			VirtualListener listener = VirtualToolkit
					.getDefaultVirtualListenerByID(listenerID);
			if (listener instanceof VirtualListenerFactory) {
				widget.execAddActionListener((VirtualActionListener) ((VirtualListenerFactory) listener)
						.createListener());
			} else {
				widget.execAddActionListener((VirtualActionListener) listener);
			}

		} else if (commandText
				.startsWith(VirtualTextField.CENTRALIZE_ACTION_COMMAND)) {
			VirtualTextField widget = (VirtualTextField) VirtualToolkit
					.getDefaultObjectByID(widgetID);

			String argsStr = commandText.substring(
					VirtualTextField.CENTRALIZE_ACTION_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			String val = args[0];

			widget.execCentralizeListeners(Boolean.parseBoolean(val));
		}

	}

	private void runButtonCommand(Command command) {
		String commandText = command.getText();
		commandText = commandText.substring(VirtualButton.COMMAND_LABEL
				.length());

		int commandStart = commandText.indexOf('.');
		String widgetID = commandText.substring(0, commandStart);
		commandText = commandText.substring(commandStart);

		if (commandText.startsWith(ButtonSelector.COMMAND)) {
			String args = commandText.substring(FrameSelector.COMMAND.length(),
					commandText.lastIndexOf(')'));
			if (args.length() == 0) {
				ButtonSelector.execCreate(widgetID);
			} else {
				ButtonSelector.execCreate(widgetID, args);
			}
		} else if (commandText
				.startsWith(VirtualButton.ADD_ACTION_LISTENER_COMMAND)) {
			VirtualButton button = (VirtualButton) VirtualToolkit
					.getDefaultObjectByID(widgetID);

			String argsStr = commandText.substring(
					VirtualButton.ADD_ACTION_LISTENER_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			String listenerID = args[0];
			// while(!vlisteners.containsKey(listenerID)){};

			VirtualListener listener = VirtualToolkit
					.getDefaultVirtualListenerByID(listenerID);
			if (listener instanceof VirtualListenerFactory) {
				button.execAddActionListener((VirtualActionListener) ((VirtualListenerFactory) listener)
						.createListener());
			} else {
				button.execAddActionListener((VirtualActionListener) listener);
			}

		} else if (commandText
				.startsWith(VirtualButton.CENTRALIZE_ACTION_COMMAND)) {
			VirtualButton widget = (VirtualButton) VirtualToolkit
					.getDefaultObjectByID(widgetID);

			String argsStr = commandText.substring(
					VirtualTextField.CENTRALIZE_ACTION_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			String val = args[0];
			boolean valBool = Boolean.parseBoolean(val);

			widget.execCentralizeListeners(valBool);
		}

	}

	private void runContainerCommand(Command command) {

		String commandText = command.getText();
		commandText = commandText.substring(VirtualContainer.COMMAND_LABEL
				.length());

		int commandStart = commandText.indexOf('.');
		String widgetID = commandText.substring(0, commandStart);
		commandText = commandText.substring(commandStart);

		VirtualContainer widget = (VirtualContainer) VirtualToolkit
				.getDefaultObjectByID(widgetID);

		if (commandText.startsWith(PanelSelector.COMMAND)) {
			PanelSelector.execCreate(widgetID);
		} else if (commandText.startsWith(VirtualContainer.ADD_COMMAND)) {
			String argsStr = commandText.substring(
					VirtualContainer.ADD_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			VirtualComponent arg0 = (VirtualComponent) VirtualToolkit
					.getDefaultObjectByID(args[0]);
			if (args.length == 1) {
				widget.execAdd(arg0);
			}
		} else if (commandText.startsWith(VirtualContainer.SET_LAYOUT_COMMAND)) {
			String argsStr = commandText.substring(
					VirtualContainer.SET_LAYOUT_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			VirtualLayout arg0 = (VirtualLayout) VirtualToolkit
					.getDefaultObjectByID(args[0]);
			widget.execSetLayout(arg0);

		}

	}

	private void runTextComponentCommand(Command command) {

		String commandText = command.getText();
		commandText = commandText.substring(VirtualTextComponent.COMMAND_LABEL
				.length());

		int commandStart = commandText.indexOf('.');
		String widgetID = commandText.substring(0, commandStart);
		commandText = commandText.substring(commandStart);

		VirtualTextComponent widget = (VirtualTextComponent) VirtualToolkit
				.getDefaultObjectByID(widgetID);

		if (commandText.startsWith(VirtualTextComponent.SET_TEXT_COMMAND)) {

			String argsStr = commandText.substring(
					VirtualTextComponent.SET_TEXT_COMMAND.length(),
					commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			// if(VirtualToolkit.getDefaultNameOnServer().equals(command.getSource())){
			// return;
			// }

			widget.execSetText(args[0]);
		} else if (commandText
				.startsWith(VirtualTextComponent.SET_IS_SYNCHRONIZED_TEXT_COMMAND)) {
			String argsStr = commandText.substring(
					VirtualTextComponent.SET_IS_SYNCHRONIZED_TEXT_COMMAND
							.length(), commandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			widget.execSetIsSynchronizedText(Boolean.parseBoolean(args[0]));
		}

	}

	private void runGridLayoutCommand(String command) {

		command = command.substring(VirtualGridLayout.COMMAND_LABEL.length());

		int commandStart = command.indexOf('.');
		String widgetID = command.substring(0, commandStart);
		command = command.substring(commandStart);

		if (command.startsWith(GridLayoutSelector.COMMAND)) {
			String argsStr = command.substring(
					GridLayoutSelector.COMMAND.length(),
					command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			if (args.length > 0) {
				GridLayoutSelector.execCreate(widgetID,
						Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			} else {
				GridLayoutSelector.execCreate(widgetID);
			}
		}

	}

	public synchronized void processCommand(Object cmdObj) {
		Command cmd = (Command) cmdObj;
		String commandText = cmd.getText();

		if (commandText.startsWith(VirtualToolkit.COMMAND_LABEL
				+ VirtualToolkit.COMMAND_START)) {
			building = false;
			VirtualToolkit.setDefaultRemoteBuildCommands(buildCommands);
		}
		if (building) {
			return;
		}

		/*
		 * if(cmd.uniqueSrc.equals(VirtualToolkit.getNameOnServer())){ return; }
		 */

		VirtualToolkit.addReceivedCommand(commandText);

		runCommand(cmd);
	}

	public void runCommand(Object cmdObj) {
		Command cmd = (Command) cmdObj;
		String commandText = cmd.getText();

		if (commandText.startsWith(VirtualToolkit.COMMAND_LABEL)) {

			VirtualToolkit.runCommand(commandText);

		} else if (commandText.startsWith(VirtualActionEvent.COMMAND_LABEL)) {

			VirtualActionEvent.runCommand(commandText);

		} else if (commandText.startsWith(VirtualComponent.COMMAND_LABEL)) {

			runComponentCommand(cmd);

		} else if (commandText.startsWith(VirtualFrame.COMMAND_LABEL)) {

			runFrameCommand(commandText);

		} else if (commandText.startsWith(VirtualTextField.COMMAND_LABEL)) {

			runTextFieldCommand(cmd);

		} else if (commandText.startsWith(VirtualButton.COMMAND_LABEL)) {

			runButtonCommand(cmd);

		} else if (commandText.startsWith(VirtualContainer.COMMAND_LABEL)) {

			runContainerCommand(cmd);

		} else if (commandText.startsWith(VirtualTextComponent.COMMAND_LABEL)) {

			runTextComponentCommand(cmd);

		} else if (commandText.startsWith(VirtualGridLayout.COMMAND_LABEL)) {

			runGridLayoutCommand(commandText);

		}

	}

	@Override
	public ArrayList<String> getCentralizedListenerWidgets() {
		RmiServerEnd serverEnd = NameServerStarter.getRegistrar(getServer(),
				getPort());
		try {
			return serverEnd.getCentralizedListenerWidgets(getApplication());
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getNameOnServer() {
		// TODO Auto-generated method stub
		return null;
	}

}
