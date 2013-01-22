package bus.uigen.widgets.swt;

import org.eclipse.swt.widgets.List;

import bus.uigen.widgets.VirtualList;

public class SWTList extends SWTContainer implements VirtualList {
	// Only supports list of strings

	public List getList() {
		return (List) component;
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
		// Selection mode must be specified in constructor of List

	}

	@Override
	public int getSelectionMode() {
		// TODO Auto-generated method stub
		return 0;
		// getList().getStyle();
	}

	@Override
	public void setSelectedIndex(int index) {
		getList().setSelection(index);
	}

	@Override
	public void setSelectedIndices(int[] indices) {
		getList().setSelection(indices);
	}

	@Override
	public void setSelectedValue(Object anObject, boolean shouldScroll) {
		if (anObject instanceof String) {
			int i;
			for (i = 0; i < getList().getItemCount(); i++) {
				if (getList().getItem(i) == anObject) {
					getList().setSelection(i);
					if (shouldScroll)
						getList().setTopIndex(i);
				}
			}
			if (i == getList().getItemCount())
				System.out.println("'" + (String) anObject
						+ "' not in SWT list");
		} else
			System.out.println("SWT List only supports strings.");
	}

	@Override
	public void setSelectionInterval(int anchor, int lead) {
		getList().select(anchor, lead);
	}

}
