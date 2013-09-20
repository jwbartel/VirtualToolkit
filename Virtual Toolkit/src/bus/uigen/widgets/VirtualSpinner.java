package bus.uigen.widgets;

public interface VirtualSpinner extends VirtualComponent {
	// public void init (Object[] choices);
	public Object getValue();

	public void setValue(Object choice);

	public Object getNextValue();

	public Object getPreviousValue();

	public void commitEdit();

	/*
	 * public void addItem (Object choice); public int getItemCount();
	 * 
	 * public void setEditable (boolean newVal); public boolean isEditable();
	 * 
	 * 
	 * public void setLightWeightPopupEnabled(boolean newVal);
	 */
	// public void setModel(SpinnerModel newVal);
	public void setModel(Object newVal);

	public void updateUI();
	/*
	 * public void removeItem(Object item) ;
	 * 
	 * public void addItemListener (ItemListener item) ; public void
	 * addItemListener (Object item) ; public void setMaximumRowCount (int num)
	 * ;
	 */
}
