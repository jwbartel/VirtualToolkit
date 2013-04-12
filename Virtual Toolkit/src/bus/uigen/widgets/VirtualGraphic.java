package bus.uigen.widgets;

import java.awt.Graphics;
import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Device;

public interface VirtualGraphic extends PaintListener{
	
	public void drawLine(int x1, int y1, int x2, int y2);
	public void drawOval(int x1, int y1, int width, int height);
	public void drawRectangle(int x1, int y1, int width, int height);
	public void setColor(float r, float g, float b, float a);
	public void setColor(int r, int g, int b);
	public void fill(VirtualGraphicObject vo);
	public void setLineWidth(int thickness);
	//public Graphics getGraphic();
	public void setDashed(int thickness);
	public void setSolid(int thickness);
	public void setDotted(int thickness);
	public void setFont(String fontName, String params[], int size);
	public void drawString(String string, int x, int y);
	
}