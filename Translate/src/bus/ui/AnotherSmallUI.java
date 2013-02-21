package bus.ui;

import bus.listeners.ATranslateListenerFactory;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualTextComponent;
public class AnotherSmallUI {
	VirtualTextComponent from, to;
	VirtualButton translate;
	void createButtons() {
		translate = ButtonSelector.createButton("translate");
	}
	void createTextWidgets() {
		from = TextFieldSelector.createTextField();
		to = TextFieldSelector.createTextField();
	}
	 void setSize(VirtualFrame frame) {
		frame.setSize(100, 100);
	 }
	void nameWidgets() {
		from.setName("from");
		to.setName("to");
		translate.setName("translate");
	}
	void addWidgets(VirtualContainer container) {
		container.add(from);
		container.add(to);
		container.add(translate);
	}
	void addListeners(VirtualContainer container) {
		translate.addActionListener(new ATranslateListenerFactory("from", "to").createListener());
		//translate.addActionListener(new ATranslateListenerFactory(from, to))
	}
	void setLayout(VirtualContainer container) {
		 container.setLayout(GridLayoutSelector.createLayout(3, 1));
	 }
	void setDomains() {
		String[] domains = {"Eclipse"};
		//VirtualToolkit.setDomains(domains);
	}
	void setCollaborationAttributes() {
		//from.setCentralizedComputation(translate);
	}	
	public void createUI() {
		VirtualFrame frame = FrameSelector.createFrame();
		VirtualContainer container = frame.getContentPane();
		createTextWidgets();
		createButtons();
		nameWidgets();
		setLayout(container);
		addWidgets(container);
		addListeners(container);
		setCollaborationAttributes();
		setDomains();
		setSize(frame);
		frame.setVisible(true);
	}
}
