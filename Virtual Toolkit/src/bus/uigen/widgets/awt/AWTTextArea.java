package bus.uigen.widgets.awt;

//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Event;
//import java.awt.Insets;
//import java.awt.LayoutManager;
import java.awt.TextArea;

import bus.uigen.widgets.VirtualTextArea;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusListener;
//import java.util.Hashtable;
//import javax.swing.Icon;
//import javax.swing.JTextArea;
//import javax.swing.JLabel;
//import javax.swing.text.PlainDocument;
//import bus.uigen.widgets.swing.SwingTextArea;

public class AWTTextArea extends AWTTextComponent implements VirtualTextArea {
	public AWTTextArea(TextArea textArea) {
		init(textArea);
	}

	public AWTTextArea() {
	}

	public static AWTTextArea virtualTextArea(TextArea theTextArea) {
		return (AWTTextArea) AWTComponent.virtualComponent(theTextArea);

	}

	public TextArea getTextArea() {
		return (TextArea) getComponent();
	}

	public void setWrapStyleWord(boolean word) {
		// getTextArea().setWrapStyleWord(word);

	}

	public void setLineWrap(boolean wrap) {
		// getTextArea().setLineWrap(wrap);

	}

	public boolean getLineWrap() {
		return false;
		// return getTextArea().getLineWrap();

	}

	public boolean getWrapStyleWord() {
		return false;
		// return getTextArea().getWrapStyleWord();
	}

	@Override
	public int getColumns() {
		return getTextArea().getColumns();

	}

	@Override
	public void setColumns(int theNumber) {
		getTextArea().setColumns(theNumber);

	}

}
