package bus.uigen.widgets.table;

import java.util.EventListener;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import bus.uigen.widgets.swing.SwingTable;
import bus.uigen.widgets.swt.SWTTable;

//get rid of extending defaulttablemodel
// get rid of super calls
public abstract class VirtualAbstractTableModel extends DefaultTableModel
		implements VirtualTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AbstractTableModel model = new DefaultTableModel();
	SwingTable swingParent = null;
	SWTTable swtParent = null;

	boolean[] useTextForColumn;

	protected void init() {
		if (model.getColumnCount() > 0) {
			useTextForColumn = new boolean[model.getColumnCount()];
			for (int i = 0; i < useTextForColumn.length; i++) {
				useTextForColumn[i] = true;
			}
		}
	}

	public VirtualAbstractTableModel() {
		init();
	}

	public VirtualAbstractTableModel(int rowCount, int columnCount) {
		init();
	}

	public VirtualAbstractTableModel(Object[][] data, String[] columnNames) {
		model = new DefaultTableModel(data, columnNames);
		init();
	}

	public VirtualAbstractTableModel(Object[] columnNames, int rowCount) {
		model = new DefaultTableModel(columnNames, rowCount);
		init();
	}

	@SuppressWarnings("rawtypes")
	public VirtualAbstractTableModel(Vector columnNames, int rowCount) {
		model = new DefaultTableModel(columnNames, rowCount);
		init();
	}

	@SuppressWarnings("rawtypes")
	public VirtualAbstractTableModel(Vector data, Vector columnNames) {
		model = new DefaultTableModel(data, columnNames);
		init();
	}

	public VirtualAbstractTableModel(AbstractTableModel model) {
		this.model = model;
		init();
	}

	public void addTableModelListener(TableModelListener listener) {
		if (model != null) {
			model.addTableModelListener(listener);
		} else {
			super.addTableModelListener(listener);
		}
	}

	public int findColumn(String columnName) {
		if (model != null) {
			return model.findColumn(columnName);
		} else {
			return super.findColumn(columnName);
		}
	}

	public void fireTableCellUpdated(int row, int column) {
		if (swtParent != null) {
			swtParent.updateCellChanged(row, column);
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableCellUpdated(row, column);
			} else {
				super.fireTableCellUpdated(row, column);
			}
		}
	}

	public void fireTableChanged(TableModelEvent e) {
		if (swtParent != null) {
			swtParent.update();
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableChanged(e);
			} else {
				super.fireTableChanged(e);
			}
		}
	}

	public void fireTableDataChanged() {
		if (swtParent != null) {
			swtParent.update();
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableDataChanged();
			} else {
				super.fireTableDataChanged();
			}
		}
	}

	public void fireTableRowsDeleted(int firstRow, int lastRow) {
		if (swtParent != null) {
			swtParent.updateDeleteRows(firstRow, lastRow);
		}
		if (swingParent != null) {
			if (model != null) {
				super.fireTableRowsDeleted(firstRow, lastRow);
			} else {
				super.fireTableRowsDeleted(firstRow, lastRow);
			}
		}
	}

	public void fireTableRowsInserted(int firstRow, int lastRow) {
		if (swtParent != null) {
			swtParent.update();
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableRowsInserted(firstRow, lastRow);
			} else {
				super.fireTableRowsInserted(firstRow, lastRow);
			}
		}
	}

	public void fireTableRowsUpdated(int firstRow, int lastRow) {
		if (swtParent != null) {
			swtParent.update();
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableRowsUpdated(firstRow, lastRow);
			} else {
				super.fireTableRowsUpdated(firstRow, lastRow);
			}
		}
	}

	public void fireTableStructureChanged() {
		if (swtParent != null) {
			swtParent.update();
		} else if (swingParent != null) {
			if (model != null) {
				model.fireTableStructureChanged();
			} else {
				super.fireTableStructureChanged();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
		if (model != null) {
			return model.getColumnClass(columnIndex);
		} else {
			return super.getColumnClass(columnIndex);
		}
	}

	public String getColumnName(int column) {
		if (model != null) {
			return model.getColumnName(column);
		} else if (swtParent != null) {
			if (column > this.getColumnCount()) {
				return "";
			} else {
				return recurseColumnName(column, "");
			}
		} else {
			return super.getColumnName(column);
		}
	}

	private String recurseColumnName(int column, String currString) {
		if (column >= 26) {
			currString = recurseColumnName(column / 26 - 1, currString);
		}
		return currString += "" + (char) ((int) 'A' + (column % 26));
	}

	public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
		if (model != null) {
			return model.getListeners(listenerType);
		} else {
			return super.getListeners(listenerType);
		}
	}

	public TableModelListener[] getTableModelListeners() {
		if (model != null) {
			return model.getTableModelListeners();
		} else {
			return super.getTableModelListeners();
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (model != null) {
			return model.isCellEditable(rowIndex, columnIndex);
		} else {
			return super.isCellEditable(rowIndex, columnIndex);
		}
	}

	public void removeTableModelListener(TableModelListener l) {
		if (model != null) {
			model.removeTableModelListener(l);
		} else {
			super.removeTableModelListener(l);
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (model != null) {
			model.setValueAt(aValue, rowIndex, columnIndex);
			this.fireTableCellUpdated(rowIndex, columnIndex);
		} else {
			super.setValueAt(aValue, rowIndex, columnIndex);
		}
	}

	public void setTextForColumn(int columnIndex, boolean setText) {
		useTextForColumn[columnIndex] = setText;
	}

	public boolean useTextForColumn(int columnIndex) {
		return useTextForColumn[columnIndex];
	}

	public void setSWTTableParent(SWTTable table) {
		swtParent = table;
		swingParent = null;
	}

	public void setSwingTableParent(SwingTable table) {
		swingParent = table;
		swtParent = null;
	}

	public int getColumnCount() {
		if (model != null)
			return model.getColumnCount();
		else
			return super.getColumnCount();
	}

	public int getRowCount() {
		if (model != null)
			return model.getRowCount();
		else
			return super.getRowCount();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (model != null)
			return model.getValueAt(rowIndex, columnIndex);
		else
			return super.getValueAt(rowIndex, columnIndex);
	}
}