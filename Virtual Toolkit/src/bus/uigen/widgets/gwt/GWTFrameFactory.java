package bus.uigen.widgets.gwt;

import bus.uigen.widgets.FrameFactory;
import bus.uigen.widgets.VirtualFrame;

public class GWTFrameFactory implements FrameFactory {

	public VirtualFrame createFrame() {
		VirtualFrame toReturn = new GWTFrame();
		toReturn.init();
		return toReturn;
	}

	public VirtualFrame createFrame(String id) {
		VirtualFrame toReturn = new GWTFrame(id);
		toReturn.init();
		return toReturn;
	}

}