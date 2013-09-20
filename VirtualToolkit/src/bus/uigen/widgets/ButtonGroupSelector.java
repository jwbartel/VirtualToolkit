package bus.uigen.widgets;

public class ButtonGroupSelector {
	static ButtonGroupFactory factory;

	// static PanelFactory factory = new AWTPanelFactory();

	public static void setButtonGroupFactory(ButtonGroupFactory newVal) {
		factory = newVal;
	}

	public static VirtualButtonGroup createButtonGroup() {
		return factory.createButtonGroup();

	}

}