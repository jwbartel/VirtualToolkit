package bus.uigen.widgets.swt;

import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;

public class Display extends Device {
	VirtualFrame frame;

	public Display() {
		(new SWTToolkit()).select();
		frame = FrameSelector.createFrame();
	}
}
