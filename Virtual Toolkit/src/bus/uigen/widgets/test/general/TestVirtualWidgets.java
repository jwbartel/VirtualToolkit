package bus.uigen.widgets.test.general;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.MenuBarSelector;
import bus.uigen.widgets.MenuItemSelector;
import bus.uigen.widgets.MenuSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.ScrollPaneSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.VirtualScrollPane;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTToolkit;
import bus.uigen.widgets.swing.SwingScrollableTable;
import bus.uigen.widgets.table.VirtualScrollableTable;

public class TestVirtualWidgets {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VirtualToolkit.selectSwing();
		VirtualToolkit.setDefaultToolkit(new AWTToolkit());
		VirtualFrame frame = FrameSelector.createFrame();
		VirtualTextField textField = TextFieldSelector.createTextField("Edit Me");
		//textField.addActionListener(new TestActionListener());
		VirtualButton button = ButtonSelector.createButton("TestButton");
		//button.addMouseListener(new TestMouseAdapter());
		//button.addMouseListener(new TestAWTMouseListener());
		//button.addMouseListener(new TestSWTMouseListener());
		//button.addActionListener(new TestActionListener());
		Boolean[][] data = new Boolean[3][3];
		String[] names = {"1","2","3"};
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				data[i][j] = new Boolean(true);
			}
		}
		VirtualScrollableTable table = new SwingScrollableTable(data, names);
		VirtualScrollPane scroll = ScrollPaneSelector.createScrollPane();
		VirtualMenu menu = MenuSelector.createMenu("Menu Text");
		VirtualMenu nestedmenu = MenuSelector.createMenu("Nested");
		VirtualMenuItem item = MenuItemSelector.createMenuItem("MenuItem");
		VirtualMenuItem item2 = MenuItemSelector.createMenuItem("Another Item");
		VirtualMenuBar menubar = MenuBarSelector.createMenuBar("This is the MenuBar");
		menubar.add(menu);
		nestedmenu.add(item);
		menu.add(nestedmenu);
		nestedmenu.add(item2);
		/*System.out.println(item2.getParent());
		item2.setParent(menu);
		System.out.println(item2.getParent());*/
		nestedmenu.add("String!");
		//VirtualTable table = TableSelector.createTable();
		//TableModel data = new MyTableModel();
		//data.setValueAt(2, 0, 0);
		//table.setModel(data);
		VirtualContainer panel = PanelSelector.createPanel();
		panel.add(textField);
		panel.add(button);
		panel.add(table);
		//menu.enable();
		//item.enable();
		frame.getContentPane().add(panel);
		frame.setMenuBar(menubar);
		frame.setSize(300, 400);
		frame.setVisible(true);
		
		

	}
	

}
