package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.GridLayoutFactory;
import bus.uigen.widgets.VirtualGridLayout;

public class ForwarderGridLayoutFactory implements GridLayoutFactory {

	@Override
	public VirtualGridLayout createLayout() {
		return new ForwarderGridLayout();
	}

	@Override
	public VirtualGridLayout createLayout(int rows, int cols) {
		return new ForwarderGridLayout(rows, cols);
	}

}
