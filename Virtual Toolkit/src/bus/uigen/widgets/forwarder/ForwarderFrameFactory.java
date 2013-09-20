/**
 * Creates ForwarderFrame objects for use within VirtualToolkit.
 * 
 * @author Roger Que
 */
package bus.uigen.widgets.forwarder;

import bus.uigen.widgets.FrameFactory;
import bus.uigen.widgets.VirtualFrame;

public class ForwarderFrameFactory implements FrameFactory {
	/**
	 * Create a ForwarderFrame.
	 */
	@Override
	public VirtualFrame createFrame() {
		return new ForwarderFrame();
	}

	/**
	 * Create a ForwarderFrame with the given title.
	 */
	@Override
	public VirtualFrame createFrame(String title) {
		ForwarderFrame f = new ForwarderFrame(title);
		// f.setTitle(title);

		// XXX: Why does this constructor (and AWTFrame's, and others) call
		// init(), when the argument-less one does not?
		// f.init();

		return f;
	}
}
