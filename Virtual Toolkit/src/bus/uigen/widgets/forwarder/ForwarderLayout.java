package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.VirtualLayout;

public class ForwarderLayout implements VirtualLayout {
	String name;

	@Override
	public void setName(String id) {
		this.name = id;
	}

	@Override
	public String getName() {
		return name;
	}

}
