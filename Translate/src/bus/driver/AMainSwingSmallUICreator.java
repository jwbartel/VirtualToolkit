package bus.driver;

import bus.ui.ASmallUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.swing.SwingToolkit;


public class AMainSwingSmallUICreator {
	public static void main(String args[]) {
		VirtualToolkit.setDefaultToolkit(new SwingToolkit());
		VirtualFrame frame = FrameSelector.createFrame("translate");
		(new ASmallUI()).createUI(frame);
		VirtualToolkit.start(frame);
	}
}
