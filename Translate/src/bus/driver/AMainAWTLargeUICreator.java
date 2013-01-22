package bus.driver;

import bus.ui.ALargeUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.awt.AWTToolkit;
import bus.uigen.widgets.distributed.nongwt.ADistributedNonGwtRmiWidgetServerFactory;


public class AMainAWTLargeUICreator {
	public static void main(String args[]) {
		WidgetServerSelector.setWidgetServerFactory(new ADistributedNonGwtRmiWidgetServerFactory());
		VirtualToolkit.setDefaultToolkit(new AWTToolkit());
		VirtualFrame frame = FrameSelector.createFrame("translate");
		(new ALargeUI()).createUI(frame);
		VirtualToolkit.start(frame);
		
	}
}
