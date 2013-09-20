package bus.uigen.widgets;

public interface VirtualSlider extends VirtualComponent,
		VirtualActionableComponent {
	// public void addActionListener (Object listener);
	/*
	 * public void setMargin (Object margin); public void setMargin (Insets
	 * margin); public void setActionCommand (String command);
	 */
	public void setValue(int value);

	public int getValue();

	public void setValueIsAdjusting(boolean newVal);

	// public void addChangeListener (ChangeListener l) ;
	public void addChangeListener(Object l);

	// public void setModel(BoundedRangeModel m);
	public void setModel(Object m);

	public void updateUI();

}
