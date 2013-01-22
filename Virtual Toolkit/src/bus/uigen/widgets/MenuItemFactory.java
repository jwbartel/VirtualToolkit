package bus.uigen.widgets;

public interface MenuItemFactory {
	public VirtualMenuItem createMenuItem(String text);

	// public VirtualMenuItem createMenuItem (Object icon);
	public VirtualMenuItem createMenuItem();
}
