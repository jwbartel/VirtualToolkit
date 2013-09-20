package bus.uigen.widgets;

public interface VirtualProgressBar extends VirtualComponent,
		VirtualActionableComponent {
	// public void addActionListener (Object listener);
	/*
	 * public void setMargin (Object margin); public void setMargin (Insets
	 * margin); public void setActionCommand (String command);
	 */
	public void setValue(int value);

	public int getValue();

	public double getPercentComplete();

	public void setMaximum(int newValue);

	public int getMaximum();

	public void setMinimum(int newValue);

	public int getMinimum();

	// public void addChangeListener (ChangeListener l) ;
	public void addChangeListener(Object l);

	public void setModel(Object m);

	// public void setModel(BoundedRangeModel m);
	public void updateUI();

	public void setIndeterminate(boolean newValue);

	public void setString(String newVal);

	public void setStringPainted(boolean newVal);

}
