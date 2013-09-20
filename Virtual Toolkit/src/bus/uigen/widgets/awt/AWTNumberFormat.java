package bus.uigen.widgets.awt;

import java.text.DecimalFormat;

import bus.uigen.widgets.VirtualNumberFormat;

public class AWTNumberFormat implements VirtualNumberFormat {
	DecimalFormat component;

	public AWTNumberFormat() {
		component = new DecimalFormat();
	}

	public AWTNumberFormat(String pattern) {
		component = new DecimalFormat(pattern);
	}

	public String format(double number) {
		return component.format(number);
	}

}
