package bus.uigen.widgets.swing;

import javax.swing.JFrame;

import bus.uigen.widgets.FrameFactory;
import bus.uigen.widgets.VirtualFrame;

public class SwingFrameFactory implements FrameFactory {
	protected JFrame createJFrame() {
		return new JFrame();
	}
	protected JFrame createJFrame(String aTitle) {
		return new JFrame(aTitle);
	}
	public VirtualFrame createFrame() {
//		JFrame frame = new JFrame();
		JFrame frame = createJFrame();
		// panel.setBackground(Color.white);
		VirtualFrame toReturn = SwingFrame.virtualFrame(frame);
//		toReturn.init();
		return toReturn;
		// return new Panel();
	}

	public VirtualFrame createFrame(String title) {
//		JFrame frame = new JFrame(title);
		JFrame frame = createJFrame(title);

		// panel.setBackground(Color.white);
		VirtualFrame toReturn = SwingFrame.virtualFrame(frame);
//		toReturn.init();
		return toReturn;
		// return new Panel();
	}

}
