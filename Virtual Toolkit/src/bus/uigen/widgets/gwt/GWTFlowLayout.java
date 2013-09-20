package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualFlowLayout;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class GWTFlowLayout extends GWTLayout implements VirtualFlowLayout {
	FlowPanel component;

	public GWTFlowLayout() {
		component = new FlowPanel();
	}

	@Override
	public Panel getComponent() {
		return component;
	}

	@Override
	public void add(VirtualComponent c) {
		component.add((Widget) c.getPhysicalComponent());
	}

}
