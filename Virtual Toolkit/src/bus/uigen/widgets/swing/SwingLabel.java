package bus.uigen.widgets.swing;

import javax.swing.Icon;
import javax.swing.JLabel;

import bus.uigen.widgets.VirtualLabel;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingLabel extends SwingComponent implements VirtualLabel {
	// JLabel getLabel();
	public SwingLabel(JLabel theLabel) {
		super(theLabel);
		// getLabel() = theLabel;

	}

	public SwingLabel() {

		super(new JLabel());
	}

	public JLabel getLabel() {
		return (JLabel) component;
	}

	public String getText() {
		return getLabel().getText();
	}

	public void setText(String theText) {
		getLabel().setText(theText);
	}

	public void setIcon(Object theIcon) {
		getLabel().setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		getLabel().setIcon(theIcon);
	}

	public static VirtualLabel virtualLabel(JLabel theLabel) {
		return (VirtualLabel) AWTComponent.virtualComponent(theLabel);

	}

	public void setHorizontalAlignment(int alignment) {
		getLabel().setHorizontalAlignment(alignment);
	}

	public void setVerticalAlignment(int alignment) {
		getLabel().setVerticalAlignment(alignment);

	}

}
