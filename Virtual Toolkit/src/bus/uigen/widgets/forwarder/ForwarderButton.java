package bus.uigen.widgets.forwarder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

public class ForwarderButton extends ForwarderComponent implements
		VirtualButton {
	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean centralizeListeners = false;
	String text = "";
	Object icon;

	public ForwarderButton() {

	}

	public ForwarderButton(String text) {
		this.text = text;
	}

	public ForwarderButton(Object icon) {
		this.icon = icon;
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setIcon(Object icon) {
		this.icon = icon;
	}

	@Override
	public void setVerticalAlignment(int alignment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHorizontalAlignment(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMargin(Object margin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActionCommand(String command) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel() {
		return text;
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

	@Override
	public void addActionListener(VirtualActionListener listener) {

		execAddActionListener(listener);

		sendActionListener(listener);
	}

	@Override
	public void addActionListener(VirtualActionListenerFactory listenerFactory) {

		execAddActionListener(listenerFactory.createListener());

		sendActionListener(listenerFactory);
	}

	@Override
	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);

	}

	@Override
	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}

	@Override
	public void addStyleName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addClickHandler(Object handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fireVirtualActionEvent(VirtualActionEvent event) {

		Iterator<VirtualActionListener> listeners = getVirtualActionListeners()
				.iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (!(listener instanceof ActionEventForwarder)) {
				listener.actionPerformed(event);
			}
		}
	}

	@Override
	public void centralizeListeners(boolean centralize) {
		execCentralizeListeners(centralize);
		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualButton.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	@Override
	public void execCentralizeListeners(boolean centralize) {
		this.centralizeListeners = centralize;
	}

	@Override
	public boolean listenersCentralized() {
		return this.centralizeListeners;
	}

	@Override
	public void execSetName(String newVal) {
		super.execSetName(newVal);
		if (VirtualToolkit.isDistributedByDefault()
				&& VirtualToolkit.defaultCentralizesListeners(newVal) != listenersCentralized()) {
			execCentralizeListeners(!listenersCentralized());
		}
	}

}
