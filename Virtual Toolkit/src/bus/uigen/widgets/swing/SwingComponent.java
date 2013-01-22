package bus.uigen.widgets.swing;

import javax.swing.JComponent;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.awt.AWTContainer;

public class SwingComponent extends AWTContainer {

	public SwingComponent(JComponent component) {
		super(component);
	}

	public SwingComponent() {
		super();
	}

	public static VirtualComponent virtualComponent(JComponent c) {
		return AWTContainer.virtualContainer(c);
	}
}
