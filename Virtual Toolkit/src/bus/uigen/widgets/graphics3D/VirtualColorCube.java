package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Node;

import com.sun.j3d.utils.geometry.ColorCube;

public class VirtualColorCube extends VirtualShape3D implements VirtualNode{

	public ColorCube cube;
	
	public VirtualColorCube()
	{
		cube = new ColorCube();
	}
	
	public VirtualColorCube(double scale)
	{
		cube = new ColorCube(scale);
	}
	
	public double getScale()
	{
		return cube.getScale();
	}

	public Node getNode() {
		return cube;
	}
	
}
