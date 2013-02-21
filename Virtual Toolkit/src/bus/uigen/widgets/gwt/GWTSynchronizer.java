package bus.uigen.widgets.gwt;

import java.util.ArrayList;

import bus.uigen.widgets.Synchronizer;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.distributed.Command;
import bus.uigen.widgets.distributed.ProgramDescription;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.exceptions.SynchronizationException;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

public class GWTSynchronizer implements Synchronizer {

	ArrayList<String> sentCommands = new ArrayList<String>();
	ArrayList<String> localBuildCommands = new ArrayList<String>();
	boolean locallyBuilding = true;
	ArrayList<Command> remoteBuildCommands;

	static String objIdRegex = VirtualToolkit.objIdRegex;
	static RegExp objIdPattern = RegExp.compile(objIdRegex);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.widgets.gwt.Synchronizer#synchronize(bus.uigen.widgets.distributed
	 * .Command, bus.uigen.widgets.distributed.Command)
	 */
	@Override
	public void synchronize(Object oldCmdObj, Object newCmdObj) {
		Command oldCmd = (Command) oldCmdObj;
		Command newCmd = (Command) newCmdObj;
		MatchResult oldMatcher = objIdPattern.exec(oldCmd.getText());
		MatchResult newMatcher = objIdPattern.exec(newCmd.getText());

		if (oldMatcher == null || newMatcher == null)
			return;

		for (int i = 0; i < oldMatcher.getGroupCount()
				&& i < newMatcher.getGroupCount(); i++) {
			String oldID = oldMatcher.getGroup(i);
			String newID = newMatcher.getGroup(i);

			if (oldID != null && newID != null && !oldID.equals(newID)) {
				if (newID.startsWith("obj")) {
					Object obj = VirtualToolkit.getDefaultObjectByID(oldID);
					if (obj != null) {
						VirtualToolkit.getIdToWidget().remove(oldID);
						VirtualToolkit.getIdToWidget().put(newID, obj);

						if (obj instanceof VirtualComponent) {
							((VirtualComponent) obj).execSetName(newID);
						} else if (obj instanceof VirtualLayout) {
							((VirtualLayout) obj).setName(newID);
						} else {
							// TODO
						}
					}
				} else if (newID.startsWith("listener")) {
					// TODO: handle listener

				}
			}

		}

		if ((newCmd.getText().startsWith(VirtualButton.COMMAND_LABEL) || newCmd
				.getText().startsWith(VirtualTextField.COMMAND_LABEL))
				&& newCmd.getText().contains(
						VirtualButton.ADD_ACTION_LISTENER_COMMAND)) {

			String tempCommandText = newCmd.getText();
			if (newCmd.getText().startsWith(VirtualButton.COMMAND_LABEL)) {
				tempCommandText = tempCommandText
						.substring(VirtualButton.COMMAND_LABEL.length());
			} else if (newCmd.getText().startsWith(
					VirtualTextField.COMMAND_LABEL)) {
				tempCommandText = tempCommandText
						.substring(VirtualTextField.COMMAND_LABEL.length());
			}

			int commandStart = tempCommandText.indexOf('.');
			tempCommandText = tempCommandText.substring(commandStart);

			String argsStr = tempCommandText.substring(
					VirtualButton.ADD_ACTION_LISTENER_COMMAND.length(),
					tempCommandText.lastIndexOf(')'));
			String[] args = argsStr.split(",");

			String listenerID = args[0];

			VirtualActionListener listener = (VirtualActionListener) VirtualToolkit
					.getDefaultObjectByID(listenerID);
			VirtualToolkit.getlistenerCreators().put(listener,
					newCmd.getSource());

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bus.uigen.widgets.gwt.Synchronizer#sendCommand(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendCommand(String command, String replicaID,
			ProgramDescription programDescription) {
		sentCommands.add(command);
		boolean thisLocallyBuilding = locallyBuilding;
		if (command.startsWith(VirtualToolkit.COMMAND_LABEL
				+ VirtualToolkit.COMMAND_START)) {
			locallyBuilding = false;
			localBuildCommands.add(command);
			if (remoteBuildCommands != null) {
				VirtualToolkit.synchronizeBuildCommandsInDefault();

			}

		}
		if (locallyBuilding) {
			localBuildCommands.add(command);
		}

		Command toSend = new Command(command,
				VirtualToolkit.getDefaultNameOnServer(), replicaID,
				programDescription, thisLocallyBuilding);
		if (thisLocallyBuilding)
			toSend.setSequenceNumber(localBuildCommands.size());
		VirtualToolkit.getWidgetServer().send(toSend);
		// TODO: check src of command
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bus.uigen.widgets.gwt.Synchronizer#sendEvent(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEvent(String event, String replicaID,
			ProgramDescription programDescription) {
		VirtualToolkit.getWidgetServer().send(
				new Command(event, VirtualToolkit.getDefaultNameOnServer(),
						replicaID, programDescription, false));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.widgets.gwt.Synchronizer#setRemoteBuildCommands(java.util.ArrayList
	 * )
	 */
	@Override
	public void setRemoteBuildCommands(ArrayList<Command> buildCommands) {
		remoteBuildCommands = buildCommands;
		if (!locallyBuilding) {
			VirtualToolkit.synchronizeBuildCommandsInDefault();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bus.uigen.widgets.gwt.Synchronizer#synchronizeBuildCommands(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void synchronizeBuildCommands(String replicaID,
			ProgramDescription programDescription) {
		System.out.println("SYNCHRONIZE ATTEMPTED");
		if (localBuildCommands.size() != remoteBuildCommands.size()) {

			if (localBuildCommands.size() == 2) {

				String localCommandText = localBuildCommands.get(0);
				Command localCommand = new Command(localCommandText,
						VirtualToolkit.getDefaultNameOnServer(), replicaID,
						programDescription, true);
				boolean synchedFrame = false;

				for (int i = 0; i < remoteBuildCommands.size(); i++) {
					Command remoteCommand = remoteBuildCommands.get(i);

					if (!VirtualToolkit.getDefaultNameOnServer().equals(
							remoteCommand.getSource())) {
						if (!synchedFrame
								&& comandsMatch(localCommand.getText(),
										remoteCommand.getText())) {
							synchedFrame = true;
							synchronize(localCommand, remoteCommand);
						} else {
							VirtualToolkit.getWidgetServer().runCommand(
									remoteCommand);
						}

					}
				}
				// TODO: handle generic program

			} else {

				for (int i = 0; i < remoteBuildCommands.size()
						&& i < localBuildCommands.size(); i++) {
					String localCmd = localBuildCommands.get(i);
					String remoteCmd = remoteBuildCommands.get(i).getText();
					if (!comandsMatch(localCmd, remoteCmd)) {
						throw new SynchronizationException(
								"mismatched programs for synchronization");
					}
				}
				throw new SynchronizationException(
						"mismatched programs for synchronization");
			}

		} else {
			for (int i = 0; i < localBuildCommands.size(); i++) {
				String localCommandText = localBuildCommands.get(i);
				Command localCommand = new Command(localCommandText,
						VirtualToolkit.getDefaultNameOnServer(), replicaID,
						programDescription, true);
				Command remoteCommand = remoteBuildCommands.get(i);

				if (!VirtualToolkit.getDefaultNameOnServer().equals(
						remoteCommand.getSource())
						&& comandsMatch(localCommand.getText(),
								remoteCommand.getText())) {
					try {
						synchronize(localCommand, remoteCommand);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}

			}
		}

		VirtualToolkit.isSynchronized = true;
		VirtualToolkit.getWidgetServer().runCommands();
	}

	private static boolean comandsMatch(String c1, String c2) {
		String[] c1NoIDs = c1.split(objIdRegex);
		String[] c2NoIDs = c2.split(objIdRegex);

		if (c1NoIDs.length != c2NoIDs.length) {
			return false;
		}

		for (int i = 0; i < c1NoIDs.length; i++) {
			if (!c1NoIDs[i].equals(c2NoIDs[i])) {
				return false;
			}
		}

		return true;
	}
}
