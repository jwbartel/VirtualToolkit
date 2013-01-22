package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.VirtualPopupMenu;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;
//import java.awt.PopupMenu;
//import javax.swing.JButton;
//import bus.uigen.widgets.VirtualMenuComponent;
//import bus.uigen.widgets.awt.AWTComponent;

public class SwingPopupMenu extends CentralUniversalWidget implements
		VirtualPopupMenu {
	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean centralizeActionListeners = false;

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public boolean listenersCentralized() {
		return this.centralizeActionListeners;
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public JPopupMenu getJPopupMenu() {
		return (JPopupMenu) getWidget();

	}

	public SwingPopupMenu() {
		// getJPopupMenu().addActionListener(new
		// SwingPopupMenuEventForwarder(this));

	}

	public SwingPopupMenu(JPopupMenu theMenu) {
		component = theMenu;
		// getMenuItem().addActionListener(new AWTMenuItemEventForwarder(this));

	}

	public void show(VirtualComponent invoker, int x, int y) {
		getJPopupMenu().show((Component) invoker.getPhysicalComponent(), x, y);
	}

	public void add(VirtualMenuItem menuItem) {

		getJPopupMenu().add((JMenuItem) menuItem.getPhysicalComponent());
	}

	public void add(String s) {
		if (s.equals("-"))
			addSeparator();
		else
			getJPopupMenu().add(s);
	}

	public Component getPhysicalComponent() {
		return (Component) component;

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

	public void addSeparator() {
		getJPopupMenu().addSeparator();
	}

	public void insert(VirtualMenuItem c, int pos) {
		getJPopupMenu().insert((JMenuItem) c.getPhysicalComponent(), pos);
		c.setParent(this);
	}

	public void remove(VirtualMenuItem c) {
		getJPopupMenu().remove((JMenuItem) c.getPhysicalComponent());
		c.setParent(null);
	}

	public void setEnabled(boolean newVal) {
		getJPopupMenu().setEnabled(newVal);
	}

	public void enable() {
		setEnabled(true);
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getJPopupMenu().postEvent(event);
	}

	public void setLabel(String newVal) {
		getJPopupMenu().setLabel(newVal);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	public void setToolTipText(String s) {
		if (getJPopupMenu() instanceof JComponent)
			((JComponent) getJPopupMenu()).setToolTipText(s);
	}

	public void setActionCommand(String cmd) {
		// getJPopupMenu().setActionCommand(cmd);
	}

	public void addActionListener(ActionListener theListener) {
		// getJPopupMenu().addActionListener(theListener);

	}

	public static SwingMenuItem virtualMenuItem(JMenuItem theMenuItem) {
		return (SwingMenuItem) CentralUniversalWidget
				.universalWidget(theMenuItem);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFont(Font f) {
		// getMenuBar().setFont(f);
	}

	public Font getFont() {
		return null;
		// return getMenuBar().getFont();
	}

	public void insertSeparator(int pos) {
		// getJPopupMenu().insertSeparator(pos);
	}

	public int getItemCount() {
		return getJPopupMenu().getSubElements().length;
	}

	public VirtualMenuItem getItem(int pos) {
		return SwingMenuItem.virtualMenuItem((JMenuItem) getJPopupMenu()
				.getComponent(pos));
	}

	public static SwingPopupMenu virtualPopupMenu(JPopupMenu theMenu) {
		return (SwingPopupMenu) CentralUniversalWidget.universalWidget(theMenu);

	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
