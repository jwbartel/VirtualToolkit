package bus.uigen.widgets.awt;

import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;

import bus.uigen.widgets.UniversalWidget;
import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class AWTMenuBar extends AWTMenuComponent implements VirtualMenuBar {
	// MenuBar menu;
	public AWTMenuBar(MenuBar theMenuBar) {
		// super (theMenuBar);
		super(theMenuBar);
		// menu = theMesnuBar;
	}

	public AWTMenuBar() {

	}

	public MenuBar getMenuBar() {
		return (MenuBar) component;
	}

	/*
	 * public void init (Object val) { menu = (MenuBar) val; } public Object
	 * getPhysicalComponent() { return getMenuBar(); }
	 */
	public void add(VirtualMenu c) {
		getMenuBar().add((Menu) c.getPhysicalComponent());
		c.setParent(this);

	}

	public void remove(VirtualMenu c) {
		getMenuBar().remove((Menu) c.getPhysicalComponent());
		c.setParent(null);
	}

	public UniversalWidget getComponentAtIndex(int i) {

		// return
		// AUniversalWidget.universalWidget(getMenuBar().getComponentAtIndex(i));
		return CentralUniversalWidget.universalWidget(getMenuBar().getMenu(i));
	}

	public void setToolTipText(String s) {

	}

	public void setFont(Font f) {

	}

	public Font getFont() {
		return null;
	}

	public int getComponentCount() {
		return getMenuBar().getMenuCount();
	}

	public static AWTMenuBar virtualMenuBar(MenuBar theMenuBar) {
		return (AWTMenuBar) CentralUniversalWidget.universalWidget(theMenuBar);
	}

}
