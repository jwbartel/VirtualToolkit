package bus.uigen.widgets.swt;

import javax.swing.table.TableModel;

import bus.uigen.widgets.table.TableFactory;
import bus.uigen.widgets.table.VirtualTable;

public class SWTTableFactory implements TableFactory {

	public VirtualTable createTable() {
		return createSWTTable();
	}

	public VirtualTable createTable(Object tablemodel) {
		return createSWTTable((TableModel) tablemodel);
	}

	public VirtualTable createTable(Object[][] data, String[] columnNames) {
		return createSWTTable(data, columnNames);
	}

	public static VirtualTable createSWTTable() {
		return new SWTTable();
	}

	public static VirtualTable createSWTTable(TableModel model) {
		return new SWTTable(model);
	}

	public static VirtualTable createSWTTable(Object[][] data,
			String[] columnNames) {
		return new SWTTable(data, columnNames);
	}
}