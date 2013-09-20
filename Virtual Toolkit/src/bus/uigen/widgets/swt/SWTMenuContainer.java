package bus.uigen.widgets.swt;

import java.awt.MenuContainer;

import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public abstract class SWTMenuContainer implements VirtualMenuContainer {
	MenuContainer menuItem;

	public SWTMenuContainer(MenuContainer theMenuContainer) {
		// super (theMenuContainer);
		menuItem = theMenuContainer;
	}

	public SWTMenuContainer() {

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

	public static SWTMenuContainer virtualMenuContainer(
			MenuContainer theMenuContainer) {
		return (SWTMenuContainer) CentralUniversalWidget
				.universalWidget(theMenuContainer);
	}

}
