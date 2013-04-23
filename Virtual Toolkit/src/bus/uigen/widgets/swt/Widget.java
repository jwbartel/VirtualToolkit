package bus.uigen.widgets.swt;

/*import java.awt.Color;
 import java.awt.Component;
 import java.awt.Cursor;
 import java.awt.Dimension;
 import java.awt.Point;
 import java.awt.event.FocusListener;
 import java.awt.event.KeyListener;
 import java.awt.event.MouseListener;

 import javax.swing.border.Border;*/

//import bus.uigen.widgets.ADelegatingVirtualComponent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDimension;
import bus.uigen.widgets.VirtualPoint;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;
import bus.uigen.widgets.graphics.VirtualGraphic;

public class Widget implements VirtualComponent {
	VirtualComponent component;
	String ID;

	// VirtualContainer parent;
	public Widget(VirtualComponent theComponent) {
		component = theComponent;

	}

	public Widget() {

	}

	public void init(VirtualComponent theComponent) {
		component = theComponent;
	}

	/*
	 * public void init(Component thePhysicalComponent) {
	 * component.init(thePhysicalComponent); }
	 */

	public void init(Object thePhysicalComponent) {
		component.init(thePhysicalComponent);
	}

	public void setParent(VirtualContainer theParent) {
		component.setParent(theParent);
	}

	public VirtualContainer getParent() {
		return component.getParent();
		/*
		 * if (parent != null) return parent; if (component.getParent() == null)
		 * return null; return
		 * AnAWTContainer.virtualContainer(component.getParent());
		 */
	}

	public void addToParent(VirtualContainer theParent) {
		// Element can only be added to a parent of the component has been
		// initialized
		if (component == null) {
			System.out.println("Widget has not been created properly");
		}
		component.addToParent(theParent);
	}

	public void invalidate() {
		component.invalidate();
	}

	public void setVisible(boolean newVal) {
		component.setVisible(newVal);
	}

	public String getName() {
		return component.getName();
	}

	public void setName(String newVal) {
		component.setName(newVal);
	}

	public void execSetName(String newVal) {
		component.execSetName(newVal);
	}

	public Object getPhysicalComponent() {
		return component.getPhysicalComponent();
	}

	/*
	 * public Component getAWTComponent() { return (Component) component; }
	 */
	public void doLayout() {
		component.doLayout();
	}

	public void setLocation(int newX, int newY) {
		component.setLocation(newX, newY);
	}

	/*
	 * public void setLocation(Point newVal) { component.setLocation(newVal); }
	 */

	public void repaint() {
		component.repaint();
	}

	public void validate() {

		component.validate();
	}

	public void revalidate() {
		/*
		 * if (component instanceof JComponent) ((JComponent)
		 * component).revalidate(); else
		 */
		component.validate();
	}

	/*
	 * public void setBackground(Object newVal) { setBackground((Color) newVal);
	 * }
	 */

	/*
	 * public void setBackground(Color newVal) {
	 * component.setBackground(newVal); }
	 */

	public Object getBackground() {
		return component.getBackground();
	}

	public void setAlignmentX(float x) {
		component.setAlignmentX(x);
	}

	public void setAlignmentY(float y) {
		component.setAlignmentY(y);
	}

	/*
	 * public void addMouseListener(Object mouseListener) {
	 * component.addMouseListener((MouseListener) mouseListener); }
	 */

	public void setEnabled(boolean newVal) {
		component.setEnabled(newVal);
	}

	/*
	 * public void setMaximumSize(Dimension d) { component.setMaximumSize(d); }
	 * 
	 * public void setMinimumSize(Dimension d) { component.setMinimumSize(d); }
	 * 
	 * public void setSize(Dimension d) { component.setSize(d); }
	 */

	public void setSize(int width, int height) {
		execSetSize(width, height);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			VirtualToolkit.getUniqueIDByDefault();
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + widgetID
					+ SET_SIZE_COMMAND + width + "," + height + ")");
		}
	}

	public void execSetSize(int width, int height) {
		component.setSize(width, height);
	}

	/*
	 * public void setPreferredSize(Dimension d) {
	 * component.setPreferredSize(d); }
	 */

	public void resize(int width, int height) {
		component.resize(width, height);
	}

	/*
	 * public Dimension getSize() { return component.getSize(); }
	 */

	public int getHeight() {
		return component.getHeight();
	}

	public int getWidth() {
		return component.getWidth();
	}

	/*
	 * public Dimension getMinimumSize() { return component.getMinimumSize(); }
	 * 
	 * public Dimension getPreferredSize() { return component.getMinimumSize();
	 * }
	 * 
	 * public void setCursor(Object newVal) { component.setCursor((Cursor)
	 * newVal); }
	 * 
	 * public void setCursor(Cursor newVal) { component.setCursor(newVal); }
	 */
	public void setCursor(int newVal) {
		component.setCursor(newVal);
	}

	public boolean isVisible() {
		return component.isVisible();
	}

	public void setBorder(Object border) {
		component.setBorder(border);
		/*
		 * if (component instanceof JComponent) ((JComponent)
		 * component).setBorder((Border) border);
		 */
	}

	/*
	 * public void setBorder(Border border) { component.setBorder(border);
	 * 
	 * 
	 * if (component instanceof JComponent) ((JComponent) component).setBorder(
	 * border);
	 * 
	 * }
	 */

	public Object getUserObject() {
		return component.getUserObject();

	}

	public void setUserObject(Object newVal) {
		component.setUserObject(newVal);
	}

	/*
	 * public void addFocusListener(Object listener) {
	 * component.addFocusListener((FocusListener) listener);
	 * 
	 * }
	 * 
	 * public void addFocusListener(FocusListener listener) {
	 * component.addFocusListener(listener);
	 * 
	 * }
	 * 
	 * public void addKeyListener(Object listener) {
	 * component.addKeyListener((KeyListener) listener); }
	 * 
	 * public void addKeyListener(KeyListener listener) {
	 * component.addKeyListener(listener); }
	 */
	/*
	 * static transient Hashtable<Component, VirtualComponent>
	 * componentsToVirtualComponents = new Hashtable(); public static
	 * VirtualComponent existingVirtualComponent (Component c) { return
	 * componentsToVirtualComponents.get(c); } public static void register
	 * (Component c, VirtualComponent vc) { componentsToVirtualComponents.put(c,
	 * vc); } public static VirtualComponent virtualComponent (Component c) { if
	 * (c == null) return null; VirtualComponent vc =
	 * componentsToVirtualComponents.get(c); if (vc == null) { if (c instanceof
	 * JLabel) vc = new ASwingLabel ((JLabel) c); else if (c instanceof
	 * Container) vc = new AnAWTContainer((Container) c); else if (c instanceof
	 * Frame) vc = new AnAWTFrame ((Frame) c); else if (c instanceof JTree) vc =
	 * new ASwingTree ((JTree) c); else vc = new AnAWTComponent(c);
	 * componentsToVirtualComponents.put(c, vc); } return vc; }
	 */

	// @Override
	public void setBounds(int newX, int newY, int newWidth, int newHeight) {
		// TODO Auto-generated method stub

	}

	// THE BELOW METHODS are implemented and disabled above (commented out)
	public void addFocusListener(Object listener) {
		// TODO Auto-generated method stub

	}

	public void addKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub

	}

	public void addMouseListener(Object mouseListener) {
		// TODO Auto-generated method stub

	}

	public VirtualDimension getMinimumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public VirtualDimension getMaximumSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public VirtualDimension getPreferredSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public VirtualDimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBackground(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void setForeground(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void setBackground(Color newVal) {
		// TODO Auto-generated method stub

	}

	public void setBorder(Border border) {
		// TODO Auto-generated method stub

	}

	public void setCursor(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void setCursor(Cursor newVal) {
		// TODO Auto-generated method stub

	}

	public void setLocation(Point newVal) {
		// TODO Auto-generated method stub

	}

	public void setMaximumSize(Dimension d) {
		// TODO Auto-generated method stub

	}

	public void setMinimumSize(Dimension d) {
		// TODO Auto-generated method stub

	}

	public void setPreferredSize(Dimension d) {
		// TODO Auto-generated method stub

	}

	public void setSize(Dimension d) {
		// TODO Auto-generated method stub

	}

	public void setToolTipText(String s) {

	}

	public void setFont(Font newVal) {
		component.setFont(newVal);
	}

	public Object getFont() {
		return component.getFont();
	}
	public Object getFontMetrics(Object f) {
		return null;
	}

	public void addMouseListener(VirtualMouseListener listener) {
		component.addMouseListener(listener);
	}

	public void addMouseTrackListener(VirtualMouseListener listener) {
		addMouseListener(listener);
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		component.addMouseMoveListener(listener);
	}

	@Override
	public void pack() {
		// TODO Auto-generated method stub

	}

	public void addPaintListener(VirtualGraphic g) {
		component.addPaintListener(g);

	}

	@Override
	public void addKeyListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPaintListener(Object g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFocusListener(Object Listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseMoveListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreferredSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseListener(Object Listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocation(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaximumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	public void addFocusListener(VirtualFocusListener listener) {
		component.addFocusListener(listener);

	}

//	public void init() {
//		component.init();
//	}

	public boolean isDisposed() {
		return true;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualPoint getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}
