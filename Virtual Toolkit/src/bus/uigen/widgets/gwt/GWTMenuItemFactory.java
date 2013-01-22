package bus.uigen.widgets.gwt;

import bus.uigen.widgets.MenuItemFactory;
import bus.uigen.widgets.VirtualMenuItem;

import com.google.gwt.user.client.ui.MenuItem;

public class GWTMenuItemFactory implements MenuItemFactory {

	@Override
	public VirtualMenuItem createMenuItem(String text) {
		return null;
		// return createGWTMenuItem(text);
	}

	@Override
	public VirtualMenuItem createMenuItem() {
		// return null;
		return createGWTMenuItem();
	}

	public static GWTMenuItem createGWTMenuItem(String text) {
		return new GWTMenuItem(text);

		/*
		 * MenuItem menuItem = new MenuItem(text); return
		 * GWTMenuItem.virtualMenuItem(menuItem);
		 */
	}

	public static GWTMenuItem createGWTMenuItem() {
		MenuItem menuItem = new MenuItem(null);
		return GWTMenuItem.virtualMenuItem(menuItem);
	}

}
