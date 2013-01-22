package bus.uigen.widgets.swing;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;
import bus.uigen.widgets.tree.VirtualDefaultTreeModel;
import bus.uigen.widgets.tree.VirtualTree;
import bus.uigen.widgets.tree.VirtualTreeModel;

public class SwingTree extends AWTContainer implements VirtualTree {
	// JTree getTree();
	public SwingTree(JTree theTree) {
		super(theTree);
		// getTree() = theTree;
		getTree().setEditable(true);

	}

	public SwingTree() {
		super(new JTree());
		getTree().setEditable(true);
	}

	public SwingTree(Object[] value) {
		super(new JTree(value));
		getTree().setEditable(true);
	}

	public SwingTree(VirtualTreeModel model) {
		super(new JTree(model));
		getTree().setEditable(true);
	}

	public SwingTree(TreeModel model) {
		super(new JTree(new VirtualDefaultTreeModel(model)));
		getTree().setEditable(true);
	}

	public JTree getTree() {
		return (JTree) component;
	}

	public Object getPathForLocation(int x, int y) {
		return getTree().getPathForLocation(x, y);
	}

	public Object getSelectionPath() {
		return getTree().getSelectionPath();
	}

	public void setSelectionPath(Object path) {
		setSelectionPath((TreePath) path);
	}

	public void setSelectionPath(TreePath path) {
		getTree().setSelectionPath(path);
	}

	public Object[] getSelectionPaths() {
		return getTree().getSelectionPaths();
	}

	public void setSelectionPaths(Object[] selectedPaths) {
		setSelectionPaths((TreePath[]) selectedPaths);
	}

	public void setSelectionPaths(TreePath[] selectedPaths) {
		setSelectionPaths(selectedPaths);
	}

	public Object getLastSelectedPathComponent() {
		return getTree().getLastSelectedPathComponent();
	}

	public void clearSelection() {
		getTree().clearSelection();
	}

	public void setEditable(boolean newVal) {
		getTree().setEditable(newVal);
	}

	public void setModel(TreeModel model) {
		getTree().setModel(model);
	}

	public void setModel(Object model) {
		setModel((TreeModel) model);
	}

	public void treeDidChange() {
		getTree().treeDidChange();
	}

	public void updateUI() {
		getTree().updateUI();
	}

	public void addTreeSelectionListener(TreeSelectionListener listener) {
		getTree().addTreeSelectionListener(listener);
	}

	public void addTreeSelectionListener(Object listener) {
		addTreeSelectionListener((TreeSelectionListener) listener);
	}

	public void addTreeExpansionListener(TreeExpansionListener listener) {
		getTree().addTreeExpansionListener(listener);
	}

	public void addTreeExpansionListener(Object listener) {
		addTreeExpansionListener((TreeExpansionListener) listener);
	}

	public static SwingTree virtualTree(JTree theTree) {
		return (SwingTree) AWTComponent.virtualComponent(theTree);

	}

	public void addSelectionInterval(int index0, int index1) {
		getTree().addSelectionInterval(index0, index1);
	}

	public void addSelectionPath(TreePath path) {
		getTree().addSelectionPath(path);

	}

	public void addSelectionPaths(TreePath[] paths) {
		getTree().addSelectionPaths(paths);

	}

	public void addSelectionRow(int row) {
		getTree().addSelectionRow(row);

	}

	public void addSelectionRows(int[] rows) {
		getTree().addSelectionRows(rows);

	}

	public void addTreeWillExpandListener(TreeWillExpandListener tel) {
		getTree().addTreeWillExpandListener(tel);

	}

	public void cancelEditing() {
		getTree().cancelEditing();

	}

	public void collapsePath(TreePath path) {
		getTree().collapsePath(path);

	}

	public void collapseRow(int row) {
		getTree().collapseRow(row);

	}

	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {
		return getTree().convertValueToText(value, selected, expanded, leaf,
				row, hasFocus);
	}

	public Object getItem(int x, int y) {
		return getTree().getClosestPathForLocation(x, y);
	}

	@Override
	public void addSelectionPath(Object path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionPaths(Object[] paths) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collapsePath(Object path) {
		// TODO Auto-generated method stub

	}

}
