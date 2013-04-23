package bus.uigen.widgets.graphics;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

import bus.uigen.widgets.awt.AWTGraphic;



public class VirtualGraphicAWT extends Applet{

	ArrayList<VirtualGraphic> graphics = new ArrayList<VirtualGraphic>();
	
	public void init()
	{
	//	graphics = new ArrayList<VirtualGraphic>();
	}
	
/*	public void paint(Graphics g)
	{
		for(int i=0; i<graphics.size(); i++){
			VirtualGraphic test = graphics.get(i);
			test.paint(g);
		}
	}
	*/
	public void add(VirtualGraphic o)
	{
		graphics.add(o);
	}
	
}
