package bus.uigen.widgets.swt;

import java.awt.Event;
import java.awt.Font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTMenuItem extends SWTMenuComponent implements VirtualMenuItem {
	// MenuItem menuItem;
	// MenuItemData mid = new MenuItemData();
	MenuItemData mid;

	static class MenuItemData { // could this be static?
		String text;
		SWTMenu menu; // perhaps this is what needs to be duplicable instead of
						// the whole class?
		// MenuItem itemToAdd; //i think this is deprecated after
		// SWTMenuItem(MenuItem) was deprecated
		int style = SWT.CASCADE;

		MenuItemData() {
			text = new String();
		}

		MenuItemData(String t) {
			text = new String(t);
		}

		void setText(String t) {
			text = new String(t);
		}

		String getText() {
			return text;
		}

		void setMenu() {
			menu = new SWTMenu();
		}

		void setMenu(String t) {
			menu = new SWTMenu();
			menu.setLabel(t);
			// equivalent to menu = new SWTMenu(t);
		}

		void setMenu(Menu m) {
			menu = new SWTMenu(m);
		}

		void setMenu(SWTMenu m) {
			menu = m;
		}

		/*
		 * void setItem(MenuItem mi) { //deprecated itemToAdd = mi; }
		 */
		/*
		 * void addMenu() { menu = new SWTMenu(); } void addMenu(String t) {
		 * menu = new SWTMenu(t); } void addMenu(Menu m) { menu = new
		 * SWTMenu(m); } void addMenu(MenuItem mi) { //this might not make sense
		 * in SWT text = mi.getText(); menu = new SWTMenu(mi.getMenu()); //*if*
		 * there is a menu, otherwise this should do nothing //mi.getStyle() //?
		 * }
		 */
		SWTMenu getMenu() {
			// right now this only returns the single menu, taking no arguments
			return menu; // this should return null if menu is not initialized
		}

		/*
		 * MenuItem getItemToAdd() { return itemToAdd; }
		 */
		void setStyle(int s) {
			style = s;
		}

		int getStyle() {
			return style;
		}
	}

	public SWTMenuItem() {
		mid = new MenuItemData();
	}

	public SWTMenuItem(String t) {
		mid = new MenuItemData(t);
	}

	public SWTMenuItem(int style) {
		mid = new MenuItemData();
		mid.setStyle(style);
	}

	/*
	 * public SWTMenuItem (MenuItem theMenuItem) { //is this ever used? //super
	 * (theMenuItem); mid = new MenuItemData(); mid.setItem(theMenuItem);
	 * mid.setText(theMenuItem.getText()); mid.setMenu(theMenuItem.getMenu());
	 * //hopefully this sets mid.menu to null if theMenuItem doesn't have a menu
	 * (null) //must be fixed //menuItem = theMenuItem; }
	 */
	public MenuItem create(Menu menu) {
		// physically define components here
		MenuItem menuItem;
		/*
		 * if (getItemToAdd()!=null) { //TODO how come this is never referenced?
		 * is getItemToAdd ever set to non-null? apparently not menuItem =
		 * getItemToAdd(); //is this valid? presumably the item would by now
		 * have been created physically //menuItem.setText(getItem().getText());
		 * //why would this be necessary? shouldn't the item have its own text
		 * set? //menuItem.setText(getText());
		 * System.out.println("Text in question is "+getText()); //do we need to
		 * call relevant create() functions here now? or is all recursion
		 * handled within other create() methods }
		 */
		// else {
		menuItem = new MenuItem(menu, getStyle());
		menuItem.setText(getText());
		// }

		// if the item contains a menu, here would be the place to reference
		// that menu's create() method
		if (getSWTMenu() != null) { // why is this not null for Edit, Help?
									// because they are menus with 0 items, not
									// items with no menu
			// System.out.println("trying to create '"+getText()+"' menu in SWTMenuItem.create()");
			menuItem.setMenu(getSWTMenu().create(menu)); // created menu is
															// added to parent
															// of menuItem
			// in non-virtual code, equivalent to Menu m = new Menu(menu,..);
			// menuItem.setMenu(m);
		}
		return menuItem;
	}

	public void setText(String t) {
		mid.setText(t);
	}

	public String getText() {
		return mid.getText();
	}

	public void setMenu(Menu m) { // TODO is this never called?
		mid.setMenu(m);
	}

	public void setMenu(String t) {
		mid.setMenu(t);
	}

	/*
	 * public void setMenu(MenuItem mi) { //deprecated: remove this eventually
	 * //mid.setMenu(mi);
	 * System.out.println("Deprecated method: setMenu(MenuItem), no action taken"
	 * ); }
	 */
	public void setMenu(SWTMenu swtM) {
		mid.setMenu(swtM);
	}

	public SWTMenu getSWTMenu() {
		return mid.getMenu();
	}

	/*
	 * public MenuItem getItemToAdd() { return mid.getItemToAdd(); }
	 */
	public void setStyle(int s) {
		mid.setStyle(s);
	}

	public int getStyle() {
		return mid.getStyle();
	}

	public MenuItem getMenuItem() {
		return (MenuItem) component; // physical component
	}

	public void setEnabled(boolean newVal) {
		getMenuItem().setEnabled(newVal); // is this valid in SWT as it is?
	}

	public void enable() {
		setEnabled(true);
	}

	public void postEvent(Event event) {
		// getMenuItem().postEvent(event);
	}

	public void setLabel(String newVal) { // only one of (setLabel,setText)
											// should exist
		// getMenuItem().setLabel(newVal);
		setText(newVal);
		System.out.println("Called SWTMenuItem.setLabel(String)");
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

	public void setActionCommand(String cmd) {
		// getMenuItem().setActionCommand(cmd);
	}

	public void addActionListener(VirtualActionListener theListener) {
		// getMenuItem().addActionListener(theListener);

	}

	/*
	 * public static SWTMenuItem virtualMenuItem (MenuItem theMenuItem) { return
	 * (SWTMenuItem) AUniversalWidget.universalWidget(theMenuItem); }
	 */
	public static VirtualMenuItem virtualMenuItem(SWTMenuItem theMenuItem) {
		return (VirtualMenuItem) CentralUniversalWidget
				.universalWidget(theMenuItem);
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
