package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;

public class VirtualLine implements VirtualGraphicObject {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public VirtualLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}
	
	public void paintObject(PaintEvent e)
	{
		e.gc.drawLine(x1, y1, x2, y2);
	}
	
	public void paintObject(Graphics g)
	{
		g.drawLine(x1, y1, x2, y2);
	}

	
	public void paintObject(VirtualGraphic g) {
		// TODO Auto-generated method stub
		
	}

	public void fill(Graphics2D g2) {
	//	Graphics2D g2 = (Graphics2D)g;
		Line2D.Double oval = new Line2D.Double(x1, y1, x2, y2);
		g2.fill(oval);
		
	}

	public void fill(GC gc) {
		gc.drawLine(x1, y1, x2, y2);
	}
}