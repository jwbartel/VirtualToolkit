package test;



import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.Painter;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualPainter;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTToolkit;
import bus.uigen.widgets.swt.SWTDelegatePanel;
import bus.uigen.widgets.tree.TreeSelector;
import bus.uigen.widgets.tree.VirtualTree;

public class TestSWTVirtualWidgets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VirtualToolkit.selectSwing();
		//VirtualToolkit.selectAWT();
		VirtualToolkit.setDefaultToolkit(new AWTToolkit());
		VirtualFrame frame = FrameSelector.createFrame();
		
		
		VirtualTextField textField = TextFieldSelector.createTextField("Edit Me");
		

		VirtualButton textButton = ButtonSelector.createButton("Set value at");
		VirtualTextField textRow = TextFieldSelector.createTextField("0");
		VirtualTextField textCol = TextFieldSelector.createTextField("0");
		VirtualTextField textVal = TextFieldSelector.createTextField("True");
		
		VirtualTextField colNum = TextFieldSelector.createTextField("0");
		VirtualButton colSmaller = ButtonSelector.createButton("Column Smaller");
		VirtualButton colBigger = ButtonSelector.createButton("Column Bigger");
		VirtualTextField rowNum = TextFieldSelector.createTextField("0");
		VirtualButton rowSmaller = ButtonSelector.createButton("Row Smaller");
		VirtualButton rowBigger = ButtonSelector.createButton("Row Bigger");
		
		VirtualContainer colPanel = PanelSelector.createPanel(); 
		VirtualContainer rowPanel = PanelSelector.createPanel();
		VirtualContainer textPanel = PanelSelector.createPanel();
		
		
		
		//frame.setLayout(new SWTFlowLayout());
		//frame.setLayout(FlowLayoutSelector.createFlowLayout());
		frame.setLayout(GridLayoutSelector.createLayout(4,1));
		//frame.getContentPane().add(textPanel);
		//frame.getContentPane().add(colPanel);
		//frame.getContentPane().add(rowPanel);
		
		textPanel.setLayout(GridLayoutSelector.createLayout(1, 4));
		//textPanel.setLayout(FlowLayoutSelector.createFlowLayout());
		textPanel.add(textButton);
		textPanel.add(textRow);
		textPanel.add(textCol);
		textPanel.add(textVal);
		
		colPanel.setLayout(GridLayoutSelector.createLayout(1, 3));
		colPanel.add(colNum);
		colPanel.add(colSmaller);
		colPanel.add(colBigger);
		
		
		rowPanel.setLayout(GridLayoutSelector.createLayout(1, 3));
		rowPanel.add(rowNum);
		rowPanel.add(rowBigger);
		rowPanel.add(rowSmaller);
		
		//panel.setLayout(new SWTFlowLayout());
		//panel.setLayout(FlowLayoutSelector.createFlowLayout());
		//panel.setLayout(GridLayoutSelector.createLayout(1, 3));
		//panel.add(textField);
		//panel.add(button1);
		//panel.add(button2);
		
		//VirtualLabel label = LabelSelector.createLabel("I am a label");
		//panel.add(label);
		//label.setSize(20,60);
		//frame.getContentPane().add(label);
		
		//VirtualTextField textField = TextFieldSelector.createTextField("Text Field Test");
		//textField.setLocation(10,20);
		//textField.setSize(200,30);
		//textField.setBounds(10, 20, 250, 30);
		//frame.getContentPane().add(textField);
		//TestActionListener listener = new TestActionListener();
		//textField.addActionListener(listener);
		//textField.addActionListener(listener);
		
		VirtualButton button = ButtonSelector.createButton("Button text");
		button.setLocation(10,55); //button will pack if size is not set
		button.setBounds(10, 50, 20, 60);
		button.addMouseListener(new TestMouseAdapter());
		button.addMouseListener(new TestAWTMouseListener());
		button.addMouseListener(new TestSWTMouseListener());
		//button.addActionListener(new TestActionListener());
		//button.pack();
		//frame.getContentPane().add(button);
		//panel.add(button);
		//button.setParent(frame.getContentPane()); //this doesn't work
		
		//VirtualComboBox combo = ComboBoxSelector.createComboBox();
		//combo.setLocation(10,100);
		//combo.setSize(20,160);
		//combo.addItem("First option");
		//combo.setEditable(false);
		//combo.addItem("Second choice");
		//frame.getContentPane().add(combo);
		//Object[][] data = new Object[3][3];
		//for(int i=0; i<3; i++){
		//	for(int j=0; j<3; j++){
			//	data[i][j] = "true";
			//}
		//}
		//String[] names = {"abc","2","3"};
		//VirtualTable table = TableSelector.createTable(data, names);
		//VirtualScrollableTable table = ScrollableTableSelector.createTable(data, names);
		//frame.getContentPane().add(table);
		
		//VirtualContainer panel2 = PanelSelector.createPanel(); //in order for this to work, the next line needs to be live
		//frame.getContentPane().add(panel2);
		//panel.setSize(400,400);
		
		
		//frame.getContentPane().add(table);
		//panel2.add(table);
		//table.setColumnWidth(1, 50);
		//table.setColumnWidth(2, 40);
		//table.setSize(400, 400);
		//frame.getContentPane().add(table);
		
		Object[][] data = { { "Colors", "Red", "Blue", "Green" },
			      { "Flavors", "Tart", "Sweet", "Bland" },
			      { "Length", "Short", "Medium", "Long" },
			      { "Volume", "High", "Medium", "Low" },
			      { "Temperature", "High", "Medium", "Low" },
			      { "Intensity", "High", "Medium", "Low" }, };
		 Object[] data2 = { "Colors", "Red", "Blue", "Green" };
		//VirtualTree tree = new SwingTree(data);
		VirtualTree tree = TreeSelector.createTree(data);
		VirtualContainer treePanel = PanelSelector.createPanel();
		

		treePanel.add(tree);
		tree.setSize(400, 400);
		//frame.getContentPane().add(treePanel);
		
		
		//colSmaller.addActionListener(new ShrinkTableColumnListener(table,colNum));
		//colBigger.addActionListener(new GrowTableColumnListener(table,colNum));
		//rowSmaller.addActionListener(new ShrinkTableRowListener(table,rowNum));
		//rowBigger.addActionListener(new GrowTableRowListener(table,rowNum));
		
		//textButton.addActionListener(new AdjustValueListener(table,textVal,textRow, textCol));
		
		//button1.addActionListener(new ShrinkTableListener(table));
		//button2.addActionListener(new ResizeTableListener(table));
		//textField.addActionListener(new AdjustValueListener(table, textField));
		//panel.add(table);
		/*VirtualMenu menu = MenuSelector.createMenu("File");
		VirtualMenu edit = MenuSelector.createMenu("Edit");
		VirtualMenu help = MenuSelector.createMenu("Help");
		VirtualMenu nestedmenu = MenuSelector.createMenu("Nested");
		VirtualMenu nestedtwice = MenuSelector.createMenu("Birded");
		VirtualMenuItem item = MenuItemSelector.createMenuItem("Item");
		VirtualMenuItem item2 = MenuItemSelector.createMenuItem("Another Item");
		VirtualMenuItem item3 = MenuItemSelector.createMenuItem("Item3");
		VirtualMenuItem item4 = MenuItemSelector.createMenuItem("Item4");
		VirtualMenuItem item5 = MenuItemSelector.createMenuItem("Item5");
		VirtualMenuBar menubar = MenuBarSelector.createMenuBar("This is the MenuBar");
		menubar.add(menu);
		menubar.add(edit);
		menubar.add(help);
		//nestedmenu.add(item);
		nestedmenu.add(item3);
		nestedmenu.add(nestedtwice);
		menu.add(nestedmenu);
		nestedtwice.add(item4);
		//menu.remove(nestedmenu);
		nestedmenu.add(item5);
		
		menu.add(item);
		menu.addSeparator();
		//menu.add(item2);
		menu.insert(item2, 0);
		menu.insertSeparator(1);
		menu.add("Yet Another Item!"); //this is not removable as we don't have the item reference
		//menu.remove(item);
		//menu.remove(nestedmenu);
		nestedmenu.add("String!");
		//menubar.remove(edit);
		frame.setMenuBar(menubar);
		*/
		//System.out.println(AUniversalWidget.existingUniversalWidget(frame.getPhysicalComponent()));
		//frame.getContentPane().setSize(750,750); //what can we do to get this to pack() instead?
		//frame.pack(); //this does nothing now
		frame.getContentPane().pack();
		//VirtualMenu menu = MenuSelector.createMenu("Test Menu");
		//VirtualMenuBar menuBar = MenuBarSelector.createMenuBar("MenuBar");
		//VirtualMenuItem menuItem = MenuItemSelector.createMenuItem("MenuItem label");
		// panel.add(menu); //a VirtualMenu is a VirtualContainer, not a VirtualComponent
		//frame.getContentPane().add(menu);
		//menuBar.add(menu);
		//menu.add(menuItem);
		//panel.add(menuBar); //VirtualMenuBar extends VirtualMenuComponent, not VComponent
		//frame.getContentPane().add(menuBar); //frame only takes VirtualComponent arguments
		//frame.setLayout(GridLayoutSelector.createLayout(1, 3));
		/*frame.setSize(800, 400);
		VirtualContainer panel1 = PanelSelector.createPanel();
		VirtualContainer panel2 = PanelSelector.createPanel();
		Object[] tree_data = {"One", "Apple","Blue"};
		VirtualTree tree = TreeSelector.createTree(tree_data);
		tree.setSize(200,200);
		frame.setLayout(GridLayoutSelector.createLayout(1, 3));
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(tree);
		frame.getContentPane().add(panel2);*/
		

		SWTDelegatePanel panel2 = new SWTDelegatePanel();
		Painter painter = new VirtualPainter();
		panel2.addPainter(painter);
		
		
		
//		panel2.virtualDelegatePanel((DelegatePanel) panel);
//		painter.paint(g);
//		panel2.addPainter(painter);
//		panel2.
//		panel.addPaintListener(g);
		//VirtualContainer graphicPanel = PanelSelector.createPanel();
//		VirtualGraphicAWT g2 = new VirtualGraphicAWT();

//		paint.paint(g);
		//g2.add(g);
		
		//graphicPanel.addPaintListener(g);
	//	frame.
		frame.setSize(400, 400);
//		frame.getContentPane().add(g)
		/*( (Shell) frame.getContentPane().getPhysicalComponent()).addPaintListener(new PaintListener(){
	        public void paintControl(PaintEvent e){
	          e.gc.drawLine(0,0,50,50);
	        }
	    }); */
		//frame.getContentPane().add(g2);
		frame.getContentPane().add(panel2);
//		frame.getContentPane().addPaintListener(panel2);
//		frame.getContentPane().add
		frame.setVisible(true);
		//System.out.println("Reached end");
		VirtualToolkit.start(frame); //start only takes VirtualFrame objects

	}
	
	

}
