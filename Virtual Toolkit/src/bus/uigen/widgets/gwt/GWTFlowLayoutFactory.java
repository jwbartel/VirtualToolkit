package bus.uigen.widgets.gwt;

import bus.uigen.widgets.FlowLayoutFactory;
import bus.uigen.widgets.VirtualFlowLayout;

public class GWTFlowLayoutFactory implements FlowLayoutFactory {

	public VirtualFlowLayout createFlowLayout() {
		return new GWTFlowLayout();
	}

}
