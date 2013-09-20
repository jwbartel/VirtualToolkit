package bus.uigen.widgets.gwt;

import java.util.Hashtable;

import bus.uigen.widgets.MenuBarFactory;
import bus.uigen.widgets.VirtualMenuBar;

import com.google.gwt.user.client.ui.MenuBar;

public class GWTMenuBarFactory implements MenuBarFactory {

	@Override
	public VirtualMenuBar createMenuBar(String text) {
		return createGWTMenuBar(text);
	}

	public static VirtualMenuBar createGWTMenuBar(String text) {
		MenuBar menuBar = new MenuBar();
		return virtualMenuBar(menuBar);
	}

	@Override
	public VirtualMenuBar createMenuBar() {
		return createGWTMenuBar();
	}

	public static GWTMenuBar createGWTMenuBar() {
		MenuBar menuBar = new MenuBar();
		return virtualMenuBar(menuBar);
	}

	static transient Hashtable<MenuBar, GWTMenuBar> MenuBarsToVirtualMenuBars = new Hashtable<MenuBar, GWTMenuBar>();

	public static GWTMenuBar virtualMenuBar(MenuBar theMenuBar) {
		if (theMenuBar == null)
			return null;
		GWTMenuBar vc = MenuBarsToVirtualMenuBars.get(theMenuBar);
		if (vc == null) {
			vc = new GWTMenuBar(theMenuBar);
			MenuBarsToVirtualMenuBars.put(theMenuBar, vc);
		}
		return vc;
	}

}
