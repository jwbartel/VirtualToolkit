package bus.uigen.widgets.swing;

import javax.swing.JTextArea;

import bus.uigen.widgets.VirtualTextArea;
import bus.uigen.widgets.awt.AWTComponent;

public class SwingTextArea extends SwingTextComponent implements
		VirtualTextArea {
	public SwingTextArea(JTextArea textArea) {
		init(textArea);
	}

	public SwingTextArea() {
	}

	public JTextArea getJTextArea() {
		return (JTextArea) getComponent();
	}

	public static SwingTextArea virtualTextArea(JTextArea theTextArea) {
		return (SwingTextArea) AWTComponent.virtualComponent(theTextArea);

	}

	public void setWrapStyleWord(boolean word) {
		getJTextArea().setWrapStyleWord(word);

	}

	public void setLineWrap(boolean wrap) {
		getJTextArea().setLineWrap(wrap);

	}

	public boolean getLineWrap() {
		return getJTextArea().getLineWrap();

	}

	public boolean getWrapStyleWord() {
		return getJTextArea().getWrapStyleWord();
	}

	@Override
	public int getColumns() {
		return getJTextArea().getColumns();

	}

	@Override
	public void setColumns(int theNumber) {
		getJTextArea().setColumns(theNumber);

	}

}
