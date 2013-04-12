package bus.uigen.widgets;

import java.awt.Graphics;
import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;

import bus.uigen.widgets.awt.AWTGraphic;
import bus.uigen.widgets.graphics.VirtualOval;
import bus.uigen.widgets.graphics.VirtualRectangle;

public class VirtualPainter implements Painter {

	public VirtualPainter()
	{
		
	}
	
	public void paint(VirtualGraphic g) {
		System.out.println("VP Paint method");
		g.setFont("Arial", new String[]{"Italic", "Bold"}, 20);
		g.drawString("Hello Praesun!", 50, 50);
		g.setDotted(4);
		g.setColor(255,0,0);
		g.drawString("Hello Praesun v2", 150, 50);
		g.drawRectangle(50, 100, 50, 50);
		g.setDotted(1);
		g.setColor(125,125,0);
		g.drawRectangle(110, 100, 50, 50);
		g.setDashed(4);
		g.setColor(0, 255, 0);
		g.drawRectangle(170, 100, 50, 50);
		g.setSolid(2);
		g.drawLine(250, 100, 300, 150);
		g.setColor(0,0,255);
		g.setDashed(3);
		g.drawLine(310, 100, 360, 150);
		g.setDashed(1);
		g.drawLine(370, 100, 420, 150);
		VirtualRectangle recty = new VirtualRectangle(50, 180, 50,50);
		g.fill(recty);
		VirtualOval ovaly = new VirtualOval(110, 180, 50, 50);
		g.fill(ovaly);
		
		//g.setColor(0,255,0);
		
		
	}


}