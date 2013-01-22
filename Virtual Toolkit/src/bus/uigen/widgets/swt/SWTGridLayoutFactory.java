package bus.uigen.widgets.swt;

import bus.uigen.widgets.GridLayoutFactory;
import bus.uigen.widgets.VirtualGridLayout;

public class SWTGridLayoutFactory implements GridLayoutFactory {

	public VirtualGridLayout createLayout(int rows, int cols) {
		return new SWTGridLayout(cols);
	}

	public VirtualGridLayout createLayout() {
		return new SWTGridLayout();
	}

}