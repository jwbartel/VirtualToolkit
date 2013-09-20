package bus.uigen.widgets.swt;

import org.eclipse.swt.widgets.Button;

import bus.uigen.widgets.VirtualRadioButton;

public class SWTRadioButton extends SWTButton implements VirtualRadioButton {

	public SWTRadioButton(Button theRadioButton) {
		super(theRadioButton);
	}

	public Button getRadioButton() {
		return (Button) component;
	}

	@Override
	public void setSelected(boolean newVal) { // Should the other options be
												// toggled off here?
		getRadioButton().setSelection(newVal);
	}

	public static SWTRadioButton virtualRadioButton(Button theButton) {
		return (SWTRadioButton) SWTComponent.virtualComponent(theButton);

	}

}
