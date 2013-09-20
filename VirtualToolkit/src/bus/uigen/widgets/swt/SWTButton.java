package bus.uigen.widgets.swt;

import java.awt.Event;
import java.awt.Insets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Icon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTButtonEventForwarder;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTButton extends SWTComponent implements VirtualButton {
	// AbstractButton getButton();
	String text;

	SWTButtonEventForwarder forwarder = new SWTButtonEventForwarder(this);

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionListenersCentralized = true;

	public SWTButton(Button theButton) {
		super(theButton);
		init();
		// getButton() = theButton;

	}

	public SWTButton(String theText) {
		text = theText;
	}

	Button getButton() { // getLabel/TextField are public, but not getButton
		return (Button) component;
	}

	public String getLabel() {
		return null;
	}

	public SWTButton() {

	}
//	@Override
//	protected void subclassInit() {
//		getButton().addSelectionListener(forwarder);
//	}

	public void init() {
		super.init();
		getButton().addSelectionListener(forwarder);
	}

	public void setActionCommand(String command) {
		// getButton().setActionCommand(command);
	}

	public String getText() {
		return getButton().getText();
	}

	public void setText(String theText) {
		text = theText;
		if (getButton() != null) {
			getButton().setText(theText);
		}
	}

	public void setIcon(Object theIcon) {
		setIcon((Icon) theIcon);
	}

	public void setIcon(Icon theIcon) {
		// getButton().setLabel( theIcon.toString());
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

	public void postEvent(Event event) {
		// getButton().postEvent(event);
	}

	public void setMargin(Object margin) {
		setMargin((Insets) margin);
	}

	public static SWTButton virtualButton(Button theButton) {
		return (SWTButton) SWTComponent.virtualComponent(theButton);

	}

	// @Override
	public void addToParent(VirtualContainer theParent) {

		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an unitialized parent");
				}
			}
		}

		component = new Button((Composite) theParent.getPhysicalComponent(),
				SWT.PUSH);
		if (text != null) {
			getButton().setText(text);
		}

		// getButton().setLocation(10,30);
		// getButton().setSize(5,5);
		// getButton().pack();

		init();
		addAllListeners();
		getComponent().setLocation(xLocation, yLocation);
		getComponent().setSize(width, height);
		CentralUniversalWidget.register(component, this);

		// getButton().pack();
		// component.addToParent(theParent);

		if ((width == -1) || (height == -1))
			getComponent().pack(); // if dimensions aren't set
		else if (toPack)
			getComponent().pack();

		theParent.layout();

	}

	// @Override
	public void pack() {
		// TODO Auto-generated method stub
		toPack = true;
		super.pack();
	}

	public void addAllListeners() {
		super.addAllListeners();

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

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
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
		this.actionListenersCentralized = centralize;
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

}
