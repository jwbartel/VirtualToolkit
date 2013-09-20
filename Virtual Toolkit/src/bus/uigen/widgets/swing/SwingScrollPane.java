package bus.uigen.widgets.swing;

import java.awt.Component;

import javax.swing.JScrollPane;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualScrollPane;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;

public class SwingScrollPane extends AWTContainer implements VirtualScrollPane {
	// JScrollPane getScrollPane();
	VirtualComponent scrolledComponent;

	public SwingScrollPane(JScrollPane theScrollPane) {
		super(theScrollPane);
		// getScrollPane() = theScrollPane;

	}

	public SwingScrollPane() {
		super(new JScrollPane());

	}

	public void add(VirtualComponent c) {
		scrolledComponent = c;
		getScrollPane().setViewportView((Component) c.getPhysicalComponent());
		// super.add(c);
	}

	public void removeAll() {
		scrolledComponent = null;
		getScrollPane().getViewport().removeAll();
	}

	public JScrollPane getScrollPane() {
		return (JScrollPane) component;
	}

	public void setScrolledComponent(VirtualComponent c) {
		// scrolledComponent = c;
		add(c);
	}

	public VirtualComponent getScrolledComponent() {
		// return
		// AnAWTComponent.virtualComponent(getScrollPane().getComponent(3));
		return scrolledComponent;

	}

	/*
	 * public static ASwingScrollPane virtualScrollPane (JScrollPane
	 * theScrollPane, VirtualComponent scrolledComponent) { ASwingScrollPane
	 * retVal = (ASwingScrollPane)
	 * AnAWTComponent.virtualComponent(theScrollPane);
	 * retVal.setScrolledComponent(scrolledComponent); return retVal; }
	 */
	public static SwingScrollPane virtualScrollPane(JScrollPane theScrollPane) {
		SwingScrollPane retVal = (SwingScrollPane) AWTComponent
				.virtualComponent(theScrollPane);
		// retVal.setScrolledComponent(scrolledComponent);
		return retVal;
	}

}
