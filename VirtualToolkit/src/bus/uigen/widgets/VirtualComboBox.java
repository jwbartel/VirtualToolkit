package bus.uigen.widgets;


public interface VirtualComboBox extends VirtualComponent {
	public void init(Object[] choices);

	public Object getSelectedItem();

	public void setSelectedItem(Object choice);

	public void addItem(Object choice);

	public int getItemCount();

	public void setEditable(boolean newVal);

	public boolean isEditable();

	public void setLightWeightPopupEnabled(boolean newVal);

	// public void setModel(ComboBoxModel newVal);
	public void setModel(Object newVal);

	public void updateUI();

	public void removeItem(Object item);

	// public void addItemListener (ItemListener item) ;
	public void addItemListener(Object item);

	public void setMaximumRowCount(int num);

	void setRenderer(Object newVal);

	Object getRenderer();

}
