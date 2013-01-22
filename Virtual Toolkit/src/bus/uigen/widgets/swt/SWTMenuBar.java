package bus.uigen.widgets.swt;

//import java.awt.Event;
//import java.awt.Menu;
import java.awt.Font;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.universal.CentralUniversalWidget;
//import java.awt.MenuBar;
//import java.awt.event.ActionListener;
//import bus.uigen.widgets.VirtualMenuItem;
//import bus.uigen.widgets.swt.SWTMenu.MenuData;

public class SWTMenuBar extends SWTMenuComponent implements VirtualMenuBar {
	// Menu menu;
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
		// boolean isEnabled = true;
		Menu menuToSet;

		// MenuBar menuBarToSet; //deprecated
		MenuData() { // constructor?
			items = new Vector<SWTMenuItem>(0);
			// text = new String();
		}

		MenuData(String t) {
			items = new Vector<SWTMenuItem>(0);
			text = new String(t); // is this appropriate? as below
		}

		String getText() { // is this appropriate? Menus don't have text fields
							// in SWT
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
		 * SWTMenuItem(mi); items.addElement(m); } void insertItem(MenuItem mi,
		 * int pos) { //is this ever used? SWTMenuItem m = new SWTMenuItem(mi);
		 * items.insertElementAt(m, pos); }
		 */
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
		 * void removeItem(MenuItem mi) { //is this ever used? for (int
		 * i=0;i<items.size();i++) { if
		 * (items.get(i).getMenuItem().equals(mi)==true) { //will this work to
		 * compare two MenuItems? items.remove(i); break; } } }
		 */
		SWTMenuItem getItem(int pos) {
			return items.get(pos);
		}

		SWTMenuItem getItem(String text) {
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
									// referencing the physical parent
		}

		Menu getMenuToSet() {
			return menuToSet;
		}
		/*
		 * void setMenu(MenuBar theMenuBar) { //deprecated menuBarToSet =
		 * theMenuBar; }
		 */
	}

	public SWTMenuBar(Menu theMenuBar) { // is this necessary to have in SWT?
		// super (theMenuBar);
		// super (theMenuBar); //will this be problematic?
		md = new MenuData();
		md.setMenuToSet(theMenuBar);
		// menu = theMenuBar;
	}

	public SWTMenuBar() {
		md = new MenuData();
	}

	public SWTMenuBar(String text) {
		md = new MenuData(text);
	}

	public Menu create(Shell shell) {
		// physically define components here
		Menu menu;
		if (getMenuToSet() != null) {
			menu = getMenuToSet();
		} else {
			menu = new Menu(shell, SWT.BAR);
			// System.out.println("MenuBar has "+md.getItemCount()+" items");
			for (int i = 0; i < md.getItemCount(); i++) {
				MenuItem item = md.getItem(i).create(menu);
				item.setText(md.getItem(i).getText());

			}
		}
		return menu;
	}

	/*
	 * public MenuBar getMenuBar() { //deprecated return (MenuBar) component; }
	 */
	public Menu getMenu() {
		return (Menu) component;
	}

	/*
	 * public void init (Object val) { menu = (MenuBar) val; } public Object
	 * getPhysicalComponent() { return getMenuBar(); }
	 */
	public void add(VirtualMenu c) {

		// getMenuBar().add((Menu) c.getPhysicalComponent());
		// String text = new String(((MenuItem) component).getText()); //is this
		// ok? no, component probably doesn't exist yet
		String text = new String(c.getText()); // had to add getText() to
												// VirtualMenu.java for this to
												// work
		md.addItem(text);
		// md.getItem(text).addMenu((Menu) c.getPhysicalComponent());
		// //component probably doesn't exist yet
		// must be fixed, need to add the items of the VirtualMenu c
		// md.getItem(text).mid.addMenu((Menu) c.getPhysicalComponent()); //this
		// is approximately the path to emulate with methods
		// creates a new menu in mid
		// don't return the component! return the component.method()
		// md.getItem(text).setMenu(text); //this doesn't set the whole menu,
		// just the text label
		md.getItem(text).setMenu((SWTMenu) c);
		/*
		 * for (int i=0;i<c.getItemCount();i++) {
		 * //md.getItem(text).getSWTMenu().setMenu(((Menu)
		 * c.getPhysicalComponent()).getItem(i)); //TODO fix }
		 */
		c.setParent(this); // what does this do?

	}

	/*
	 * public void add (VirtualMenuItem c) { //this functionality doesn't exist
	 * in swing/awt //String text = new String(((MenuItem) c).getText()); //this
	 * is the current compile blocker. error at TestSWT,73 //...how do we
	 * extract the string from this VMenuItem before it exists? //it is actually
	 * an SWTMenuItem //String text = new String
	 * ("Str generated in SWTMenu.add()"); String text = new
	 * String(((SWTMenuItem) c).getText()); //error at TestSWT,74
	 * md.addItem(text); md.getItem(text).setMenu(text); //leave out nested
	 * menus (menus in menuitems in a menu) for now
	 * //md.getItem(text).getSWTMenu().setMenu(((MenuItem)
	 * c.getPhysicalComponent()).getMenu()); //TODO fix c.setParent(this);
	 * 
	 * }
	 */
	public void remove(VirtualMenu c) {
		// getMenuBar().remove((Menu) c.getPhysicalComponent());
		// md.removeItem(getMenuBar().getName()); //what would this have done in
		// the first place?
		md.removeItem(c.getText());
		c.setParent(null);
	}

	public VirtualComponent getComponentAtIndex(int i) {
		return null;
	}

	public void setToolTipText(String s) {

	}

	public int getComponentCount() {
		return getMenu().getItemCount();
	}

	public void setFont(Font f) {
		// getMenuBar().setFont(f);
	}

	public Font getFont() {
		return null;
		// return getMenuBar().getFont();
	}

	public static SWTMenuBar virtualMenuBar(Menu theMenuBar) {
		return (SWTMenuBar) CentralUniversalWidget.universalWidget(theMenuBar);
	}

	public void setMenuToSet(Menu m) {
		/*
		 * if (md.menuToSet!=null) md.setMenuToSet(m); else { //TODO what goes
		 * here again? //here extract items from menu because menu object
		 * already exists physically //TODO how do i do this here? }
		 */
		md.setMenuToSet(m);
	}

	public Menu getMenuToSet() {
		return md.getMenuToSet();
	}
	/*
	 * public void setMenuBar(MenuBar mb) { //deprecated if
	 * (md.menuBarToSet!=null) md.setMenu(mb); else { //here extract items from
	 * menubar because menubar object already exists physically } }
	 */

}
