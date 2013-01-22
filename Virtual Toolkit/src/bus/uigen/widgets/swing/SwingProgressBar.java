package bus.uigen.widgets.swing;

import java.awt.Event;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

import bus.uigen.widgets.VirtualProgressBar;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SwingProgressBar extends AWTComponent implements
		VirtualProgressBar {
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

	// JProgressBar slider;
	public SwingProgressBar(JProgressBar theProgressBar) {
		super(theProgressBar);
		// slider = theProgressBar;

	}

	public JProgressBar getProgressBar() {
		return (JProgressBar) component;
	}

	public SwingProgressBar() {

	}

	public void setValue(int value) {
		getProgressBar().setValue(value);
	}

	public int getValue() {
		return getProgressBar().getValue();
	}

	public void addChangeListener(ChangeListener l) {
		getProgressBar().addChangeListener(l);
	}

	public void addChangeListener(Object l) {
		addChangeListener((ChangeListener) l);
		// getProgressBar().addChangeListener(l);
	}

	public void postEvent(Event event) {
		getProgressBar().postEvent(event);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	public void addActionListener(Object theListener) {
		System.out.println("Action listener not allowed on slider");
		// addActionListener((ActionListener) theListener);
	}

	public void setModel(BoundedRangeModel m) {
		getProgressBar().setModel(m);
	}

	public void updateUI() {
		getProgressBar().updateUI();
	}

	public void setIndeterminate(boolean newValue) {
		getProgressBar().setIndeterminate(newValue);
	}

	public void setString(String newVal) {
		getProgressBar().setString(newVal);
	}

	public void setMaximum(int newVal) {
		getProgressBar().setMaximum(newVal);
	}

	public int getMaximum() {
		return getProgressBar().getMaximum();
	}

	public void setMinimum(int newVal) {
		getProgressBar().setMinimum(newVal);
	}

	public int getMinimum() {
		return getProgressBar().getMinimum();
	}

	public double getPercentComplete() {
		return getProgressBar().getPercentComplete();
	}

	public void setStringPainted(boolean newVal) {
		getProgressBar().setStringPainted(newVal);
	}

	public static SwingProgressBar virtualProgressBar(
			JProgressBar theProgressBar) {
		return (SwingProgressBar) AWTComponent.virtualComponent(theProgressBar);

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object m) {
		// TODO Auto-generated method stub

	}

}
