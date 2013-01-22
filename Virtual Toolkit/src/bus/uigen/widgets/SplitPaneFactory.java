package bus.uigen.widgets;

public interface SplitPaneFactory {
	public VirtualSplitPane createSplitPane();

	public VirtualSplitPane createSplitPane(int direction,
			VirtualComponent component1, VirtualComponent component2);

}
