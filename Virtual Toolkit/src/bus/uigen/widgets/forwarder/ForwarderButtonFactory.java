package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.ButtonFactory;
import bus.uigen.widgets.VirtualButton;

public class ForwarderButtonFactory implements ButtonFactory {

	@Override
	public VirtualButton createButton(String text) {
		return new ForwarderButton(text);
	}

	@Override
	public VirtualButton createButton(Object icon) {
		return new ForwarderButton(icon);
	}

	@Override
	public VirtualButton createButton() {
		return new ForwarderButton();
	}

}
