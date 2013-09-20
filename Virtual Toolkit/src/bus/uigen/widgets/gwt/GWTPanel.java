package bus.uigen.widgets.gwt;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;

public class GWTPanel extends GWTContainer {

	public GWTPanel() {
		super(new FlowPanel());
	}

	public FlowPanel getPanel() {
		return (FlowPanel) component;
	}

	public void addStyleName(String style) {
		getPanel().addStyleName(style);
	}

	public void add(Widget w) {
		getPanel().add(w);
	}

	public void setHorizontalAlignment(
			HasHorizontalAlignment.HorizontalAlignmentConstant v) {
	}

}
