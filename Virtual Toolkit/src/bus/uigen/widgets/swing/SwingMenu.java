package bus.uigen.widgets.swing;

//import java.awt.Event;
//import java.awt.MenuComponent;
import java.awt.Menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.universal.CentralUniversalWidget;
//import java.awt.Menu;
//import java.awt.MenuItem;
//import java.awt.event.ActionListener;
//import bus.uigen.widgets.UniversalWidget;

public class SwingMenu extends SwingMenuItem implements VirtualMenu {
	JMenu menu;

	public SwingMenu(JMenu theMenu) {
		super(theMenu);
		// menu = theMenu;
	}

	public SwingMenu() {

	}

	public JMenu getMenu() {
		return (JMenu) component;
	}

	/*
	 * public void init (Object val) { menu = (Menu) val; }
	 */
	/*
	 * public Object getPhysicalComponent() { return getMenu(); }
	 */
	public void add(VirtualMenuItem c) {
		getMenu().add((JMenuItem) c.getPhysicalComponent());
		c.setParent(this);

	}

	public void insert(VirtualMenuItem c, int pos) {
		getMenu().insert((JMenuItem) c.getPhysicalComponent(), pos);
		c.setParent(this);
	}

	public void remove(VirtualMenuItem c) {
		getMenu().remove((JMenuItem) c.getPhysicalComponent());
		c.setParent(null);
	}

	public void add(String s) {
		if (s.equals("-"))
			addSeparator();
		else
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

	// should this be universal widget?
	public VirtualMenuItem getItem(int n) {

		return SwingMenuItem.virtualMenuItem(getMenu().getItem(n));
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

	public static SwingMenu virtualMenu(Menu theMenu) {
		return (SwingMenu) CentralUniversalWidget.universalWidget(theMenu);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
		// return getMenu().getName();
	}

}
