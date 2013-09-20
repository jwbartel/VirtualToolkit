package bus.uigen.widgets.swt;

import java.util.Iterator;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SWTTextFieldEventForwarder implements ModifyListener, KeyListener,
		MouseListener {
	SWTTextField component;
	String oldText;

	public SWTTextFieldEventForwarder(SWTTextField t) {
		component = t;
		oldText = "";
	}

	public void modifyText(ModifyEvent event) {
		VirtualActionEvent gen = SWTEventPackager.convert(event);

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
	public void mouseDoubleClick(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseDown(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		checkTextForChange();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		checkTextForChange();
	}

}
