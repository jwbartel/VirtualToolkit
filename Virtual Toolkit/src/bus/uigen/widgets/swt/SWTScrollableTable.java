package bus.uigen.widgets.swt;

import javax.swing.table.TableModel;

import org.eclipse.swt.widgets.Table;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.table.VirtualScrollableTable;

public class SWTScrollableTable extends SWTTable implements
		VirtualScrollableTable {

	public VirtualComponent getScrolledComponent() {
		return this;
	}

	@Override
	public void setScrolledComponent(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	public SWTScrollableTable() {
		super();
	}

	public SWTScrollableTable(Table table) {
		super(table);
	}

	public SWTScrollableTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);

	}

	public SWTScrollableTable(TableModel model) {
		super(model);
	}

}