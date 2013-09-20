package bus.uigen.widgets.gwt;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualMouseEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

public class GWTEventPackager {

	public static VirtualActionEvent convert(ClickEvent event) {
		VirtualActionEvent toReturn = new VirtualActionEvent();

		return toReturn;
	}

	public static VirtualActionEvent convert(ValueChangeEvent<String> event) {
		VirtualActionEvent toReturn = new VirtualActionEvent();

		return toReturn;
	}

	public static VirtualMouseEvent convert(MouseMoveEvent event, int type) {
		VirtualMouseEvent toReturn = new VirtualMouseEvent(type);

		return toReturn;
	}
}
