package bus.uigen.widgets.events;

public interface VirtualFocusListener extends VirtualListener {

	public void focusLost(VirtualFocusEvent event);

	public void focusGained(VirtualFocusEvent event);
}
