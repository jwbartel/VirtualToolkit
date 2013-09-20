package bus.uigen.widgets.swt;

import java.awt.Dimension;

import javax.swing.border.Border;

import org.eclipse.swt.widgets.Widget;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTWidget extends CentralUniversalWidget {
	// Component component;
	// Widget component;
	// VirtualContainer parent;
	public SWTWidget(Widget theComponent) {
		super(theComponent);
		// component = theComponent;

	}

	public SWTWidget() {

	}

	public Widget getWidget() {
		return (Widget) component;

	}

	/*
	 * public void setParent (VirtualContainer theParent) { parent = theParent;
	 * } public VirtualContainer getParent () { if (parent != null) return
	 * parent; if (getWidget().getParent() == null) return null; return
	 * SWTContainer.virtualContainer(getComponent().getParent()); }
	 */
	public void invalidate() {
		// getComponent().invalidate();
	}

	/*
	 * public void setVisible (boolean newVal) { getWidget().setVisible(newVal);
	 * }
	 */

	public String getName() {
		return "";
		// return getComponent().getName();
	}

	public void setName(String newVal) {
		// getComponent().setName(newVal);
	}

	public Object getPhysicalComponent() {
		return getWidget();
	}

	public void doLayout() {
		// getComponent().doLayout();
	}

	/*
	 * public void setLocation(int newX, int newY) {
	 * getWidget().setLocation(newX, newY); } public void setLocation(Point
	 * newVal) { getComponent().setLocation(newVal.x, newVal.y); }
	 */
	public void setBorder(Object border) {
		/*
		 * if (getComponent() instanceof JComponent) ((JComponent)
		 * getComponent()).setBorder((Border) border);
		 */
	}

	public void setBorder(Border border) {
		/*
		 * if (getComponent() instanceof JComponent) ((JComponent)
		 * getComponent()).setBorder( border);
		 */
	}

	public void setPreferredSize(Dimension d) {
		// getComponent().setPreferredSize(d);
	}

	public void repaint() {
		// getComponent().repaint();
	}

	public void validate() {

		// getComponent().validate();
	}

	public void revalidate() {
		/*
		 * if (getComponent() instanceof JComponent) ((JComponent)
		 * getComponent()).revalidate(); else getComponent().validate();
		 */
	}

	void setMaximumSize(Dimension d) {
		// getComponent().setMaximumSize(d);
	}

	public void setMinimumSize(Dimension d) {
		// getComponent().setMinimumSize(d);
	}

	public void setSize(Dimension d) {
		// getComponent().setSize(d);
	}

	public static VirtualComponent virtualComponent(Widget c) {
		return (VirtualComponent) CentralUniversalWidget.universalWidget(c);
	}

}
