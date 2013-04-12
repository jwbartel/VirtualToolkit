package test;


import org.eclipse.swt.SWT;

/*import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;*/

import bus.uigen.widgets.swt.Button;
import bus.uigen.widgets.swt.Composite;
import bus.uigen.widgets.swt.Display;
import bus.uigen.widgets.swt.Shell;

public class TestSWTWidgets {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display(); //SWTFrame?
		
		Shell shell = new Shell (display);		//SWTContainer (in VirtualFrame)
		shell.pack();
		Composite c = new Composite (shell, SWT.NONE); //SWTPanel --not really panel. in VFrame too?
		c.pack();
		c.setSize(400,400);
		
		/*Label label= new Label (c, SWT.NONE);
		//Label label = new Label (shell, SWT.NONE);
		label.setText("Hello, World");
		label.pack();*/
		
		/*Text text1 = new Text(c, SWT.BORDER);
		text1.setText("Text message!");
		//text1.setLocation(20,20);
		//text1.setSize(200,40);
		text1.pack();
		text1.setBounds(15,15,200,60);*/
		
		
		
		Button button = new Button(c, SWT.PUSH);
		button.setBounds(20,80,100,100);
		button.setBounds(40, 200, 150, 100);
		button.setText("Push me, I'm a button!");
		button.pack();
		
		 
		
		/*Combo combo = new Combo (c, SWT.DROP_DOWN);
		combo.setBounds(10,150,140,10);
		combo.setItems(new String[] {"Cool", "Cooler","Coolest"});
		combo.select(1);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		//shell.setMen
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("File");  //note that menuitems can hold menus, but cannot themselves be menus
		MenuItem edit = new MenuItem(menu, SWT.CASCADE);
		edit.setText("Edit");
		MenuItem help = new MenuItem(menu, SWT.CASCADE);
		help.setText("Help");
		//to create Menu(Menu m), do new MenuItem item, new Menu m, then item.setMenu(m)
		Menu filemenu = new Menu(file); //or Menu(menu) or Menu(shell, SWT.DROP_DOWN)
		file.setMenu(filemenu);
		Menu editmenu = new Menu(menu);
		edit.setMenu(editmenu);
		Menu helpmenu = new Menu(shell, SWT.DROP_DOWN);
		help.setMenu(helpmenu);
		MenuItem secondary = new MenuItem(filemenu, SWT.CASCADE);
		secondary.setText("Secondary menu option");
		MenuItem copy = new MenuItem(editmenu, SWT.PUSH);
		copy.setText("Copy");
		MenuItem about = new MenuItem(helpmenu, SWT.PUSH);
		about.setText("Help");
		Menu tertiary = new Menu(secondary);
		secondary.setMenu(tertiary);
		MenuItem tertitem = new MenuItem(tertiary, SWT.PUSH);
		tertitem.setText("Tertiary!");*/
		
		
		shell.setSize(600,600);
		//c.pack();
		
		//shell.pack();
		shell.open();
		
		/*while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		display.dispose();
		label.dispose();*/

	}

}
