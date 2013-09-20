package bus.uigen.widgets.table;

//import javax.swing.event.TableExpansionListener;
//import javax.swing.event.TableSelectionListener;
//import javax.swing.ListSelectionModel;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.event.TableColumnModelListener;
//import javax.swing.table.TableCellEditor;
//import javax.swing.table.TableModel;
//import javax.swing.table.TablePath;

import java.awt.Color;
import java.awt.Font;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;

public interface VirtualTable extends VirtualContainer {
	// public void setSelectionPaths (TablePath[] selectedPaths);
	// public void setSelectionPaths (Object[] selectedPaths);
	public void clearSelection();

	// Object getPathForLocation (int x, int y);
	// public void setEditable(boolean newVal);
	// public Object getLastSelectedPathComponent();
	/*
	 * public void addTableSelectionListener(TableSelectionListener listener);
	 * public void addTableSelectionListener(Object listener); public void
	 * addTableExpansionListener(TableExpansionListener listener) ; public void
	 * addTableExpansionListener(Object listener) ;
	 */
	// public void tableDidChange();
	public void updateUI();

	/*
	 * public TablePath getSelectionPath(); public TablePath[]
	 * getSelectionPaths();
	 */
	// public Object getSelectionPath();
	// public Object[] getSelectionPaths();
	// public void setDefaultEditor (Class objClass, TableCellEditor editor) ;
	@SuppressWarnings("rawtypes")
	public void setDefaultEditor(Class objClass, Object editor);

	public VirtualComponent getTableHeader();

	public void setCellSelectionEnabled(boolean newVal);

	// public void add (VirtualComponent c, String direction);
	public Object getSelectionModel();

	/*
	 * public Object getColumnModel() { return getTable().getColumnModel(); }
	 */
	// public void addListSelectionListener(ListSelectionListener l);
	public void addListSelectionListener(Object l);

	// public void addColumnModelListener (TableColumnModelListener l) ;
	public void addColumnModelListener(Object l);

	public int getRowHeight();

	public int getRowHeight(int row);

	public void createDefaultColumnsFromModel();

	public void addColumnSelectionInterval(int col1, int col2);

	public void addRowSelectionInterval(int row1, int row2);

	public void setColumnWidth(int colNum, int width);

	public int getColumnWidth(int colNum);

	public void setRowHeight(int rowNum, int height);

	public void setRowHeight(int height);

	public boolean getRowSelectionAllowed();

	public boolean getColumnSelectionAllowed();

	public boolean getCellSelectionEnabled();

	public void setColumnSelectionAllowed(boolean columnSelectionAllowed);

	public void setRowSelectionAllowed(boolean rowSelectionAllowed);

	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend);

	public int getSelectedRow();

	public int getSelectedColumn();

	// public void setModel(TableModel model);
	public void setModel(Object model);

	public void setModel(VirtualTableModel model);

	public Object getModel();
	// public TableModel getModel();
	public void addColumn();
	public void setTooltipText (int aRow, int aCol, String newVal) ;
	public void setFont (int aRow, int aCol, Font newVal) ;
	public void setBackground (int aRow, int aCol, Color newVal) ;
	
	public void setForeground (int aRow, int aCol, Color newVal);

}
