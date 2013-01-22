package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualPasswordField;
import bus.uigen.widgets.universal.CentralUniversalWidget;

import com.google.gwt.user.client.ui.TextBox;

public class GWTPasswordField extends GWTTextField implements
		VirtualPasswordField {

	public GWTPasswordField(String initText) {
		super(initText);
	}

	public GWTPasswordField() {
		super();
	}

	public static GWTPasswordField virtualPasswordField(TextBox thePasswordField) {
		try {
			return (GWTPasswordField) CentralUniversalWidget
					.universalWidget(thePasswordField);
		} catch (ClassCastException ce) {
			ce.printStackTrace();
			return null;
		}
	}
}
