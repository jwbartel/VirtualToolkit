package bus.uigen.widgets.swt;

import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;

import bus.uigen.widgets.graphics.VirtualGraphic;
import bus.uigen.widgets.graphics.VirtualGraphicObject;
import bus.uigen.widgets.graphics.VirtualLine;

public class SWTGraphic extends VirtualGraphic implements PaintListener {
	ArrayList<VirtualGraphicObject> drawnElements = new ArrayList<VirtualGraphicObject>();

	public void paintControl(PaintEvent e) {

		for (int i = 0; i < drawnElements.size(); i++) {
			paintObject(e.gc, drawnElements.get(i));
		}

	}

	public void paintObject(GC gc, VirtualGraphicObject ooject) {
		System.out.print("");
	}

	public void paintObject(GC gc, VirtualLine line) {
		gc.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	}

	public void addDrawnObject(VirtualGraphicObject o) {
		drawnElements.add(o);
	}
}