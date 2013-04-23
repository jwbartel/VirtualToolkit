package bus.uigen.widgets.swing;

import java.awt.Event;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import bus.uigen.widgets.VirtualSlider;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.events.VirtualActionListener;

public class SwingSlider extends AWTComponent implements VirtualSlider {
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

	// JSlider slider;
	public SwingSlider(JSlider theSlider) {
		super(theSlider);
		// getSlider().addActionListener(new SwingSliderEventForwarder(this));

		// slider = theSlider;

	}

	public JSlider getSlider() {
		return (JSlider) component;
	}

	public SwingSlider() {

	}

	public void setValue(int value) {
		getSlider().setValue(value);
	}

	public int getValue() {
		return getSlider().getValue();
	}

	public void setValueIsAdjusting(boolean newVal) {
		getSlider().setValueIsAdjusting(newVal);
	}

	public void addChangeListener(ChangeListener l) {
		getSlider().addChangeListener(l);
	}

	public void addChangeListener(Object l) {
		addChangeListener((ChangeListener) l);
		// getSlider().addChangeListener(l);
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getSlider().postEvent(event);
	}

	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);

	}

	public void addActionListener(Object theListener) {
		System.out.println("Action listener not allowed on slider");
		// addActionListener((ActionListener) theListener);
	}

	public void setModel(BoundedRangeModel m) {
		getSlider().setModel(m);
	}

	public void updateUI() {
		getSlider().updateUI();
	}

	public static SwingSlider virtualSlider(JSlider theSlider) {
		return (SwingSlider) AWTComponent.virtualComponent(theSlider);

	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object m) {
		setModel((BoundedRangeModel) m);

	}

}
