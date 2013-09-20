package bus.uigen.widgets;

public class FlowLayoutSelector {
	static FlowLayoutFactory factory;

	public static void setFlowLayoutFactory(FlowLayoutFactory newVal) {
		factory = newVal;
	}

	public static VirtualFlowLayout createFlowLayout() {
		if (factory == null)
			return null;
		return factory.createFlowLayout();

	}
}