package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class ActionEventForwarder implements VirtualActionListener {
	VirtualComponent parent;

	public ActionEventForwarder() {

	}

	public ActionEventForwarder(VirtualComponent parent) {
		this.parent = parent;
	}

	public void actionPerformed(VirtualActionEvent e) {
		if (parent instanceof VirtualButton
				&& !((VirtualButton) parent).listenersCentralized()) {
			return;
		} else if (parent instanceof VirtualTextField
				&& !((VirtualTextField) parent).listenersCentralized()) {
			return;
		}

		String originator = VirtualToolkit.getDefaultNameOnServer();
		while (originator == null) {
			originator = VirtualToolkit.getDefaultNameOnServer();
		}

		String widgetID = parent.getName();

		String cmd = e.getActionCommand();
		long when = e.when();
		int type = e.getType();
		int modifiers = e.modifiers();

		String event = VirtualActionEvent.COMMAND_LABEL
				+ VirtualActionEvent.FIRE_EVENT_COMMAND + originator + ","
				+ widgetID + "," + cmd + "," + when + "," + type + ","
				+ modifiers + ")";

		// CommandSender sender = new CommandSender(command);
		// sender.start();
		VirtualToolkit.sendEventThroughDefault(event);

	}

	/*
	 * class CommandSender extends Thread{ String command; public
	 * CommandSender(String command){ this.command = command; }
	 * 
	 * public void run(){ VirtualToolkit.sendCommand(command); } }
	 */

}
