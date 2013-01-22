package bus.uigen.widgets.events;

public interface VirtualMouseMoveListenerFactory extends
		VirtualListenerFactory, VirtualListener {

	public VirtualMouseMoveListener createListener();

}
