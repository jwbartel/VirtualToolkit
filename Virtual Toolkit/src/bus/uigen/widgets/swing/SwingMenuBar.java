package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import bus.uigen.widgets.UniversalWidget;
import bus.uigen.widgets.VirtualMenu;
import bus.uigen.widgets.VirtualMenuBar;
import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.awt.AWTMenuBar;
import bus.uigen.widgets.universal.CentralUniversalWidget;

//TODO: why does SwingMenuBar extend AUniversalWidget
public class SwingMenuBar extends CentralUniversalWidget implements
		VirtualMenuBar {
	// MenuBar menu;
	public SwingMenuBar(JMenuBar theMenuBar) {
		// super (theMenuBar);
		super(theMenuBar);
		// menu = theMesnuBar;
	}

	public SwingMenuBar() {

	}

	public Component getPhysicalComponent() {
		return (Component) component;

	}

	public JMenuBar getMenuBar() {
		return (JMenuBar) component;
	}

	/*
	 * public void init (Object val) { menu = (MenuBar) val; } public Object
	 * getPhysicalComponent() { return getMenuBar(); }
	 */
	public void add(VirtualMenu c) {
		getMenuBar().add((JMenu) c.getPhysicalComponent());
		c.setParent(this);

	}

	public void remove(VirtualMenu c) {
		getMenuBar().remove((Menu) c.getPhysicalComponent());
		c.setParent(null);
	}

	VirtualMenuContainer parent;

	public void setParent(VirtualMenuContainer theParent) {
		parent = theParent;
	}

	public VirtualMenuContainer getParent() {
		return parent;
		// return (VirtualMenu)
		// AUniversalWidget.universalWidget(menuComponent.getParent());
	}

	public void setToolTipText(String s) {
		if (getMenuBar() instanceof JComponent)
			((JComponent) getMenuBar()).setToolTipText(s);
	}

	public void setFont(Font f) {
		getMenuBar().setFont(f);
	}

	public Font getFont() {
		return getMenuBar().getFont();
	}
	public FontMetrics getFontMetrics(Font f) {
		return getMenuBar().getFontMetrics(f);
	}
	
	public FontMetrics getFontMetrics(Object f) {
		return getMenuBar().getFontMetrics((Font) f);
	}
	
	

	// public VirtualComponent getComponentAtIndex(int i) {
	public UniversalWidget getComponentAtIndex(int i) {

		// return
		// AUniversalWidget.universalWidget(getMenuBar().getComponentAtIndex(i));
		return CentralUniversalWidget.universalWidget(getMenuBar()
				.getComponent(i));
	}

	public int getComponentCount() {
		return getMenuBar().getComponentCount();
	}

	public static AWTMenuBar virtualMenuBar(MenuBar theMenuBar) {
		return (AWTMenuBar) CentralUniversalWidget.universalWidget(theMenuBar);
	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

}
