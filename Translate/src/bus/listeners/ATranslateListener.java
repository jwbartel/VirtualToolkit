package bus.listeners;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;

public class ATranslateListener implements VirtualActionListener  {
	Translator translator = new ATranslator();
	VirtualTextComponent from, to;
	public ATranslateListener(VirtualTextComponent from, VirtualTextComponent to) {
		this.from = from;
		this.to = to;
	}
	@Override
	public void actionPerformed(VirtualActionEvent event) {
		to.setText(translator.translate(from.getText()));		
	}
}
