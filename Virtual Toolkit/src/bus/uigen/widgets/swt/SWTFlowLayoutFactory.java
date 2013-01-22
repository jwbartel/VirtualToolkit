package bus.uigen.widgets.swt;

import bus.uigen.widgets.FlowLayoutFactory;
import bus.uigen.widgets.VirtualFlowLayout;

public class SWTFlowLayoutFactory implements FlowLayoutFactory {

	public VirtualFlowLayout createFlowLayout() {
		return new SWTFlowLayout();
	}
}