package bus.uigen.widgets.graphics3D;

import javax.media.j3d.BranchGroup;

public class VirtualBranchGroup {

	public BranchGroup branch;
	
	
	public VirtualBranchGroup()
	{
		branch = new BranchGroup();
	}
	
	public void addChild(VirtualNode node)
	{
		branch.addChild(node.getNode());
	}
	 	
	public BranchGroup getBranchGroup ()
	{
		return branch;
	}
}
