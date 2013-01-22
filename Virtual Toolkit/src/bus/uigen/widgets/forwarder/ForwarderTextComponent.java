package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;

public abstract class ForwarderTextComponent extends ForwarderComponent {
	String text = "";
	boolean isSynchronizedText = true;

	public String getText() {
		return text;
	}

	public void setText(String theText) {
		execSetText(text);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ theText + ")");
		}
	}

	public void execSetText(String theText) {
		this.text = theText;
	}

	public boolean getIsSynchronizedText() {
		return isSynchronizedText;
	}

	public void setIsSynchronizedText(boolean isSynchronizedText) {
		execSetIsSynchronizedText(isSynchronizedText);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualTextComponent.COMMAND_LABEL
					+ this.getName()
					+ VirtualTextComponent.SET_IS_SYNCHRONIZED_TEXT_COMMAND
					+ isSynchronizedText + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

	}

	public void execSetIsSynchronizedText(boolean isSynchronizedText) {
		this.isSynchronizedText = isSynchronizedText;
	}
}
