package bus.uigen.widgets.swt;

import org.eclipse.swt.widgets.Layout;

import bus.uigen.widgets.VirtualLayout;

public abstract class SWTLayout implements VirtualLayout {

	Layout component;
	String id;

	public SWTLayout() {

	}

	public SWTLayout(Layout l) {
		component = l;
	}

	public Layout getLayout() {
		return component;
	}

	public void setName(String ID) {
		this.id = ID;
	}

	public String getName() {
		return id;
	}
}