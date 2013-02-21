package bus.uigen.widgets.awt;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.swing.SwingTable;
import bus.uigen.widgets.table.ProxyAbstractTableModel;
import bus.uigen.widgets.table.VirtualTable;

public class AWTTable extends SwingTable implements VirtualTable {
	public AWTTable(JTable theTable) {
		super(theTable);

	}

	public AWTTable() {

	}

	public AWTTable(int numRows, int numColumns) {
		super(new JTable(numRows, numColumns));
	}

	public AWTTable(Object[][] data, String[] columnNames) {
		super(new JTable(data, columnNames));
	}

	public JTable getTable() {
		return (JTable) component;
	}

	public void clearSelection() {
		getTable().clearSelection();
	}

	public void setModel(TableModel model) {
		ProxyAbstractTableModel proxyModel = new ProxyAbstractTableModel(model);
		proxyModel.setSwingTableParent(this);
		getTable().setModel(proxyModel);
	}

	public void setModel(Object model) {
		setModel((TableModel) model);
	}

	public void updateUI() {
		getTable().updateUI();
	}

	@SuppressWarnings("rawtypes")
	public void setDefaultEditor(Class objClass, TableCellEditor editor) {
		getTable().setDefaultEditor(objClass, editor);
	}

	@SuppressWarnings("rawtypes")
	public void setDefaultEditor(Class objClass, Object editor) {
		setDefaultEditor(objClass, (TableCellEditor) editor);
	}

	public VirtualComponent getTableHeader() {
		return AWTComponent.virtualComponent(getTable().getTableHeader());
	}

	public void setCellSelectionEnabled(boolean newVal) {
		getTable().setCellSelectionEnabled(true);
	}

	public Object getSelectionModel() {
		return getTable().getSelectionModel();
	}

	public void addListSelectionListener(ListSelectionListener l) {
		ListSelectionModel row = getTable().getSelectionModel();
		row.addListSelectionListener(l);
	}

	public void addListSelectionListener(Object l) {
		addListSelectionListener((ListSelectionListener) l);
	}

	public void addColumnModelListener(TableColumnModelListener l) {
		getTable().getColumnModel().addColumnModelListener(l);
	}

	public void addColumnModelListener(Object l) {
		addColumnModelListener((TableColumnModelListener) l);
	}

	public int getRowHeight() {
		return getTable().getRowHeight();
	}

	public void createDefaultColumnsFromModel() {
		getTable().createDefaultColumnsFromModel();
	}

	public void addColumnSelectionInterval(int col1, int col2) {
		getTable().addColumnSelectionInterval(col1, col2);
	}

	public void addRowSelectionInterval(int row1, int row2) {
		getTable().addRowSelectionInterval(row1, row2);
	}

	public int getColumnWidth(int colNum) {
		return getTable().getColumnModel().getColumn(colNum).getWidth();
	}

	public void setColumnWidth(int colNum, int width) {
		if (colNum < getTable().getColumnModel().getColumnCount())
			// TableColumnModel columnModel = getTable().getColumnModel();
			getTable().getColumnModel().getColumn(colNum)
					.setPreferredWidth(width);
		else
			return;

	}

	public void setRowHeight(int rowNum, int height) {
		getTable().setRowHeight(rowNum, height);
	}

	public void setRowHeight(int height) {
		getTable().setRowHeight(height);
	}

	public boolean getRowSelectionAllowed() {
		return getTable().getRowSelectionAllowed();
	}

	public boolean getColumnSelectionAllowed() {
		return getTable().getColumnSelectionAllowed();
	}

	public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
		getTable().setColumnSelectionAllowed(columnSelectionAllowed);
	}

	public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
		getTable().setRowSelectionAllowed(rowSelectionAllowed);
	}

	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend) {
		getTable().changeSelection(rowIndex, columnIndex, toggle, extend);
	}

	public int getSelectedRow() {
		return getTable().getSelectedRow();
	}

	public int getSelectedColumn() {
		return getTable().getSelectedColumn();
	}

	/*
	 * public void addTableSelectionListener(TableSelectionListener listener) {
	 * getTable().addTableSelectionListener(listener); } public void
	 * addTableSelectionListener(Object listener) {
	 * addTableSelectionListener((TableSelectionListener) listener); }
	 * 
	 * 
	 * public void addTableExpansionListener(TableExpansionListener listener) {
	 * getTable().addTableExpansionListener(listener); } public void
	 * addTableExpansionListener(Object listener) {
	 * addTableExpansionListener((TableExpansionListener) listener); }
	 */
	public static SwingTable virtualTable(JTable theTable) {
		return (SwingTable) AWTComponent.virtualComponent(theTable);

	}

}