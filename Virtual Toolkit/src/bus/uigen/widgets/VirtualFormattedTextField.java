package bus.uigen.widgets;

public interface VirtualFormattedTextField extends VirtualTextField {
	public Object getValue();

	public void setValue(Object value);

	Object getFormatter();

	Object getFormatterFactory();

	void setFormatterFactory(Object tf);

}
