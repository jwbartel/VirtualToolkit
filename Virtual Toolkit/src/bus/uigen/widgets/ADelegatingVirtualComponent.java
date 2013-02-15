package bus.uigen.widgets;

import java.awt.event.MouseListener;

import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Frame;
//import java.awt.Point;
//import java.awt.event.FocusListener;
//import java.awt.event.KeyListener;
//import java.lang.reflect.Method;
//import java.util.Hashtable;
//import javax.swing.JComponent;
//import javax.swing.JLabel;
//import javax.swing.JTree;
//import javax.swing.border.Border;

//import bus.uigen.widgets.events.VirtualMouseAdapter;
//import bus.uigen.widgets.events.ProxyMouseAdapter;
//import bus.uigen.widgets.events.VirtualMouseMoveAdapter;
//import bus.uigen.widgets.events.ProxyMouseMoveAdapter;
//import bus.uigen.widgets.events.ProxyFocusAdapter;
//import bus.uigen.widgets.events.VirtualFocusAdapter;
//import bus.uigen.widgets.events.VirtualActionAdapter;
//import bus.uigen.widgets.events.ProxyActionAdapter;

public class ADelegatingVirtualComponent implements VirtualComponent {
	VirtualComponent component;

	// VirtualContainer parent;
	public ADelegatingVirtualComponent(VirtualComponent theComponent) {
		component = theComponent;

	}

	public ADelegatingVirtualComponent() {

	}

	public void init() {
		component.init();
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

	public void setBackground(Object newVal) {
		component.setBackground(newVal);
	}

	public void setForeground(Object newVal) {
		component.setForeground(newVal);
	}

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
	 */

	/*
	 * public void setMinimumSize(Dimension d) { component.setMinimumSize(d); }
	 */

	/*
	 * public void setSize(Dimension d) { component.setSize(d); }
	 */

	public void setSize(int width, int height) {
		execSetSize(width, height);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String uniqueID = VirtualToolkit.getUniqueIDByDefault();
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

	public VirtualDimension getSize() {
		return component.getSize();
	}

	public int getHeight() {
		return component.getHeight();
	}

	public int getWidth() {
		return component.getWidth();
	}

	public VirtualDimension getMinimumSize() {
		return component.getMinimumSize();
	}

	public VirtualDimension getPreferredSize() {
		return component.getMinimumSize();
	}

	public void setCursor(Object newVal) {
		component.setCursor(newVal);
	}

	/*
	 * public void setCursor(Cursor newVal) { component.setCursor(newVal); }
	 */
	public void setCursor(int newVal) {
		component.setCursor(newVal);
	}

	/*
	 * public void setFont(Font newVal) { component.setFont(newVal); }
	 */
	public Object getFont() {
		return component.getFont();
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
	 * public void setBorder(Border border) { component.setBorder(border); /*
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

	public void setToolTipText(String s) {
		component.setToolTipText(s);
	}

	/*
	 * public void addKeyListener(Object listener) {
	 * component.addKeyListener((KeyListener) listener); }
	 */

	/*
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

	public void pack() {
		component.pack();

	}

	public void addFocusListener(VirtualFocusListener listener) {
		component.addFocusListener(listener);
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		component.addMouseMoveListener(listener);
	}

	@Override
	public void addPaintListener(Object g) {
		component.addPaintListener(g);
	}

	@Override
	public void removeFocusListener(Object Listener) {
		component.removeFocusListener(Listener);
	}

	@Override
	public void removeMouseMoveListener(Object listener) {
		component.removeMouseMoveListener(listener);
	}

	@Override
	public void setMinimumSize(VirtualDimension d) {
		component.setMinimumSize(d);
	}

	@Override
	public void setPreferredSize(VirtualDimension d) {
		component.setPreferredSize(d);
	}

	@Override
	public void setSize(VirtualDimension d) {
		component.setSize(d);
	}

	@Override
	public void removeMouseListener(Object Listener) {
		component.removeMouseListener(Listener);
	}

	@Override
	public void setLocation(Object newVal) {
		component.setLocation(newVal);
	}

	@Override
	public void setMaximumSize(VirtualDimension d) {
		component.setMaximumSize(d);
	}

	@Override
	public void setFont(Object f) {
		component.setFont(f);
	}

	@Override
	public void addKeyListener(Object listener) {
		component.addKeyListener(listener);
	}

	public void addMouseListener(VirtualMouseListener listener) {
		component.addMouseListener(listener);
	}

	public void addMouseTrackListener(VirtualMouseListener listener) {
		addMouseListener(listener);
	}

	/*
	 * public void addPaintListener(VirtualGraphic g) {
	 * component.addPaintListener(g);
	 * 
	 * }
	 */

	public boolean isDisposed() {
		return true;
	}

	@Override
	public void addMouseListener(Object listener) {
		component.addMouseListener((MouseListener) listener);

	}

	@Override
	public VirtualDimension getMaximumSize() {
		return component.getMaximumSize();

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return component.getX();
	}

	@Override
	public int getY() {
		return component.getY();
	}

	@Override
	public VirtualPoint getLocation() {
		return component.getLocation();
	}

}
