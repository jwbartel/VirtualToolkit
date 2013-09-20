package bus.uigen.widgets;

public interface VirtualLabel extends VirtualComponent {
	public String getText();

	public void setText(String text);

	public void setIcon(Object icon);

	// public void setIcon (Icon icon);
	public void setVerticalAlignment(int alignment);

	public void setHorizontalAlignment(int x);

}
