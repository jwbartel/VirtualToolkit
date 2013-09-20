package bus.uigen.widgets.swing;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bus.uigen.widgets.VirtualPasswordField;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingPasswordField extends SwingTextField implements
		VirtualPasswordField {
	// JTextField textField;
	public SwingPasswordField(JPasswordField theTextField) {
		super(theTextField);
		// textField = theTextField;

	}

	public SwingPasswordField() {

	}

	public static SwingPasswordField virtualPasswordField(
			JTextField theTextField) {
		return (SwingPasswordField) AWTComponent.virtualComponent(theTextField);

	}

}
