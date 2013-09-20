package bus.uigen.widgets.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTPanel extends SWTContainer {

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

		component = new Composite((Composite) theParent.getPhysicalComponent(),
				SWT.PUSH);
		CentralUniversalWidget.register(component, this);
		if (layout != null) {
			this.getContainer().setLayout(layout.getLayout());
		}
		this.setLayout(layout);

		init();
		addAllListeners();
		addExistingChildren();
		// component.addToParent(theParent);

		theParent.layout();
	}

	public void pack() {
		for (int i = 0; i < children.size(); i++) {
			children.get(i).pack();
		}
		if (this.getComponent() != null) {
			this.getComponent().pack();
		}
	}

}
