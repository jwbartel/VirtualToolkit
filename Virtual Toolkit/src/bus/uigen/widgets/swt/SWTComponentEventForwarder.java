package bus.uigen.widgets.swt;

import java.util.Vector;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;

import bus.uigen.widgets.events.VirtualFocusEvent;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseEvent;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

public class SWTComponentEventForwarder implements FocusListener,
		MouseTrackListener, MouseListener, MouseMoveListener {
	SWTComponent component;
	boolean inside = false;
	boolean down = false;

	public SWTComponentEventForwarder(SWTComponent c) {
		component = c;
	}

	public void focusGained(FocusEvent event) {
		VirtualFocusEvent virtualEvent = SWTEventPackager.convert(event);
		virtualEvent.setId(VirtualFocusEvent.Focus_gain);
		Vector<VirtualFocusListener> listeners = component
				.getVirtualFocusListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).focusGained(virtualEvent);
		}
	}

	public void focusLost(FocusEvent event) {
		VirtualFocusEvent virtualEvent = SWTEventPackager.convert(event);
		virtualEvent.setId(VirtualFocusEvent.Focus_lost);
		Vector<VirtualFocusListener> listeners = component
				.getVirtualFocusListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).focusLost(virtualEvent);
		}
	}

	public void mouseEnter(MouseEvent event) {
		inside = true;
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseEnter);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseEntered(virtualEvent);
			listeners.elementAt(i).mouseEnter(virtualEvent);
		}
	}

	public void mouseExit(MouseEvent event) {
		inside = false;
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseExit);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseExited(virtualEvent);
			listeners.elementAt(i).mouseExit(virtualEvent);
		}
	}

	public void mouseHover(MouseEvent event) {
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseHover);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseHover(virtualEvent);
		}
	}

	public void mouseDoubleClick(MouseEvent event) {
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseDoubleClick);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseDoubleClick(virtualEvent);
		}
	}

	public void mouseDown(MouseEvent event) {
		down = true;
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseDown);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mousePressed(virtualEvent);
			listeners.elementAt(i).mouseDown(virtualEvent);
		}
	}

	public void mouseUp(MouseEvent event) {
		boolean click = inside;
		down = false;
		VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
				VirtualMouseEvent.MouseUp);
		Vector<VirtualMouseListener> listeners = component
				.getVirtualMouseListeners();
		for (int i = 0; i < listeners.size(); i++) {
			listeners.elementAt(i).mouseReleased(virtualEvent);
			listeners.elementAt(i).mouseUp(virtualEvent);
		}
		if (click) {
			virtualEvent = SWTEventPackager.convert(event,
					VirtualMouseEvent.MouseClick);
			for (int i = 0; i < listeners.size(); i++) {
				listeners.elementAt(i).mouseClicked(virtualEvent);
			}
		}
	}

	public void mouseMove(MouseEvent event) {
		if (!down) {
			VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
					VirtualMouseEvent.Mouse_Move);
			Vector<VirtualMouseMoveListener> listeners = component
					.getVirtualMouseMoveListeners();
			for (int i = 0; i < listeners.size(); i++) {
				listeners.elementAt(i).mouseMoved(virtualEvent);
			}
		} else {
			VirtualMouseEvent virtualEvent = SWTEventPackager.convert(event,
					VirtualMouseEvent.Mouse_Drag);
			Vector<VirtualMouseMoveListener> listeners = component
					.getVirtualMouseMoveListeners();
			for (int i = 0; i < listeners.size(); i++) {
				listeners.elementAt(i).mouseDragged(virtualEvent);
			}
		}
	}

}
