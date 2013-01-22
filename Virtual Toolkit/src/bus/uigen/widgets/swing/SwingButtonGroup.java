package bus.uigen.widgets.swing;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualButtonGroup;

public class SwingButtonGroup implements VirtualButtonGroup {
	ButtonGroup buttonGroup;

	public SwingButtonGroup(ButtonGroup theButtonGroup) {
		buttonGroup = theButtonGroup;
		// ButtonGroup = theButtonGroup;

	}

	public SwingButtonGroup() {

	}

	public void add(VirtualButton b) {
		buttonGroup.add((AbstractButton) b.getPhysicalComponent());
	}

	public Object getSelection() {
		return buttonGroup.getSelection();
	}

	public String getSelectionActionCommand() {
		return buttonGroup.getSelection().getActionCommand();
	}

	@SuppressWarnings("unchecked")
	public Enumeration getElements() {
		return buttonGroup.getElements();
	}

	static transient Hashtable<ButtonGroup, SwingButtonGroup> ButtonGroupsToVirtualButtonGroups = new Hashtable<ButtonGroup, SwingButtonGroup>();

	public static SwingButtonGroup virtualButtonGroup(ButtonGroup theButtonGroup) {
		if (theButtonGroup == null)
			return null;
		SwingButtonGroup vc = ButtonGroupsToVirtualButtonGroups
				.get(theButtonGroup);
		if (vc == null) {

			vc = new SwingButtonGroup(theButtonGroup);
			ButtonGroupsToVirtualButtonGroups.put(theButtonGroup, vc);
		}
		return vc;

	}

}
