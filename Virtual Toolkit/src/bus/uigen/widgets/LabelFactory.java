package bus.uigen.widgets;

public interface LabelFactory {
	public VirtualLabel createLabel();

	public VirtualLabel createLabel(String text);

	public VirtualLabel createLabel(Object icon);

}
