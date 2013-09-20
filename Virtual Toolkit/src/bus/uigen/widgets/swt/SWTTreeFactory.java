package bus.uigen.widgets.swt;

import javax.swing.tree.TreeModel;

import bus.uigen.widgets.tree.TreeFactory;
import bus.uigen.widgets.tree.VirtualTree;

public class SWTTreeFactory implements TreeFactory {

	public VirtualTree createTree() {
		return new SWTTree();
	}

	public VirtualTree createTree(Object treeModel) {
		return new SWTTree((TreeModel) treeModel);

	}

	public VirtualTree createTree(TreeModel treeModel) {
		return new SWTTree(treeModel);

	}

	public VirtualTree createTree(Object[] value) {
		return new SWTTree(value);
	}

}
