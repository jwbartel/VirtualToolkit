package bus.uigen.widgets.awt;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import bus.uigen.widgets.events.VirtualFocusEvent;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseEvent;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

public class AWTComponentEventForwarder implements FocusListener,
		MouseListener, MouseMotionListener {
	AWTComponent component;

	private long timeForDoubleClick = 500; // 500 ms
	private long timeLastClick;

	public AWTComponentEventForwarder(AWTComponent c) {
		component = c;
	}

	public void focusGained(FocusEvent event) {
		VirtualFocusEvent virtualEvent = AWTEventPackager.convert(event);
		Vector<VirtualFocusListener> listeners = component
				.getVirtualFocusListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).focusGained(virtualEvent);
		}
	}

	public void focusLost(FocusEvent event) {
		VirtualFocusEvent virtualEvent = AWTEventPackager.convert(event);
		Vector<VirtualFocusListener> listeners = component
				.getVirtualFocusListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).focusLost(virtualEvent);
		}
	}

	public void mouseClicked(MouseEvent event) {
		// send the single click event
		long currTime = event.getWhen();
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.MouseClick);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseClicked(virtualEvent);
		}

		// check if the double click has been peformed
		if (currTime - timeLastClick < timeForDoubleClick) {
			virtualEvent = AWTEventPackager.convert(event,
					VirtualMouseEvent.MouseDoubleClick);
			for (int i = 0; i < listeners.size(); i++) {
				listeners.elementAt(i).mouseDoubleClick(virtualEvent);
			}
		}
		timeLastClick = currTime;
	}

	public void mouseEntered(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.MouseEnter);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseEntered(virtualEvent);
			listeners.elementAt(i).mouseEnter(virtualEvent);
		}

	}

	public void mouseExited(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.MouseExit);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseExited(virtualEvent);
			listeners.elementAt(i).mouseExit(virtualEvent);
		}
	}

	public void mousePressed(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.MouseDown);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mousePressed(virtualEvent);
			listeners.elementAt(i).mouseDown(virtualEvent);

		}
	}

	public void mouseReleased(MouseEvent event) {
		// boolean click = (lastMouseEvent==VirtualMouseEvent.MouseDown);
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.MouseUp);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseReleased(virtualEvent);
			listeners.elementAt(i).mouseUp(virtualEvent);
		}
		/*
		 * if(click){ mouseClicked(event); }
		 */

	}

	public void mouseDragged(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.Mouse_Drag);
		Vector<VirtualMouseMoveListener> listeners = component
				.getVirtualMouseMoveListener();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).mouseDragged(virtualEvent);
		}
	}

	public void mouseMoved(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event,
				VirtualMouseEvent.Mouse_Move);
		Vector<VirtualMouseMoveListener> listeners = component
				.getVirtualMouseMoveListener();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).mouseMoved(virtualEvent);
		}
	}

}
