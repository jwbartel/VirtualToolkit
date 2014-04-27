package bus.uigen.widgets.swing;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;

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
	
	@Override
	public void addTab(String title, Object icon, VirtualComponent component,
			String tip) {
		getTabbedPane().addTab(title, (Icon) icon, (Component) component.getPhysicalComponent(), tip);
		
	}

	public void setTitleAt(int index, String label) {
		getTabbedPane().setTitleAt(index, label);
	}

	public void setTabPlacement(int placement) {
		getTabbedPane().setTabPlacement(placement);
	}
	
	public void setSelectedIndex(int index) {
		getTabbedPane().setSelectedIndex(index);
	}
	public int getSelectedIndex() {
		return getTabbedPane().getSelectedIndex();
	}
	
	public int getTabCount() {
		return getTabbedPane().getTabCount();
	}
	
	public void addChangeListener(Object aListener) {
		getTabbedPane().addChangeListener((ChangeListener) aListener);
	}

	public static SwingTabbedPane virtualTabbedPane(JTabbedPane theTabbedPane) {
		return (SwingTabbedPane) AWTComponent.virtualComponent(theTabbedPane);
	}

	

}
