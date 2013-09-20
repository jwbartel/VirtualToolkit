package bus.uigen.widgets;

public interface VirtualScrollPane extends VirtualContainer {
	public VirtualComponent getScrolledComponent();

	public void setScrolledComponent(VirtualComponent c);

}
