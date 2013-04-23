package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Node;

import com.sun.j3d.utils.geometry.Sphere;

public class VirtualSphere implements VirtualNode {

	private Sphere sphere;
	
	public VirtualSphere()
	{
		sphere = new Sphere();
		
	}
	
	public VirtualSphere(float radius, VirtualAppearance appearance)
	{
		sphere = new Sphere(radius, appearance.getAppearance());
	}

	public Node getNode() {
		return sphere;
	}
}
