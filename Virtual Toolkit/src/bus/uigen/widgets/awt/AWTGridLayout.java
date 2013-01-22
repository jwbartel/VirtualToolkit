package bus.uigen.widgets.awt;

import java.awt.GridLayout;

import bus.uigen.widgets.VirtualGridLayout;

public class AWTGridLayout extends AWTLayout implements VirtualGridLayout {

	public GridLayout getGridLayout() {
		return (GridLayout) component;
	}

	public AWTGridLayout() {
		component = new GridLayout();
	}

	public AWTGridLayout(int rows, int cols) {
		component = new GridLayout(rows, cols);
	}

	public int getColumns() {
		return getGridLayout().getColumns();
	}

	public int getHgap() {
		return getGridLayout().getHgap();
	}

	public int getRows() {
		return getGridLayout().getRows();
	}

	public int getVgap() {
		return getGridLayout().getVgap();
	}

	public void setColumns(int cols) {
		getGridLayout().setColumns(cols);
	}

	public void setHgap(int hgap) {
		getGridLayout().setHgap(hgap);
	}

	public void setRows(int rows) {
		getGridLayout().setRows(rows);
	}

	public void setVgap(int vgap) {
		getGridLayout().setVgap(vgap);
	}
}