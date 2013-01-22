package bus.uigen.widgets.gwt;

import java.util.Iterator;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class GWTTextFieldEventForwarder implements ValueChangeHandler<String>,
		KeyDownHandler, KeyUpHandler, KeyPressHandler, MouseDownHandler,
		MouseUpHandler {

	GWTTextField component;
	String oldText;

	public GWTTextFieldEventForwarder(GWTTextField c) {
		component = c;
		oldText = "";
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		VirtualActionEvent gen = GWTEventPackager.convert(event);

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

	private void checkTextForChange() {
		if (!component.getIsSynchronizedText()
				|| oldText.equals(component.getText()))
			return;

		oldText = component.getText();
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = component.getName();
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ component.getText() + ")");
		}
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		checkTextForChange();
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		checkTextForChange();
	}

	@Override
	public void onKeyDown(KeyDownEvent event) {
		checkTextForChange();
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		checkTextForChange();
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		checkTextForChange();
	}

}
