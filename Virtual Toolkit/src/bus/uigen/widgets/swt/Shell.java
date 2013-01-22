package bus.uigen.widgets.swt;

import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class Shell extends Decorations {
	VirtualContainer shell;

	public Shell(Display display) {
		shell = ((VirtualFrame) (CentralUniversalWidget
				.existingUniversalWidget(display.frame.getPhysicalComponent())))
				.getContentPane();
		shell.setParent((VirtualContainer) (display.frame)); // is this legal?
	}

	public void pack() {
		shell.pack();
	}

	public void open() {
		// ((VirtualFrame)
		// AUniversalWidget.existingUniversalWidget(d.frame.getPhysicalComponent())).setVisible(true);
		((VirtualFrame) CentralUniversalWidget.existingUniversalWidget(shell
				.getParent().getPhysicalComponent())).setVisible(true);
		// VirtualToolkit.start((VirtualFrame)
		// AUniversalWidget.existingUniversalWidget(d.frame.getPhysicalComponent()));
		VirtualToolkit toolkit = new SWTToolkit();
		toolkit.start((VirtualFrame) CentralUniversalWidget
				.existingUniversalWidget(shell.getParent()
						.getPhysicalComponent()));
	}

	public void setSize(int width, int height) {
		// ((VirtualContainer) (shell.getPhysicalComponent())).setSize(width,
		// height);
		shell.setSize(width, height);
	}
}
