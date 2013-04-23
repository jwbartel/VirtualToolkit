package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class VirtualTransform3D {

	Transform3D transform;
	
	public VirtualTransform3D()
	{
		transform = new Transform3D();
	}
	
	public void setTranslation(Vector3f vect)
	{
		transform.setTranslation(vect);
	}
	
	public void setTranslation(Vector3d vect)
	{
		transform.setTranslation(vect);
	}

	public Transform3D getTransform3D() {
		return transform;
	}
}
