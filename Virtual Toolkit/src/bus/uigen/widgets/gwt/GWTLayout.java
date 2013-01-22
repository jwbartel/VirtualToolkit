package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualLayout;

import com.google.gwt.user.client.ui.Panel;

public abstract class GWTLayout implements VirtualLayout {

	String id;

	public abstract Panel getComponent();

	public abstract void add(VirtualComponent c);

	public void setName(String ID) {
		this.id = ID;
	}

	public String getName() {
		return id;
	}

}
