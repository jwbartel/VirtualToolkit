package bus.driver.server;

import bus.ui.ALargeUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.distributed.nongwt.ADistributedNonGwtRmiWidgetServerFactory;
import bus.uigen.widgets.forwarder.ForwarderToolkit;

public class ALargeServerStarter {
	public static void main(String args[]) {
		WidgetServerSelector.setWidgetServerFactory(new ADistributedNonGwtRmiWidgetServerFactory());
		VirtualToolkit.setDefaultToolkit(new ForwarderToolkit("127.0.0.1:15151/~translator/?session=test1&kind=large", true, true, true));
		VirtualFrame frame = FrameSelector.createFrame("translate");
		(new ALargeUI()).createUI(frame);
		VirtualToolkit.start(frame);
		
	}
}
