package bus.uigen.widgets;

//import java.net.URL;

public interface VirtualEditorPane extends VirtualTextComponent {
	public void setPage(Object theURL);

	public Object getPage();

	public void addHyperlinkListener(Object listener);

}
