package bus.uigen.widgets.awt;

import bus.uigen.widgets.FlowLayoutFactory;
import bus.uigen.widgets.VirtualFlowLayout;

public class AWTFlowLayoutFactory implements FlowLayoutFactory {

	public VirtualFlowLayout createFlowLayout() {
		return new AWTFlowLayout();
	}
}