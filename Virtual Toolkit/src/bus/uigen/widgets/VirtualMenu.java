package bus.uigen.widgets;

public interface VirtualMenu extends VirtualMenuContainer, VirtualMenuItem {
	public void add(VirtualMenuItem c);

	public void insert(VirtualMenuItem c, int pos);

	public void add(String s);

	public void remove(VirtualMenuItem c);

	public void addSeparator();

	public void insertSeparator(int pos);

	public int getItemCount();

	public VirtualMenuItem getItem(int pos);
}
