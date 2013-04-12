package test;

import bus.uigen.widgets.events.VirtualActionAdapter;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.VirtualTable;
import bus.uigen.widgets.VirtualTextField;

public class GrowTableRowListener extends VirtualActionAdapter{
	VirtualTable table;
	VirtualTextField text;
	
	public GrowTableRowListener(VirtualTable t, VirtualTextField txt){
		table = t;
		text = txt;
	}
	
	public void actionPerformed(VirtualActionEvent e){
		table.setRowHeight(Integer.parseInt(text.getText()), table.getRowHeight(Integer.parseInt(text.getText()))+10);
	}
}