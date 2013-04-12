package test;

import bus.uigen.widgets.events.VirtualActionAdapter;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.VirtualTable;
import bus.uigen.widgets.VirtualTextField;

public class GrowTableColumnListener extends VirtualActionAdapter{
	VirtualTable table;
	VirtualTextField text;
	
	public GrowTableColumnListener(VirtualTable t, VirtualTextField txt){
		table = t;
		text = txt;
	}
	
	public void actionPerformed(VirtualActionEvent e){
		table.setColumnWidth(Integer.parseInt(text.getText()), table.getColumnWidth(Integer.parseInt(text.getText()))+10);
	}
}