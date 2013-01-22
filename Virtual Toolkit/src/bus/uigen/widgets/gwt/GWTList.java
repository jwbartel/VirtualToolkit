package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualList;

import com.google.gwt.user.client.ui.ListBox;

public class GWTList extends GWTContainer implements VirtualList {
	// Only supports list of strings

	public GWTList() {
		super(new ListBox());
	}

	public ListBox getList() {
		return (ListBox) component;
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListSelectionListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionMode(int mode) {
		if (mode == 0)
			getList().setMultipleSelect(false);
		else
			getList().setMultipleSelect(true);
	}

	@Override
	public int getSelectionMode() {
		if (getList().isMultipleSelect())
			return 1;
		else
			return 0;
	}

	@Override
	public void setSelectedIndex(int index) {
		getList().setItemSelected(index, true);
	}

	@Override
	public void setSelectedIndices(int[] indices) {
		for (int i = 0; i < indices.length; i++) {
			getList().setItemSelected(indices[i], true);
		}
	}

	@Override
	public void setSelectedValue(Object anObject, boolean shouldScroll) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionInterval(int anchor, int lead) {
		for (int index = anchor; index <= lead; index++) {
			getList().setItemSelected(index, true);
		}
	}

}
