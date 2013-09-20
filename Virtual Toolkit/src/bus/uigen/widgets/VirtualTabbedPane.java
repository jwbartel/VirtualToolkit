package bus.uigen.widgets;

public interface VirtualTabbedPane extends VirtualContainer {
	public void addTab(String label, VirtualComponent c);

	public void setTitleAt(int index, String label);

	public void setTabPlacement(int placement);

}
