package bus.uigen.widgets.events;

public interface VirtualActionListenerFactory extends VirtualListenerFactory,
		VirtualListener {

	public VirtualActionListener createListener();
}
