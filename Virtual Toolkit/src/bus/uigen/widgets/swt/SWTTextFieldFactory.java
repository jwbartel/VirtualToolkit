package bus.uigen.widgets.swt;

import bus.uigen.widgets.TextFieldFactory;
import bus.uigen.widgets.VirtualTextField;

public class SWTTextFieldFactory implements TextFieldFactory {
	static int id;

	// String text;
	public VirtualTextField createTextField(String text) {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createSWTTextField(text);
	}

	public VirtualTextField createTextField() {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createSWTTextField();
	}

	static int getNewID() {
		return id++;
	}

	public static VirtualTextField createSWTTextField(String text) {
		// TextField textField = new TextField(text);
		// text = theText;

		// return SWTTextField.virtualTextField(textField);
		return new SWTTextField(text);
		// return new Panel();
		// return new JPanel();
	}

	public static VirtualTextField createSWTTextField() {
		// Text textField = new Text();
		// return SWTTextField.virtualTextField(textField);
		return new SWTTextField();
		// return new Panel();
		// return new JPanel();
	}

}
