package bus.uigen.widgets.swt;

//import org.eclipse.swt.widgets.Composite;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class Button extends Control {
	VirtualButton button;

	public Button(Composite parent, int style) { // parent is actually a
													// Composite--will
													// VContainer work instead?
		// Shell shellparent = (Shell) parent;

		// VirtualFrame frame = FrameSelector.createFrame(); //but these won't
		// be the same frame/panel we want
		// VirtualContainer panel = PanelSelector.createPanel();

		// use the HashTable to find the reference between parent and the
		// VirtualContainer panel we want to use

		// frame.setVisible(true); //we need the reference to frame in here,
		// don't we?
		button = ButtonSelector.createButton("Test Button Text");
		((VirtualContainer) (CentralUniversalWidget
				.existingUniversalWidget(parent.component
						.getPhysicalComponent()))).add(button);
		// ((VirtualContainer)
		// (AUniversalWidget.existingUniversalWidget((shellparent).shell))).add(button);
		// this only works if the frame has actually been registered, which
		// requires a Shell.java delegator
	}

	public void setBounds(int x, int y, int width, int height) {
		button.getParent().remove(button);
		button.setBounds(x, y, width, height);
		button.addToParent(button.getParent()); // will i have to do this for
												// every method?
		// why doesn't the component remain malleable after it's added?
	}

	public void setText(String text) {
		button.getParent().remove(button);
		button.setText(text);
		button.addToParent(button.getParent()); // maybe just emulate effects
												// found in addToParent()
	}

	public void pack() {
		button.pack();
	}
}
