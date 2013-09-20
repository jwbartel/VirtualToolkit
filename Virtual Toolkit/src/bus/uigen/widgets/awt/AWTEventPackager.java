package bus.uigen.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualFocusEvent;
import bus.uigen.widgets.events.VirtualMouseEvent;
import bus.uigen.widgets.universal.CentralUniversalWidget;

//Generates virtual versions of various event classes
public class AWTEventPackager {

	public static VirtualActionEvent convert(ActionEvent event) {
		VirtualActionEvent toReturn = new VirtualActionEvent();

		toReturn.setActionCommand(event.getActionCommand());
		toReturn.setModifies(event.getModifiers());
		toReturn.setWhen(event.getWhen());
		toReturn.setType(event.getID());
		// toReturn.setSource(AWTComponent.virtualComponent((Component)
		// event.getSource()));
		toReturn.setSource(CentralUniversalWidget.universalWidget(event
				.getSource()));

		return toReturn;
	}

	public static VirtualFocusEvent convert(FocusEvent event) {
		VirtualFocusEvent toReturn = new VirtualFocusEvent();
		toReturn.setId(event.getID());
		toReturn.setWhen(System.currentTimeMillis());
		return toReturn;
	}

	public static VirtualMouseEvent convert(MouseEvent event, int type) {
		VirtualMouseEvent toReturn = new VirtualMouseEvent(type);

		toReturn.setButton(event.getButton());
		toReturn.setWhen(event.getWhen());
		toReturn.setModifiers(event.getModifiers());
		toReturn.setX(event.getX());
		toReturn.setY(event.getY());
		toReturn.setXOnScreen(event.getXOnScreen());
		toReturn.setYOnScreen(event.getYOnScreen());
		toReturn.setIsPopupTrigger(event.isPopupTrigger());
		toReturn.setLocationOnScreen(event.getLocationOnScreen());
		toReturn.setParamString(event.paramString());

		return toReturn;
	}

}
