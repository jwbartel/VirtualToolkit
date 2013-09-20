package bus.uigen.widgets;

public interface InternalFrameFactory extends FrameFactory {
	public VirtualInternalFrame createInternalFrame();

	public VirtualInternalFrame createInternalFrame(String title);

}
