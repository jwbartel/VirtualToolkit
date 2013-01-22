package bus.ui;
import bus.listeners.ATranslateListener;
import bus.listeners.ATranslateListenerFactory;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.TextAreaSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualGridLayout;
import bus.uigen.widgets.VirtualTextComponent;
public class ASmallUI {
	VirtualTextComponent from, to;
	VirtualButton translate;
	VirtualTextComponent createTextComponent() {
		return TextFieldSelector.createTextField();
	}
	void createWidgets() {
		from = createTextComponent();
		from.setName("from");
		to = createTextComponent();
		to.setName("to");
		to.setIsSynchronizedText(false);
		translate = ButtonSelector.createButton("translate");
		translate.setName("translate");
		translate.addActionListener(new ATranslateListenerFactory("from", "to"));
		//translate.addActionListener(new ATranslateListenerFactory(from, to))		
		//translate.setCentralizedComputation(true);
	}	
	 void setSize(VirtualFrame frame) {
		frame.setSize(100, 150);
	 }
	void addWidgets(VirtualContainer container) {
		setLayout(container);
		container.add(from);
		container.add(to);
		container.add(translate);
	}
	
	void setLayout(VirtualContainer container) {
		 container.setLayout(GridLayoutSelector.createLayout(3, 1));
	 }	
	public void createUI(VirtualFrame frame) {
		VirtualContainer container = frame.getContentPane();
		createWidgets();
		addWidgets(container);
		setSize(frame);
		frame.setVisible(true);
	}
}
