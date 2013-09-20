package bus.uigen.widgets.awt;

import java.awt.LayoutManager;

import bus.uigen.widgets.VirtualLayout;

public abstract class AWTLayout implements VirtualLayout {

	LayoutManager component;
	String id;

	public AWTLayout() {

	}

	public AWTLayout(LayoutManager l) {
		component = l;
	}

	public LayoutManager getLayout() {
		return component;
	}

	public void setName(String ID) {
		this.id = ID;
	}

	public String getName() {
		return id;
	}
}