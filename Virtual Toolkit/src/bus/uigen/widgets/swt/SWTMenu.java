package bus.uigen.widgets.swt;

//import java.awt.Event;
//import java.awt.MenuComponent;
//import java.awt.Menu;
import java.awt.Font;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTMenu extends SWTMenuComponent implements VirtualMenu {
	// Menu menu;
	// MenuData md = new MenuData(); //should we not create a new MenuData()
	// here?
	MenuData md;

	class MenuData { // could this be static?
		// maybe i just want a structure to hold the data and it will be created
		// to shell afterwards.
		// ...but it's not a component, so addToParent() won't automatically be
		// called, will it?
		// perhaps some sort of linked list or node-based structure to hold the
		// menu hierarchy.
		Vector<SWTMenuItem> items;
		String text;
		Menu menuToSet; // to store the menu reference if the physical component
						// doesn't exist yet

		// boolean isEnabled = true;
		MenuData() { // constructor?
			items = new Vector<SWTMenuItem>(0);
			// text = new String();
		}

		MenuData(String t) { // is this appropriate? as below
			items = new Vector<SWTMenuItem>(0);
			text = new String(t); // is this appropriate? as below
		}

		String getText() { // TODO is this appropriate? Menus don't have text
							// fields in SWT
			return text;
		}

		void setText(String t) { // as above
			text = new String(t);
		}

		void addItem(int style) {
			SWTMenuItem m = new SWTMenuItem(style);
			items.addElement(m);
		}

		void addItem(String t) {
			SWTMenuItem m = new SWTMenuItem(t);
			items.addElement(m);
		}

		/*
		 * void addItem(MenuItem mi) { //is this ever used? SWTMenuItem m = new
		 * SWTMenuItem(mi); items.addElement(m); }
		 */
		void addItem(SWTMenuItem swtMI) {
			items.addElement(swtMI);
		}

		void insertItem(String t, int pos) {
			SWTMenuItem m = new SWTMenuItem(t);
			items.insertElementAt(m, pos);
		}

		/*
		 * void insertItem(MenuItem mi, int pos) { //is this ever used? probably
		 * not: deprecated SWTMenuItem m = new SWTMenuItem(mi);
		 * items.insertElementAt(m, pos); }
		 */
		void insertItem(SWTMenuItem swtMI, int pos) {
			items.insertElementAt(swtMI, pos);
		}

		void insertSeparator(int pos) {
			SWTMenuItem m = new SWTMenuItem();
			m.setStyle(SWT.SEPARATOR); // equivalent to new
										// SWTMenuItem(SWT.SEPARATOR)
			items.insertElementAt(m, pos);
		}

		void removeItem(String t) {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getText().equals(t) == true) {
					items.remove(i);
					break;
				}
			}
			// else item is not in the Vector
		}

		/*
		 * void removeItem(MenuItem mi) { //is this used? probably not:
		 * deprecated for (int i=0;i<items.size();i++) { if
		 * (items.get(i).getMenuItem().equals(mi)==true) { //will this work to
		 * compare two MenuItems? items.remove(i); break; } } }
		 */
		void removeItem(SWTMenuItem swtMI) {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).equals(swtMI) == true) { // will this work to
															// compare two
															// SWTMenuItems?
					items.remove(i);
					break;
				}
			}
		}

		SWTMenuItem getSWTItem(int pos) {
			return items.get(pos);
		}

		SWTMenuItem getSWTItem(String text) {
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getText().equals(text) == true) {
					return items.get(i);
				}
			}
			// return new SWTMenuItem();
			return null; // hopefully this is never reached, how to correct?
		}

		int getItemCount() {
			return items.size();
		}

		void setMenuToSet(Menu theMenu) {
			menuToSet = theMenu; // can't create new Menu here without
									// referencing the parent
		}

		Menu getMenuToSet() {
			return menuToSet;
		}
	}

	public SWTMenu() {
		// menu = new Menu();
		md = new MenuData();
	}

	public SWTMenu(String s) {
		// menu = new Menu (s);
		md = new MenuData(s);
		// menu = theMenu;
	}

	public SWTMenu(Menu theMenu) {
		// super (theMenu);
		md = new MenuData();
		/*
		 * for (int i=0; i<theMenu.getItemCount(); i++) { //is this valid if
		 * theMenu component doesn't exist yet? i think not..
		 * md.addItem(theMenu.getItem(i)); }
		 */
		md.setMenuToSet(theMenu);
		// we can't add the items yet because the menu component probably
		// doesn't exist.

		// menu = theMenu;
	}

	public Menu create(Menu parent) {
		// physically define components here
		Menu menu;
		if (getMenuToSet() != null) { // if there is a menu to set
			menu = getMenuToSet(); // is this valid? it overrides all other data
									// stored in md
			// setMenuToSet(null); //there is no longer a menu to set
		} else {
			menu = new Menu(parent);
			// System.out.println("Menu "+getText()+" has "+md.getItemCount()+" items");
			for (int i = 0; i < md.getItemCount(); i++) {
				MenuItem item = md.getSWTItem(i).create(menu);
				item.setText(md.getSWTItem(i).getText());
			}
		}
		return menu;
	}

	public Menu getMenu() {
		return (Menu) component;
	}

	public String getText() {
		return md.getText();
	}

	/*
	 * public void init (Object val) { menu = (Menu) val; }
	 */
	public Object getPhysicalComponent() {
		return getMenu();
	}

	public void add(VirtualMenuItem c) {

		// String text = new String(c.getText()); //error at TestSWT,74: was
		// ((SWTMenuItem) c)
		if (c instanceof SWTMenuItem) {
			md.addItem((SWTMenuItem) c); // will need to be able to add
											// SWTMenuItem c and SWTMenu c here
		} else if (c instanceof SWTMenu) {
			md.addItem(c.getText());
			md.getSWTItem(c.getText()).setMenu((SWTMenu) c);
		}
		// System.out.println("Attempting to add "+text+" to "+getText());
		// System.out.println("Items list now has length "+getItemCount());
		c.setParent(this);

	}

	public void insert(VirtualMenuItem c, int pos) {
		// getMenu().insert((MenuItem)c.getPhysicalComponent(), pos);
		// md.insertItem((MenuItem)c.getPhysicalComponent(), pos); //is the
		// position usage the same? (0-based)
		// md.insertItem(((SWTMenuItem) c).getItem(), pos);
		// will this try to reference the physical component before it exists
		// also?

		if (c instanceof SWTMenuItem) {
			md.insertItem((SWTMenuItem) c, pos); // will need to be able to add
													// SWTMenuItem c and SWTMenu
													// c here
		} else if (c instanceof SWTMenu) {
			md.insertItem(c.getText(), pos);
			md.getSWTItem(c.getText()).setMenu((SWTMenu) c);
		}

		c.setParent(this);
	}

	public void remove(VirtualMenuItem c) {
		// getMenu().remove((MenuItem) c.getPhysicalComponent());
		// md.removeItem((MenuItem)c.getPhysicalComponent()); //see usage as
		// above in insert
		// does this reference the physical component before it exists?

		if (c instanceof SWTMenuItem) {
			md.removeItem((SWTMenuItem) c); // will need to be able to add
											// SWTMenuItem c and SWTMenu c here
		} else if (c instanceof SWTMenu) {
			md.removeItem(c.getText());
		}

		c.setParent(null);
	}

	public void add(String s) {
		// getMenu().add(s);
		md.addItem(s);
	}

	public void addSeparator() {
		// getMenu().addSeparator(); //SWT.SEPARATOR attribute in an SWTMenuItem
		md.addItem(SWT.SEPARATOR);
	}

	public void insertSeparator(int pos) {
		// getMenu().insertSeparator(pos);
		md.insertSeparator(pos);
	}

	public int getItemCount() {
		// return getMenu().getItemCount();
		return md.getItemCount();
	}

	public void setMenuToSet(Menu m) {
		/*
		 * if (md.menuToSet!=null) md.setMenuToSet(m); //a menu reference has
		 * been saved to be set later because it doesn't exist yet //when menu
		 * is created from menuToSet, menuToSet must be returned to null else {
		 * //here extract items from menu because menu object already exists
		 * physically
		 * 
		 * }
		 */
		md.setMenuToSet(m);
	}

	public Menu getMenuToSet() {
		return md.getMenuToSet();
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
	public VirtualMenuItem getItem(int pos) {
		return md.getSWTItem(pos);
	}

	public void setToolTipText(String s) {

	}

	public void setFont(Font f) {
		// getMenuBar().setFont(f);
	}

	public Font getFont() {
		return null;
		// return getMenuBar().getFont();
	}

	public static SWTMenu virtualMenu(Menu theMenu) {
		return (SWTMenu) CentralUniversalWidget.universalWidget(theMenu);
	}

	public void enable() {
		// TODO Auto-generated method stub

	}

	public void setActionCommand(String cmd) {
		// TODO Auto-generated method stub

	}

	public void setEnabled(boolean newVal) {
		// TODO Auto-generated method stub

	}

	public void setLabel(String newVal) {
		// TODO Auto-generated method stub
		md.setText(newVal);

	}

	public void addActionListener(VirtualActionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
