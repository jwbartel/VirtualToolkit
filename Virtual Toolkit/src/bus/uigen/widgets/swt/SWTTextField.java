package bus.uigen.widgets.swt;

import java.awt.Event;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.text.PlainDocument;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import bus.uigen.widgets.ActionEventForwarder;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualTextComponent;
import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualActionEvent;
import bus.uigen.widgets.events.VirtualActionListener;
import bus.uigen.widgets.events.VirtualActionListenerFactory;
import bus.uigen.widgets.events.VirtualListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTTextField extends SWTComponent implements VirtualTextField {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionListenersCentralized;
	boolean isSynchronizedText = true;

	SWTTextFieldEventForwarder forwarder = new SWTTextFieldEventForwarder(this);

	String text = "";

	// JTextField getTextField();
	/*
	 * public SWTTextField (Text theTextField) { super (theTextField);
	 * //getTextField() = theTextField;
	 * 
	 * }
	 */
	public SWTTextField(String theText) {
		text = theText;
		// getTextField().setText(theText); //object doesn't exist yet
	}

	public SWTTextField() {

	}

	public void setCaretPosition(int newVal) {
		// getTextField().setCaretPosition(newVal);

	}

	public void init() {
		super.init();
		getTextField().addKeyListener(forwarder);
		getTextField().addMouseListener(forwarder);
	}

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public StyledText getTextField() {
		return (StyledText) component;
	}

	public int getColumns() {
		return 0;
		// return getTextField().getColumns();
	}

	public void setColumns(int theNumber) {
		// getTextField().setColumns(theNumber);
	}

	public void postActionEvent() {
		System.out.println("Post Event Not Defined for Text Field");
		// getTextField().postActionEvent();
	}

	// @Override
	public void addToParent(VirtualContainer theParent) {
		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an unitialized parent");
				}
			}
		}

		component = new StyledText(
				(Composite) theParent.getPhysicalComponent(), SWT.SINGLE
						| SWT.BORDER);

		init();
		addAllListeners();
		execSetText(text);
		// getTextField().setBounds(15,10,400,40);
		if ((xLocation != -1) && (yLocation != -1))
			getTextField().setLocation(xLocation, yLocation); // is there a
																// better way to
																// do this than
																// with these
																// flags?
		if ((width != -1) && (height != -1))
			getComponent().setSize(width, height);
		getTextField().setTextLimit(14); // there should be a setTextLimit
											// method too
		CentralUniversalWidget.register(component, this);
		// addExistingChildren();
		// if ((width==-1)||(height==-1)) getComponent().pack(); //if dimensions
		// aren't set, although this isn't default in SWT

	}

	public String getText() {
		if (component == null)
			return text;
		return ((StyledText) component).getText();
	}

	public void setText(String theText) {
		execSetText(theText);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			VirtualToolkit.getUniqueIDByDefault();
			VirtualToolkit
					.sendCommandByDefault(VirtualTextComponent.COMMAND_LABEL
							+ widgetID + VirtualTextComponent.SET_TEXT_COMMAND
							+ theText + ")");
		}
	}

	public void execSetText(String theText) {
		// getTextComponent().setText(theText);
		// text = new Text((Composite) getParent(),SWT.BORDER);
		text = theText;
		if (getTextField() != null) {
			if (getTextField().equals(theText))
				return;
			getTextField().getDisplay().asyncExec(new TextSetter(theText));
		}
		// getTextField().setText(theText);

	}

	class TextSetter implements Runnable {
		String text;

		public TextSetter(String text) {
			this.text = text;
		}

		public void run() {
			String oldText = getTextField().getText();
			int caratPosition = getTextField().getCaretOffset();
			if (caratPosition == oldText.length()) {
				caratPosition = text.length();
			} else if (caratPosition > oldText.length()) {
				caratPosition = oldText.length();
			}

			getTextField().setText(text);
			getTextField().setCaretOffset(caratPosition);
		}

	}

	/*
	 * public void setBounds (int x, int y, int width, int height) { int flags =
	 * 0; //getTextField().setBounds(x, y, width, height, flags); //non-public
	 * getTextField().setBounds(x, y, width, height); }
	 */
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
		System.out.println("Set Document not defined for AWT Text Component");
		// getTextComponent().setDocument(d);
	}

	public void setDocument(Object d) {
		setDocument((PlainDocument) d);
	}

	public void postEvent(Event event) {
		// getTextComponent().postEvent(event);
	}

	public boolean isEditable() {
		// return getTextComponent().isEditable();
		return true;
	}

	public void setEditable(boolean newVal) {
		// getTextComponent().setEditable(newVal);
	}

	public static SWTTextField virtualTextField(StyledText theTextField) {
		return (SWTTextField) SWTComponent.virtualComponent(theTextField);

	}

	public void addAllListeners() {
		super.addAllListeners();

	}

	public void addActionListener(VirtualActionListener listener) {

		execAddActionListener(listener);

		sendActionListener(listener);
	}

	public void addActionListener(VirtualActionListenerFactory listenerFactory) {

		execAddActionListener(listenerFactory.createListener());

		sendActionListener(listenerFactory);
	}

	private void sendActionListener(VirtualListener listener) {

		if (VirtualToolkit.isDistributedByDefault()
				&& !(listener instanceof ActionEventForwarder)) {
			String listenerID = VirtualToolkit.getDefaultVirtualListenerID();
			VirtualToolkit.defaultAssociate(listenerID, listener);
			VirtualToolkit.sendListenerToDefault(listener, listenerID);

			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ VirtualTextField.ADD_ACTION_LISTENER_COMMAND + listenerID
					+ ")";
			// VirtualToolkit.foundPossibleListenerCreator(listener,
			// VirtualToolkit.getNameOnServer());
			VirtualToolkit.sendCommandByDefault(command);
		}

	}

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public void removeActionListener(VirtualActionListener listener) {
		vActionListeners.remove(listener);
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyUpHandler(Object handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus(boolean focus) {
		// TODO Auto-generated method stub

	}

	public void fireVirtualActionEvent(VirtualActionEvent event) {

		Iterator<VirtualActionListener> listeners = getVirtualActionListeners()
				.iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			if (!(listener instanceof ActionEventForwarder)) {
				listener.actionPerformed(event);
			}
		}
	}

	public void centralizeListeners(boolean centralize) {
		centralizeListeners(centralize);
		if (VirtualToolkit.isDistributedByDefault()) {
			String command = VirtualTextField.COMMAND_LABEL + this.getName()
					+ CENTRALIZE_ACTION_COMMAND + centralize + ")";
			VirtualToolkit.sendCommandByDefault(command);
		}
	}

	public void execCentralizeListeners(boolean centralize) {
		this.actionListenersCentralized = centralize;
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
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
