package bus.uigen.widgets.gwt;

import bus.uigen.widgets.ListFactory;
import bus.uigen.widgets.VirtualList;

public class GWTListFactory implements ListFactory {

	@Override
	public VirtualList createList() {
		GWTList toReturn = new GWTList();
		toReturn.init();
		return toReturn;
	}

	@Override
	public VirtualList createList(Object listModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
