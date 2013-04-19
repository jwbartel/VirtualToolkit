package bus.uigen.widgets.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.GC;


public interface VirtualGraphicObject{
	
	public void paintObject(PaintEvent e);
	public void paintObject(Graphics g);
	public void paintObject(VirtualGraphic g);
	public void fill(Graphics2D g);
	public void fill(GC gc);
	
}