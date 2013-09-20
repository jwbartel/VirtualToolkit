package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.VirtualGridLayout;

public class ForwarderGridLayout extends ForwarderLayout implements
		VirtualGridLayout {
	int rows;
	int columns;
	int hgap;
	int vgap;

	public ForwarderGridLayout() {

	}

	public ForwarderGridLayout(int rows, int cols) {
		this.rows = rows;
		this.columns = cols;
	}

	@Override
	public int getColumns() {
		return columns;
	}

	@Override
	public int getHgap() {
		return hgap;
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public int getVgap() {
		return vgap;
	}

	@Override
	public void setColumns(int cols) {
		this.columns = cols;
	}

	@Override
	public void setHgap(int hgap) {
		this.hgap = hgap;
	}

	@Override
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public void setVgap(int vgap) {
		this.vgap = vgap;
	}

}
