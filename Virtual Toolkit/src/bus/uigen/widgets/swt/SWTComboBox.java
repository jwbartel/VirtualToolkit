package bus.uigen.widgets.swt;

import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import bus.uigen.widgets.VirtualComboBox;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTComboBox extends SWTComponent implements VirtualComboBox {
	// JComboBox getComboBox();
	Vector<String> comboChoices = new Vector<String>(0);
	boolean readOnly = false;
	int selectionIndex = 0;

	public SWTComboBox(Combo theComboBox) {
		super(theComboBox);
		// getComboBox() = theComboBox;

	}

	public SWTComboBox(Object[] choices) {

	}

	public SWTComboBox(Vector choices) {

	}

	public SWTComboBox() {

	}

	public Combo getComboBox() {
		return (Combo) component;
	}

	public void init() {
		super.init();
	}

	public void init(Object[] choices) {
		// Component c = new Combo (choices);
		for (int i = 0; i < choices.length; i++) {
			comboChoices.addElement(String.valueOf(choices[i]));
		}
		// super.init(c); //no component is initialized here, only in
		// addToParent
	}

	public void setEditable(boolean newVal) {
		readOnly = !newVal;
	}

	public boolean isEditable() {
		return !readOnly;
	}

	public int getItemCount() {
		return getComboBox().getItemCount();
	}

	public void setLightWeightPopupEnabled(boolean newVal) {
		// getComboBox().setLightWeightPopupEnabled(newVal);
	}

	public void setModel(ComboBoxModel newVal) {
		// getComboBox().setModel(newVal);
	}

	public void setModel(Object newVal) {
		// setModel((ComboBoxModel) newVal);
	}

	public void updateUI() {
		// getComboBox().updateUI();
	}

	public void removeItem(Object item) {
		getComboBox().remove(String.valueOf(item));
		comboChoices.removeElement((String.valueOf(item)));
	}

	public void addItemListener(ItemListener item) {
		// getComboBox().addItemListener(item);
	}

	public void addItemListener(Object item) {
		// getComboBox().addItemListener((ItemListener)item);
	}

	public void setMaximumRowCount(int num) {
		getComboBox().setVisibleItemCount(num);
	}

	public static VirtualComboBox virtualComboBox(Combo theComboBox) {
		return (VirtualComboBox) SWTComponent.virtualComponent(theComboBox);

	}

	public Object getSelectedItem() {
		return getComboBox().getItem(selectionIndex);
	}

	public void setSelectedItem(Object choice) {
		// getComboBox().setSelectedItem(choice);
		for (int i = 0; i < comboChoices.size(); i++) {
			if (comboChoices.get(i).equals(String.valueOf(choice))) {
				selectionIndex = i;
				break;
			}
		}
	}

	public void addItem(Object choice) {
		// getComboBox().add(String.valueOf(choice));
		comboChoices.add(String.valueOf(choice));
	}

	// @Override
	public void addToParent(VirtualContainer theParent) {
		// TODO Auto-generated method stub

		if (theParent == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		} else {
			if (!(theParent instanceof SWTContainer)) {
				throw new IllegalArgumentException(
						"Argument must be of SWT type");
			} else {
				if (theParent.getPhysicalComponent() == null) {
					throw new IllegalArgumentException(
							"Cannot add to an unitialized parent");
				}
			}
		}

		if (readOnly)
			component = new Combo((Composite) theParent.getPhysicalComponent(),
					SWT.DROP_DOWN | SWT.READ_ONLY);
		else
			component = new Combo((Composite) theParent.getPhysicalComponent(),
					SWT.DROP_DOWN);
		for (int i = 0; i < comboChoices.size(); i++) {
			getComboBox().add(comboChoices.get(i), i);
		}
		init();
		addAllListeners();
		getComboBox().setSize(40, 40);
		getComponent().setLocation(xLocation, yLocation);
		getComponent().setSize(width, height);

		CentralUniversalWidget.register(component, this);
		if ((width == -1) || (height == -1))
			getComponent().pack(); // if dimensions aren't set
		// else if (toPack) getComponent().pack();
	}

	@Override
	public void setRenderer(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getRenderer() {
		// TODO Auto-generated method stub
		return null;
	}

}
