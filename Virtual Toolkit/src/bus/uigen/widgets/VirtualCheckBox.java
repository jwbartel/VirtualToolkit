package bus.uigen.widgets;

public interface VirtualCheckBox extends VirtualActionableComponent,
		VirtualComponent {
	/*
	 * public void addChangeListener (ChangeListener l) ; public void
	 * addChangeListener (Object l) ;
	 */
	// public void addItemListener (ItemListener l);
	public void addItemListener(Object l);

	public boolean isSelected();

	public void setSelected(boolean newVal);

	public void setLabel(String newValue);

	public String getLabel();

}
