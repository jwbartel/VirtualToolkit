package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;

import bus.uigen.widgets.VirtualGraphic;
import bus.uigen.widgets.VirtualGraphicObject;

public class VirtualRectangle implements VirtualGraphicObject{
	private int x1;
	private int y1;
	private int height;
	private int width;
		
	public VirtualRectangle(int x1, int y1, int width, int height){
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

	public int getwidth() {
		return width;
	}
	
	public void paintObject(PaintEvent e)
	{
		e.gc.drawRectangle(x1,y1,width,height);
	}
	
	public void paintObject(Graphics g)
	{
		g.drawRect(x1,y1,width,height);
	}

	public void paintObject(VirtualGraphic g) {
		// TODO Auto-generated method stub
		g.drawRectangle(x1, y1, width, height);
	}

	public void fill(Graphics2D g2) {
	//	Graphics2D g2 = (Graphics2D)g;
		Rectangle2D.Double recty = new Rectangle2D.Double(x1,y1,width,height);
		g2.fill(recty);
		// TODO Auto-generated method stub
		
	}

	public void fill(GC gc) {
		//gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN)); 
		gc.fillRectangle(x1, y1, width, height);
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}