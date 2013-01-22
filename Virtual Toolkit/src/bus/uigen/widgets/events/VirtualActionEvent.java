package bus.uigen.widgets.events;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;

public class VirtualActionEvent {
	public static final String COMMAND_LABEL = "VIRTUALACTIONEVENT:";
	public static final String FIRE_EVENT_COMMAND = "fireEvent(";
	/*
	 * protected ActionEvent actionComponent; protected SelectionEvent
	 * selectionComponent; protected ModifyEvent modifyComponent;
	 */

	public static final int SELECTED = 2;// SWT.SELECTED;
	public static final int MODIFIED = 24;// SWT.Modify;

	String cmd;
	long when;
	int type;
	int modifiers;

	// java.awt.Button awtSource = new java.awt.Button(); //just a filler
	// org.eclipse.swt.widgets.Button swtSource = new
	// org.eclipse.swt.widgets.Button(new Shell(), SWT.NONE); //just a filler

	public VirtualActionEvent() {

	}

	/*
	 * public VirtualActionEvent(ActionEvent event){ actionComponent = event;
	 * cmd = event.getActionCommand(); when = event.getWhen(); modifiers =
	 * event.getModifiers(); type = event.getID(); }
	 * 
	 * public VirtualActionEvent(SelectionEvent event, String command){
	 * selectionComponent = event; cmd = command; when = event.time; modifiers =
	 * event.stateMask; type = VirtualActionEvent.SELECTED; }
	 * 
	 * public VirtualActionEvent(ModifyEvent event, String command){
	 * modifyComponent = event; cmd = command; when = event.time; modifiers =
	 * -1; type = VirtualActionEvent.MODIFIED; }
	 */

	Object source;

	public Object getSource() {
		return source;
	}

	public void setSource(Object val) {
		source = val;
	}

	public String getActionCommand() {
		return cmd;
	}

	public void setActionCommand(String cmd) {
		this.cmd = cmd;
	}

	public long when() {
		return when;
	}

	public void setWhen(long when) {
		this.when = when;
	}

	public int modifiers() {
		return modifiers;
	}

	public void setModifies(int modifiers) {
		this.modifiers = modifiers;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	/*
	 * public ActionEvent getActionEvent(){ if(actionComponent != null){ return
	 * actionComponent; }else{ awtSource.setLabel(cmd); return new
	 * ActionEvent(awtSource,type,cmd, (int)when, modifiers); } }
	 */

	/*
	 * public SelectionEvent getSelectionEvent(){ if(selectionComponent !=
	 * null){ return selectionComponent; }else{ swtSource.setText(cmd);
	 * org.eclipse.swt.widgets.Event event = new
	 * org.eclipse.swt.widgets.Event(); event.type = type; event.text = cmd;
	 * event.widget = swtSource; event.time = (int) when; event.stateMask =
	 * modifiers; return new SelectionEvent(event); } }
	 */

	/*
	 * public ModifyEvent getModifyEvent(){ if(modifyComponent != null){ return
	 * modifyComponent; }else{ swtSource.setText(cmd);
	 * org.eclipse.swt.widgets.Event event = new
	 * org.eclipse.swt.widgets.Event(); event.type = type; event.text = cmd;
	 * event.widget = swtSource; event.time = (int) when; event.stateMask =
	 * modifiers; return new ModifyEvent(event); } }
	 */

	public static void runCommand(String command) {
		command = command.substring(COMMAND_LABEL.length());
		if (command.startsWith(FIRE_EVENT_COMMAND)) {
			String argsStr = command.substring(FIRE_EVENT_COMMAND.length(),
					command.lastIndexOf(')'));
			String[] args = argsStr.split(",");
			// if(args[0].equals(VirtualToolkit.getDefaultNameOnServer())){
			// return;
			// }

			VirtualComponent component = (VirtualComponent) VirtualToolkit
					.getDefaultObjectByID(args[1]);

			// TODO: Ignore if not central program XOR widget not centralized

			VirtualActionEvent event = new VirtualActionEvent();
			if (!args[2].equals("null")) {
				event.setActionCommand(args[2]);
			}
			event.setWhen(Long.parseLong(args[3]));
			event.setType(Integer.parseInt(args[4]));
			event.setModifies(Integer.parseInt(args[5]));

			if (component instanceof VirtualButton) {

				VirtualButton button = (VirtualButton) component;
				if (!VirtualToolkit.defaultIsCentralProgram()
						&& button.listenersCentralized())
					return;
				System.out.println("processed remote event");
				button.fireVirtualActionEvent(event);

			} else if (component instanceof VirtualTextField) {

				VirtualTextField textField = (VirtualTextField) component;
				if (!VirtualToolkit.defaultIsCentralProgram()
						&& textField.listenersCentralized())
					return;
				textField.fireVirtualActionEvent(event);

			}
		}

	}

}