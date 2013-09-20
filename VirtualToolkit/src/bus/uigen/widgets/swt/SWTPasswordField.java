package bus.uigen.widgets.swt;

import org.eclipse.swt.widgets.Text;

import bus.uigen.widgets.VirtualPasswordField;

public class SWTPasswordField extends SWTTextField implements
		VirtualPasswordField {

	public SWTPasswordField(String thePassword) {
		super(thePassword);
		((Text) component).setEchoChar('*');
	}

	public SWTPasswordField() {
		super();
		((Text) component).setEchoChar('*');
	}
}
