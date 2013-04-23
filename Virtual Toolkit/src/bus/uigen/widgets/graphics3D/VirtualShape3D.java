package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Geometry;
import javax.media.j3d.Shape3D;
public class VirtualShape3D{
		
	Shape3D shape3D;
	
	public VirtualShape3D()
	{
		shape3D = new Shape3D();
	}
	
	public VirtualShape3D(VirtualGeometry geometry)
	{
		shape3D = new Shape3D(geometry);
	}
	
	public VirtualShape3D(VirtualGeometry geometry, VirtualAppearance appearance)
	{
		shape3D = new Shape3D(geometry);
	}
	
	
}
