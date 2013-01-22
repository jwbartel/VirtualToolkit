package bus.driver.client;

import bus.ui.ASmallUI;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.distributed.gwt.ADistributedGwtRmiWidgetServerFactory;
import bus.uigen.widgets.gwt.GWTToolkit;




public class Translate{// implements EntryPoint {
	
	public void onModuleLoad() {
		
		System.out.println("Module reached");
		
		WidgetServerSelector.setWidgetServerFactory(new ADistributedGwtRmiWidgetServerFactory());
		VirtualToolkit.setDefaultToolkit(new GWTToolkit("127.0.0.1:15151/~translator/?session=test1&kind=large"));
		VirtualFrame frame = FrameSelector.createFrame("translator");
		//frame.add(ButtonSelector.createButton("Fun stuff"));
		
		//Build a large UI
		//(new ALargeUI()).createUI(frame);
		
		//Build a small UI
		(new ASmallUI()).createUI(frame);
	
		
		VirtualToolkit.start(frame);
	}
}
