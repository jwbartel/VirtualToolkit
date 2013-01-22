package bus.uigen.widgets;

public class NumberFormatSelector {
	static NumberFormatFactory factory;

	public static void setNumberFormatFactory(NumberFormatFactory factory) {
		NumberFormatSelector.factory = factory;
	}

	public static VirtualNumberFormat createNumberFormat() {
		return factory.createNumberFormat();
	}

	public static VirtualNumberFormat createNumberFormat(String pattern) {
		return factory.createNumberFormat(pattern);
	}
}
