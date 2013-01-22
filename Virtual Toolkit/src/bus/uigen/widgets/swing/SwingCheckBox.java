package bus.uigen.widgets.swing;

import java.awt.Component;
import java.awt.Event;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;

import bus.uigen.widgets.VirtualCheckBox;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SwingCheckBox extends SwingComponent implements VirtualCheckBox {
	// JCheckBox getJCheckBox();
	public SwingCheckBox(JCheckBox theCheckBox) {
		super(theCheckBox);
		getJCheckBox().addActionListener(new SwingCheckBoxEventForwarder(this));

		// getJCheckBox() = theCheckBox;

	}

	public SwingCheckBox() {

	}

	public void init(Component c) {
		super.init(c);
		getJCheckBox().addActionListener(new SwingCheckBoxEventForwarder(this));
	}

	public JCheckBox getJCheckBox() {
		return (JCheckBox) component;
	}

	public boolean isSelected() {
		return getJCheckBox().isSelected();
	}

	public void setSelected(boolean newVal) {
		getJCheckBox().setSelected(newVal);
	}

	public void addChangeListener(ChangeListener l) {
		getJCheckBox().addChangeListener(l);
	}

	public void addChangeListener(Object l) {
		addChangeListener((ChangeListener) l);
		// getJCheckBox().addChangeListener(l);
	}

	public void postEvent(Event event) {
		getJCheckBox().postEvent(event);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	// public void addActionListener (Object theListener) {
	// addActionListener((ActionListener) theListener);
	// }
	public void addItemListener(ItemListener theListener) {
		getJCheckBox().addItemListener(theListener);
		// addActionListener(theListener);

	}

	@SuppressWarnings("deprecation")
	public void setLabel(String newValue) {
		getJCheckBox().setLabel(newValue);
	}

	@SuppressWarnings("deprecation")
	public String getLabel() {
		return getJCheckBox().getLabel();

	}

	public void addItemListener(Object theListener) {
		getJCheckBox().addItemListener((ItemListener) theListener);
	}

	public static SwingCheckBox virtualCheckBox(JCheckBox theCheckBox) {
		return (SwingCheckBox) AWTComponent.virtualComponent(theCheckBox);

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

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

}
