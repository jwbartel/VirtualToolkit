package bus.uigen.widgets;

public interface MenuBarFactory {
	public VirtualMenuBar createMenuBar(String text);

	// public VirtualMenu createMenu (Object icon);
	public VirtualMenuBar createMenuBar();
}
