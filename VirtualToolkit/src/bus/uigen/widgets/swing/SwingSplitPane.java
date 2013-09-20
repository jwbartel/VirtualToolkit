package bus.uigen.widgets.swing;

import java.awt.Component;

import javax.swing.JSplitPane;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualSplitPane;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;

public class SwingSplitPane extends AWTContainer implements VirtualSplitPane {
	// JSplitPane getSplitPane();
	public SwingSplitPane(JSplitPane theSplitPane) {
		super(theSplitPane);
		// getSplitPane() = theSplitPane;

	}

	public SwingSplitPane() {

	}

	public JSplitPane getSplitPane() {
		return (JSplitPane) component;
	}

	public void setResizeWeight(double weight) {
		getSplitPane().setResizeWeight(weight);
	}

	public void setContinuousLayout(boolean newVal) {
		getSplitPane().setContinuousLayout(newVal);
	}

	public void setRightComponent(VirtualComponent comp) {
		getSplitPane().setRightComponent(
				(Component) comp.getPhysicalComponent());
		comp.setParent(this);
	}

	public void setLeftComponent(VirtualComponent comp) {
		getSplitPane()
				.setLeftComponent((Component) comp.getPhysicalComponent());
		comp.setParent(this);
	}

	public void remove(VirtualComponent comp) {
		super.remove(comp);
		// getSplitPane().setLeftComponent(null);
		comp.setParent(null);
	}

	public VirtualComponent getRightComponent() {
		return AWTComponent
				.virtualComponent(getSplitPane().getRightComponent());
	}

	public void setOrientation(int direction) {
		getSplitPane().setOrientation(direction);
	}

	public VirtualComponent getLeftComponent() {
		return AWTComponent.virtualComponent(getSplitPane().getLeftComponent());
	}

	public static SwingSplitPane virtualSplitPane(JSplitPane theSplitPane) {
		return (SwingSplitPane) AWTComponent.virtualComponent(theSplitPane);
	}

}
