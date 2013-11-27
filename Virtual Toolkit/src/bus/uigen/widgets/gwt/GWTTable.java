package bus.uigen.widgets.gwt;

import java.awt.Color;
import java.awt.Font;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.table.VirtualAbstractTableModel;
import bus.uigen.widgets.table.VirtualTable;
import bus.uigen.widgets.table.VirtualTableModel;

import com.google.gwt.user.cellview.client.CellTable;

public class GWTTable extends GWTContainer implements VirtualTable {
	VirtualAbstractTableModel model;

	public GWTTable(Object[][] data, String[] columnNames) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public GWTTable() {
		super(new CellTable());
	}

	@SuppressWarnings("rawtypes")
	public CellTable getTable() {
		return (CellTable) component;
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUI() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setDefaultEditor(Class objClass, Object editor) {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualComponent getTableHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCellSelectionEnabled(boolean newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListSelectionListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addColumnModelListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRowHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowHeight(int row) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createDefaultColumnsFromModel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addColumnSelectionInterval(int col1, int col2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRowSelectionInterval(int row1, int row2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColumnWidth(int colNum, int width) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getColumnWidth(int colNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowHeight(int rowNum, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRowHeight(int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getRowSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCellSelectionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSelectedRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelectedColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(VirtualTableModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColumn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTooltipText(int aRow, int aCol, String newVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFont(int aRow, int aCol, Font newVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBackground(int aRow, int aCol, Color newVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setForeground(int aRow, int aCol, Color newVal) {
		// TODO Auto-generated method stub
		
	}

}
