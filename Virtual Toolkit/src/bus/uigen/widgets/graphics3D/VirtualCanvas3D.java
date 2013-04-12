package bus.uigen.widgets.graphics3D;

import java.awt.GraphicsConfiguration;

import javax.media.j3d.Canvas3D;

public class VirtualCanvas3D  {

	public Canvas3D canvas;
	
	public VirtualCanvas3D(GraphicsConfiguration config)
	{
		canvas = new Canvas3D(config);
	}
	
	public VirtualCanvas3D(GraphicsConfiguration config, boolean offscreen)
	{
		canvas = new Canvas3D(config, offscreen);
	}
	
	public Canvas3D getCanvas3D()
	{
		return canvas;
	}
	
	public void setSize(int width, int height)
	{
		canvas.setSize(width, height);
	}
}
