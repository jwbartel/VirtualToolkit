package bus.uigen.widgets.swing;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;

import bus.uigen.widgets.VirtualFormattedTextField;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingFormattedTextField extends SwingTextField implements
		VirtualFormattedTextField {
	// JTextField getTextField();
	public SwingFormattedTextField(JFormattedTextField theTextField) {
		super(theTextField);
		// getTextField() = theTextField;

	}

	public SwingFormattedTextField() {

	}

	public JFormattedTextField getFormattedTextField() {
		return (JFormattedTextField) component;
	}

	public Object getValue() {
		return getFormattedTextField().getValue();
	}

	public void setValue(Object value) {
		getFormattedTextField().setValue(value);
	}

	public AbstractFormatter getFormatter() {
		return getFormattedTextField().getFormatter();
	}

	public AbstractFormatterFactory getFormatterFactory() {
		return getFormattedTextField().getFormatterFactory();
	}

	public void setFormatterFactory(AbstractFormatterFactory tf) {
		getFormattedTextField().setFormatterFactory(tf);
	}

	public static SwingFormattedTextField virtualFormattedTextField(
			JFormattedTextField theTextField) {
		return (SwingFormattedTextField) AWTComponent
				.virtualComponent(theTextField);

	}

	@Override
	public void setFormatterFactory(Object tf) {
		// TODO Auto-generated method stub

	}

}
