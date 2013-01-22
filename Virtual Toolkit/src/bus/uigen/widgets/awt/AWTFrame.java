package bus.uigen.widgets.awt;

import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.PopupMenu;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualPopupMenu;

//import javax.swing.Frame;

public class AWTFrame extends AWTContainer implements VirtualFrame {
	// protected VirtualContainer contents = this;
	protected VirtualContainer contents;

	public AWTFrame(Frame theFrame) {
		super(theFrame);
		// getFrame() = theFrame;
		contents = AWTContainer.virtualContainer(getFrame());

	}

	public AWTFrame() {

	}

	public Frame getFrame() {
		return (Frame) component;
	}

	public void init(Object theComponent) {
		super.init(theComponent);
		// contents = AnAWTContainer.virtualContainer(getFrame());
		contents = this;
	}

	/*
	 * public void init (Component theComponent) { super.init(theComponent);
	 * //contents = AnAWTContainer.virtualContainer(getFrame()); contents =
	 * this; }
	 */
	protected VirtualMenuBar menuBar;

	public void setMenuBar(VirtualMenuBar theMenuBar) {
		menuBar = theMenuBar;
		getFrame().setMenuBar((MenuBar) menuBar.getPhysicalComponent());
	}

	public VirtualMenuBar getMenuBar() {
		return menuBar;
	}

	public VirtualContainer getContentPane() {
		return contents;
	}

	public void setContentPane(VirtualContainer container) {
		// getFrame().setContentPane((Container)
		// container.getPhysicalComponent());
	}

	public void pack() {
		getFrame().pack();
	}

	public void setResizable(boolean newVal) {
		getFrame().setResizable(newVal);
	}

	public void setTitle(String label) {
		getFrame().setTitle(label);
	}

	public String getTitle() {
		return getFrame().getTitle();
	}

	public void setCursor(int newVal) {
		getFrame().setCursor(newVal);
	}

	public void dispose() {
		getFrame().dispose();
	}

	public void setMenuBar(Object newVal) {
		getFrame().setMenuBar((MenuBar) newVal);
	}

	public void add(VirtualPopupMenu menu) {
		if (menu.getPhysicalComponent() instanceof PopupMenu)
			getFrame().add((PopupMenu) menu.getPhysicalComponent());
	}

	public void addWindowListener(Object newVal) {
		getFrame().addWindowListener((WindowListener) newVal);
	}

	public void addComponentListener(ComponentListener cl) {
		getFrame().addComponentListener(cl);
	}

	// static transient Hashtable<Container, VirtualContainer>
	// containersToVirtualContainers = new Hashtable();
	public static VirtualFrame virtualFrame(Frame f) {
		return (VirtualFrame) AWTComponent.virtualComponent(f);

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

	public void setDefaultCloseOperation(int arg) {
		// getFrame().setDefaultCloseOperation(arg);
	}

	@Override
	public void addComponentListener(Object cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	/*
	 * Frame frame; VirtualContainer contents; public AnAWTFrame (Frame
	 * theFrame) { super (theFrame); frame = theFrame;
	 * 
	 * } public VirtualContainer getContentPane () { return this; }
	 * 
	 * public void pack() { frame.pack(); } public void setResizable(boolean
	 * newVal) { frame.setResizable(newVal); } public void setTitle (String
	 * label) { frame.setTitle(label); } public String getTitle() { return
	 * frame.getTitle(); } public void dispose() { frame.dispose(); } public
	 * void setMenuBar(Object newVal) { frame.setMenuBar ((MenuBar) newVal); }
	 * 
	 * public void setContentPane(VirtualContainer container) {
	 * frame.add((Container) container.getPhysicalComponent());
	 * System.out.println
	 * ("setContentPane: cannot change container, adding to existing content pane"
	 * ); }
	 * 
	 * public void addWindowListener(Object newVal) {
	 * frame.addWindowListener((WindowListener) newVal ); } public void
	 * addComponentListener (ComponentListener cl) {
	 * frame.addComponentListener(cl); }
	 * 
	 * //static transient Hashtable<Container, VirtualContainer>
	 * containersToVirtualContainers = new Hashtable(); public static
	 * VirtualFrame virtualFrame (Frame f) { return (VirtualFrame)
	 * AnAWTComponent.virtualComponent(f);
	 * 
	 * //return vcontainer;
	 * 
	 * }
	 */

	public void asyncExec(Runnable runnable) {
		runnable.run();
	}

	public void syncExec(Runnable runnable) {
		runnable.run();
	}

}
