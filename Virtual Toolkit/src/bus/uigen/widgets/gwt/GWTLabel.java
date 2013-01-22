package bus.uigen.widgets.gwt;

import bus.uigen.widgets.VirtualLabel;

import com.google.gwt.user.client.ui.Label;

public class GWTLabel extends GWTComponent implements VirtualLabel {

	public GWTLabel() {
		component = new Label();
	}

	public GWTLabel(String text) {
		component = new Label(text);
	}

	public Label getLabel() {
		return (Label) component;
	}

	public String getText() {
		return getLabel().getText();
	}

	public void setText(String text) {
		getLabel().setText(text);
	}

	@Override
	public void setIcon(Object icon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHorizontalAlignment(int x) {
		// TODO Auto-generated method stub
		System.out.println("Alignment cannot be set for Button");
	}

	@Override
	public void setVerticalAlignment(int alignment) {
		// TODO Auto-generated method stub
		System.out.println("Alignment cannot be set for Button");
	}

}