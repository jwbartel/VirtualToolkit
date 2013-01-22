package bus.uigen.widgets.gwt;

import bus.uigen.widgets.ButtonGroupFactory;
import bus.uigen.widgets.VirtualButtonGroup;

public class GWTButtonGroupFactory implements ButtonGroupFactory {
	static int id = 1;

	static int getNewID() {
		return id++;
	}

	@Override
	public VirtualButtonGroup createButtonGroup() {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createGWTButtonGroup();
	}

	public static VirtualButtonGroup createGWTButtonGroup() {
		return new GWTButtonGroup();
	}

}
