package bus.uigen.widgets.awt;

import java.awt.MenuContainer;

import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public abstract class AWTMenuContainer implements VirtualMenuContainer {
	MenuContainer menuItem;

	public AWTMenuContainer(MenuContainer theMenuContainer) {
		// super (theMenuContainer);
		menuItem = theMenuContainer;
	}

	public AWTMenuContainer() {

	}

	public MenuContainer getMenuContainer() {
		return (MenuContainer) menuItem;
	}

	public void init(Object val) {
		menuItem = (MenuContainer) val;
	}

	/*
	 * public void setEnabled (boolean newVal) {
	 * getMenuContainer().setEnabled(newVal); } public void enable () {
	 * setEnabled(true); } public void postEvent(Event event) {
	 * getMenuContainer().postEvent(event); } public void setLabel (String
	 * newVal) { getMenuContainer().setLabel(newVal); } public void
	 * addActionListener (Object theListener) {
	 * addActionListener((ActionListener) theListener);
	 * 
	 * } public void addActionListener (ActionListener theListener) {
	 * getMenuContainer().addActionListener(theListener);
	 * 
	 * }
	 */

	public static AWTMenuContainer virtualMenuContainer(
			MenuContainer theMenuContainer) {
		return (AWTMenuContainer) CentralUniversalWidget
				.universalWidget(theMenuContainer);
	}

}
