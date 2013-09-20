package bus.uigen.widgets.events;

public interface VirtualFocusListenerFactory extends VirtualListenerFactory,
		VirtualListener {

	public VirtualFocusListener createListener();
}
