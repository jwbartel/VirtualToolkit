package bus.uigen.widgets.swt;

import java.awt.LayoutManager;
import java.util.Vector;

import org.eclipse.swt.widgets.Composite;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualToolkit;

public abstract class SWTContainer extends SWTComponent implements
		VirtualContainer {
	// Container getContainer();
	Vector<VirtualComponent> children = new Vector<VirtualComponent>();
	SWTLayout layout = new SWTFlowLayout();

	public SWTContainer(Composite theContainer) {
		super(theContainer);
		// getContainer() = theContainer;

	}

	public SWTContainer() {

	}

	public Composite getContainer() {
		return (Composite) component;
	}

	/*
	 * public void setMenuBar(VirtualMenuBar theMenuBar) {
	 * 
	 * }
	 */// should this go in SWTContainer?
	public void setContainer(Composite theContainer) {
		component = theContainer;
	}

	void addExistingChildren() {
		if (component == null)
			return;
		for (int i = 0; i < children.size(); i++)
			children.elementAt(i).addToParent(this);
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

		// this.verifyInitialization();

		if (!(c instanceof SWTComponent)) {
			if (c != null) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			}
		}

		if (component == null) {
			// children.add(c);
			this.addChild(children.size(), c);
		} else {
			// children.add(c);
			this.addChild(children.size(), c);
			// c.addToParent(this);
			this.getComponent().getDisplay()
					.asyncExec(new AddsToParent(this, c));

			// getContainer().add((Component) (c.getPhysicalComponent()));
			// c.setParent(this);
		}

	}

	private class AddsToParent implements Runnable {
		VirtualContainer container;
		VirtualComponent c;

		public AddsToParent(VirtualContainer container, VirtualComponent c) {
			this.container = container;
			this.c = c;
		}

		public void run() {
			c.addToParent(container);
			container.execSetSize(container.getWidth(), container.getHeight());
			container.pack();
			container.layout();
		}
	}

	public void add(VirtualComponent c, int pos) {
		/*
		 * getContainer().add((Component) (c.getPhysicalComponent()), pos);
		 * c.setParent(this);
		 */
	}

	public void add(VirtualComponent c, String direction) {
		/*
		 * getContainer().add((Component) c.getPhysicalComponent(), direction )
		 * ;
		 */
	}

	public void add(VirtualComponent c, Object constraint) {
		/*
		 * //getContainer().add(((AnSWTComponent) c).getSWTComponent(),
		 * constraint); getContainer().add((Component)
		 * (c.getPhysicalComponent()), constraint); c.setParent(this);
		 */

	}

	public void add(VirtualComponent c, Object constraint, int pos) {
		/*
		 * //getContainer().add(((AnSWTComponent) c).getSWTComponent(),
		 * constraint, pos); getContainer().add((Component)
		 * (c.getPhysicalComponent()), constraint, pos); c.setParent(this);
		 */

	}

	public void remove(VirtualComponent c) {
		/*
		 * getContainer().remove((Component) (c.getPhysicalComponent()));
		 * c.setParent(null);
		 */

		// TODO fix this method

		/*
		 * children.remove(c); //is this valid in all cases? see add() method
		 * above c.setParent(null); //what am i doing here? c.invalidate();
		 * //what does this do?
		 */}

	public void remove(int pos) {
		/*
		 * getContainer().remove( pos);
		 */

	}

	public void removeAll() {
		/*
		 * getContainer().removeAll();
		 */
	}

	public int getComponentCount() {
		return 0;
		/*
		 * return getContainer().getComponentCount();
		 */
	}

	public int countComponents() {
		return 0;
		/*
		 * return getContainer().countComponents();
		 */
	}

	public void setLayout(Object layoutManager) {
		/*
		 * getContainer().setLayout((LayoutManager) layoutManager);
		 */
	}

	public void setLayout(LayoutManager layoutManager) {
		// getContainer().setLayout(layoutManager);
	}

	public Object getLayout() {
		return null;
		// return getContainer().getLayout();
	}

	public VirtualComponent[] getComponents() {
		return null;
		/*
		 * Component[] components = getContainer().getComponents();
		 * VirtualComponent[] retVal = new VirtualComponent[components.length];
		 * for (int i = 0; i < components.length; i++) retVal[i] =
		 * SWTComponent.virtualComponent(components[i]); return retVal;
		 */
	}

	public VirtualComponent getComponent(int pos) {
		return null;
		/*
		 * return
		 * SWTComponent.virtualComponent(getContainer().getComponents()[pos]);
		 */
	}

	// static transient Hashtable<Container, VirtualContainer>
	// getContainer()sToVirtualContainers = new Hashtable();
	public static VirtualContainer virtualContainer(Composite c) {
		return (VirtualContainer) SWTComponent.virtualComponent(c);
		/*
		 * if (c == null) return null; VirtualComponent vcomp =
		 * AnSWTComponent.existingVirtualComponent(c); if (c != null) return
		 * (VirtualContainer) vcomp; VirtualContainer vgetContainer() = new
		 * AnSWTContainer(c); AnSWTComponent.register (c, vgetContainer());
		 */
		/*
		 * getContainer()sToVirtualContainers.get(c); if (vc == null) { vc = new
		 * AnSWTContainer(c); getContainer()sToVirtualContainers.put(c, vc); }
		 */
		// return vgetContainer();

	}

	public void adjustParentSize(int deltaWidth, int deltaHeight) {

	}

	public void setLocation(int newX, int newY) {
		// override for SWTContainer
		getComponent().setLocation(newX, newY);
	}

	public void pack() {
		this.execSetLayout(layout);
		for (int i = 0; i < children.size(); i++) {
			children.get(i).pack();
		}
		super.pack();
	}

	public void verifyInitialization() {
		if (this.component == null) {
			throw new NullPointerException(
					"Component in SWTComponent unitialized");
		}
	}

	public void addChild(int pos, VirtualComponent c) {
		for (int i = 0; i < children.size(); i++) {
			// VirtualComponent child = children.get(i);
			if (children.get(i) == c) {
				children.remove(i);
				i--;
			}
		}
		if (pos >= children.size()) {
			children.add(c);
		} else {
			children.add(pos, c);
		}
	}

	public void setLayout(VirtualLayout l) {
		execSetLayout(l);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String lID = l.getName();
			VirtualToolkit.sendCommandByDefault(VirtualContainer.COMMAND_LABEL
					+ widgetID + SET_LAYOUT_COMMAND + lID + ")");
		}
	}

	public void execSetLayout(VirtualLayout l) {
		if (!(l == null || l instanceof SWTLayout)) {
			throw new IllegalArgumentException("Argument must be of SWT type");
		}
		layout = (SWTLayout) l;
		if (getContainer() != null) {
			LayoutSetter setter = new LayoutSetter(layout);
			getContainer().getDisplay().asyncExec(setter);

		}
	}

	class LayoutSetter implements Runnable {
		SWTLayout layout;

		public LayoutSetter(SWTLayout layout) {
			this.layout = layout;
		}

		public void run() {
			getContainer().setLayout(layout.getLayout());
		}
	}

	public void layout() {
		getContainer().layout();
	}

	public void requestFocus() {
		// TODO
		System.out.println("Stub method");

	}
}
