package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;

public interface VirtualButton extends VirtualActionableComponent, VirtualLabel {
	public static final String COMMAND_LABEL = "VIRTUALBUTTON:";
	public static final String ADD_ACTION_LISTENER_COMMAND = ".addActionListener(";
	public static final String CENTRALIZE_ACTION_COMMAND = ".centralizeListeners(";

	// public void addActionListener (Object listener);
	public void setMargin(Object margin);

	public void setActionCommand(String command);

	public void pack();

	public String getLabel();

	public void addActionListener(VirtualActionListener listener);

	public void addActionListener(VirtualActionListenerFactory listener);

	public void execAddActionListener(VirtualActionListener listener);

	public void removeActionListener(VirtualActionListener listener);

	public void addStyleName(String name);

	public void setFocus(boolean focus);

	public void addClickHandler(Object handler);

	public void fireVirtualActionEvent(VirtualActionEvent event);

	public void centralizeListeners(boolean centralize);

	// public void blockActionEventForwarding(boolean block);
	public void execCentralizeListeners(boolean centralize);

	public boolean listenersCentralized();
}
