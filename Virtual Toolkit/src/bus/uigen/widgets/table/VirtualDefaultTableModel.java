package bus.uigen.widgets.table;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unchecked")
public class VirtualDefaultTableModel extends VirtualAbstractTableModel
		implements VirtualTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VirtualDefaultTableModel() {
		super();
		init();
	}

	public VirtualDefaultTableModel(int rowCount, int columnCount) {
		model = new DefaultTableModel(rowCount, columnCount);
		init();
	}

	public VirtualDefaultTableModel(Object[][] data, String[] columnNames) {
		model = new DefaultTableModel(data, columnNames);
		init();
	}

	public VirtualDefaultTableModel(Object[] columnNames, int rowCount) {
		model = new DefaultTableModel(columnNames, rowCount);
		init();
	}

	@SuppressWarnings("rawtypes")
	public VirtualDefaultTableModel(Vector columnNames, int rowCount) {
		model = new DefaultTableModel(columnNames, rowCount);
		init();
	}

	@SuppressWarnings("rawtypes")
	public VirtualDefaultTableModel(Vector data, Vector columnNames) {
		model = new DefaultTableModel(data, columnNames);
		init();
	}

	public int getColumnCount() {
		if (model == null)
			return 0;
		return model.getColumnCount();
	}

	public int getRowCount() {
		if (model == null)
			return 0;
		return model.getRowCount();
	}
	/*
	 * public Class getColumnClass(int columnIndex){ return
	 * super.getColumnClass(columnIndex); }
	 * 
	 * public Object getValueAt(int rowIndex, int columnIndex){ return
	 * model.getValueAt(rowIndex, columnIndex); }
	 */

}