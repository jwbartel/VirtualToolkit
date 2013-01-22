package bus.uigen.widgets.gwt;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.VirtualMenuItem;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

import com.google.gwt.user.client.ui.MenuItem;

public class GWTMenuItem extends CentralUniversalWidget implements
		VirtualMenuItem {

	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	Vector<VirtualMouseMoveListener> vMouseMoveListeners = new Vector<VirtualMouseMoveListener>();
	boolean actionListenersCentralized = false;

	public GWTMenuItem(GWTMenuItem theMenuItem) {
		super(theMenuItem);
	}

	public GWTMenuItem(String text) {
		setLabel(text);
	}

	public MenuItem getMenuItem() {
		return (MenuItem) component;
	}

	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		vMouseMoveListeners.add(listener);
	}

	public Vector<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
		return vMouseMoveListeners;
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
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

	@Override
	public Object getPhysicalComponent() {
		return (Object) component;
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

	@Override
	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);
	}

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}

	@Override
	public void setEnabled(boolean newVal) {
		getMenuItem().setEnabled(newVal);
	}

	@Override
	public void enable() {
		setEnabled(true);
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLabel(String newVal) {
		getMenuItem().setText(newVal);
	}

	@Override
	public void setActionCommand(String cmd) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getText() {
		return getMenuItem().getText();
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

	public static GWTMenuItem virtualMenuItem(MenuItem theMenuItem) {
		return (GWTMenuItem) CentralUniversalWidget
				.universalWidget(theMenuItem);
	}

}
