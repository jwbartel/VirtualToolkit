package bus.uigen.widgets.awt;import java.awt.Frame;import bus.uigen.widgets.FrameFactory;import bus.uigen.widgets.VirtualFrame;public class AWTFrameFactory implements FrameFactory {	public VirtualFrame createFrame() {		Frame frame = new Frame();		// panel.setBackground(Color.white);		return AWTFrame.virtualFrame(frame);		// return new Panel();	}	public VirtualFrame createFrame(String title) {		Frame frame = new Frame(title);		// panel.setBackground(Color.white);		VirtualFrame toReturn = AWTFrame.virtualFrame(frame);		toReturn.init();		return toReturn;		// return new Panel();	}}