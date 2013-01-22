package bus.uigen.widgets;

public interface VirtualTextComponent extends VirtualComponent /* VirtualActionableComponent */{
	public final static String COMMAND_LABEL = "VIRTUALTEXTCOMPONENT:";
	public final static String SET_TEXT_COMMAND = ".setText(";
	public final static String SET_IS_SYNCHRONIZED_TEXT_COMMAND = ".setIsSynchronizedText(";

	public String getText();

	public void setText(String theText);

	public void execSetText(String theText);

	public void addTextListener(Object listener);

	// public void addFocusListener(Object listener);
	// public int getColumns() ;
	// public void setColumns (int theNumber) ;
	// public void postActionEvent();
	public void setDocument(Object d);

	// public void setDocument (PlainDocument d);
	public boolean isEditable();

	public void setEditable(boolean newVal);

	// public void addActionListener(Object listener);

	public boolean getIsSynchronizedText();

	public void setIsSynchronizedText(boolean isSynchronizedText);

	public void execSetIsSynchronizedText(boolean isSynchronizedText);
}
