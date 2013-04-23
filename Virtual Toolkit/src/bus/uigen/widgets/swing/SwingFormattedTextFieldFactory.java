package bus.uigen.widgets.swing;import javax.swing.JFormattedTextField;import javax.swing.JFormattedTextField.AbstractFormatter;import javax.swing.JFormattedTextField.AbstractFormatterFactory;import bus.uigen.widgets.FormattedTextFieldFactory;import bus.uigen.widgets.VirtualFormattedTextField;public class SwingFormattedTextFieldFactory implements		FormattedTextFieldFactory {	static int id;	public VirtualFormattedTextField createFormattedTextField() {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createJFormattedTextField();	}	static int getNewID() {		return id++;	}	public VirtualFormattedTextField createFormattedTextField(Object value) {		JFormattedTextField textField = new JFormattedTextField(value);		return SwingFormattedTextField.virtualFormattedTextField(textField);		// return new Panel();		// return new JPanel();	}	public static VirtualFormattedTextField createJFormattedTextField() {		JFormattedTextField textField = new JFormattedTextField();		return SwingFormattedTextField.virtualFormattedTextField(textField);		// return new Panel();		// return new JPanel();	}	public VirtualFormattedTextField createFormattedTextField(			AbstractFormatter formatter) {		JFormattedTextField textField = new JFormattedTextField(formatter);		VirtualFormattedTextField toReturn = SwingFormattedTextField				.virtualFormattedTextField(textField);//		toReturn.init();		return toReturn;	}	public VirtualFormattedTextField createFormattedTextField(			AbstractFormatterFactory factory) {		JFormattedTextField textField = new JFormattedTextField(factory);		VirtualFormattedTextField toReturn = SwingFormattedTextField				.virtualFormattedTextField(textField);//		toReturn.init();		return toReturn;	}	public VirtualFormattedTextField createFormattedTextField(			JFormattedTextField.AbstractFormatterFactory factory,			Object currentValue) {		JFormattedTextField textField = new JFormattedTextField(factory,				currentValue);		VirtualFormattedTextField toReturn = SwingFormattedTextField				.virtualFormattedTextField(textField);//		toReturn.init();		return toReturn;	}	@Override	public VirtualFormattedTextField createFormattedTextField(Object factory,			Object currentValue) {		// TODO Auto-generated method stub		return null;	}}