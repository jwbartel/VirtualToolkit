package bus.uigen.widgets.gwt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;

public class GWTButton extends GWTComponent implements VirtualButton {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();

	boolean centralizedActionListeners = true;

	public GWTButton() {
		super(new Button());
	}

	public GWTButton(String html) {
		super(new Button(html));
	}

	public GWTButton(Button b) {
		super(b);
	}
	

	public void init() {
		GWTButtonEventForwarder forwarder = new GWTButtonEventForwarder(this);
		getButton().addClickHandler(forwarder);
	}

	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
		return vMouseMoveListeners;
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public Button getButton() {
		return (Button) component;
	}

	public void setEnabled(boolean enabled) {
		getButton().setEnabled(enabled);
	}

	public void setFocus(boolean focus) {
		getButton().setFocus(focus);
	}

	public void setHorizontalAlignment(int x) {
		/*
		 * if(getButton().getParent() instanceof HasHorizontalAlignment){ if(x
		 * == SwingConstants.LEFT){ ((HasHorizontalAlignment)
		 * getButton().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT); }else
		 * if(x == SwingConstants.RIGHT){ ((HasHorizontalAlignment)
		 * getButton().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT); }else
		 * if(x == SwingConstants.CENTER){ ((HasHorizontalAlignment)
		 * getButton().
		 * getParent()).setHorizontalAlignment(HasHorizontalAlignment
		 * .ALIGN_CENTER); }else{ ((HasHorizontalAlignment)
		 * getButton().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_DEFAULT); } }
		 */
	}

	public void setVerticalAlignment(int alignment) {
		/*
		 * if(getButton().getParent() instanceof HasVerticalAlignment){
		 * if(alignment == SwingConstants.BOTTOM){ ((HasVerticalAlignment)
		 * getButton
		 * ().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM
		 * ); }else if(alignment == SwingConstants.CENTER){
		 * ((HasVerticalAlignment)
		 * getButton().getParent()).setVerticalAlignment(
		 * HasVerticalAlignment.ALIGN_MIDDLE); }else if(alignment ==
		 * SwingConstants.TOP){ ((HasVerticalAlignment)
		 * getButton().getParent()).
		 * setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP); }else{
		 * ((HasVerticalAlignment)
		 * getButton().getParent()).setVerticalAlignment(
		 * HasVerticalAlignment.ALIGN_MIDDLE); } }
		 */
	}

	public Element getElement() {
		return getButton().getElement();
	}

	public String getLabel() {
		return getButton().getText();
	}

	public String getText() {
		return getButton().getText();
	}

	public void setText(String text) {
		getButton().setText(text);
	}

	public void addStyleName(String style) {
		getButton().addStyleName(style);
	}

	public void addClickHandler(ClickHandler handler) {
		getButton().addClickHandler(handler);
	}

	public void addClickHandler(Object handler) {
		if (handler instanceof ClickHandler) {
			getButton().addClickHandler((ClickHandler) handler);
		}

	}

	@Override
	public void setActionCommand(String command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMargin(Object margin) {
		// TODO Auto-generated method stub
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIcon(Object icon) {
		// TODO Make the icon a name on the button

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

	@Override
	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		vMouseMoveListeners.add(listener);
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
		this.centralizedActionListeners = centralize;
	}

	public boolean listenersCentralized() {
		return this.centralizedActionListeners;
	}

}