package bus.uigen.widgets.awt;

import java.awt.ScrollPane;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualScrollPane;

public class AWTScrollPane extends AWTContainer implements VirtualScrollPane {
	// JScrollPane getScrollPane();
	VirtualComponent scrolledComponent;

	public AWTScrollPane(ScrollPane theScrollPane) {
		super(theScrollPane);
		// getScrollPane() = theScrollPane;

	}

	public AWTScrollPane() {

	}

	public void add(VirtualComponent c) {
		scrolledComponent = c;
		super.add(c);
	}

	public ScrollPane getScrollPane() {
		return (ScrollPane) component;
	}

	public void setScrolledComponent(VirtualComponent c) {
		add(c);
	}

	public VirtualComponent getScrolledComponent() {
		// return
		// AnAWTComponent.virtualComponent(getScrollPane().getComponent(3));
		return scrolledComponent;

	}

	/*
	 * public VirtualComponent getScrolledComponent () { return
	 * AnAWTComponent.virtualComponent(getScrollPane().getComponent(0));
	 * 
	 * }
	 */

	public static AWTScrollPane virtualScrollPane(ScrollPane theScrollPane) {
		return (AWTScrollPane) AWTComponent.virtualComponent(theScrollPane);
	}
	/*
	 * public static AnAWTScrollPane virtualScrollPane (ScrollPane
	 * theScrollPane, VirtualComponent scrolledComponent) { AnAWTScrollPane
	 * retVal = (AnAWTScrollPane)
	 * AnAWTComponent.virtualComponent(theScrollPane);
	 * retVal.setScrolledComponent(scrolledComponent); return retVal; }
	 */

}
