package bus.uigen.widgets.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SwingCheckBoxEventForwarder implements ActionListener {
	SwingCheckBox component;

	public SwingCheckBoxEventForwarder(SwingCheckBox b) {
		component = b;
	}

	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent virtualEvent = SwingEventPackager.convert(event);
		Iterator<VirtualActionListener> listeners = component
				.getVirtualActionListeners().iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (!VirtualToolkit.isDistributedByDefault()
					|| (listener instanceof ActionEventForwarder && component
							.listenersCentralized())
					|| (!(listener instanceof ActionEventForwarder) && !component
							.listenersCentralized())) {
				listener.actionPerformed(virtualEvent);
			}
		}
	}

}
