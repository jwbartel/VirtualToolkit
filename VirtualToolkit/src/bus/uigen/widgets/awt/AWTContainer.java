package bus.uigen.widgets.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualToolkit;

public class AWTContainer extends AWTComponent implements VirtualContainer {
	// Container getContainer();
	public AWTContainer(Container theContainer) {
		super(theContainer);
		// getContainer() = theContainer;

	}

	public AWTContainer() {
		// super(new Panel());
	}

	public Container getContainer() {
		return (Container) component;
	}

	public void setContainer(Container theContainer) {
		component = theContainer;
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
		// if (c instanceof AnAWTComponent) {
		// getContainer().add(((AnAWTComponent) c).getAWTComponent());
		getContainer().add((Component) (c.getPhysicalComponent()));
		c.setParent(this);
		// }

	}

	public void execAdd(VirtualComponent c, int pos) {
		// if (c instanceof AnAWTComponent) {
		// getContainer().add(((AnAWTComponent) c).getAWTComponent());
		getContainer().add((Component) (c.getPhysicalComponent()), pos);
		c.setParent(this);
		// }

	}

	public void add(VirtualComponent c, int pos) {
		// if (c instanceof AnAWTComponent) {
		// getContainer().add(((AnAWTComponent) c).getAWTComponent(), pos);

		getContainer().add((Component) (c.getPhysicalComponent()), pos);
		c.setParent(this);
		// }
	}

	public void execAdd(VirtualComponent c, String direction) {
		getContainer().add((Component) c.getPhysicalComponent(), direction);
	}

	public void add(VirtualComponent c, String direction) {
		getContainer().add((Component) c.getPhysicalComponent(), direction);
	}

	public void add(VirtualComponent c, Object constraint) {
		// getContainer().add(((AnAWTComponent) c).getAWTComponent(),
		// constraint);
		getContainer().add((Component) (c.getPhysicalComponent()), constraint);
		c.setParent(this);

	}

	public void add(VirtualComponent c, Object constraint, int pos) {
		// getContainer().add(((AnAWTComponent) c).getAWTComponent(),
		// constraint, pos);
		getContainer().add((Component) (c.getPhysicalComponent()), constraint,
				pos);
		c.setParent(this);

	}

	public void remove(VirtualComponent c) {
		// if (c instanceof AnAWTComponent) {
		getContainer().remove((Component) (c.getPhysicalComponent()));
		c.setParent(null);
		// getContainer().remove(((AnAWTComponent) c).getAWTComponent());
		// c.setParent(null);
		// }
	}

	public void remove(int pos) {
		// VirtualComponent c = this.getComponent(pos);

		getContainer().remove(pos);
		// c.setParent(null);

	}

	public void removeAll() {
		getContainer().removeAll();
	}

	public int getComponentCount() {
		return getContainer().getComponentCount();
	}

	@SuppressWarnings("deprecation")
	public int countComponents() {
		return getContainer().countComponents();
	}

	public void setLayout(Object layoutManager) {
		getContainer().setLayout((LayoutManager) layoutManager);
	}

	public void setLayout(LayoutManager layoutManager) {
		getContainer().setLayout(layoutManager);
	}

	public Object getLayout() {
		return getContainer().getLayout();
	}

	public VirtualComponent[] getComponents() {
		Component[] components = getContainer().getComponents();
		VirtualComponent[] retVal = new VirtualComponent[components.length];
		for (int i = 0; i < components.length; i++)
			retVal[i] = AWTComponent.virtualComponent(components[i]);
		return retVal;
	}

	public VirtualComponent getComponent(int pos) {
		return AWTComponent
				.virtualComponent(getContainer().getComponents()[pos]);
	}

	// static transient Hashtable<Container, VirtualContainer>
	// getContainer()sToVirtualContainers = new Hashtable();
	public static VirtualContainer virtualContainer(Container c) {
		return (VirtualContainer) AWTComponent.virtualComponent(c);
		/*
		 * if (c == null) return null; VirtualComponent vcomp =
		 * AnAWTComponent.existingVirtualComponent(c); if (c != null) return
		 * (VirtualContainer) vcomp; VirtualContainer vgetContainer() = new
		 * AnAWTContainer(c); AnAWTComponent.register (c, vgetContainer());
		 */
		/*
		 * getContainer()sToVirtualContainers.get(c); if (vc == null) { vc = new
		 * AnAWTContainer(c); getContainer()sToVirtualContainers.put(c, vc); }
		 */
		// return vgetContainer();

	}

	// @Override
	public void pack() {
		// TODO Auto-generated method stub

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
		if (!(l == null || l instanceof AWTLayout)) {
			throw new IllegalArgumentException("Argument must be of AWT type");
		}
		java.awt.LayoutManager layout = ((AWTLayout) l).getLayout();
		getContainer().setLayout(layout);

	}

	@Override
	public void layout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestFocus() {
		getContainer().requestFocus();

	}

}
