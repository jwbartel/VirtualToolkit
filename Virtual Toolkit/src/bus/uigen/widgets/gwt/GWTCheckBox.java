package bus.uigen.widgets.gwt;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualCheckBox;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

import com.google.gwt.user.client.ui.CheckBox;

public class GWTCheckBox extends GWTComponent implements VirtualCheckBox {
	boolean actionListenersCentralized;

	public GWTCheckBox() {
		super(new CheckBox());
	}

	public void init() {
		GWTCheckBoxEventForwarder forwarder = new GWTCheckBoxEventForwarder(
				this);
		getCheckBox().addClickHandler(forwarder);
	}

	public CheckBox getCheckBox() {
		return (CheckBox) component;
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);
		sendActionListener(listener);
	}

	public void sendActionListener(VirtualActionListener listener) {
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

	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
		return vMouseMoveListeners;
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		vMouseMoveListeners.add(listener);
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addItemListener(Object theListener) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isSelected() {
		return getCheckBox().getValue();
	}

	@Override
	public void setSelected(boolean newVal) {
		getCheckBox().setValue(newVal);
	}

	@Override
	public void setLabel(String newValue) {
		getCheckBox().setText(newValue);
	}

	@Override
	public String getLabel() {
		return getCheckBox().getText();
	}

	boolean centralizeActionListeners = false;

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

}
