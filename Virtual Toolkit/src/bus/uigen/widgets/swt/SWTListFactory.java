package bus.uigen.widgets.swt;

import bus.uigen.widgets.ListFactory;
import bus.uigen.widgets.VirtualList;

public class SWTListFactory implements ListFactory {

	@Override
	public VirtualList createList() {
		SWTList toReturn = new SWTList();
//		toReturn.init();
		return toReturn;
	}

	@Override
	public VirtualList createList(Object listModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
