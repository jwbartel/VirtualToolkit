package bus.uigen.widgets.swing;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import bus.uigen.widgets.VirtualList;
import bus.uigen.widgets.awt.AWTComponent;

/*
 import javax.swing.event.ListExpansionListener;
 import javax.swing.event.ListSelectionListener;
 */
//import javax.swing.table.ListPath;

public class SwingList extends SwingComponent implements VirtualList {
	// JList getList();
	public SwingList(JList theList) {
		super(theList);
		// getList() = theList;

	}

	public SwingList() {

	}

	public JList getList() {
		return (JList) component;
	}

	/*
	 * public Object getPathForLocation (int x, int y) { return
	 * getList().getPathForLocation(x, y); } public Object getSelectionPath() {
	 * return getList().getSelectionPath(); } public Object[]
	 * getSelectionPaths() { return getList().getSelectionPaths(); } public void
	 * setSelectionPaths (Object[] selectedPaths) {
	 * setSelectionPaths((ListPath[])selectedPaths); } public void
	 * setSelectionPaths (ListPath[] selectedPaths) {
	 * setSelectionPaths(selectedPaths); } public Object
	 * getLastSelectedPathComponent() { return
	 * getList().getLastSelectedPathComponent(); }
	 */

	public void clearSelection() {
		getList().clearSelection();
	}

	/*
	 * public void setEditable(boolean newVal) { getList().setEditable(newVal);
	 * }
	 */
	public void setModel(ListModel model) {
		getList().setModel(model);
	}

	public void setModel(Object model) {
		setModel((ListModel) model);
	}

	/*
	 * public void treDidChange() { getList().tableDidChange(); }
	 */
	public void updateUI() {
		getList().updateUI();
	}

	public Object getSelectionModel() {
		return getList().getSelectionModel();
	}

	/*
	 * public Object getColumnModel() { return getList().getColumnModel(); }
	 */

	public void addListSelectionListener(ListSelectionListener l) {
		ListSelectionModel row = getList().getSelectionModel();
		row.addListSelectionListener(l);
	}

	public void addListSelectionListener(Object l) {
		addListSelectionListener((ListSelectionListener) l);
	}

	public void setSelectionMode(int mode) {
		getList().setSelectionMode(mode);
	}

	public int getSelectionMode() {
		return getList().getSelectionMode();
	}

	public void setSelectedIndex(int index) {
		getList().setSelectedIndex(index);
	}

	public void setSelectedIndices(int[] indices) {
		getList().setSelectedIndices(indices);
	}

	public void setSelectedValue(Object anObject, boolean shouldScroll) {
		getList().setSelectedValue(anObject, shouldScroll);
	}

	public void setSelectionInterval(int anchor, int lead) {
		getList().setSelectionInterval(anchor, lead);
	}

	public static SwingList virtualList(JList theList) {
		return (SwingList) AWTComponent.virtualComponent(theList);

	}

}
