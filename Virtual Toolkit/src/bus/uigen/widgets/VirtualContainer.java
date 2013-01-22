package bus.uigen.widgets;

public interface VirtualContainer extends VirtualComponent {
	public static final String COMMAND_LABEL = "VIRTUALCONTAINER:";
	public static final String ADD_COMMAND = ".add(";
	public static final String SET_LAYOUT_COMMAND = ".setLayout(";

	public void add(VirtualComponent c);

	public void execAdd(VirtualComponent c);

	public void add(VirtualComponent c, int pos);

	public void add(VirtualComponent c, Object constraint, int pos);

	public void add(VirtualComponent c, Object constraint);

	public void add(VirtualComponent c, String direction);

	public void remove(VirtualComponent c);

	public void remove(int pos);

	public void removeAll();

	public VirtualComponent getComponent(int pos);

	int getComponentCount();

	int countComponents();

	public Object getLayout();

	public void setLayout(Object layoutManager);

	// public void setLayout (LayoutManager layoutManager);
	public VirtualComponent[] getComponents();

	public void pack(); // for SWT shells

	public void setLayout(VirtualLayout l);

	public void execSetLayout(VirtualLayout l);

	public void layout();

	public void requestFocus();

}
