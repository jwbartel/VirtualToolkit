package bus.uigen.widgets.swing;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import bus.uigen.widgets.VirtualDesktopPane;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingDesktopPane extends SwingComponent implements
		VirtualDesktopPane {
	// JDesktopPane getDesktopPane();
	public SwingDesktopPane(JDesktopPane theDesktopPane) {
		super(theDesktopPane);
		// getDesktopPane() = theDesktopPane;

	}

	public SwingDesktopPane() {

	}

	public JDesktopPane getDesktopPane() {
		return (JDesktopPane) component;
	}

	public VirtualFrame[] getAllFrames() {
		JInternalFrame[] physicalFrames = getDesktopPane().getAllFrames();
		VirtualFrame[] frames = new VirtualFrame[physicalFrames.length];
		for (int i = 0; i < physicalFrames.length; i++) {
			frames[i] = SwingInternalFrame.virtualFrame(physicalFrames[i]);
		}
		return frames;
	}

	public static SwingDesktopPane virtualDesktopPane(
			JDesktopPane theDesktopPane) {
		return (SwingDesktopPane) AWTComponent.virtualComponent(theDesktopPane);
	}

}
