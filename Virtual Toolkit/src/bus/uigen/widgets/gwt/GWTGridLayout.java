package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualGridLayout;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;

public class GWTGridLayout extends GWTLayout implements VirtualGridLayout {

	Grid grid;

	int rowPos = 0;
	int colPos = 0;

	public GWTGridLayout() {
		grid = new Grid(1, 1);

	}

	public GWTGridLayout(int rows, int cols) {
		grid = new Grid(rows, cols);
	}

	public int getColumns() {
		return grid.getColumnCount();
	}

	public int getHgap() {
		return grid.getCellPadding();
	}

	public int getRows() {
		return grid.getRowCount();
	}

	public int getVgap() {
		return grid.getCellPadding();
	}

	public void setColumns(int cols) {
		grid.resizeColumns(cols);

	}

	public void setHgap(int hgap) {
		grid.setCellPadding(hgap);
	}

	public void setRows(int rows) {
		grid.resizeRows(rows);
	}

	public void setVgap(int vgap) {
		grid.setCellPadding(vgap);
	}

	public void add(VirtualComponent c) {
		if (colPos >= getColumns()) {
			colPos = 0;
			rowPos++;
		}

		if (rowPos >= getRows()) {
			setRows(getRows() + 1);
		}

		grid.setWidget(rowPos, colPos, ((GWTComponent) c).getWidget());
		colPos++;
	}

	public Panel getComponent() {
		return grid;
	}

}
