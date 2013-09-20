package bus.uigen.widgets.swt;

import bus.uigen.widgets.PanelFactory;
import bus.uigen.widgets.VirtualContainer;

public class SWTPanelFactory implements PanelFactory {
	public VirtualContainer createPanel() {
		// Container panel = new Panel();
		// panel.setBackground(Color.white);
		return new SWTPanel();
		// return new Panel();
	}

}
