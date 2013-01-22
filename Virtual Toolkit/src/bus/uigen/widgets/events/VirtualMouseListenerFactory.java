package bus.uigen.widgets.events;

public interface VirtualMouseListenerFactory extends VirtualListenerFactory,
		VirtualListener {

	public VirtualMouseListener createListener();

}
