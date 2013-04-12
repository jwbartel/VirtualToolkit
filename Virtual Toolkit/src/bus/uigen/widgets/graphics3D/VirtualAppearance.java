package bus.uigen.widgets.graphics3D;

import javax.media.j3d.Appearance;
import javax.media.j3d.PolygonAttributes;

public class VirtualAppearance {

	
	public Appearance appearance;
	
	public VirtualAppearance()
	{
		appearance = new Appearance();
	}
	
	public void setColoringAttributes(VirtualColoringAttributes color)
	{
		appearance.setColoringAttributes(color.getColoringAttributes());
	}
	
	public void setPolygonAttributes(PolygonAttributes attributes)
	{
		appearance.setPolygonAttributes(attributes);
	}
	
	public Appearance getAppearance()
	{
		return appearance;
	}
}
