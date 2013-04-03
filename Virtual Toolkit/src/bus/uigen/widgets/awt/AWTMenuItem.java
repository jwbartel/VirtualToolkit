package bus.uigen.widgets.awt;

import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.MenuItem;
import java.util.HashSet;
import java.util.Set;

import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class AWTMenuItem extends AWTMenuComponent implements VirtualMenuItem {
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
	@Override
	public void init() {
		super.init();
		getMenuItem().addActionListener(new AWTMenuItemEventForwarder(this));
	}

	// MenuItem menuItem;
	public AWTMenuItem(MenuItem theMenuItem) {
		super(theMenuItem);
		init();
//		getMenuItem().addActionListener(new AWTMenuItemEventForwarder(this));
//		// menuItem = theMenuItem;
	}

	public AWTMenuItem() {
//		init();
//		getMenuItem().addActionListener(new AWTMenuItemEventForwarder(this));

	}

	public MenuItem getMenuItem() {
		return (MenuItem) component;
	}

	public void setEnabled(boolean newVal) {
		getMenuItem().setEnabled(newVal);
	}

	public void enable() {
		setEnabled(true);
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getMenuItem().postEvent(event);
	}

	public void setLabel(String newVal) {
		getMenuItem().setLabel(newVal);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	public void setActionCommand(String cmd) {
		getMenuItem().setActionCommand(cmd);
	}

	// public void addActionListener (ActionListener theListener) {
	// getMenuItem().addActionListener(theListener);
	//
	// }
	public void setToolTipText(String s) {

	}

	public void setFont(Font f) {
		getMenuItem().setFont(f);
	}

	public Font getFont() {
		return getMenuItem().getFont();
	}
	public FontMetrics getFontMetrics(Font f) {
		return null;
	}
	
	public FontMetrics getFontMetrics(Object f) {
		return null;
	}

	public static AWTMenuItem virtualMenuItem(MenuItem theMenuItem) {
		return (AWTMenuItem) CentralUniversalWidget
				.universalWidget(theMenuItem);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
