package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;

public interface VirtualTextField extends VirtualTextComponent,
		VirtualActionableComponent {
	public static final String COMMAND_LABEL = "VIRTUALTEXTFIELD:";
	public static final String ADD_ACTION_LISTENER_COMMAND = VirtualButton.ADD_ACTION_LISTENER_COMMAND;
	public static final String CENTRALIZE_ACTION_COMMAND = ".centralizeListeners(";

	// public String getText();
	// public void setText (String theText);
	// public void addTextListener(Object listener);
	// public void addFocusListener(Object listener);
	public int getColumns();

	public void setColumns(int theNumber);

	public void postActionEvent();

	// public void setDocument (PlainDocument d);
	// public boolean isEditable();
	// public void setEditable(boolean newVal);

	// public void setBounds(int x, int y, int width, int height);

	public void addActionListener(VirtualActionListener listener);

	public void addActionListener(VirtualActionListenerFactory listenerFactory);

	public void execAddActionListener(VirtualActionListener listener);

	public void removeActionListener(VirtualActionListener listener);

	public void setFocus(boolean focus);

	public void selectAll();

	public void addKeyUpHandler(Object handler);

	public void fireVirtualActionEvent(VirtualActionEvent event);

	public void centralizeListeners(boolean centralize);

	public void execCentralizeListeners(boolean centralize);

	public boolean listenersCentralized();
}
