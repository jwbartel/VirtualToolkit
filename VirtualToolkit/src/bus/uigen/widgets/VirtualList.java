package bus.uigen.widgets;

//import javax.swing.event.ListExpansionListener;
//import javax.swing.table.ListPath;

public interface VirtualList extends VirtualContainer {
	// public void setSelectionPaths (ListPath[] selectedPaths);
	// public void setSelectionPaths (Object[] selectedPaths);
	public void clearSelection();

	public void updateUI();

	// public void setModel(ListModel model);
	public void setModel(Object model);

	// public VirtualComponent getListHeader() ;
	// public void setCellSelectionEnabled (boolean newVal) ;
	// public void add (VirtualComponent c, String direction);
	public Object getSelectionModel();

	// public void addListSelectionListener(ListSelectionListener l);
	public void addListSelectionListener(Object l);

	public void setSelectionMode(int mode);

	public int getSelectionMode();

	public void setSelectedIndex(int index);

	public void setSelectedIndices(int[] indices);

	public void setSelectedValue(Object anObject, boolean shouldScroll);

	public void setSelectionInterval(int anchor, int lead);

}
