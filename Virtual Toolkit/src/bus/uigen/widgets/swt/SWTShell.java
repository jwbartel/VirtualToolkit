package bus.uigen.widgets.swt;

//import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Shell;

import bus.uigen.widgets.VirtualContainer;

public class SWTShell extends SWTContainer {

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

		init();
		addAllListeners();
		/*
		 * component = new Shell ((Composite)theParent.getPhysicalComponent(),
		 * SWT.NONE); AUniversalWidget.register(component, this);
		 * addExistingChildren(); //component.addToParent(theParent);
		 */
	}

	public void execSetName(String newVal) {
		this.name = newVal;
	}

}
