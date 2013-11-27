package bus.uigen.widgets.gwt;

import java.util.Iterator;
import java.util.Vector;

import bus.uigen.widgets.VirtualComboBox;
import bus.uigen.widgets.events.VirtualActionListener;

import com.google.gwt.user.client.ui.*;

public class GWTComboBox extends GWTComponent implements VirtualComboBox {

	Vector<String> comboChoices = new Vector<String>(0);
	int selectedItem = 0;
	boolean readOnly = false;

	public GWTComboBox() {
		super(new ListBox());
	}

	public GWTComboBox(Object[] choices) {
		super(new ListBox());
		init(choices);
	}

	@SuppressWarnings("rawtypes")
	public GWTComboBox(Vector choices) {
		super(new ListBox());
		init(choices);
	}

	public void init() {
		super.init();
	}

	public void init(Object[] choices) {
		for (int i = 0; i < choices.length; i++) {
			comboChoices.add(String.valueOf(choices[i]));
		}
		updateUI();
	}

	@SuppressWarnings("rawtypes")
	public void init(Vector choices) {
		Iterator iter = choices.iterator();
		while (iter.hasNext()) {
			comboChoices.add(String.valueOf(iter.next()));
		}
		updateUI();
	}

	public ListBox getComboBox() {
		return (ListBox) component;
	}

	public Object getSelectedItem() {
		return getComboBox().getValue(selectedItem);
	}

	public void setSelectedItem(Object choice) {
		ListBox currentComboBox = getComboBox();
		for(int i=0; i<currentComboBox.getItemCount();i++){
			if(String.valueOf(choice).equals(currentComboBox.getItemText(i))){
				currentComboBox.setSelectedIndex(i);
				break; 
			}
		}
	}

	public void addItem(Object choice) {
		comboChoices.add(String.valueOf(choice));
		updateUI();
	}

	public int getItemCount() {
		return getComboBox().getItemCount();
	}

	public void setEditable(boolean newVal) {
		readOnly = !newVal;
	}

	public boolean isEditable() {
		return !readOnly;
	}

	public void setLightWeightPopupEnabled(boolean newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void removeItem(Object item) {
		comboChoices.remove(item);
		updateUI();
	}

	@Override
	public void addItemListener(Object item) {
		// TODO Auto-generated method stub

	}

	public void setMaximumRowCount(int num) {
		getComboBox().setVisibleItemCount(num);
	}

	@Override
	public void setRenderer(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getRenderer() {
		// TODO Auto-generated method stub
		return null;
	}


	public void updateUI() {
		Iterator<String> iter = comboChoices.iterator();
		while (iter.hasNext()) {
			getComboBox().addItem(iter.next());
		}
	}

}
