package bus.uigen.widgets.awt;

import java.awt.FlowLayout;

import bus.uigen.widgets.VirtualFlowLayout;

public class AWTFlowLayout extends AWTLayout implements VirtualFlowLayout {
	public AWTFlowLayout() {
		super(new FlowLayout());
	}

	public AWTFlowLayout(FlowLayout l) {
		component = l;
	}
}