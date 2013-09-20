package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Node;
import javax.media.j3d.TransformGroup;

public class VirtualTransformGroup implements VirtualNode{

	public TransformGroup trans;
	
	
	public VirtualTransformGroup()
	{
		trans = new TransformGroup();
	}
	
	public VirtualTransformGroup(VirtualTransform3D transform)
	{
		trans = new TransformGroup(transform.getTransform3D());
	}
	
	public void addChild(VirtualNode node)
	{
		
		trans.addChild(node.getNode());
	}

	public Node getNode() {
		return trans;
	}
	
	
}
