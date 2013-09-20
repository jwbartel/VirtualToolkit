package bus.uigen.widgets.table;

public class ScrollableTableSelector {
	static ScrollableTableFactory factory;

	public static void setScrollableTableFactory(ScrollableTableFactory newVal) {
		factory = newVal;
	}

	public static VirtualScrollableTable createTable() {
		return factory.createTable();

	}

	public static VirtualScrollableTable createTable(Object treeModel) {
		return factory.createTable(treeModel);
	}

	public static VirtualScrollableTable createTable(Object[][] data,
			String[] columnNames) {
		return factory.createTable(data, columnNames);
	}
}