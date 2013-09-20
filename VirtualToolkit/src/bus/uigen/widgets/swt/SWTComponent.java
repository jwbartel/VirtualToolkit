package bus.uigen.widgets.swt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.border.Border;

import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDimension;
import bus.uigen.widgets.VirtualPoint;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;
import bus.uigen.widgets.exceptions.VirtualException;
import bus.uigen.widgets.graphics.VirtualGraphic;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public abstract class SWTComponent extends CentralUniversalWidget implements
		VirtualComponent {
	// Component component;
	// Control component;

	String name;

	Vector<VirtualFocusListener> vFocusListeners = new Vector<VirtualFocusListener>();
	Vector<VirtualMouseListener> vMouseListeners = new Vector<VirtualMouseListener>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();

	VirtualContainer parent;
	int xLocation = 0, yLocation = 0;
	int width = -1, height = -1; // conceivably someone might want to set width
									// or height to 0
	boolean toPack = false; // if object is set to be packed when it is created

	Vector<SWTGraphic> graphics = new Vector<SWTGraphic>();

	public SWTComponent(Control theComponent) {
		super(theComponent);
		// component = theComponent;

	}

	public SWTComponent() {

	}

	public void init() {
		SWTComponentEventForwarder forwarder = new SWTComponentEventForwarder(
				this);
		getComponent().addFocusListener(forwarder);
		getComponent().addMouseListener(forwarder);
		getComponent().addMouseTrackListener(forwarder);
		getComponent().addMouseMoveListener(forwarder);
	}

	public Control getComponent() {
		return (Control) component;

	}

	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
		return vMouseMoveListeners;
	}

	public Vector<VirtualFocusListener> getVirtualFocusListeners() {
		return vFocusListeners;
	}

	public Vector<VirtualMouseListener> getVirtualMouseListeners() {
		return vMouseListeners;
	}

	public void init(Control theComponent) {
		super.init(theComponent);
	}

	/*
	 * public void init (Object theComponent) { init ((Component) theComponent);
	 * }
	 */
	public void setParent(VirtualContainer theParent) {
		parent = theParent;
	}

	public VirtualContainer getParent() {
		if (parent != null)
			return parent;
		if (getComponent().getParent() == null)
			return null;
		return SWTContainer.virtualContainer(getComponent().getParent());
	}

	public void invalidate() {
		// getComponent().invalidate();
	}

	public void setVisible(boolean newVal) {
		getComponent().setVisible(newVal);
	}

	public String getName() {
		return name;
	}

	public void setName(String newVal) {
		String oldName = this.name;
		execSetName(newVal);

		String command = VirtualComponent.COMMAND_LABEL + oldName
				+ VirtualComponent.SET_NAME_COMMAND + name + ")";
		VirtualToolkit.sendCommandByDefault(command);
	}

	public void execSetName(String newVal) {
		VirtualToolkit.defaultReassociate(name, newVal, this);
		this.name = newVal;
	}

	public Object getPhysicalComponent() {
		return getComponent();
	}

	public Control getSWTComponent() {
		return getComponent();
	}

	public void doLayout() {
		// getComponent().doLayout();
	}

	public void setLocation(int newX, int newY) {
		// getComponent().setLocation(newX, newY); //component does not yet
		// exist
		xLocation = newX;
		yLocation = newY;
	}

	public void setLocation(Point newVal) {
		getComponent().setLocation(newVal.x, newVal.y);
	}

	public void setBounds(int newX, int newY, int newWidth, int newHeight) {
		setLocation(newX, newY);
		setSize(newWidth, newHeight);
	}

	public void repaint() {
		if (parent != null) {
			parent.repaint();
		}
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

	public void setBackground(Object newVal) {
		// getComponent().setBackground((Color) newVal);
	}

	public void setForeground(Object newVal) {
		// getComponent().setBackground((Color) newVal);
	}

	public void setBackground(Color newVal) {
		// getComponent().setBackground(newVal);
	}

	public Object getBackground() {
		return getComponent().getBackground();
	}

	public void setEnabled(boolean newVal) {
		getComponent().setEnabled(newVal);
	}

	public void setMaximumSize(Dimension d) {
		// getComponent().setMaximumSize(d);
	}

	public void setMinimumSize(Dimension d) {
		// getComponent().setMinimumSize(d);
	}

	public void setSize(Dimension d) {
		// getComponent().setSize(d);
	}

	public void setSize(int newWidth, int newHeight) {
		execSetSize(newWidth, newHeight);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			VirtualToolkit.getUniqueIDByDefault();
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + widgetID
					+ SET_SIZE_COMMAND + newWidth + "," + newHeight + ")");
		}
	}

	class SizeSetter implements Runnable {
		int width;
		int height;

		public SizeSetter(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public void run() {
			getComponent().setSize(width, height);
		}

	}

	public void execSetSize(int newWidth, int newHeight) {
		// getComponent().setSize(newWidth, newHeight); //impossible for Button,
		// TextField because the component does not exist yet

		width = newWidth;
		height = newHeight;
		if (getComponent() != null) {
			// Control component = getComponent);
			SizeSetter setter = new SizeSetter(newWidth, newHeight);
			getComponent().getDisplay().asyncExec(setter);
		}
	}

	public void setPreferredSize(Dimension d) {
		// getComponent().setPreferredSize(d);
	}

	public void resize(int width, int height) {
		// getComponent().resize(width, height);
	}

	public VirtualDimension getSize() {
		return new VirtualDimension(getComponent().getSize().x, getComponent()
				.getSize().y);
		// return getComponent().getSize();
	}

	public int getHeight() {
		if (height != -1 || getComponent() == null) {
			return height;
		} else {
			return getComponent().getSize().y;
		}
		// return getComponent().getHeight();
	}

	public int getWidth() {
		if (width != -1 || getComponent() == null) {
			return width;
		} else {
			return getComponent().getSize().x;
		}
		// return getComponent().getWidth();
	}

	public VirtualDimension getMinimumSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public VirtualDimension getMaximumSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public VirtualDimension getPreferredSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public void setCursor(Object newVal) {
		getComponent().setCursor((Cursor) newVal);
	}

	public void setCursor(java.awt.Cursor newVal) {
		// getComponent().setCursor(newVal);
	}

	public void setCursor(int newVal) {

	}

	public boolean isVisible() {
		return getComponent().isVisible();
	}

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

	public void setAlignmentX(float x) {
		/*
		 * if (getComponent() instanceof JComponent) ((JComponent)
		 * getComponent()).setAlignmentX( x);
		 */
	}

	public void setAlignmentY(float y) {
		/*
		 * if (getComponent() instanceof JComponent) ((JComponent)
		 * getComponent()).setAlignmentY( y);
		 */
	}

	public void setToolTipText(String s) {

	}

	public void addKeyListener(Object listener) {
		// getComponent().addKeyListener((KeyListener) listener);
	}

	public void addKeyListener(KeyListener listener) {
		// getComponent().addKeyListener( listener);
	}

	/*
	 * static transient Hashtable<Component, VirtualComponent>
	 * componentsToVirtualComponents = new Hashtable(); static transient
	 * Hashtable<Class, Class> componentClassToVirtualComponentClass = new
	 * Hashtable(); public static VirtualComponent existingVirtualComponent
	 * (Component c) { return componentsToVirtualComponents.get(c);
	 * 
	 * } public static void register (Component c, VirtualComponent vc) {
	 * componentsToVirtualComponents.put(c, vc); } public static Class
	 * getVirtualClass(Class c) { //return AUniversalWidget.getVirtualClass(c);
	 * 
	 * Class virtualClass = componentClassToVirtualComponentClass.get(c); Class
	 * superClass = c.getSuperclass(); if (virtualClass != null) return
	 * virtualClass; else if (superClass != null) return getVirtualClass
	 * (superClass); else return null;
	 * 
	 * }
	 */
	public void setFont(Font f) {

	}

	public Font getFont() {
		return null;
	}
	public Object getFontMetrics(Object f) {
		return null;
	}


	public static VirtualComponent virtualComponent(Control c) {
		return (VirtualComponent) CentralUniversalWidget.universalWidget(c);
		/*
		 * if (c == null) return null; VirtualComponent vc =
		 * componentsToVirtualComponents.get(c); if (vc == null) { try { //Class
		 * virtualClass =
		 * componentClassToVirtualComponentClass.get(c.getClass()); Class
		 * virtualClass = getVirtualClass(c.getClass()); if (virtualClass ==
		 * null) vc = new AnAWTComponent(c); else { vc = (VirtualComponent)
		 * virtualClass.newInstance(); vc.init(c); }
		 * 
		 * } catch (Exception e) { vc = new AnAWTComponent(c); }
		 * componentsToVirtualComponents.put(c, vc);
		 * 
		 * 
		 * }
		 * 
		 * return vc;
		 */

	}

	/*
	 * public static void register (Class componentClass, Class virtualClass) {
	 * componentClassToVirtualComponentClass.put(componentClass, virtualClass);
	 * } public static void registerVirtualComponentClasses() { register
	 * (Component.class, AnAWTComponent.class); register (Container.class,
	 * AnAWTContainer.class); register (Frame.class, AnAWTFrame.class);
	 * //register (JPanel.class, ASwingPanel.class); register (JLabel.class,
	 * ASwingLabel.class); register (JToolBar.class, ASwingToolBar.class);
	 * register (JFrame.class, ASwingFrame.class); register (JTextField.class,
	 * ASwingTextField.class); register (JTextArea.class, ASwingTextArea.class);
	 * register (JButton.class, ASwingButton.class); register (JSlider.class,
	 * ASwingSlider.class); register (JComboBox.class, ASwingComboBox.class);
	 * register (JPasswordField.class, ASwingPasswordField.class); register
	 * (JRadioButton.class, ASwingRadioButton.class); register (JSlider.class,
	 * ASwingSlider.class); register (JSplitPane.class, ASwingSplitPane.class);
	 * register (JTabbedPane.class, ASwingTabbedPane.class); register
	 * (JTree.class, ASwingTree.class); register (JTable.class,
	 * ASwingTable.class);
	 * 
	 * }
	 */

	/*
	 * Check to make sure parent and parent's component has been intialized
	 * 
	 * This indicates a component has been initialized to have component added
	 * to it
	 */

	public void addMouseListener(VirtualMouseListener listener) {
		vMouseListeners.add(listener);
	}

	public void addMouseTrackListener(VirtualMouseListener listener) {
		addMouseListener(listener);
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		vMouseMoveListeners.add(listener);
	}

	public void addFocusListener(VirtualFocusListener listener) {
		vFocusListeners.add(listener);
	}

	public void addAllListeners() {

		for (int i = 0; i < graphics.size(); i++) {
			getComponent().addPaintListener(graphics.get(i));
		}
	}

	public void pack() {
		if (getComponent() != null) {
			// Runnable packer = new Runnable(){
			// public void run(){
			if (width >= 0 && height >= 0) {
				getComponent().setSize(width, height);
			} else {
				getComponent().pack();
			}

			// }
			// };
			// getComponent().getDisplay().asyncExec(packer);
		}
	}

	public void addPaintListener(VirtualGraphic g1) {
		SWTGraphic g = (SWTGraphic) g1;
		graphics.add(g);
		if (getComponent() != null) {
			getComponent().addPaintListener(g);
		}
	}

	@Override
	public void addToParent(VirtualContainer theParent) {
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

	public boolean isDisposed() {
		return true;
	}

	public void addMouseListener(Object listener) {

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
