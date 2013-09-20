package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualNumberFormat;

import com.google.gwt.i18n.client.NumberFormat;

public class GWTNumberFormat implements VirtualNumberFormat {
	NumberFormat component;

	public GWTNumberFormat() {
		component = NumberFormat.getDecimalFormat();
	}

	public GWTNumberFormat(String pattern) {
		component = NumberFormat.getFormat(pattern);
	}

	public String format(double number) {
		return component.format(number);
	}

}
