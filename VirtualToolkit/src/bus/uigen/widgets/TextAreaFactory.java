package bus.uigen.widgets;

public interface TextAreaFactory {
	public VirtualTextArea createTextArea();

	public VirtualTextArea createTextArea(String text);

	public VirtualTextArea createTextArea(String text, int rows, int cols);
}
