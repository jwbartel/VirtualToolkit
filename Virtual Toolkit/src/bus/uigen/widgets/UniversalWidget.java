package bus.uigen.widgets;

public interface UniversalWidget {
	public void init(Object c);

	Object getPhysicalComponent();

	public Object getUserObject();

	public void setUserObject(Object newVal);

	public void setToolTipText(String s);

	public void setFont(Object f);

	public Object getFont();
}
