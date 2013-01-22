package bus.uigen.widgets.swt;

import org.eclipse.swt.layout.FillLayout;

import bus.uigen.widgets.VirtualFlowLayout;

public class SWTFlowLayout extends SWTLayout implements VirtualFlowLayout {
	public SWTFlowLayout() {
		component = new FillLayout();
	}

	public SWTFlowLayout(FillLayout layout) {
		super(layout);
	}

	public FillLayout getFillLayout() {
		return (FillLayout) getLayout();
	}

	public void setType(int type) {
		getFillLayout().type = type;
	}

	public int getType() {
		return getFillLayout().type;
	}
}