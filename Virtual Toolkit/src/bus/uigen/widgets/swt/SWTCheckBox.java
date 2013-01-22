package bus.uigen.widgets.swt;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.widgets.Button;

import bus.uigen.widgets.VirtualCheckBox;
import bus.uigen.widgets.events.VirtualActionListener;

public class SWTCheckBox extends SWTComponent implements VirtualCheckBox {

	public SWTCheckBox() {

	}

	public SWTCheckBox(Button theCheckBox) {
		super(theCheckBox);
	}

	public Button getCheckBox() {
		return (Button) component;
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		execAddActionListener(listener);
	}

	protected Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();
	boolean actionListenersCentralized = true;

	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	public void execAddActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	public boolean listenersCentralized() {
		return this.actionListenersCentralized;
	}

	@Override
	public void postEvent(Object event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItemListener(Object l) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSelected() {
		return getCheckBox().getSelection();
	}

	@Override
	public void setSelected(boolean newVal) {
		getCheckBox().setSelection(newVal);
	}

	@Override
	public void setLabel(String newValue) {
		getCheckBox().setText(newValue);
	}

	@Override
	public String getLabel() {
		return getCheckBox().getText();
	}

}
