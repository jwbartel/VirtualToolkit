package bus.uigen.widgets.swing;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

import bus.uigen.widgets.VirtualSpinner;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingSpinner extends AWTComponent implements VirtualSpinner {
	// JSpinner getSpinner();
	public SwingSpinner(JSpinner theSpinner) {
		super(theSpinner);
		// getSpinner() = theSpinner;

	}

	public SwingSpinner() {

	}

	public JSpinner getSpinner() {
		return (JSpinner) component;
	}

	/*
	 * public void init (Object[] choices) { Component c = new JSpinner
	 * (choices); super.init(c); } public void setEditable (boolean newVal) {
	 * getSpinner().setEditable(newVal); } public boolean isEditable() { return
	 * getSpinner().isEditable(); } public int getItemCount() { return
	 * getSpinner().getItemCount(); } public void
	 * setLightWeightPopupEnabled(boolean newVal) {
	 * getSpinner().setLightWeightPopupEnabled(newVal); }
	 */
	public void setModel(SpinnerModel newVal) {
		getSpinner().setModel(newVal);
	}

	public void setModel(Object newVal) {
		setModel((SpinnerModel) newVal);
	}

	public void updateUI() {
		getSpinner().updateUI();
	}

	public void commitEdit() {
		try {
			getSpinner().commitEdit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void removeItem(Object item) { getSpinner().removeItem(item); }
	 * public void addItemListener (ItemListener item) {
	 * getSpinner().addItemListener(item); } public void addItemListener (Object
	 * item) { getSpinner().addItemListener((ItemListener)item); } public void
	 * setMaximumRowCount (int num) { getSpinner().setMaximumRowCount(num); }
	 */
	public static VirtualSpinner virtualSpinner(JSpinner theSpinner) {
		return (VirtualSpinner) AWTComponent.virtualComponent(theSpinner);

	}

	public Object getValue() {
		return getSpinner().getValue();
	}

	public Object getPreviousValue() {
		return getSpinner().getPreviousValue();
	}

	public Object getNextValue() {
		return getSpinner().getNextValue();
	}

	public void setValue(Object choice) {
		getSpinner().setValue(choice);
	}

}
