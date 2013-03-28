package bus.uigen.widgets.swing;

import java.awt.Event;
import java.awt.Insets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

public class SwingButton extends SwingComponent implements VirtualButton {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionListenersCentralized = false;

	public SwingButton(AbstractButton theButton) {
		super(theButton);
		// getButton() = theButton;

	}

	AbstractButton getButton() {
		return (AbstractButton) component;
	}

	public SwingButton() {

	}
	
	protected void subclassInit() {
		getButton().addActionListener(new SwingButtonEventForwarder(this));
	}

	public void init() {
//		subClassInit();
//		getButton().addActionListener(new SwingButtonEventForwarder(this));
//		subclassInit();
		super.init();
		subclassInit();
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public void setActionCommand(String command) {
		getButton().setActionCommand(command);
	}

	public String getText() {
		return getButton().getText();
	}

	public void setText(String theText) {
		getButton().setText(theText);
	}

	public void setIcon(Object theIcon) {
		getButton().setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		getButton().setIcon(theIcon);
	}

	public void setMargin(Insets margin) {
		getButton().setMargin(margin);
	}

	public void setVerticalAlignment(int alignment) {
		getButton().setVerticalAlignment(alignment);

	}

	public void setHorizontalAlignment(int alignment) {
		getButton().setHorizontalAlignment(alignment);
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getButton().postEvent(event);
	}

	@SuppressWarnings("deprecation")
	public String getLabel() {
		return getButton().getLabel();
	}

	public void setMargin(Object margin) {
		getButton().setMargin((Insets) margin);
	}

	public static SwingButton virtualButton(JButton theButton) {
		return (SwingButton) AWTComponent.virtualComponent(theButton);

	}

	// @Override
	public void pack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addClickHandler(Object handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStyleName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub

	}

	public void addActionListener(VirtualActionListener listener) {

		execAddActionListener(listener);

		sendActionListener(listener);
	}

	public void addActionListener(VirtualActionListenerFactory listenerFactory) {

		execAddActionListener(listenerFactory.createListener());

		sendActionListener(listenerFactory);
	}

	private void sendActionListener(VirtualListener listener) {

		if (VirtualToolkit.isDistributedByDefault()
				&& !(listener instanceof ActionEventForwarder)) {
			String listenerID = VirtualToolkit.getDefaultVirtualListenerID();
			VirtualToolkit.defaultAssociate(listenerID, listener);
			VirtualToolkit.sendListenerToDefault(listener, listenerID);

			String command = VirtualButton.COMMAND_LABEL + this.getName()
					+ VirtualButton.ADD_ACTION_LISTENER_COMMAND + listenerID
					+ ")";
			// VirtualToolkit.foundPossibleListenerCreator(listener,
			// VirtualToolkit.getNameOnServer());
			VirtualToolkit.sendCommandByDefault(command);
		}

	}

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}

	public void fireVirtualActionEvent(VirtualActionEvent event) {
		Iterator<VirtualActionListener> listeners = vActionListeners.iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (!(listener instanceof ActionEventForwarder)) {
				listener.actionPerformed(event);
			}
		}
	}

	public void centralizeListeners(boolean centralize) {
		execCentralizeListeners(centralize);
		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualButton.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	public void execCentralizeListeners(boolean centralize) {
		this.actionListenersCentralized = centralize;
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

}
