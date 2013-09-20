package bus.uigen.widgets.awt;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.Vector;

import bus.uigen.widgets.Painter;

public class DelegatePanel extends Panel /* implements VirtualDelegatePanel */
{

	private static final long serialVersionUID = 1L;

	public DelegatePanel() {
		super();

	}

	Vector<Painter> painters = new Vector<Painter>();

	public void addPainter(Painter painter) {
		if (painters.contains(painter))
			return;
		painters.add(painter);

	}

	public void removePainter(Painter painter) {
		if (painters.contains(painter))
			return;
		painters.remove(painter);

	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < painters.size(); i++)
			painters.elementAt(i).paint(new AWTGraphic(g));

	}

}
