package bus.uigen.widgets.gwt;

import java.util.ArrayList;
import java.util.Enumeration;

import bus.uigen.widgets.VirtualButton;
import bus.uigen.widgets.VirtualButtonGroup;

public class GWTButtonGroup implements VirtualButtonGroup {
	static int groupID = 1;
	String groupName;
	ArrayList<GWTRadioButton> buttons = new ArrayList<GWTRadioButton>();

	public GWTButtonGroup() {
		groupName = "ButtonGroup" + groupID;
		groupID++;
	}

	@Override
	public void add(VirtualButton b) {
		((GWTRadioButton) b.getPhysicalComponent()).getElement().setAttribute(
				"name", groupName);
		buttons.add((GWTRadioButton) b);
	}

	public Object getSelection() {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isSelected())
				return buttons.get(i);
		}
		return null;
	}

	@Override
	public String getSelectionActionCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration<Object> getElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
