package bus.listeners;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class AClearListener implements VirtualActionListener {
	VirtualTextComponent from, to;
	public AClearListener(VirtualTextComponent from, VirtualTextComponent to) {
		this.from = from;
		this.to = to;
	}
	@Override
	public void actionPerformed(VirtualActionEvent event) {
		from.setText("");
		to.setText("");		
	}
}
