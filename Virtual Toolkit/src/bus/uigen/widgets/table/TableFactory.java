package bus.uigen.widgets.table;

public interface TableFactory {
	public VirtualTable createTable();

	public VirtualTable createTable(Object treeModel);

	public VirtualTable createTable(Object[][] data, String[] columnNames);

}
