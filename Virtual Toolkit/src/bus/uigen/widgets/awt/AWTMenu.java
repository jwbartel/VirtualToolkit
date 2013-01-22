package bus.uigen.widgets.awt;

//import java.awt.Event;
//import java.awt.MenuComponent;
import java.awt.Menu;
import java.awt.MenuItem;

import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.universal.CentralUniversalWidget;
//import java.awt.Menu;
//import java.awt.event.ActionListener;
//import bus.uigen.widgets.swing.SwingMenuItem;

public class AWTMenu extends AWTMenuItem implements VirtualMenu {
	// Menu menu;
	public AWTMenu(Menu theMenu) {
		super(theMenu);
		// menu = theMenu;
	}

	public AWTMenu() {
		component = new Menu();
	}

	public AWTMenu(String s) {
		component = new Menu(s);
		// menu = theMenu;
	}

	public Menu getMenu() {
		return (Menu) component;
	}

	/*
	 * public void init (Object val) { menu = (Menu) val; }
	 */
	public Object getPhysicalComponent() {
		return getMenu();
	}

	public void add(VirtualMenuItem c) {
		if (c.getPhysicalComponent() instanceof MenuItem)
			getMenu().add((MenuItem) c.getPhysicalComponent());

		c.setParent(this);

	}

	public void insert(VirtualMenuItem c, int pos) {
		getMenu().insert((MenuItem) c.getPhysicalComponent(), pos);
		c.setParent(this);
	}

	public void remove(VirtualMenuItem c) {
		getMenu().remove((MenuItem) c.getPhysicalComponent());
		c.setParent(null);
	}

	public void add(String s) {
		getMenu().add(s);
	}

	public void addSeparator() {
		getMenu().addSeparator();
	}

	public void insertSeparator(int pos) {
		getMenu().insertSeparator(pos);
	}

	public int getItemCount() {
		return getMenu().getItemCount();
	}

	public VirtualMenuItem getItem(int n) {

		return AWTMenuItem.virtualMenuItem(getMenu().getItem(n));
	}

	/*
	 * public void setEnabled (boolean newVal) { getMenu().setEnabled(newVal); }
	 * public void enable () { setEnabled(true); } public void postEvent(Event
	 * event) { getMenu().postEvent(event); } public void setLabel (String
	 * newVal) { getMenu().setLabel(newVal); } public void addActionListener
	 * (Object theListener) { addActionListener((ActionListener) theListener);
	 * 
	 * } public void addActionListener (ActionListener theListener) {
	 * getMenu().addActionListener(theListener);
	 * 
	 * }
	 */

	public static AWTMenu virtualMenu(Menu theMenu) {
		return (AWTMenu) CentralUniversalWidget.universalWidget(theMenu);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
		// return getMenu().getName();
	}

}
