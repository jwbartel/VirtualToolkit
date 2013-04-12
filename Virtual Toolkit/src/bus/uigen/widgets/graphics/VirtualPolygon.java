package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;

import bus.uigen.widgets.VirtualGraphic;
import bus.uigen.widgets.VirtualGraphicObject;

public class VirtualPolygon implements VirtualGraphicObject{

	private int[] x;
	private int[] y;
	private int numPoints;
	private int[] combined;
	
	public VirtualPolygon(int[] xPoints, int[] yPoints, int num){
		this.x = xPoints;
		this.y = yPoints;
		this.numPoints = num;
		
		//This is for the SWT's implementation of Polygon.  It uses
		//a single array as the arguments, instead of two separate ones like AWT
		//does.
		int combinedCounter=0;
		combined = new int[numPoints*2];
		for(int i = 0; i < numPoints; i++)
		{
			combined[combinedCounter] = x[0];
			combinedCounter++;
			combined[combinedCounter] = y[0];
			combinedCounter++;
		}
	}
	
	public void addPoint(int x1, int y1)
	{
		x[numPoints] = x1;
		y[numPoints] = y1;
		numPoints++;
	}
	
	public void fill(Graphics2D g) {
		g.fillPolygon(x, y, numPoints);
	}

	public void fill(GC gc) {
		gc.fillPolygon(combined);
	}

	public void paintObject(PaintEvent e) {
		e.gc.drawPolygon(combined);
	}

	public void paintObject(Graphics g) {
		g.drawPolygon(x, y, numPoints);
	}

	public void paintObject(VirtualGraphic g) {
		// TODO Auto-generated method stub
		
	}

	
	
}
