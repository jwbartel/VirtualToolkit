package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;


import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;


public class VirtualArc implements VirtualGraphicObject{
	private int x1;
	private int y1;
	private int width;
	private int height;
	private int startAngle;
	private int endAngle;
	
	public VirtualArc(int x, int y, int width, int height, int startAngle, int endAngle){
		this.x1 = x;
		this.y1 = y;
		this.width = width;
		this.height = height;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
	}

	public int getX() {
		return x1;
	}

	public int getY() {
		return y1;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getStartAngle()
	{
		return startAngle;
	}
	
	public int getEndAngle()
	{
		return endAngle;
	}
	
	public void paintObject(PaintEvent e)
	{
		e.gc.drawArc(x1, y1, width, height, startAngle, endAngle);
	}
	public void paintObject(Graphics g)
	{
		
		g.drawArc(x1, y1, width, height, startAngle, endAngle);
	}

	public void paintObject(VirtualGraphic g) {
		// TODO Auto-generated method stub
		
	}

	public void fill(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillArc(x1, y1, width, height, startAngle, endAngle);
	}

	public void fill(GC gc) {
		// TODO Auto-generated method stub
		gc.fillArc(x1,y1,width,height,startAngle,endAngle);
	}
	
	
}