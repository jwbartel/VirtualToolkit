package bus.uigen.widgets.awt;

import bus.uigen.widgets.NumberFormatFactory;
import bus.uigen.widgets.VirtualNumberFormat;

public class AWTNumberFormatFactory implements NumberFormatFactory {

	public VirtualNumberFormat createNumberFormat() {
		return new AWTNumberFormat();
	}

	public VirtualNumberFormat createNumberFormat(String pattern) {
		return new AWTNumberFormat(pattern);
	}

}
