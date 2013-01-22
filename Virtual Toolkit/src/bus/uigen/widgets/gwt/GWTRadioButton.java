package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualRadioButton;

import com.google.gwt.user.client.ui.RadioButton;

public class GWTRadioButton extends GWTButton implements VirtualRadioButton {

	RadioButton getRadioButton() {
		return (RadioButton) component;
	}

	@Override
	public void setSelected(boolean newVal) {
		getRadioButton().setValue(true);
	}

	public boolean isSelected() {
		return getRadioButton().getValue();
	}

}
