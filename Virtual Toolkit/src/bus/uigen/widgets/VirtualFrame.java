package bus.uigen.widgets;

public interface VirtualFrame extends VirtualComponent /* VirtualContainer */{
	public static final String COMMAND_LABEL = "VIRTUALFRAME:";

	public VirtualContainer getContentPane();

	public void add(VirtualComponent c);

	public void setContentPane(VirtualContainer container);

	public void setResizable(boolean newVal);

	public void addWindowListener(Object newVal);

	public void setTitle(String label);

	public String getTitle();

	public void dispose();

	public VirtualMenuBar getMenuBar();

	public void setMenuBar(VirtualMenuBar newVal);

	public void pack();

	public void addComponentListener(Object cl);

	// public void setDefaultCloseOperation();
	public void setDefaultCloseOperation(int arg);

	public void add(VirtualPopupMenu menu);

	public void setLayout(Object l);

	public void setLayout(VirtualLayout l);

	public void asyncExec(Runnable runnable);

	public void syncExec(Runnable runnable);

	public void open();

}
