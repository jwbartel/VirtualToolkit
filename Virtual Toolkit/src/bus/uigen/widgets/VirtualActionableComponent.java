package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualActionListener;

public interface VirtualActionableComponent /* extends VirtualComponent */{ // formerly
																			// extends
																			// VirtualComponent
																			// was
																			// commented
																			// out

	public void addActionListener(VirtualActionListener listener);

	public void postEvent(Object event);

}
