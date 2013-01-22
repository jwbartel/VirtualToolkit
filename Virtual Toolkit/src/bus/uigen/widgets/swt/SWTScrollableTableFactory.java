package bus.uigen.widgets.swt;

import javax.swing.table.TableModel;

import bus.uigen.widgets.table.ScrollableTableFactory;
import bus.uigen.widgets.table.VirtualScrollableTable;

public class SWTScrollableTableFactory implements ScrollableTableFactory {

	public VirtualScrollableTable createTable() {
		return new SWTScrollableTable();
	}

	public VirtualScrollableTable createTable(Object tableModel) {
		return new SWTScrollableTable((TableModel) tableModel);
	}

	public VirtualScrollableTable createTable(Object[][] data,
			String[] columnNames) {
		return new SWTScrollableTable(data, columnNames);
	}

}