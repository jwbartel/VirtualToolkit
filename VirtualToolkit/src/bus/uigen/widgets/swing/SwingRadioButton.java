package bus.uigen.widgets.swing;

import javax.swing.JRadioButton;

import bus.uigen.widgets.VirtualRadioButton;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingRadioButton extends SwingButton implements VirtualRadioButton {
	// JradioButton radioButton;
	public SwingRadioButton(JRadioButton theRadioButton) {
		super(theRadioButton);
		// radioButton = theradioButton;

	}

	public SwingRadioButton() {

	}

	JRadioButton getJRadioButton() {
		return (JRadioButton) component;
	}

	public void setSelected(boolean newVal) {
		getJRadioButton().setSelected(newVal);
	}

	public static SwingRadioButton virtualRadioButton(JRadioButton theButton) {
		return (SwingRadioButton) AWTComponent.virtualComponent(theButton);

	}

}
