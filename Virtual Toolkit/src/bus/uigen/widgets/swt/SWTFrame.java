package bus.uigen.widgets.swt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.border.Border;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDimension;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.universal.CentralUniversalWidget;

//public class SWTFrame extends AUniversalWidget  implements VirtualFrame {
public class SWTFrame extends SWTContainer implements VirtualFrame,
		VirtualContainer { // this should really be SWTShell
	// JFrame getFrame();
	VirtualContainer contents; // shell
	VirtualContainer parent;
	protected VirtualMenuBar menuBar;

	public SWTFrame(Display theFrame, VirtualContainer theContents) {
		// getFrame() = theFrame;
		contents = theContents;
		resetContents();
		// contents =
		// AnAWTContainer.virtualContainer(getJFrame().getContentPane());

	}

	public SWTFrame() {

	}

	public void init() {
		super.init();
	}

	public Shell getShell() { // getFrame()
		return (Shell) contents.getPhysicalComponent();
	}

	public void add(VirtualComponent c) {
		execAdd(c);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String cID = c.getName();
			VirtualToolkit.sendCommandByDefault(VirtualContainer.COMMAND_LABEL
					+ widgetID + ADD_COMMAND + cID + ")");
		}
	}

	public void execAdd(VirtualComponent c) {

		if (!(c instanceof SWTComponent)) {
			if (c != null) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			}
		}

		if (this.getContentPane() == null) {
			// children.add(c);
			this.addChild(children.size(), c);
		} else {
			// children.add(c);
			this.addChild(children.size(), c);
			this.getContentPane().execAdd(c);
			// getContainer().add((Component) (c.getPhysicalComponent()));
			// c.setParent(this);
		}

	}

	public void addToParent(VirtualContainer theParent) {

		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an unitialized parent");
				}
			}
		}
		init();

		if (layout != null)
			getShell().setLayout(layout.getLayout());
		addAllListeners();

	}

	public Display getDisplay() {
		return (Display) component;
	}

	public void init(Object theComponent) {
		super.init(theComponent);
		resetContents();
		// contents =
		// AnAWTContainer.virtualContainer(getJFrame().getContentPane());
	}

	public VirtualMenuBar getMenuBar() {
		return menuBar;
	}

	public VirtualContainer getContentPane() {
		// return getJFrame().
		return contents;
	}

	public void setContentPane(VirtualContainer container) {
		contents = container;
		this.execSetLayout(layout);
		// getJFrame().setContentPane((Container)
		// container.getPhysicalComponent());
		// resetContents();

	}

	void resetContents() {
		// contents =
		// AWTContainer.virtualContainer(getDisplay().getContentPane());
	}

	public void setMenuBar(VirtualMenuBar theMenuBar) {
		/*
		 * menuBar = theMenuBar; Object component =
		 * menuBar.getPhysicalComponent(); if (component instanceof JMenuBar)
		 * ((JFrame) getFrame()).setJMenuBar ((JMenuBar)
		 * menuBar.getPhysicalComponent()); else super.setMenuBar(menuBar);
		 */

		// where does the new Menu() command go here?
		// perhaps menuBar.create() can return a new Menu, which is then set to
		// menuBar's physical component somehow
		// or instead of menuBar we could use an actual Menu variable

		menuBar = theMenuBar;
		Menu menu = ((SWTMenuBar) menuBar).create(getShell());
		// super.setMenuBar(menuBar);
		// contents.getPhysicalComponent().setMenuBar ((MenuBar)
		// menuBar.getPhysicalComponent());
		// getShell().setMenuBar((MenuBar) menuBar.getPhysicalComponent());
		// //has to take Menu
		// getShell().setMenuBar((Menu) menuBar.getPhysicalComponent()); //is
		// this ok? i probably first have to create the component
		getShell().setMenuBar(menu);
		// System.out.println("Menu has been set to Shell");
		// ((SWTMenuBar) menuBar).create(getShell()); //physically define menus
		// and submenus here
	}

	/*
	 * public void pack() { getJFrame().pack(); } public void
	 * setResizable(boolean newVal) { getJFrame().setResizable(newVal); } public
	 * void setTitle (String label) { getJFrame().setTitle(label); } public
	 * String getTitle() { return getJFrame().getTitle(); }
	 * 
	 * public void setCursor (int newVal) { getJFrame().setCursor(newVal); }
	 * public void dispose() { getJFrame().dispose(); } public void
	 * setMenuBar(Object newVal) { getJFrame().setMenuBar ((MenuBar) newVal); }
	 * 
	 * public void addWindowListener(Object newVal) {
	 * getJFrame().addWindowListener((WindowListener) newVal ); } public void
	 * addComponentListener (ComponentListener cl) {
	 * getJFrame().addComponentListener(cl); }
	 */
	// static transient Hashtable<Container, VirtualContainer>
	// containersToVirtualContainers = new Hashtable();

	public void setCursor(Object newVal) {
		getContentPane().setCursor((Cursor) newVal);
	}

	public void setCursor(java.awt.Cursor newVal) {
		// getComponent().setCursor(newVal);
	}

	public void setDefaultCloseOperation(int arg) {
		// getFrame().setDefaultCloseOperation(arg);
	}

	public void addFocusListener(Object listener) {
		// getComponent().addFocusListener((FocusListener) listener);

	}

	public void addFocusListener(FocusListener listener) {
		// getComponent().addFocusListener( listener);

	}

	public void addKeyListener(Object listener) {
		// getComponent().addKeyListener((KeyListener) listener);
	}

	public void addKeyListener(KeyListener listener) {
		// getComponent().addKeyListener( listener);
	}

	public void pack() {
		this.execSetLayout(layout);
		for (int i = 0; i < children.size(); i++) {
			children.get(i).pack();
		}
		getContentPane().pack();
	}

	public void setResizable(boolean newVal) {
		// getDisplay().setResizable(newVal);
	}

	public void setTitle(String label) {
		// getDisplay().setTitle(label);
	}

	public String getTitle() {
		return "";
		// return getDisplay().getTitle();
	}

	public void setCursor(int newVal) {
		// getDisplay().setCursor(newVal);
	}

	public void dispose() {
		getDisplay().dispose();
	}

	public void setMenuBar(Object newVal) {
		// getDisplay().setMenuBar ((MenuBar) newVal);
	}

	public void addWindowListener(Object newVal) {
		// getDisplay().addWindowListener((WindowListener) newVal );
	}

	public void addComponentListener(ComponentListener cl) {
		// getDisplay().addComponentListener(cl);
	}

	// static transient Hashtable<Container, VirtualContainer>
	// containersToVirtualContainers = new Hashtable();
	public static VirtualFrame virtualFrame(Display f) {
		return (VirtualFrame) CentralUniversalWidget.universalWidget(f);

		/*
		 * if (c == null) return null; VirtualComponent vcomp =
		 * AnAWTComponent.existingVirtualComponent(c); if (c != null) return
		 * (VirtualContainer) vcomp; VirtualContainer vcontainer = new
		 * AnAWTContainer(c); AnAWTComponent.register (c, vcontainer);
		 */
		/*
		 * containersToVirtualContainers.get(c); if (vc == null) { vc = new
		 * AnAWTContainer(c); containersToVirtualContainers.put(c, vc); }
		 */
		// return vcontainer;

	}

	public int getHeight() {
		return getContentPane().getHeight();
		// return getComponent().getHeight();
	}

	public VirtualDimension getMinimumSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public void setLocation(int newX, int newY) {
		getContentPane().setLocation(newX, newY);
	}

	public void setLocation(Point newVal) {
		getContentPane().setLocation(newVal.x, newVal.y);
	}

	public void setSize(Dimension d) {
		// getComponent().setSize(d);
	}

	public void execSetSize(int width, int height) {
		getContentPane().execSetSize(width, height);
	}

	public VirtualDimension getSize() {
		return getContentPane().getSize();
		// return new Dimension (getComponent().getSize().x,
		// getComponent().getSize().y);
		// return getComponent().getSize();
	}

	public void setParent(VirtualContainer theParent) {
		// parent = theParent;
	}

	public VirtualContainer getParent() {
		return parent;
		/*
		 * if (parent != null) return parent; if (getContainer().getParent() ==
		 * null) return null; return
		 * SWTContainer.virtualContainer(getComponent().getParent());
		 */
	}

	public void setBackground(Object newVal) {
		// getComponent().setBackground((Color) newVal);
	}

	public void setBackground(Color newVal) {
		// getComponent().setBackground(newVal);
	}

	public Object getBackground() {
		return getContentPane().getBackground();
	}

	public void addMouseListener(Object mouseListener) {
		// getComponent().addMouseListener((MouseListener) mouseListener);
	}

	public void setEnabled(boolean newVal) {
		getContentPane().setEnabled(newVal);
	}

	public void setMaximumSize(Dimension d) {
		// getComponent().setMaximumSize(d);
	}

	public void setMinimumSize(Dimension d) {
		// getComponent().setMinimumSize(d);
	}

	public void setPreferredSize(Dimension d) {
		// getComponent().setPreferredSize(d);
	}

	public void resize(int width, int height) {
		// getComponent().resize(width, height);
	}

	public int getWidth() {
		return ((VirtualDimension) getContentPane().getSize()).getWidth();
		// return getComponent().getWidth();
	}

	public VirtualDimension getPreferredSize() {
		return getSize();
		// return getComponent().getMinimumSize();
	}

	public boolean isVisible() {
		return getContentPane().isVisible();
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

	public void invalidate() {
		// getComponent().invalidate();
	}

	/*
	 * public void setVisible (boolean newVal) { getWidget().setVisible(newVal);
	 * }
	 */

	public String getName() {
		return name;
		// return getComponent().getName();
	}

	public Object getPhysicalComponent() {
		return getDisplay();
	}

	public void doLayout() {
		// getComponent().doLayout();
	}

	/*
	 * public void setLocation(int newX, int newY) {
	 * getWidget().setLocation(newX, newY); } public void setLocation(Point
	 * newVal) { getComponent().setLocation(newVal.x, newVal.y); }
	 */

	public void repaint() {
		getShell().redraw();
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

	public void setVisible(boolean newVal) {
		// getDisplay().syncExec(new SetVisibleThread(newVal));
		getShell().setVisible(newVal);
	}

	public void add(VirtualPopupMenu menu) {

	}

	class LayoutSetter implements Runnable {
		SWTLayout layout;

		public LayoutSetter(SWTLayout layout) {
			this.layout = layout;
		}

		public void run() {
			getShell().setLayout(layout.getLayout());
		}
	}

	public void execSetLayout(VirtualLayout l) {
		if (!(l == null || l instanceof SWTLayout)) {
			throw new IllegalArgumentException("Argument must be of SWT type");
		}
		layout = (SWTLayout) l;
		contents.execSetLayout(layout);
		if (component != null) {
			getShell().getDisplay().asyncExec(new LayoutSetter(layout));
		}
	}

	@Override
	public void addComponentListener(Object cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	public void asyncExec(Runnable runnable) {
		getDisplay().asyncExec(runnable);
	}

	public void syncExec(Runnable runnable) {
		getDisplay().syncExec(runnable);
	}

	public void setName(String id) {
		super.setName(id);
		contents.execSetName(id);
	}

	public void execSetName(String id) {
		super.execSetName(id);
		contents.execSetName(id);
	}

	@Override
	public void setGlassPane(VirtualComponent aGlassPane) {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualComponent getGlassPane() {
		// TODO Auto-generated method stub
		return null;
	}
}
