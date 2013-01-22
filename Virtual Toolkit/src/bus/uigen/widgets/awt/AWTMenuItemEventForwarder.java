package bus.uigen.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class AWTMenuItemEventForwarder implements ActionListener {
	AWTMenuItem component;

	public AWTMenuItemEventForwarder(AWTMenuItem c) {
		component = c;
	}

	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent gen = AWTEventPackager.convert(event);

		Iterator<VirtualActionListener> listeners = component
				.getVirtualActionListeners().iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (VirtualToolkit.isDistributedByDefault()) {
				if (!((listener instanceof ActionEventForwarder && component
						.listenersCentralized()) || (!(listener instanceof ActionEventForwarder) && !component
						.listenersCentralized()))) {
					continue;
				}
			}
			listener.actionPerformed(gen);
		}
	}

}
