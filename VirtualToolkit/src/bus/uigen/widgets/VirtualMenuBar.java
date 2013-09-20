package bus.uigen.widgets;

public interface VirtualMenuBar extends VirtualMenuComponent,
		VirtualMenuContainer {
	public void add(VirtualMenu menu);

	public void remove(VirtualMenu menu);

	public UniversalWidget getComponentAtIndex(int i);

	public int getComponentCount();

}
