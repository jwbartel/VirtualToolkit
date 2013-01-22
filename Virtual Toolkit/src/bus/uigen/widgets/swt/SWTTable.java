package bus.uigen.widgets.swt;

import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.table.ProxyAbstractTableModel;
import bus.uigen.widgets.table.VirtualAbstractTableModel;
import bus.uigen.widgets.table.VirtualDefaultTableModel;
import bus.uigen.widgets.table.VirtualTable;
import bus.uigen.widgets.table.VirtualTableModel;

public class SWTTable extends SWTContainer implements VirtualTable {
	VirtualAbstractTableModel model;
	VirtualContainer theParent;

	int[] colWidths = new int[0];
	Vector<Listener> listeners;

	boolean shouldPack = true;

	public SWTTable() {
		super();
	}

	public SWTTable(Table table) {
		super(table);
	}

	public void init() {
		super.init();
	}

	public SWTTable(Object[][] data, String[] columnNames) {
		model = new VirtualDefaultTableModel(data, columnNames);
		model.setSWTTableParent(this);

	}

	public SWTTable(TableModel model) {
		this.model = new ProxyAbstractTableModel(model);
		this.model.setSWTTableParent(this);
	}

	public void addToParent(VirtualContainer theParent) {
		this.theParent = theParent;

		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an uninitialized parent");
				}
			}
		}
		component = new Table((Composite) theParent.getPhysicalComponent(),
				SWT.BORDER);

		init();
		buildComponent();
		if (width >= 0 && height >= 0) {
			setSize(width, height);
			shouldPack = false;
		}
		// theParent.pack();

	}

	private void buildComponent() {
		if (getComponent() != null) {
			// getTable().removeAll();
			if (model != null) {

				// int w =0;
				for (int i = 0; i < model.getColumnCount(); i++) {
					TableColumn column = new TableColumn(getTable(), SWT.CENTER);
					column.setText(model.getColumnName(i));
					column.setWidth(15 + 6 * column.getText().length());
					// currColumn.setWidth(name.length()*7);
					// w+= name.length()*7;

				}
				// int h=10;
				// if(model.getRowCount()>0){
				// h = model.getRowCount()*10;
				// }

				/*
				 * width = w; height = h; setSize(width, height);
				 * 
				 * getTable().setSize(width,height);
				 */
				// System.out.println(width);
				getTable().setHeaderVisible(true);
				for (int i = 0; i < model.getRowCount(); i++) {
					TableItem currRow = new TableItem((Table) component,
							SWT.NONE);

					// Currently only converts to table value based on toString
					// Adjust for later
					String[] rowTextData = new String[model.getColumnCount()];
					Image[] rowImageData = new Image[model.getColumnCount()];
					for (int j = 0; j < model.getColumnCount(); j++) {
						if (model.useTextForColumn(j)) {
							if (model.getValueAt(i, j) == null) {
								rowTextData[j] = "null";
							} else {
								rowTextData[j] = model.getValueAt(i, j)
										.toString();
							}
							rowImageData[j] = null;
						} else {
							rowTextData[j] = "";
							rowImageData[j] = (Image) model.getValueAt(i, j);
						}
					}
					currRow.setText(rowTextData);
					currRow.setImage(rowImageData);
				}
				for (int i = 0; i < colWidths.length; i++) {
					if (colWidths[i] >= 0) {
						this.setColumnWidth(i, colWidths[i]);
					}
				}
			}
		}
		// getTable().pack();

	}

	public Table getTable() {
		return (Table) getComponent();
	}

	protected void notifyListeners(Event e) {
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).handleEvent(e);
		}
	}

	public void update() {
		if (getComponent() != null) {
			getTable().clearAll();
			buildComponent();
		}
	}

	public void updateCellChanged(int row, int column) {
		if (getComponent() != null) {
			if (model.useTextForColumn(column)) {
				getTable().getItem(row).setText(column,
						model.getValueAt(row, column).toString());
			} else {
				getTable().getItem(row).setImage(column,
						(Image) model.getValueAt(row, column));
			}
		}

	}

	public void updateDeleteRows(int firstRow, int lastRow) {
		if (getComponent() != null) {
			getTable().remove(firstRow, lastRow);
		}
	}

	public void addColumnModelListener(TableColumnModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addColumnModelListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addColumnSelectionInterval(int col1, int col2) {
		// TODO Auto-generated method stub

	}

	public void addListSelectionListener(ListSelectionListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListSelectionListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRowSelectionInterval(int row1, int row2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
			boolean extend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createDefaultColumnsFromModel() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getColumnWidth(int colNum) {

		int val = colWidths[colNum];
		if (val == -1 && getTable() != null) {
			val = getTable().getColumn(colNum).getWidth();
			colWidths[colNum] = val;
		}
		return val;
	}

	@Override
	public int getRowHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRowHeight(int row) {
		return -1;
	}

	@Override
	public boolean getRowSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSelectedColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelectedRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
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
	public void setColumnSelectionAllowed(boolean columnSelectionAllowed) {
		// TODO Auto-generated method stub

	}

	public void setColumnWidth(int colNum, int width) {
		if (component != null) {
			/*
			 * int deltaWidth = width - getTable().getColumn(colNum).getWidth();
			 * if(deltaWidth>0 || (deltaWidth<0 &&
			 * getTable().getBounds().width>deltaWidth)){
			 * getTable().setSize(getTable().getBounds().width+deltaWidth,
			 * getTable().getBounds().height); }
			 */
			getTable().getColumn(colNum).setWidth(width);
		}
		if (this.colWidths.length < model.getColumnCount()) {
			int[] temp = new int[model.getColumnCount()];
			for (int i = 0; i < colWidths.length; i++) {
				temp[i] = colWidths[i];
			}
			for (int i = colWidths.length; i < model.getColumnCount(); i++) {
				temp[i] = -1;
			}
			colWidths = temp;
		}
		if (this.colWidths.length > model.getColumnCount()) {
			int[] temp = new int[model.getColumnCount()];
			for (int i = 0; i < model.getColumnCount(); i++) {
				temp[i] = colWidths[i];
			}
			colWidths = temp;
		}
		colWidths[colNum] = width;

	}

	public void setDefaultEditor(Class objClass, TableCellEditor editor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaultEditor(Class objClass, Object editor) {
		// TODO Auto-generated method stub

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
	public void setRowSelectionAllowed(boolean rowSelectionAllowed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUI() {
		// TODO Auto-generated method stub

	}

	public void setModel(TableModel model) {
		this.model = new ProxyAbstractTableModel(model);
	}

	@Override
	public void setModel(VirtualTableModel model) {
		this.model = new ProxyAbstractTableModel(model);

	}

	public void pack() {
		if (shouldPack)
			super.pack();
	}

	public TableModel getModel() {
		return model;
	}

	@Override
	public boolean getCellSelectionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub

	}

}