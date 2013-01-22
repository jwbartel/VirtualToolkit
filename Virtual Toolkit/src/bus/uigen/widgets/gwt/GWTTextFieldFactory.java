package bus.uigen.widgets.gwt;

import bus.uigen.widgets.TextFieldFactory;
import bus.uigen.widgets.VirtualTextField;

public class GWTTextFieldFactory implements TextFieldFactory {

	public VirtualTextField createTextField() {
		GWTTextField retVal = new GWTTextField();
		retVal.init();
		return retVal;
	}

	public VirtualTextField createTextField(String text) {
		GWTTextField retVal = new GWTTextField(text);
		retVal.init();
		return retVal;
	}

}
