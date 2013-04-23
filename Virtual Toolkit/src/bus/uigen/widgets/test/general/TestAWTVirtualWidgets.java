package bus.uigen.widgets.test.general;



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.Painter;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTDelegatePanel;
import bus.uigen.widgets.awt.AWTGraphic;
import bus.uigen.widgets.awt.AWTToolkit;
import bus.uigen.widgets.awt.DelegatePanel;
import bus.uigen.widgets.graphics.VirtualGraphic;
import bus.uigen.widgets.graphics.VirtualPainter;


public class TestAWTVirtualWidgets {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VirtualToolkit.selectSwing();
		VirtualToolkit.setDefaultToolkit(new AWTToolkit());
		//VirtualToolkit.selectSWT();
		VirtualFrame frame = FrameSelector.createFrame();
		
	/*	
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
		
		*/
		
		//frame.setLayout(new SWTFlowLayout());
		//frame.setLayout(FlowLayoutSelector.createFlowLayout());
		frame.setLayout(GridLayoutSelector.createLayout(4,1));
		//frame.getContentPane().add(textPanel);
		//frame.getContentPane().add(colPanel);
		//frame.getContentPane().add(rowPanel);
		
	/*	textPanel.setLayout(GridLayoutSelector.createLayout(1, 4));
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
		button.addActionListener(new TestActionListener());
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

		frame.getContentPane().pack();*/

		VirtualGraphic g = new AWTGraphic();
	//	g.addDrawnObject(new VirtualLine(100,100, 200, 200));
	//	g.addDrawnObject(new VirtualOval(200,200,50,50));
	//	g.addDrawnObject((new VirtualRectangle(300,300,40,40)));
	//	g.drawLine(100, 100, 200, 200);
		Painter painter = new VirtualPainter();
	//	painter.drawLine(100,100,200,200);
	//	painter.drawRect(100,100,100,100);
//		VirtualDelegatePanel panel = DelegatePanelSelector.createDelegatePanel();
		
		DelegatePanel panel3 = new DelegatePanel();
	//	SWTPanel spanel = new SWTPanel();
		System.out.println("AWTDelegatePanel instantiation");
		AWTDelegatePanel panel2 = new AWTDelegatePanel(panel3);
//		panel2.virtualDelegatePanel((DelegatePanel) panel);
//		painter.paint(g);
		panel2.addPainter(painter);
//		panel2.
//		panel.addPaintListener(g);
		//VirtualContainer graphicPanel = PanelSelector.createPanel();
//		VirtualGraphicAWT g2 = new VirtualGraphicAWT();

//		paint.paint(g);
		//g2.add(g);
		
		//graphicPanel.addPaintListener(g);
	//	frame.
		frame.setSize(400, 400);

		

	    frame.addWindowListener(new WindowAdapter() {

	       public void windowClosing(WindowEvent winEvent) {

	          System.exit(0);

	       }

	    });
		
	//	    frame.add
		

		 //   canvas.addMouseListener(this);
		
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
