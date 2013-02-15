package bus.uigen.widgets.swing;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;
import bus.uigen.widgets.table.ProxyAbstractTableModel;
import bus.uigen.widgets.table.VirtualAbstractTableModel;
import bus.uigen.widgets.table.VirtualTable;
import bus.uigen.widgets.table.VirtualTableModel;

public class SwingTable extends AWTContainer implements VirtualTable {
	// JTable getTable();
	TableModel model;

	public SwingTable(JTable theTable) {
		super(theTable);
		// getTable() = theTable;

	}

	public SwingTable() {

	}

	public SwingTable(int numRows, int numColumns) {
		super(new JTable(numRows, numColumns));
	}

	public SwingTable(Object[][] data, String[] columnNames) {
		super(new JTable(data, columnNames));
	}

	public SwingTable(TableModel model) {
		super(new JTable(model));
		this.model = model;
	}

	public JTable getTable() {
		return (JTable) component;
	}

	/*
	 * public Object getPathForLocation (int x, int y) { return
	 * getTable().getPathForLocation(x, y); } public Object getSelectionPath() {
	 * return getTable().getSelectionPath(); } public Object[]
	 * getSelectionPaths() { return getTable().getSelectionPaths(); } public
	 * void setSelectionPaths (Object[] selectedPaths) {
	 * setSelectionPaths((TablePath[])selectedPaths); } public void
	 * setSelectionPaths (TablePath[] selectedPaths) {
	 * setSelectionPaths(selectedPaths); } public Object
	 * getLastSelectedPathComponent() { return
	 * getTable().getLastSelectedPathComponent(); }
	 */

	public void clearSelection() {
		getTable().clearSelection();
	}

	/*
	 * public void setEditable(boolean newVal) { getTable().setEditable(newVal);
	 * }
	 */
	public void setModel(TableModel model) {
		ProxyAbstractTableModel proxyModel = new ProxyAbstractTableModel(model);
		this.model = proxyModel;
		setModel(proxyModel);
	}

	public void setModel(VirtualTableModel model) {
		ProxyAbstractTableModel proxyModel = new ProxyAbstractTableModel(model);
		this.model = proxyModel;
		setModel(proxyModel);
	}

	public void setModel(VirtualAbstractTableModel model) {
		this.model = model;
		model.setSwingTableParent(this);

	}

	public void setModel(Object model) {
		this.model = (TableModel) model;
		setModel((TableModel) model);
	}

	/*
	 * public void treDidChange() { getTable().tableDidChange(); }
	 */
	public void updateUI() {
		getTable().updateUI();
	}

	public void setDefaultEditor(Class objClass, TableCellEditor editor) {
		getTable().setDefaultEditor(objClass, editor);
	}

	public void setDefaultEditor(Class objClass, Object editor) {
		setDefaultEditor(objClass, (TableCellEditor) editor);
	}

	public VirtualComponent getTableHeader() {
		return AWTComponent.virtualComponent(getTable().getTableHeader());
	}

	public boolean getCellSelectionEnabled() {
		return getTable().getCellSelectionEnabled();
	}

	public void setCellSelectionEnabled(boolean newVal) {
		getTable().setCellSelectionEnabled(true);
	}

	public Object getSelectionModel() {
		return getTable().getSelectionModel();
	}

	/*
	 * public Object getColumnModel() { return getTable().getColumnModel(); }
	 */

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

	public int getRowHeight(int row) {
		return getTable().getRowHeight(row);
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
		getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getTable().getColumnModel().getColumn(colNum).setPreferredWidth(width);

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

	public void setSelectionMode(int selectionMode) {
		getTable().setSelectionMode(selectionMode);
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

	public TableModel getModel() {
		return getTable().getModel();
	}

}
