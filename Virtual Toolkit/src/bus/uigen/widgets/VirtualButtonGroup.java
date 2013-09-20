package bus.uigen.widgets;

import java.util.Enumeration;

public interface VirtualButtonGroup {
	public void add(VirtualButton b);

	// Object getSelection();
	String getSelectionActionCommand();

	Enumeration<Object> getElements();

}
