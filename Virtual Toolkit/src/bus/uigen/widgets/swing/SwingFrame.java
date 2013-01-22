package bus.uigen.widgets.swing;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;
import bus.uigen.widgets.awt.AWTFrame;

public class SwingFrame extends AWTFrame implements VirtualFrame {
	// JFrame getFrame();
	// VirtualContainer contents;
	public SwingFrame(JFrame theFrame) {
		super(theFrame);
		// getFrame() = theFrame;
		resetContents();
		// contents =
		// AnAWTContainer.virtualContainer(getJFrame().getContentPane());

	}

	public SwingFrame() {
		// super(new JFrame());
	}

	public JFrame getJFrame() {
		return (JFrame) component;
	}

	public void init(Object theComponent) {
		super.init(theComponent);
		resetContents();
		// contents =
		// AnAWTContainer.virtualContainer(getJFrame().getContentPane());
	}

	public VirtualContainer getContentPane() {
		// return getJFrame().
		return contents;
	}

	public void setContentPane(VirtualContainer container) {
		getJFrame()
				.setContentPane((Container) container.getPhysicalComponent());
		resetContents();

	}

	void resetContents() {
		contents = AWTContainer.virtualContainer(getJFrame().getContentPane());
	}

	public void setMenuBar(VirtualMenuBar theMenuBar) {
		menuBar = theMenuBar;
		Object component = menuBar.getPhysicalComponent();
		if (component instanceof JMenuBar)
			((JFrame) getFrame()).setJMenuBar((JMenuBar) menuBar
					.getPhysicalComponent());
		else
			super.setMenuBar(menuBar);
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
	public static VirtualFrame virtualFrame(JFrame f) {
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
		getJFrame().setDefaultCloseOperation(arg);
	}

}
