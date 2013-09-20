package bus.uigen.widgets.gwt;

import java.util.Iterator;
import java.util.Vector;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualMouseEvent;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;

public class GWTCheckBoxEventForwarder implements ClickHandler,
		MouseMoveHandler {
	GWTCheckBox component;

	public GWTCheckBoxEventForwarder(GWTCheckBox c) {
		component = c;
	}

	public void onClick(ClickEvent event) {
		VirtualActionEvent virtualEvent = GWTEventPackager.convert(event);
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

	public void onMouseMove(MouseMoveEvent event) {
		VirtualMouseEvent virtualEvent = GWTEventPackager.convert(event,
				VirtualMouseEvent.Mouse_Move);
		Vector<VirtualMouseMoveListener> listeners = component
				.getVirtualMouseMoveListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseMoved(virtualEvent);
		}
	}
}
