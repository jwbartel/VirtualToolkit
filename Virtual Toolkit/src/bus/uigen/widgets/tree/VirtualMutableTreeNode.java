package bus.uigen.widgets.tree;

import javax.swing.tree.DefaultMutableTreeNode;

public class VirtualMutableTreeNode extends DefaultMutableTreeNode implements
		VirtualTreeNode {

	Object userObject;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VirtualMutableTreeNode() {
		super();
	}

	public VirtualMutableTreeNode(Object userObject) {
		super(userObject);
		this.userObject = userObject;
	}

	public VirtualMutableTreeNode(Object userObject, boolean allowsChildren) {
		super(userObject, allowsChildren);
		this.userObject = userObject;
	}

	public String toString() {
		String toReturn = super.toString();
		if (toReturn == null) {
			return "";
		}
		return toReturn;
	}
}