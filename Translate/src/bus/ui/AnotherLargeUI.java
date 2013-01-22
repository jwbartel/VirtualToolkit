package bus.ui;

import bus.listeners.AClearListenerFactory;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.TextAreaSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;

public class AnotherLargeUI extends AnotherSmallUI {
	 VirtualButton clear;
	 void createTextWidgets() {
		from = TextAreaSelector.createTextArea();
		to = TextAreaSelector.createTextArea();
	}
	 void createButtons() {
		 super.createButtons();
		 clear = ButtonSelector.createButton("clear");		
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
	 void addListeners(VirtualContainer container) {
		 super.addListeners(container);
		 clear.addActionListener(new AClearListenerFactory("from", "to"));
			//translate.addActionListener(new ATranslateListenerFactory(from, to))
	 }
	 void nameWidgets() {
		 super.nameWidgets();
		 clear.setName("clear");
	 }
	 void setDomains() {
		String[] domains = {"Stand-Alone", "Web"};
		//VirtualToolkit.setDomains(domains);
	 }
}
