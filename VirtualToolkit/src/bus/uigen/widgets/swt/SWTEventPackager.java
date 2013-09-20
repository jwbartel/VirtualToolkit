package bus.uigen.widgets.swt;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualFocusEvent;
import bus.uigen.widgets.events.VirtualMouseEvent;

public class SWTEventPackager {

	public static VirtualActionEvent convert(SelectionEvent event) {
		VirtualActionEvent toReturn = new VirtualActionEvent();
		Button internalButton = (Button) event.widget;

		toReturn.setActionCommand(internalButton.getText());
		toReturn.setWhen(event.time);
		toReturn.setModifies(event.stateMask);
		toReturn.setType(VirtualActionEvent.SELECTED);

		return toReturn;
	}

	public static VirtualActionEvent convert(ModifyEvent event) {
		VirtualActionEvent toReturn = new VirtualActionEvent();

		toReturn.setWhen(event.time);
		toReturn.setModifies(-1);
		toReturn.setType(VirtualActionEvent.MODIFIED);

		return toReturn;
	}

	public static VirtualFocusEvent convert(FocusEvent event) {
		VirtualFocusEvent toReturn = new VirtualFocusEvent();

		toReturn.setWhen(event.time);

		return toReturn;
	}

	public static VirtualMouseEvent convert(MouseEvent event, int type) {
		VirtualMouseEvent toReturn = new VirtualMouseEvent(type);
		toReturn.setWhen(event.time);
		toReturn.setModifiers(event.stateMask);
		toReturn.setX(event.x);
		toReturn.setY(event.y);
		if (toReturn.type() == VirtualMouseEvent.MouseClick) {
			toReturn.setClickCount(0);
		} else if (toReturn.type() == VirtualMouseEvent.MouseDoubleClick) {
			toReturn.setClickCount(2);
		} else {
			toReturn.setClickCount(0);
		}
		toReturn.setButton(event.button);

		return toReturn;
	}
}
