package bus.uigen.widgets.swt;

import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
//import bus.uigen.widgets.awt.AWTToolkit;
//import bus.uigen.widgets.swing.SwingToolkit;
//import bus.uigen.widgets.VirtualToolkit_Old;
//import bus.uigen.widgets.universal.AUniversalWidget;

public class Display extends Device {
	VirtualFrame frame;

	public Display() {
		(new SWTToolkit()).select();
		frame = FrameSelector.createFrame();
	}
}
