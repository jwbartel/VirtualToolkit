package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentListener;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualInternalFrame;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;
import bus.uigen.widgets.awt.AWTLayout;

public class SwingInternalFrame extends SwingComponent implements
		VirtualInternalFrame {
	// JInternalFrame getFrame();
	VirtualContainer contents;

	public SwingInternalFrame(JInternalFrame theFrame) {
		super(theFrame);
		// getFrame() = theFrame;
		contents = AWTContainer.virtualContainer(getJInternalFrame()
				.getContentPane());

	}

	public SwingInternalFrame() {

	}

	public JInternalFrame getJInternalFrame() {
		return (JInternalFrame) component;
	}

	public void init(Object theComponent) {
		super.init(theComponent);
		contents = AWTContainer.virtualContainer(getJInternalFrame()
				.getContentPane());
	}

	public VirtualContainer getContentPane() {
		return contents;
	}

	public void setContentPane(VirtualContainer container) {
		getJInternalFrame().setContentPane(
				(Container) container.getPhysicalComponent());
	}

	public void pack() {
		getJInternalFrame().pack();
	}

	public void setResizable(boolean newVal) {
		getJInternalFrame().setResizable(newVal);
	}

	public void setTitle(String label) {
		getJInternalFrame().setTitle(label);
	}

	public String getTitle() {
		return getJInternalFrame().getTitle();
	}

	/*
	 * public void setCursor (int newVal) {
	 * getJInternalFrame().setCursor(newVal); }
	 */
	public void dispose() {
		getJInternalFrame().dispose();
	}

	VirtualMenuBar menuBar;

	public void setMenuBar(VirtualMenuBar newVal) {
		menuBar = newVal;
		getJInternalFrame().setJMenuBar(
				(JMenuBar) newVal.getPhysicalComponent());
	}

	public VirtualMenuBar getMenuBar() {
		return menuBar;
	}

	public void addWindowListener(Object newVal) {
		/*
		 * getJInternalFrame().addWindowListener((WindowListener) newVal );
		 */
	}

	public void addComponentListener(ComponentListener cl) {
		getJInternalFrame().addComponentListener(cl);
	}

	// static transient Hashtable<Container, VirtualContainer>
	// containersToVirtualContainers = new Hashtable();
	public static VirtualInternalFrame virtualFrame(JInternalFrame f) {
		return (VirtualInternalFrame) AWTComponent.virtualComponent(f);
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
		getJInternalFrame().setDefaultCloseOperation(arg);
	}

	public void add(VirtualPopupMenu menu) {

	}

	public void setLayout(VirtualLayout l) {
		if (!(l == null || l instanceof AWTLayout)) {
			throw new IllegalArgumentException("Argument must be of SWT type");
		}
		getJInternalFrame().setLayout(((AWTLayout) l).getLayout());

	}

	@Override
	public void addComponentListener(Object cl) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayout(Object l) {
		// TODO Auto-generated method stub

	}

	public void add(VirtualComponent c) {
		this.getJInternalFrame().add((Component) c.getPhysicalComponent());

	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

	public void asyncExec(Runnable runnable) {
		runnable.run();
	}

	public void syncExec(Runnable runnable) {
		runnable.run();
	}

}
