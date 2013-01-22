package bus.uigen.widgets.swing;

import bus.uigen.widgets.Painter;
import bus.uigen.widgets.VirtualDelegatePanel;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingDelegatePanel extends SwingComponent implements
		VirtualDelegatePanel {

	public SwingDelegatePanel(DelegateJPanel thePanel) {
		super(thePanel);
		// getScrollPane() = theScrollPane;

	}

	public SwingDelegatePanel() {

	}

	public void addPainter(Painter painter) {
		getDelegatePanel().addPainter(painter);

	}

	public void removePainter(Painter painter) {
		getDelegatePanel().removePainter(painter);

	}

	public DelegateJPanel getDelegatePanel() {
		// return
		// AnAWTComponent.virtualComponent(getScrollPane().getComponent(3));
		return (DelegateJPanel) getPhysicalComponent();

	}

	public static SwingDelegatePanel virtualDelegatePanel(
			DelegateJPanel thePanel) {
		SwingDelegatePanel retVal = (SwingDelegatePanel) AWTComponent
				.virtualComponent(thePanel);
		// retVal.setjpanel(jpanel);
		return retVal;
	}

}
