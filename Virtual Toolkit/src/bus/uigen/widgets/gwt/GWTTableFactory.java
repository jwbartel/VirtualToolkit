package bus.uigen.widgets.gwt;

import bus.uigen.widgets.table.TableFactory;
import bus.uigen.widgets.table.VirtualTable;

public class GWTTableFactory implements TableFactory {

	@Override
	public VirtualTable createTable() {
		return new GWTTable();
	}

	@Override
	public VirtualTable createTable(Object treeModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VirtualTable createTable(Object[][] data, String[] columnNames) {
		return new GWTTable(data, columnNames);
	}

}
