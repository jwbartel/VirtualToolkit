package bus.uigen.widgets;

public interface VirtualSplitPane extends VirtualContainer {
	public void setResizeWeight(double weight);

	public void setContinuousLayout(boolean newVal);

	public void setRightComponent(VirtualComponent comp);

	public void setLeftComponent(VirtualComponent comp);

	public VirtualComponent getRightComponent();

	// public VirtualComponent clearRightComponent();
	public VirtualComponent getLeftComponent();

	public void setOrientation(int direction);

}
