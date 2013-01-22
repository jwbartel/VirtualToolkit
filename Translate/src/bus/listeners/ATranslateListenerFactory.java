package bus.listeners;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;

public class ATranslateListenerFactory implements VirtualActionListenerFactory{
	String fromName, toName;
	//VirtualTextComponent from, to;
	
	public ATranslateListenerFactory(){}
	
	public ATranslateListenerFactory(String from, String to) {
		this.fromName = from;
		this.toName = to;
	}
	public VirtualActionListener createListener() {
		VirtualTextComponent from = (VirtualTextComponent) VirtualToolkit.getDefaultObjectByID(fromName);
		VirtualTextComponent to = (VirtualTextComponent) VirtualToolkit.getDefaultObjectByID(toName);
		return new ATranslateListener(from, to);
	}
}
