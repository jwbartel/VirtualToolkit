package bus.uigen.widgets.swing;

import java.awt.Event;

import javax.swing.JTextField;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTComponent;

public abstract class SwingTextComponent extends AWTComponent {
	// JTextField getTextField();
	boolean isSynchronizedText = true;

	public SwingTextComponent(JTextComponent theTextComponent) {
		super(theTextComponent);
		// getTextField() = theTextField;

	}

	public SwingTextComponent() {

	}

	public JTextComponent getTextComponent() {
		return (JTextComponent) component;
	}

	public String getText() {
		return getTextComponent().getText();
	}

	public void setText(String theText) {
		execSetText(theText);
		// System.out.println("Set the text:\""+theText+"\"");
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			// String uniqueID = VirtualToolkit.getUniqueIDByDefault();
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ theText + ")");
		}
	}

	public void setCaretPosition(int newVal) {
		getTextComponent().setCaretPosition(newVal);

	}
	
	public Object getCaret() {
		return getTextComponent().getCaret();
	}
	
	public void setCaret(Object aCaret) {
		getTextComponent().setCaret((Caret) aCaret);
		
	}

	public void execSetText(String theText) {
		Caret caret = getTextComponent().getCaret();
		int caretPosition = caret.getMark();
		if (caretPosition == getTextComponent().getText().length()) {
			caretPosition++;
		}
		getTextComponent().setText(theText);
		caret.setDot(caretPosition);
	}

	public void addTextListener(Object listener) {

	}

	/*
	 * public void addFocusListener(Object listener) {
	 * getTextField().addFocusListener((FocusListener) listener);
	 * 
	 * }
	 */
	/*
	 * public void addActionListener(Object listener) {
	 * addActionListener((ActionListener) listener);
	 * 
	 * }
	 */

	public void setDocument(PlainDocument d) {
		getTextComponent().setDocument(d);
	}

	public void setDocument(Object d) {
		setDocument((PlainDocument) d);
	}

	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getTextComponent().postEvent(event);
	}

	public boolean isEditable() {
		return getTextComponent().isEditable();
	}

	public void setEditable(boolean newVal) {
		getTextComponent().setEditable(newVal);
	}

	public static SwingTextField virtualTextField(JTextField theTextField) {
		return (SwingTextField) AWTComponent.virtualComponent(theTextField);

	}

	public boolean getIsSynchronizedText() {
		return isSynchronizedText;
	}

	public void setIsSynchronizedText(boolean isSynchronizedText) {
		execSetIsSynchronizedText(isSynchronizedText);

		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualTextComponent.COMMAND_LABEL
					+ this.getName()
					+ VirtualTextComponent.SET_IS_SYNCHRONIZED_TEXT_COMMAND
					+ isSynchronizedText + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}

	}

	public void execSetIsSynchronizedText(boolean isSynchronizedText) {
		this.isSynchronizedText = isSynchronizedText;
	}

}
