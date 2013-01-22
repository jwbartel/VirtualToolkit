package bus.uigen.widgets;

public interface VirtualTextArea extends VirtualTextComponent {
	public void setWrapStyleWord(boolean word);

	public void setLineWrap(boolean wrap);

	public boolean getLineWrap();

	public boolean getWrapStyleWord();

	public int getColumns();

	public void setColumns(int theNumber);

}
