package bus.uigen.widgets.tree;

public interface TreeFactory {
	public VirtualTree createTree();

	public VirtualTree createTree(Object treeModel);

	public VirtualTree createTree(Object[] value);

}
