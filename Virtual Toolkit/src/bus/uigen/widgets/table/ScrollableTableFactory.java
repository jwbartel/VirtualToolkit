package bus.uigen.widgets.table;

public interface ScrollableTableFactory {

	public VirtualScrollableTable createTable();

	public VirtualScrollableTable createTable(Object tableModel);

	public VirtualScrollableTable createTable(Object[][] data,
			String[] columnNames);
}