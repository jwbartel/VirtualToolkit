package bus.uigen.widgets.swing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTextField;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

public class SwingTextField extends SwingTextComponent implements
		VirtualTextField {
	// JTextField getTextField();

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean centralizedActionListeners;

	public SwingTextField(JTextField theTextField) {
		super(theTextField);
		// getTextField() = theTextField;

	}

	public SwingTextField() {

	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public JTextField getTextField() {
		return (JTextField) component;
	}

	public void init() {
		super.init();
		SwingTextFieldEventForwarder forwarder = new SwingTextFieldEventForwarder(
				this);
		getTextField().addActionListener(forwarder);
		getTextField().addKeyListener(forwarder);
		getTextField().addMouseListener(forwarder);
	}

	public int getColumns() {
		return getTextField().getColumns();
	}

	public void setColumns(int theNumber) {
		getTextField().setColumns(theNumber);
	}

	public void postActionEvent() {
		getTextField().postActionEvent();
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

			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ VirtualTextField.ADD_ACTION_LISTENER_COMMAND + listenerID
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

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyUpHandler(Object handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub

	}

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

	public void centralizeListeners(boolean centralize) {
		execCentralizeListeners(centralize);
		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	public void execCentralizeListeners(boolean centralize) {
		this.centralizedActionListeners = centralize;
	}

	public boolean listenersCentralized() {
		return this.centralizedActionListeners;
	}

}
