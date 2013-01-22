package bus.uigen.widgets.gwt;

import bus.uigen.widgets.GridLayoutFactory;
import bus.uigen.widgets.VirtualGridLayout;

public class GWTGridLayoutFactory implements GridLayoutFactory {

	public VirtualGridLayout createLayout() {
		return new GWTGridLayout();
	}

	public VirtualGridLayout createLayout(int rows, int cols) {
		return new GWTGridLayout(rows, cols);
	}

}
