package bus.uigen.widgets.gwt;

import bus.uigen.widgets.PasswordFieldFactory;
import bus.uigen.widgets.VirtualPasswordField;

import com.google.gwt.user.client.ui.PasswordTextBox;

public class GWTPasswordFieldFactory implements PasswordFieldFactory {

	@Override
	public VirtualPasswordField createPasswordField() {
		PasswordTextBox passwordField = new PasswordTextBox();
		VirtualPasswordField retVal = GWTPasswordField
				.virtualPasswordField(passwordField);
//		retVal.init();
		return retVal;
	}

	@Override
	public VirtualPasswordField createPasswordField(String text) {
		PasswordTextBox passwordField = new PasswordTextBox();
		VirtualPasswordField retVal = GWTPasswordField
				.virtualPasswordField(passwordField);
//		retVal.init();
		return retVal;
	}
}
