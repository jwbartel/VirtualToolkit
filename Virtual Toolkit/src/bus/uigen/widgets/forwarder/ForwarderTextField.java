package bus.uigen.widgets.forwarder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

public class ForwarderTextField extends ForwarderTextComponent implements
		VirtualTextField {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionCentralized = false;

	public ForwarderTextField() {

	}

	public ForwarderTextField(String text) {
		this.text = text;
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void addTextListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocument(Object d) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEditable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEditable(boolean newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setColumns(int theNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postActionEvent() {
		// TODO Auto-generated method stub

	}

	private void sendActionListener(VirtualListener listener) {

		if (VirtualToolkit.isDistributedByDefault()
				&& !(listener instanceof ActionEventForwarder)) {
			String listenerID = VirtualToolkit.getDefaultVirtualListenerID();
			VirtualToolkit.defaultAssociate(listenerID, listener);
			VirtualToolkit.sendListenerToDefault(listener, listenerID);

			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ VirtualTextField.ADD_ACTION_LISTENER_COMMAND + listenerID
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
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyUpHandler(Object handler) {
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
			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	@Override
	public void execCentralizeListeners(boolean centralize) {
		this.actionCentralized = centralize;
	}

	@Override
	public boolean listenersCentralized() {
		return this.actionCentralized;
	}

	@Override
	public void execSetName(String newVal) {
		super.execSetName(newVal);
		if (VirtualToolkit.isDistributedByDefault()
				&& VirtualToolkit.defaultCentralizesListeners(newVal) != listenersCentralized()) {
			centralizeListeners(!listenersCentralized());
		}
	}

}
