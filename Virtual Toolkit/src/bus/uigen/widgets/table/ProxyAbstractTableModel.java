package bus.uigen.widgets.table;

import java.util.EventListener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ProxyAbstractTableModel extends VirtualAbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TableModel basicModel;
	VirtualTableModel model;
	VirtualAbstractTableModel absModel;

	public ProxyAbstractTableModel(TableModel model) {
		basicModel = model;
	}

	public ProxyAbstractTableModel(VirtualTableModel model) {
		this.model = model;
	}

	public ProxyAbstractTableModel(VirtualAbstractTableModel model) {
		absModel = model;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		if (absModel != null)
			return absModel.getColumnCount();
		if (model != null)
			return model.getColumnCount();
		if (basicModel != null)
			return basicModel.getColumnCount();
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (absModel != null)
			return absModel.getRowCount();
		if (model != null)
			return model.getRowCount();
		if (basicModel != null)
			return basicModel.getRowCount();
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (absModel != null)
			return absModel.getValueAt(rowIndex, columnIndex);
		if (model != null)
			return model.getValueAt(rowIndex, columnIndex);
		if (basicModel != null)
			return basicModel.getValueAt(rowIndex, columnIndex);
		return null;
	}

	public void addTableModelListener(TableModelListener listener) {
		if (absModel != null)
			absModel.addTableModelListener(listener);
		if (model != null)
			model.addTableModelListener(listener);
		if (basicModel != null)
			basicModel.addTableModelListener(listener);
	}

	public int findColumn(String columnName) {
		if (absModel != null)
			return absModel.findColumn(columnName);
		else
			return -1;
	}

	public void fireTableCellUpdated(int row, int column) {
		if (absModel != null)
			absModel.fireTableCellUpdated(row, column);
	}

	public void fireTableChanged(TableModelEvent e) {
		if (absModel != null)
			absModel.fireTableChanged(e);
	}

	public void fireTableDataChanged() {
		if (absModel != null)
			absModel.fireTableDataChanged();
	}

	public void fireTableRowsDeleted(int firstRow, int lastRow) {
		if (absModel != null)
			absModel.fireTableRowsDeleted(firstRow, lastRow);
	}

	public void fireTableRowsInserted(int firstRow, int lastRow) {
		if (absModel != null)
			absModel.fireTableRowsInserted(firstRow, lastRow);
	}

	public void fireTableRowsUpdated(int firstRow, int lastRow) {
		if (absModel != null)
			absModel.fireTableRowsUpdated(firstRow, lastRow);
	}

	public void fireTableStructureChanged() {
		if (absModel != null)
			absModel.fireTableStructureChanged();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
		if (absModel != null)
			return absModel.getColumnClass(columnIndex);
		if (model != null)
			return model.getColumnClass(columnIndex);
		if (basicModel != null)
			return basicModel.getColumnClass(columnIndex);
		return Object.class;
	}

	public String getColumnName(int column) {
		if (absModel != null)
			return absModel.getColumnName(column);
		if (model != null)
			return model.getColumnName(column);
		if (basicModel != null)
			return basicModel.getColumnName(column);
		return null;
	}

	public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
		if (absModel != null)
			return absModel.getListeners(listenerType);
		return null;
	}

	public TableModelListener[] getTableModelListeners() {
		if (absModel != null)
			return absModel.getTableModelListeners();
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (absModel != null)
			return absModel.isCellEditable(rowIndex, columnIndex);
		if (model != null)
			return model.isCellEditable(rowIndex, columnIndex);
		if (basicModel != null)
			return basicModel.isCellEditable(rowIndex, columnIndex);
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
		if (absModel != null)
			absModel.removeTableModelListener(l);
		if (model != null)
			model.removeTableModelListener(l);
		if (basicModel != null)
			basicModel.removeTableModelListener(l);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (absModel != null)
			absModel.setValueAt(aValue, rowIndex, columnIndex);
		if (model != null)
			model.setValueAt(aValue, rowIndex, columnIndex);
		if (basicModel != null)
			basicModel.setValueAt(aValue, rowIndex, columnIndex);
	}

	public void setTextForColumn(int columnIndex, boolean setText) {
		if (absModel != null)
			absModel.setTextForColumn(columnIndex, setText);
	}

	public boolean useTextForColumn(int columnIndex) {
		if (absModel != null)
			return absModel.useTextForColumn(columnIndex);
		return true;
	}
}