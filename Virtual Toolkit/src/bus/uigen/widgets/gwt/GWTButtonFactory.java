package bus.uigen.widgets.gwt;

import bus.uigen.widgets.ButtonFactory;
import bus.uigen.widgets.VirtualButton;

public class GWTButtonFactory implements ButtonFactory {

	public VirtualButton createButton(String text) {
		VirtualButton toReturn = new GWTButton(text);
		toReturn.init();
		return toReturn;
	}

	public VirtualButton createButton(Object icon) {
		VirtualButton toReturn = new GWTButton();
		toReturn.init();
		return toReturn;
	}

	public VirtualButton createButton() {
		VirtualButton toReturn = new GWTButton();
		toReturn.init();
		return toReturn;
	}

}
