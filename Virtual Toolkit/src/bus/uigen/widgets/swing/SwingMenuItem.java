package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JMenuItem;

import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SwingMenuItem extends CentralUniversalWidget implements
		VirtualMenuItem {
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

	// MenuItem menuItem;
	public SwingMenuItem(JMenuItem theMenuItem) {
		super(theMenuItem);
		getMenuItem().addActionListener(new SwingMenuItemEventForwarder(this));

		// menuItem = theMenuItem;
	}

	public SwingMenuItem() {
		// super (new JMenuItem());
		// getMenuItem().addActionListener(new
		// SwingMenuItemEventForwarder(this));

	}

	public void init(Object theComponent) {
		super.init(theComponent);
		getMenuItem().addActionListener(new SwingMenuItemEventForwarder(this));

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

	public JMenuItem getMenuItem() {
		return (JMenuItem) component;
	}

	public void setEnabled(boolean newVal) {
		getMenuItem().setEnabled(newVal);
	}

	public void enable() {
		setEnabled(true);
	}

	public void postEvent(Event event) {
		getMenuItem().postEvent(event);
	}

	public void setLabel(String newVal) {
		getMenuItem().setLabel(newVal);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	public void setToolTipText(String s) {
		if (getMenuItem() instanceof JComponent)
			((JComponent) getMenuItem()).setToolTipText(s);
	}

	public void setFont(Font f) {
		getMenuItem().setFont(f);
	}

	public Font getFont() {
		return getMenuItem().getFont();
	}

	public void setActionCommand(String cmd) {
		getMenuItem().setActionCommand(cmd);
	}

	public void addActionListener(ActionListener theListener) {
		getMenuItem().addActionListener(theListener);

	}

	public static SwingMenuItem virtualMenuItem(JMenuItem theMenuItem) {
		return (SwingMenuItem) CentralUniversalWidget
				.universalWidget(theMenuItem);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFont(Object f) {
		getMenuItem().setFont((Font) f);
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
