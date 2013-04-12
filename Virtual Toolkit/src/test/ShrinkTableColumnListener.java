package test;

import bus.uigen.widgets.events.VirtualActionAdapter;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.table.VirtualTable;
import bus.uigen.widgets.VirtualTextField;

public class ShrinkTableColumnListener extends VirtualActionAdapter{
	VirtualTable table;
	VirtualTextField text;
	
	public ShrinkTableColumnListener(VirtualTable t, VirtualTextField txt){
		table = t;
		text = txt;
	}
	
	public void actionPerformed(VirtualActionEvent e){
		int col = Integer.parseInt(text.getText());
		int oldVal = table.getColumnWidth(Integer.parseInt(text.getText()));
		table.setColumnWidth(col, oldVal-10);
	}
}