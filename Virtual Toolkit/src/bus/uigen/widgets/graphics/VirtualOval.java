package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;

import bus.uigen.widgets.VirtualGraphic;
import bus.uigen.widgets.VirtualGraphicObject;

public class VirtualOval implements VirtualGraphicObject{
	private int x1;
	private int y1;
	private int width;
	private int height;
	
		
	public VirtualOval(int x1, int y1, int width, int height){
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;		
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public void paintObject(PaintEvent e)
	{
		e.gc.drawOval(x1, y1, width, height);
	}
	
	public void paintObject(Graphics g)
	{
		g.drawOval(x1, y1, width, height);
	}

	public void paintObject(VirtualGraphic g) {
		// TODO Auto-generated method stub
		
	}

	public void fill(Graphics2D g2) {
	//	Graphics2D g2 = (Graphics2D)g;
		Ellipse2D.Double oval = new Ellipse2D.Double(x1,y1,width,height);
		g2.fill(oval);
		
	}

	public void fill(GC gc) {
		gc.fillOval(x1,y1,width,height);
		// TODO Auto-generated method stub
	}
}