package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.VirtualToolkit;

public class ForwarderContainer extends ForwarderComponent implements
		VirtualContainer {

	@Override
	public void add(VirtualComponent c) {
		execAdd(c);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String cID = c.getName();
			VirtualToolkit.sendCommandByDefault(VirtualContainer.COMMAND_LABEL
					+ widgetID + ADD_COMMAND + cID + ")");
		}
	}

	@Override
	public void execAdd(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, Object constraint, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, Object constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, String direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualComponent getComponent(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComponentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countComponents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLayout(Object layoutManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualComponent[] getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLayout(VirtualLayout l) {
		execSetLayout(l);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String lID = l.getName();
			VirtualToolkit.sendCommandByDefault(VirtualContainer.COMMAND_LABEL
					+ widgetID + SET_LAYOUT_COMMAND + lID + ")");
		}

	}

	@Override
	public void execSetLayout(VirtualLayout l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void layout() {
		// TODO Auto-generated method stub

	}

	public void requestFocus() {
		// TODO

	}

}
