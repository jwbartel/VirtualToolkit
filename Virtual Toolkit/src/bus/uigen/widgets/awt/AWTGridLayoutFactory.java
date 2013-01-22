package bus.uigen.widgets.awt;

import bus.uigen.widgets.GridLayoutFactory;
import bus.uigen.widgets.VirtualGridLayout;

public class AWTGridLayoutFactory implements GridLayoutFactory {

	public VirtualGridLayout createLayout(int rows, int cols) {
		return new AWTGridLayout(rows, cols);
	}

	public VirtualGridLayout createLayout() {
		return new AWTGridLayout();
	}

}