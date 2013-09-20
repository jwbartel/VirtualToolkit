package bus.uigen.widgets.gwt;

import bus.uigen.widgets.LabelFactory;
import bus.uigen.widgets.VirtualLabel;

public class GWTLabelFactory implements LabelFactory {

	public VirtualLabel createLabel() {
		VirtualLabel toReturn = new GWTLabel();
//		toReturn.init();
		return toReturn;
	}

	public VirtualLabel createLabel(String text) {
		VirtualLabel toReturn = new GWTLabel(text);
//		toReturn.init();
		return toReturn;
	}

	@Override
	public VirtualLabel createLabel(Object icon) {
		VirtualLabel toReturn = new GWTLabel();
//		toReturn.init();
		return toReturn;
	}

}