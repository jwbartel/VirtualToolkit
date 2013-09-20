package bus.uigen.widgets;

import java.util.Vector;

public class ComboBoxSelector {
	static ComboBoxFactory factory;

	// static PanelFactory factory = new AWTPanelFactory();

	public static void setComboBoxFactory(ComboBoxFactory newVal) {
		factory = newVal;
	}

	public static VirtualComboBox createComboBox() {
		return factory.createComboBox();

	}

	public static VirtualComboBox createComboBox(Object[] choices) {
		return factory.createComboBox(choices);

	}

	public static VirtualComboBox createComboBox(Vector<Object> choices) {
		return factory.createComboBox(choices);
	}
}