package bus.uigen.widgets.swt;

import org.eclipse.swt.layout.GridLayout;

import bus.uigen.widgets.VirtualGridLayout;

public class SWTGridLayout extends SWTLayout implements VirtualGridLayout {

	public SWTGridLayout() {
		component = new GridLayout();
	}

	public SWTGridLayout(int numColumns) {
		component = new GridLayout(numColumns, false);
		// getGridLayout().horizontalSpacing = 0;
		// getGridLayout().verticalSpacing = 0;
		// getGridLayout().makeColumnsEqualWidth = true;
		// getGridLayout().marginBottom = 0;
		getGridLayout().marginHeight = 0;
		// getGridLayout().marginLeft = 0;
		getGridLayout().marginRight = 0;
		// getGridLayout().marginTop = 0;
		getGridLayout().marginWidth = 0;
	}

	public GridLayout getGridLayout() {
		return (GridLayout) this.getLayout();
	}

	public int getColumns() {
		return getGridLayout().numColumns;
	}

	public int getHgap() {
		return getGridLayout().horizontalSpacing;
	}

	public int getRows() {
		return -1;
	}

	public int getVgap() {
		return getGridLayout().verticalSpacing;
	}

	public void setColumns(int cols) {
		getGridLayout().numColumns = cols;
	}

	public void setHgap(int hgap) {
		getGridLayout().horizontalSpacing = hgap;
	}

	public void setRows(int rows) {
	}

	public void setVgap(int vgap) {
		getGridLayout().verticalSpacing = vgap;
	}
}