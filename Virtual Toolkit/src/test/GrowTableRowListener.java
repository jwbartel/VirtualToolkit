package test;

import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.table.VirtualTable;

public class GrowTableRowListener implements VirtualActionListener{
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