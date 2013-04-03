package bus.uigen.widgets.gwt;

import java.awt.Component;
import java.awt.FontMetrics;

import bus.uigen.widgets.UniversalWidget;
import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

public class GWTMenuBar extends CentralUniversalWidget implements
		VirtualMenuBar {

	public GWTMenuBar(MenuBar theMenuBar) {
		super(theMenuBar);
	}

	public GWTMenuBar() {
		super(new MenuBar());
	}

	public MenuBar getMenuBar() {
		return (MenuBar) component;
	}

	VirtualMenuContainer parent;

	@Override
	public VirtualMenuContainer getParent() {
		return parent;
	}

	@Override
	public void setParent(VirtualMenuContainer theParent) {
		parent = theParent;
	}

	public Component getPhysicalComponent() {
		return (Component) component;
	}

	@Override
	public void setToolTipText(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getFont() {
		// TODO Auto-generated method stub
		return null;
	}
	public FontMetrics getFontMetrics(Object f) {
		return null;
	}

	@Override
	public void add(VirtualMenu c) {
		getMenuBar().addItem((MenuItem) c.getPhysicalComponent());
		c.setParent(this);
	}

	@Override
	public void remove(VirtualMenu c) {
		getMenuBar().removeItem((MenuItem) c.getPhysicalComponent());
		c.setParent(null);
	}

	@Override
	public UniversalWidget getComponentAtIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComponentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
