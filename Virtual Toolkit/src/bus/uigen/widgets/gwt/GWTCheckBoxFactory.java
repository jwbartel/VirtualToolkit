package bus.uigen.widgets.gwt;

import bus.uigen.widgets.CheckBoxFactory;
import bus.uigen.widgets.VirtualCheckBox;

public class GWTCheckBoxFactory implements CheckBoxFactory {

	@Override
	public VirtualCheckBox createCheckBox() {
		VirtualCheckBox toReturn = new GWTCheckBox();
		toReturn.init();
		return toReturn;
	}

}
