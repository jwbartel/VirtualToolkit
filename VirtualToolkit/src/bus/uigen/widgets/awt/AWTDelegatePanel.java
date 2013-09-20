package bus.uigen.widgets.awt;

import bus.uigen.widgets.Painter;
import bus.uigen.widgets.VirtualDelegatePanel;

public class AWTDelegatePanel extends AWTContainer implements
		VirtualDelegatePanel {

	public AWTDelegatePanel(DelegatePanel thePanel) {
		super(thePanel);
		// getScrollPane() = theScrollPane;

	}

	public AWTDelegatePanel() {

	}

	public void addPainter(Painter painter) {
		getDelegatePanel().addPainter(painter);

	}

	public void removePainter(Painter painter) {
		getDelegatePanel().removePainter(painter);

	}

	public DelegatePanel getDelegatePanel() {
		// return
		// AnAWTComponent.virtualComponent(getScrollPane().getComponent(3));
		return (DelegatePanel) getPhysicalComponent();

	}

	public static AWTDelegatePanel virtualDelegatePanel(DelegatePanel thePanel) {
		AWTDelegatePanel retVal = (AWTDelegatePanel) AWTComponent
				.virtualComponent(thePanel);
		// retVal.setjpanel(jpanel);
		return retVal;
	}

}
