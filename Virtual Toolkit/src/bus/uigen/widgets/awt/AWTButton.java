package bus.uigen.widgets.awt;

//import java.awt.Component;
//import java.awt.Container;
import java.awt.Button;
import java.awt.Event;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Icon;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;

public class AWTButton extends AWTComponent implements VirtualButton {
	// AbstractButton getButton();
	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean centralizeActionListeners = false;

	public AWTButton(Button theButton) {
		super(theButton);
		// getButton() = theButton;

		// init();

	}

	public AWTButton() {
		component = new Button();
	}

	public void init() {
		super.init();
		getButton().addActionListener(new AWTButtonEventForwarder(this));
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public Button getButton() {
		return (Button) component;
	}

	public void setActionCommand(String command) {
		getButton().setActionCommand(command);
	}

	public String getText() {
		return getButton().getLabel();
	}

	public void setText(String theText) {
		getButton().setLabel(theText);
	}

	public void setIcon(Object theIcon) {
		setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		getButton().setLabel(theIcon.toString());
	}

	public void setMargin(Insets margin) {
		System.out.println("Margins cannot be set for Button");
		// getButton().setMargin(margin);
	}

	public void setVerticalAlignment(int alignment) {
		System.out.println("Alignment cannot be set for Button");
		// getButton().setVerticalAlignment(alignment);

	}

	public void setHorizontalAlignment(int alignment) {
		System.out.println("Alignment cannot be set for Button");
		// getButton().setHorizontalAlignment(alignment);
	}

	public String getLabel() {
		return getButton().getLabel();
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getButton().postEvent(event);
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

	public void addActionListener(Object theListener) {
		addActionListener((ActionListener) theListener);

	}

	/*
	 * public void addActionListener (ActionListener theListener) {
	 * getButton().addActionListener(theListener);
	 * 
	 * }
	 */
	public void setMargin(Object margin) {
		setMargin((Insets) margin);
	}

	public static AWTButton virtualButton(Button theButton) {
		return (AWTButton) AWTComponent.virtualComponent(theButton);

	}

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

	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
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
			String command = VirtualButton.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	public void execCentralizeListeners(boolean centralize) {
		this.centralizeActionListeners = centralize;
	}

	public boolean listenersCentralized() {
		return this.centralizeActionListeners;
	}
}
