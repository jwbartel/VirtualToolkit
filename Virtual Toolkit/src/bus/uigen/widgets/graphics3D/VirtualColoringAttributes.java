package bus.uigen.widgets.graphics3D;

import javax.media.j3d.ColoringAttributes;
import javax.vecmath.Color3f;

public class VirtualColoringAttributes {

	ColoringAttributes cAttributes;
	
	public VirtualColoringAttributes()
	{
		cAttributes = new ColoringAttributes();
	}
	
	public VirtualColoringAttributes(Color3f color, int shadeModel)
	{
		cAttributes = new ColoringAttributes(color, shadeModel);
	}
	
	public ColoringAttributes getColoringAttributes()
	{
		return cAttributes;
	}
	
	public VirtualColoringAttributes(float red, float green, float blue, int shadeModel)
	{
		cAttributes = new ColoringAttributes(red, green, blue, shadeModel);
	}
	
	public void getColor(Color3f color)
	{
		cAttributes.getColor(color);
	}
	
	public void setColor(Color3f color)
	{
		cAttributes.setColor(color);
	}
	
	public int getShadeModel()
	{
		return cAttributes.getShadeModel();
	}
	
	public void setShadeModel(int shadeModel)
	{
		cAttributes.setShadeModel(shadeModel);
	}
}
