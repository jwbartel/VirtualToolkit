package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.TextFieldFactory;
import bus.uigen.widgets.VirtualTextField;

public class ForwarderTextFieldFactory implements TextFieldFactory {

	@Override
	public VirtualTextField createTextField() {
		return new ForwarderTextField();
	}

	@Override
	public VirtualTextField createTextField(String text) {
		return new ForwarderTextField(text);
	}

}
