package bus.driver;

import bus.ui.ASmallUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.distributed.nongwt.ADistributedNonGwtRmiWidgetServerFactory;
import bus.uigen.widgets.swt.SWTToolkit;


public class AMainSWTSmallUICreator {
	public static void main(String args[]) {
		WidgetServerSelector.setWidgetServerFactory(new ADistributedNonGwtRmiWidgetServerFactory());
		VirtualToolkit.setDefaultToolkit(new SWTToolkit());

		VirtualFrame frame = FrameSelector.createFrame("translate");
		(new ASmallUI()).createUI(frame);
		VirtualToolkit.start(frame);
	}
}