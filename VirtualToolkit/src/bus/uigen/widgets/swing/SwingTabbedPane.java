package bus.uigen.widgets.swing;

import java.awt.Component;

import javax.swing.JTabbedPane;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualTabbedPane;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;

public class SwingTabbedPane extends AWTContainer implements VirtualTabbedPane {
	// JTabbedPane getTabbedPane();
	public SwingTabbedPane(JTabbedPane theTabbedPane) {
		super(theTabbedPane);
		// getTabbedPane() = theTabbedPane;

	}

	public SwingTabbedPane() {
	}

	public JTabbedPane getTabbedPane() {
		return (JTabbedPane) component;
	}

	public void addTab(String label, VirtualComponent c) {
		getTabbedPane().addTab(label, (Component) c.getPhysicalComponent());
	}

	public void setTitleAt(int index, String label) {
		getTabbedPane().setTitleAt(index, label);
	}

	public void setTabPlacement(int placement) {
		getTabbedPane().setTabPlacement(placement);
	}

	public static SwingTabbedPane virtualTabbedPane(JTabbedPane theTabbedPane) {
		return (SwingTabbedPane) AWTComponent.virtualComponent(theTabbedPane);
	}

}
