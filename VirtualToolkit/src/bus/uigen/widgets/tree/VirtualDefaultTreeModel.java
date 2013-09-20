package bus.uigen.widgets.tree;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class VirtualDefaultTreeModel extends DefaultTreeModel implements
		VirtualTreeModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeModel treeModel;
	private DefaultTreeModel defaultModel;

	public VirtualDefaultTreeModel(VirtualTreeNode root,
			boolean asksAllowsChildren) {
		super(root, asksAllowsChildren);
	}

	public VirtualDefaultTreeModel(VirtualTreeNode root) {
		super(root);
	}

	public VirtualDefaultTreeModel(TreeModel model) {
		super(null);
		treeModel = model;
	}

	public VirtualDefaultTreeModel(DefaultTreeModel model) {
		super(null);
		defaultModel = model;
	}

	public void addTreeModelListener(TreeModelListener l) {
		if (treeModel != null)
			treeModel.addTreeModelListener(l);
		else if (defaultModel != null)
			defaultModel.addTreeModelListener(l);
		else
			super.addTreeModelListener(l);
	}

	public Object getChild(Object parent, int index) {
		if (treeModel != null)
			return treeModel.getChild(parent, index);
		else if (defaultModel != null)
			return defaultModel.getChild(parent, index);
		else
			return super.getChild(parent, index);
	}

	public int getChildCount(Object parent) {
		if (treeModel != null)
			return treeModel.getChildCount(parent);
		else if (defaultModel != null)
			return defaultModel.getChildCount(parent);
		else
			return super.getChildCount(parent);
	}

	public int getIndexOfChild(Object parent, Object child) {
		if (treeModel != null)
			return treeModel.getIndexOfChild(parent, child);
		else if (defaultModel != null)
			return defaultModel.getIndexOfChild(parent, child);
		else
			return super.getIndexOfChild(parent, child);
	}

	public Object getRoot() {
		if (treeModel != null)
			return treeModel.getRoot();
		else if (defaultModel != null)
			return defaultModel.getRoot();
		else
			return super.getRoot();
	}

	public boolean isLeaf(Object node) {
		if (treeModel != null)
			return treeModel.isLeaf(node);
		else if (defaultModel != null)
			return defaultModel.isLeaf(node);
		else
			return super.isLeaf(node);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		if (treeModel != null)
			treeModel.removeTreeModelListener(l);
		else if (defaultModel != null)
			defaultModel.removeTreeModelListener(l);
		else
			super.removeTreeModelListener(l);
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		if (treeModel != null)
			treeModel.valueForPathChanged(path, newValue);
		else if (defaultModel != null)
			defaultModel.valueForPathChanged(path, newValue);
		else
			super.valueForPathChanged(path, newValue);
	}
}