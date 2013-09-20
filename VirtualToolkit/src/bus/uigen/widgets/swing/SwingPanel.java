package bus.uigen.widgets.swing;

import javax.swing.JPanel;

import bus.uigen.widgets.VirtualContainer;

public class SwingPanel extends SwingComponent {

	public SwingPanel(JPanel component) {
		super(component);
	}

	public SwingPanel() {
		super();
	}

	public static VirtualContainer virtualPanel(JPanel c) {
		return (VirtualContainer) SwingComponent.virtualComponent(c);
	}

}
