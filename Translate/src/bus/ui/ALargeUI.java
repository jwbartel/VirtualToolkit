package bus.ui;

import bus.listeners.AClearListenerFactory;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualTextComponent;

public class ALargeUI extends ASmallUI {
	 VirtualButton clear;
	 VirtualTextComponent createTextComponent() {
		//return TextAreaSelector.createTextArea();
		 return TextFieldSelector.createTextField();
	 } 	 
	 void createWidgets() {
		 super.createWidgets();
		 clear = ButtonSelector.createButton("clear");
		 clear.setName("clear");
		 clear.addActionListener(new AClearListenerFactory("from", "to"));
	 }	 
	 void setLayout(VirtualContainer container) {
		 container.setLayout(GridLayoutSelector.createLayout(2, 2));
	 }
	 void setSize(VirtualFrame frame) {
		frame.setSize(250, 80);
	 }
	 void addWidgets(VirtualContainer container) {
		 super.addWidgets(container);
		 container.add(clear);
	 }	 
}
