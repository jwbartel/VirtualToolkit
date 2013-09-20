package bus.uigen.widgets.awt;

import java.awt.Label;

import javax.swing.Icon;

import bus.uigen.widgets.VirtualLabel;

public class AWTLabel extends AWTComponent implements VirtualLabel {
	// Label getLabel();
	public AWTLabel(Label theLabel) {
		super(theLabel);
		// getLabel() = theLabel;

	}

	public AWTLabel() {

		super(new Label());

	}

	public Label getLabel() {
		return (Label) component;
	}

	public String getText() {
		return getLabel().getText();
	}

	public void setText(String theText) {
		getLabel().setText(theText);
	}

	public void setIcon(Object theIcon) {
		setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		getLabel().setText(theIcon.toString());
	}

	public static VirtualLabel virtualLabel(Label theLabel) {
		return (VirtualLabel) AWTComponent.virtualComponent(theLabel);

	}

	public void setHorizontalAlignment(int alignment) {
		System.out.println("Cannot set alignment of an AWT label");
		// getLabel().setHorizontalAlignment(alignment);
	}

	public void setVerticalAlignment(int alignment) {
		System.out.println("Cannot set alignment of an AWT label");
		// getLabel().setVerticalAlignment(alignment);

	}

}
