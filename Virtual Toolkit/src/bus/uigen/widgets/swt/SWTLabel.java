package bus.uigen.widgets.swt;

import javax.swing.Icon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLabel;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTLabel extends SWTComponent implements VirtualLabel {
	// JLabel getLabel();
	String text;

	public SWTLabel(Label theLabel) {
		super(theLabel);
		// getLabel() = theLabel;

	}

	public SWTLabel(String theText) {
		text = theText;

	}

	public void init() {
		super.init();
	}

	public void addToParent(VirtualContainer theParent) {

		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an unitialized parent");
				}
			}
		}

		component = new Label((Composite) theParent.getPhysicalComponent(),
				SWT.PUSH);

		// getLabel().setText ("foo");
		if (getText() != null)
			getLabel().setText(getText());

		init();
		addAllListeners();
		CentralUniversalWidget.register(component, this);
		// getLabel().pack();
		// component.addToParent(theParent);
	}

	public SWTLabel(Icon theIcon) {
		text = theIcon.toString();
	}

	public SWTLabel() {

	}

	public Label getLabel() {
		return (Label) component;
	}

	public void pack() {
		getLabel().pack();
	}

	public String getText() {
		return text;
		// return getLabel().getText();
	}

	public void setText(String theText) {
		getLabel().setText(theText);
		getLabel().pack();
	}

	public void setIcon(Object theIcon) {
		setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		getLabel().setText(theIcon.toString());
	}

	public static VirtualLabel virtualLabel(Label theLabel) {
		return (VirtualLabel) SWTComponent.virtualComponent(theLabel);

	}

	public void setHorizontalAlignment(int alignment) {
		// getLabel().setHorizontalAlignment(alignment);
	}

	public void setVerticalAlignment(int alignment) {
		// getLabel().setVerticalAlignment(alignment);

	}

}
