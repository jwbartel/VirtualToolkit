package bus.uigen.widgets.swt;

import java.util.Iterator;

import org.eclipse.swt.events.SelectionEvent;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SWTCheckBoxEventForwarder {
	SWTCheckBox component;

	public SWTCheckBoxEventForwarder(SWTCheckBox b) {
		component = b;
	}

	public void widgetSelected(SelectionEvent event) {
		VirtualActionEvent virtualEvent = SWTEventPackager.convert(event);
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
			listener.actionPerformed(virtualEvent);
		}
	}

}
