package bus.uigen.widgets.swt;

import bus.uigen.widgets.PasswordFieldFactory;
import bus.uigen.widgets.VirtualPasswordField;

public class SWTPasswordFieldFactory implements PasswordFieldFactory {
	static int id;

	@Override
	public VirtualPasswordField createPasswordField() {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createSWTPasswordField();
	}

	@Override
	public VirtualPasswordField createPasswordField(String password) {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createSWTPasswordField(password);
	}

	static int getNewID() {
		return id++;
	}

	public static VirtualPasswordField createSWTPasswordField(String password) {
		return new SWTPasswordField(password);
	}

	public static VirtualPasswordField createSWTPasswordField() {
		return new SWTPasswordField();
	}

}
