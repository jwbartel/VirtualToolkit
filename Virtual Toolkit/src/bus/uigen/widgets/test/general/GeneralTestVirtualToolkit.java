package bus.uigen.widgets.test.general;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.swing.SwingToolkit;

class  ButtonAction implements VirtualActionListener{
	String action;
	public ButtonAction(String a){action = a;}
	
	public void actionPerformed(VirtualActionEvent e){
		if(action.equals("print")){System.out.println("Button pressed");}
		if(action.equals("exit")){System.exit(0);}
	}
}

public class GeneralTestVirtualToolkit{
	

	
	public static void main(String[] args){
		
		VirtualToolkit.setDefaultToolkit(new SwingToolkit());
		//VirtualToolkit.selectSwing();
		//VirtualToolkit.selectSWT();
		
		//Create Frame
		VirtualFrame frame = FrameSelector.createFrame();
		
		//Set size of frame
		frame.setSize(400, 200);
		
		//Add a basic label
		/*VirtualLabel label = LabelSelector.createLabel("Test Label");
		frame.getContentPane().add(label);*/
		
		//Add a basic text field
		/*VirtualTextField field = TextFieldSelector.createTextField();
		frame.getContentPane().add(field);*/
		
		//Add a basic button
		/*VirtualButton button = ButtonSelector.createButton("TestButton");
		frame.getContentPane().add(button);*/
		
		//Add Items in a GridLayout
		/*VirtualGridLayout grid = GridLayoutSelector.createLayout(2, 2);
		frame.setLayout(grid);
		VirtualButton b1 = ButtonSelector.createButton("1");
		VirtualButton b2 = ButtonSelector.createButton("2");
		VirtualButton b3 = ButtonSelector.createButton("3");
		VirtualButton b4 = ButtonSelector.createButton("4");
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);*/
		
		//Add items in Flowlayout
		/*VirtualFlowLayout flow = FlowLayoutSelector.createFlowLayout();
		frame.setLayout(flow);
		VirtualButton b1 = ButtonSelector.createButton("1");
		VirtualButton b2 = ButtonSelector.createButton("2");
		VirtualButton b3 = ButtonSelector.createButton("3");
		VirtualButton b4 = ButtonSelector.createButton("4");
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);*/
		
		//Add items in panels
		/*frame.setLayout(FlowLayoutSelector.createFlowLayout());
		VirtualContainer panel1 = PanelSelector.createPanel();
		VirtualContainer panel2 = PanelSelector.createPanel();
		panel2.setLayout(GridLayoutSelector.createLayout(2, 2));
		panel1.add(LabelSelector.createLabel("label 1"));
		panel2.add(ButtonSelector.createButton("button 1"));
		panel2.add(ButtonSelector.createButton("button 2"));
		panel2.add(ButtonSelector.createButton("button 3"));
		panel2.add(ButtonSelector.createButton("button 4"));
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(panel2);*/
		
		//Add a basic table
		/*Object[][] data = {{"row 1", 1, true}, {'a', 3.14, false}};
		String[] titles = {"Text", "Nums", "Bools"};
		VirtualTable table = TableSelector.createTable(data, titles);
		frame.getContentPane().add(table);*/
		
		//By default in Swing and AWT are not scrollable, so there is a ScrollableTable class
		/*Object[][] data = {{"row 1", 1, true},{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false},
							{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false},
							{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false},
							{'a', 3.14, false},{'a', 3.14, false},{'a', 3.14, false}};
		String[] titles = {"Text", "Nums", "Bools"};
		VirtualScrollableTable sTable = ScrollableTableSelector.createTable(data, titles);
		frame.getContentPane().add(sTable);*/
		
		//Example of Actions
		frame.getContentPane().setLayout(GridLayoutSelector.createLayout(1, 2));
		VirtualButton b1 = ButtonSelector.createButton("Print \"Button pressed\"");
		b1.addActionListener(new ButtonAction("print"));
		VirtualButton b2 = ButtonSelector.createButton("Exit");
		b2.addActionListener(new ButtonAction("exit"));
		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		
		//Make the frame visible
		//Note: start(frame) is a while loop in SWT and nothing will run after it
		frame.setVisible(true);
		VirtualToolkit.start(frame);
		
	}
	
	
	
}