package bus.uigen.widgets.awt;

import java.awt.Component;
import java.awt.PopupMenu;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.universal.CentralUniversalWidget;
//import javax.swing.JPopupMenu;
//import bus.uigen.widgets.swing.SwingPopupMenu;

public class AWTPopupMenu extends AWTMenu implements VirtualPopupMenu {
	public PopupMenu getPopupMenu() {
		return (PopupMenu) getMenu();

	}

	public void show(VirtualComponent invoker, int x, int y) {
		getPopupMenu().show((Component) invoker.getPhysicalComponent(), x, y);
	}

	public static AWTPopupMenu virtualPopupMenu(PopupMenu theMenu) {
		return (AWTPopupMenu) CentralUniversalWidget.universalWidget(theMenu);

	}

}
