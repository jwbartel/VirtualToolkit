package bus.uigen.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class AWTTextFieldEventForwarder implements ActionListener, KeyListener,
		MouseListener {
	AWTTextField component;
	String oldText;

	public AWTTextFieldEventForwarder(AWTTextField t) {
		component = t;
		oldText = component.getText();
	}

	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent gen = AWTEventPackager.convert(event);

		Iterator<VirtualActionListener> listeners = component
				.getVirtualActionListeners().iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (VirtualToolkit.isDistributedByDefault()) {
				if (!((listener instanceof ActionEventForwarder && component
						.listenersCentralized()) || (!(listener instanceof ActionEventForwarder) && !component
						.listenersCentralized()))) {
					continue;
				}
			}
			listener.actionPerformed(gen);
		}
	}

	private void checkTextForChange() {
		if (!component.getIsSynchronizedText()
				|| oldText.equals(component.getText()))
			return;

		oldText = component.getText();
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = component.getName();
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ component.getText() + ")");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		checkTextForChange();
	}

}
