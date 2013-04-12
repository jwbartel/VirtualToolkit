package test;

import bus.uigen.widgets.events.VirtualActionAdapter;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.table.VirtualTable;
import bus.uigen.widgets.VirtualTextField;

import javax.swing.table.TableModel;

public class AdjustValueListener extends VirtualActionAdapter{
	VirtualTable table;
	VirtualTextField value;
	VirtualTextField row;
	VirtualTextField col;
	
	
	public AdjustValueListener(VirtualTable t, VirtualTextField v, VirtualTextField r, VirtualTextField c){
		table = t;
		value = v;
		row = r;
		col = c;
	}
	
	public void actionPerformed(VirtualActionEvent e){
		TableModel model = table.getModel();
		model.setValueAt(value.getText(), Integer.parseInt(row.getText()), Integer.parseInt(col.getText()));
		
	}
}