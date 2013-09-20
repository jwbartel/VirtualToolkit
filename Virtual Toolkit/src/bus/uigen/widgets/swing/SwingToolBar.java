package bus.uigen.widgets.swing;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.JToolBar;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualToolBar;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;

public class SwingToolBar extends AWTContainer implements VirtualToolBar {
	// JToolBar toolBar;
	public SwingToolBar(JToolBar theToolBar) {
		super(theToolBar);
		// toolBar = theToolBar;

	}

	public SwingToolBar() {

	}

	public JToolBar getToolBar() {
		return (JToolBar) component;
	}

	public VirtualButton add(Object action) {
		return add((Action) action);
	}

	public VirtualComponent add(Component component) {
		return AWTComponent.virtualComponent(getToolBar().add(component));
	}

	public VirtualButton add(Action action) {
		return SwingButton.virtualButton(getToolBar().add(action));
	}

	public static SwingToolBar virtualToolBar(JToolBar theToolBar) {
		return (SwingToolBar) AWTComponent.virtualComponent(theToolBar);

	}

}
