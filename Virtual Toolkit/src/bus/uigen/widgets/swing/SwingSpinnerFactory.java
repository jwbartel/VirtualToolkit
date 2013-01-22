package bus.uigen.widgets.swing;import javax.swing.JSpinner;import javax.swing.SpinnerModel;import bus.uigen.widgets.SpinnerFactory;import bus.uigen.widgets.VirtualSpinner;public class SwingSpinnerFactory implements SpinnerFactory {	static int id;	public VirtualSpinner createSpinner() {		return createJSpinner();	}	public VirtualSpinner createSpinner(SpinnerModel model) {		return createJSpinner(model);	}	static int getNewID() {		return id++;	}	public static VirtualSpinner createJSpinner() {		JSpinner spinner = new JSpinner();		VirtualSpinner toReturn = SwingSpinner.virtualSpinner(spinner);		toReturn.init();		return toReturn;		// return new Panel();		// return new JPanel();	}	public static VirtualSpinner createJSpinner(SpinnerModel model) {		JSpinner spinner = new JSpinner(model);		VirtualSpinner toReturn = SwingSpinner.virtualSpinner(spinner);		toReturn.init();		return toReturn;		// return new Panel();		// return new JPanel();	}	@Override	public VirtualSpinner createSpinner(Object model) {		// TODO Auto-generated method stub		return null;	}}