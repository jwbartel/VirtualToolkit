package bus.uigen.widgets.gwt;

import bus.uigen.widgets.NumberFormatFactory;
import bus.uigen.widgets.VirtualNumberFormat;

public class GWTNumberFormatFactory implements NumberFormatFactory {

	public VirtualNumberFormat createNumberFormat() {
		return new GWTNumberFormat();
	}

	public VirtualNumberFormat createNumberFormat(String pattern) {
		return new GWTNumberFormat(pattern);
	}

}
