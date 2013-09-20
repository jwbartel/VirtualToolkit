package bus.uigen.widgets.gwt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class GWTTextField extends GWTComponent implements VirtualTextField {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionListenersCentralized;
	boolean isSynchronizedText = false;

	GWTTextFieldEventForwarder forwarder = new GWTTextFieldEventForwarder(this);

	public GWTTextField() {
		super(new TextBox());
	}

	public GWTTextField(String text) {
		super(new TextBox());
		getTextBox().setText(text);
	}

	public GWTTextField(TextBox t) {
		super(t);
	}

	public void init() {
		// getTextBox().addValueChangeHandler(forwarder);
		getTextBox().addKeyDownHandler(forwarder);
		getTextBox().addKeyUpHandler(forwarder);
		getTextBox().addKeyPressHandler(forwarder);
		getTextBox().addMouseDownHandler(forwarder);
		getTextBox().addMouseUpHandler(forwarder);
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public TextBox getTextBox() {
		return (TextBox) component;
	}

	public void setFocus(boolean focused) {
		getTextBox().setFocus(focused);
	}

	public void selectAll() {
		getTextBox().selectAll();
	}

	public void addKeyUpHandler(KeyUpHandler handler) {
		getTextBox().addKeyUpHandler(handler);
	}

	public String getText() {
		return getTextBox().getText();
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void postActionEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColumns(int theNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTextListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEditable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDocument(Object d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEditable(boolean newVal) {
		// TODO Auto-generated method stub

	}

	public void setText(String theText) {
		execSetText(theText);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			String uniqueID = VirtualToolkit.getUniqueIDByDefault();
			while (uniqueID == null) {
				uniqueID = VirtualToolkit.getUniqueIDByDefault();
			}
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ theText + ")");
		}
	}

	public void execSetText(String theText) {
		getTextBox().setText(theText);

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyUpHandler(Object handler) {
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

	@Override
	public void removeActionListener(VirtualActionListener listener) {
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
		this.actionListenersCentralized = centralize;
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

	public boolean getIsSynchronizedText() {
		return isSynchronizedText;
	}

	public void setIsSynchronizedText(boolean isSynchronizedText) {
		execSetIsSynchronizedText(isSynchronizedText);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualTextComponent.COMMAND_LABEL
					+ this.getName()
					+ VirtualTextComponent.SET_IS_SYNCHRONIZED_TEXT_COMMAND
					+ isSynchronizedText + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

	}

	public void execSetIsSynchronizedText(boolean isSynchronizedText) {
		this.isSynchronizedText = isSynchronizedText;
	}

	@Override
	public void setCaretPosition(int newVal) {
		// TODO Auto-generated method stub

	}

}