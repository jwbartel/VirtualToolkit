package bus.uigen.widgets.tree;

import bus.uigen.widgets.VirtualContainer;

public interface VirtualTree extends VirtualContainer {
	public void addSelectionInterval(int index0, int index1);

	public void addSelectionPath(Object path);

	public void addSelectionPaths(Object[] paths);

	public void addSelectionRow(int row);

	public void addSelectionRows(int[] rows);

	public void cancelEditing();

	// public void clearAll();
	public void collapsePath(Object path);

	public void collapseRow(int row);

	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus);

	public Object getItem(int x, int y);

	// public void setSelectionPaths (TreePath[] selectedPaths);
	public void setSelectionPaths(Object[] selectedPaths);

	public void clearSelection();

	Object getPathForLocation(int x, int y);

	public void setEditable(boolean newVal);

	public Object getLastSelectedPathComponent();

	// public void addTreeSelectionListener(TreeSelectionListener listener);
	public void addTreeSelectionListener(Object listener);

	// public void addTreeExpansionListener(TreeExpansionListener listener) ;
	public void addTreeExpansionListener(Object listener);

	// public void addTreeWillExpandListener(TreeWillExpandListener tel) ;
	public void treeDidChange();

	public void updateUI();

	/*
	 * public TreePath getSelectionPath(); public TreePath[]
	 * getSelectionPaths();
	 */
	public Object getSelectionPath();

	public void setSelectionPath(Object path);

	// public void setSelectionPath (TreePath path);
	public Object[] getSelectionPaths();

	// public void setModel(TreeModel model);
	public void setModel(Object model);

}
