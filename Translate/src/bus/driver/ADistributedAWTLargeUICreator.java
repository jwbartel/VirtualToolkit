package bus.driver;

import bus.ui.ALargeUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.awt.AWTToolkit;
import bus.uigen.widgets.distributed.nongwt.ADistributedNonGwtRmiWidgetServerFactory;

public class ADistributedAWTLargeUICreator {

	public static void main(String[] args) {
		WidgetServerSelector.setWidgetServerFactory(new ADistributedNonGwtRmiWidgetServerFactory());
		VirtualToolkit.setDefaultToolkit(new AWTToolkit("127.0.0.1:15151/~translator/?session=test1&kind=large", true, true));
		VirtualFrame frame = FrameSelector.createFrame("translate");
		(new ALargeUI()).createUI(frame);
		VirtualToolkit.start(frame);
		
	}

}
