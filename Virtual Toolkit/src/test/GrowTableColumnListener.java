package test;

import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.table.VirtualTable;

public class GrowTableColumnListener implements VirtualActionListener {
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