package bus.uigen.widgets;

public interface MenuFactory {
	public VirtualMenu createMenu(String text);

	// public VirtualMenu createMenu (Object icon);
	public VirtualMenu createMenu();
}
