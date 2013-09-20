package bus.uigen.widgets.swt;

import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class Composite extends Scrollable {
	VirtualContainer component;

	public Composite(Composite parent, int style) {
		component = PanelSelector.createPanel();
		((VirtualContainer) CentralUniversalWidget
				.existingUniversalWidget(((Shell) parent).shell
						.getPhysicalComponent())).add(component); // do i need
																	// getPhysicalComponent
																	// here?
	}

	public Composite() {
		// default constructor
	}

	public void pack() {
		component.pack();
	}

	public void setSize(int width, int height) {
		component.setSize(width, height);
	}

}
