package bus.uigen.widgets;

public class DelegatePanelSelector {
	static DelegatePanelFactory factory;

	// static DelegatePanelFactory factory = new AWTDelegatePanelFactory();
	// static PanelFactory factory = new AWTPanelFactory();

	public static void setDelegatePanelFactory(DelegatePanelFactory newVal) {
		factory = newVal;
	}

	public static VirtualDelegatePanel createDelegatePanel() {
		return factory.createDelegatePanel();

	}

}