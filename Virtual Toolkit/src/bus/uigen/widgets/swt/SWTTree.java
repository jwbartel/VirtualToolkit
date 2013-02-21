package bus.uigen.widgets.swt;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualLayout;
import bus.uigen.widgets.tree.VirtualDefaultTreeModel;
import bus.uigen.widgets.tree.VirtualMutableTreeNode;
import bus.uigen.widgets.tree.VirtualTree;
import bus.uigen.widgets.tree.VirtualTreeModel;
import bus.uigen.widgets.tree.VirtualTreeNode;

public class SWTTree extends SWTComponent implements VirtualTree {
	VirtualTreeModel model;

	public SWTTree() {

	}

	public SWTTree(VirtualTreeModel model) {
		this.model = model;
	}

	public SWTTree(TreeModel model) {
		this.model = new VirtualDefaultTreeModel(model);
	}

	public SWTTree(Object[] value) {
		model = new VirtualDefaultTreeModel(getNodes(value));
	}

	public void init() {
		super.init();
	}

	@SuppressWarnings("rawtypes")
	protected VirtualTreeNode getNodes(Object value) {
		VirtualMutableTreeNode node = new VirtualMutableTreeNode(value);
		if (node != null) {
			if (value instanceof Object[]) {
				for (int i = 0; i < ((Object[]) value).length; i++) {
					node.add((MutableTreeNode) (getNodes(((Object[]) value)[i])));
				}
			}
			if (value instanceof ArrayList) {
				ArrayList list = (ArrayList) value;
				for (int i = 0; i < list.size(); i++) {
					node.add((MutableTreeNode) getNodes(list.get(i)));
				}
			}
			if (value instanceof Vector) {
				Vector list = (Vector) value;
				for (int i = 0; i < list.size(); i++) {
					node.add((MutableTreeNode) getNodes(list.get(i)));
				}
			}
		}
		return node;
	}

	public Tree getTree() {
		return (Tree) getComponent();
	}

	public void addToParent(VirtualContainer theParent) {
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

		component = new Tree((Composite) theParent.getPhysicalComponent(),
				SWT.BORDER);

		init();

		if (model != null) {
			generateFromModel(model.getRoot(), getTree());
		}
		getComponent().setSize(width, height);

	}

	protected void generateFromModel(Object currentNode, Tree parent) {
		TreeItem currItem = new TreeItem(parent, SWT.None);
		currItem.setText(currentNode.toString());
		recurseModel(currentNode, currItem);
	}

	protected void generateFromModel(Object currentNode, TreeItem parent) {
		TreeItem currItem = new TreeItem(parent, SWT.None);
		currItem.setText(currentNode.toString());
		recurseModel(currentNode, currItem);
	}

	protected void recurseModel(Object currentNode, TreeItem currItem) {
		for (int i = 0; i < model.getChildCount(currentNode); i++) {
			generateFromModel(model.getChild(currentNode, i), currItem);
		}
	}

	@Override
	public void addSelectionInterval(int index0, int index1) {
		// TODO Auto-generated method stub

	}

	public void addSelectionPath(TreePath path) {
		// TODO Auto-generated method stub

	}

	public void addSelectionPaths(TreePath[] paths) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionRow(int row) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionRows(int[] rows) {
		// TODO Auto-generated method stub

	}

	public void addTreeExpansionListener(TreeExpansionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTreeExpansionListener(Object listener) {
		// TODO Auto-generated method stub

	}

	public void addTreeSelectionListener(TreeSelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTreeSelectionListener(Object listener) {
		// TODO Auto-generated method stub

	}

	public void addTreeWillExpandListener(TreeWillExpandListener tel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelEditing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub

	}

	public void collapsePath(TreePath path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collapseRow(int row) {
		// TODO Auto-generated method stub

	}

	@Override
	public String convertValueToText(Object value, boolean selected,
			boolean expanded, boolean leaf, int row, boolean hasFocus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLastSelectedPathComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPathForLocation(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSelectionPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getSelectionPaths() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEditable(boolean newVal) {
		// TODO Auto-generated method stub

	}

	public void setModel(TreeModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionPath(Object path) {
		// TODO Auto-generated method stub

	}

	public void setSelectionPath(TreePath path) {
		// TODO Auto-generated method stub

	}

	public void setSelectionPaths(TreePath[] selectedPaths) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionPaths(Object[] selectedPaths) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeDidChange() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execAdd(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, Object constraint, int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, Object constraint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(VirtualComponent c, String direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countComponents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualComponent getComponent(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComponentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualComponent[] getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(VirtualComponent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayout(Object layoutManager) {
		// TODO Auto-generated method stub

	}

	public void setLayout(LayoutManager layoutManager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayout(VirtualLayout l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execSetLayout(VirtualLayout l) {
		// TODO Auto-generated method stub

	}

	public Object getItem(int x, int y) {
		if (getTree() == null)
			return null;
		else
			return getTree().getItem(new Point(x, y));
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

	@Override
	public void layout() {
		// TODO Auto-generated method stub

	}

	public void requestFocus() {
		// TODO

	}

}