package bus.uigen.widgets.gwt;

import bus.uigen.widgets.PanelFactory;
import bus.uigen.widgets.VirtualContainer;

public class GWTPanelFactory implements PanelFactory {

	public VirtualContainer createPanel() {
		return new GWTPanel();
	}

}
