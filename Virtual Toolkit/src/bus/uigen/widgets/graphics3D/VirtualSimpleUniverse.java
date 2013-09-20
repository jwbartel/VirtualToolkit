package bus.uigen.widgets.graphics3D;

import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

public class VirtualSimpleUniverse{

	private SimpleUniverse simple;
	
	public VirtualSimpleUniverse()
	{
		simple = new SimpleUniverse();
	}
	
	public VirtualSimpleUniverse(VirtualCanvas3D canvas)
	{
		simple = new SimpleUniverse(canvas.getCanvas3D());
	}
	
	public void addBranchGraph (VirtualBranchGroup scene)
	{
		simple.addBranchGraph(scene.getBranchGroup());
	}
	
	public ViewingPlatform getViewingPlatform()
	{
		return simple.getViewingPlatform();
	}
}
