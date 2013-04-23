package bus.uigen.widgets.test.general;

import javax.swing.table.TableModel;

import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.table.VirtualTable;

public class AdjustValueListener implements VirtualActionListener{
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
		TableModel model = (TableModel) table.getModel();
		model.setValueAt(value.getText(), Integer.parseInt(row.getText()), Integer.parseInt(col.getText()));
		
	}
}