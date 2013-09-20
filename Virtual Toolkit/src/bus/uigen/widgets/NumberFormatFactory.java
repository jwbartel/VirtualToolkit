package bus.uigen.widgets;

public interface NumberFormatFactory {

	public VirtualNumberFormat createNumberFormat();

	public VirtualNumberFormat createNumberFormat(String pattern);
}
