package bus.uigen.widgets.swing;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.table.VirtualAbstractTableModel;
import bus.uigen.widgets.table.VirtualScrollableTable;
import bus.uigen.widgets.table.VirtualTableModel;
//import javax.swing.ListSelectionModel;
//import bus.uigen.widgets.table.ProxyAbstractTableModel;

public class SwingScrollableTable extends SwingTable implements
		VirtualScrollableTable {
	private SwingScrollPane scrollPane = new SwingScrollPane();
	private SwingTable table;

	public SwingScrollableTable(JTable theTable) {
		table = new SwingTable(theTable);
		scrollPane.add(table);
	}

	public SwingScrollableTable() {
		table = new SwingTable();
		scrollPane.add(table);
	}

	public SwingScrollableTable(int numRows, int numColumns) {
		table = new SwingTable(numRows, numColumns);
		scrollPane.add(table);
	}

	public SwingScrollableTable(Object[][] data, String[] columnNames) {
		table = new SwingTable(data, columnNames);
		scrollPane.add(table);
	}

	public SwingScrollableTable(TableModel model) {
		table = new SwingTable(model);
		scrollPane.add(table);
	}

	public void setSize(int width, int height) {
		getTable().setSize(width, height);
	}

	public VirtualComponent getScrolledComponent() {
		return scrollPane.getScrolledComponent();
	}

	public void setScrolledComponent(VirtualComponent c) {
		scrollPane.setScrolledComponent(c);

	}

	public Object getPhysicalComponent() {
		return scrollPane.getPhysicalComponent();
	}

	public JTable getTable() {
		return table.getTable();
	}

	public void clearSelection() {
		table.clearSelection();
	}

	public void setModel(TableModel model) {
		table.setModel(model);
	}

	public void setModel(VirtualTableModel model) {
		table.setModel(model);
	}

	public void setModel(VirtualAbstractTableModel model) {
		table.setModel(model);

	}

	public void setModel(Object model) {
		table.setModel(model);
	}

	public void updateUI() {
		table.updateUI();
	}

	public void setDefaultEditor(Class objClass, TableCellEditor editor) {
		table.setDefaultEditor(objClass, editor);
	}

	public void setDefaultEditor(Class objClass, Object editor) {
		table.setDefaultEditor(objClass, editor);
	}

	public VirtualComponent getTableHeader() {
		return table.getTableHeader();
	}

	public boolean getCellSelectionEnabled() {
		return table.getCellSelectionEnabled();
	}

	public void setCellSelectionEnabled(boolean newVal) {
		table.setCellSelectionEnabled(newVal);
	}

	public Object getSelectionModel() {
		return table.getSelectionModel();
	}

	public void addListSelectionListener(ListSelectionListener l) {
		table.addListSelectionListener(l);
	}

	public void addListSelectionListener(Object l) {
		table.addListSelectionListener(l);
	}

	public void addColumnModelListener(TableColumnModelListener l) {
		table.addColumnModelListener(l);
	}

	public void addColumnModelListener(Object l) {
		table.addColumnModelListener(l);
	}

	public int getRowHeight() {
		return table.getRowHeight();
	}

	public void createDefaultColumnsFromModel() {
		table.createDefaultColumnsFromModel();
	}

	public void addColumnSelectionInterval(int col1, int col2) {
		table.addColumnSelectionInterval(col1, col2);
	}

	public void addRowSelectionInterval(int row1, int row2) {
		table.addRowSelectionInterval(row1, row2);
	}

	public int getColumnWidth(int colNum) {
		return table.getColumnWidth(colNum);
	}

	public void setColumnWidth(int colNum, int width) {
		table.setColumnWidth(colNum, width);
	}

	public void setRowHeight(int rowNum, int height) {
		table.setRowHeight(rowNum, height);
	}

	public void setRowHeight(int height) {
		table.setRowHeight(height);
	}

	public boolean getRowSelectionAllowed() {
		return table.getRowSelectionAllowed();
	}

	public boolean getColumnSelectionAllowed() {
		return table.getColumnSelectionAllowed();
	}

	public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
		table.setColumnSelectionAllowed(columnSelectionAllowed);
	}

	public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
		table.setRowSelectionAllowed(rowSelectionAllowed);
	}

	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend) {
		table.changeSelection(rowIndex, columnIndex, toggle, extend);
	}

	public void setSelectionMode(int selectionMode) {
		table.setSelectionMode(selectionMode);
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

	public int getSelectedColumn() {
		return table.getSelectedColumn();
	}

	public static SwingTable virtualTable(JTable theTable) {
		return (SwingTable) AWTComponent.virtualComponent(theTable);

	}

	public void init() {
		scrollPane.init();
		table.init();
	}
}