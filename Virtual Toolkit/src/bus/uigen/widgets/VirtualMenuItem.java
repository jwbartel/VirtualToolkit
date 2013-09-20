package bus.uigen.widgets;

public interface VirtualMenuItem extends VirtualMenuComponent,
		VirtualActionableComponent {
	public void setEnabled(boolean newVal);

	public void enable();

	public void postEvent(Object event);

	public void setLabel(String newVal);

	public void setActionCommand(String cmd);

	// public Object getPhysicalComponent();
	public String getText(); // moved here from VirtualMenu

}
