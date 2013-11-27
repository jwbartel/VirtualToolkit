package bus.uigen.widgets.gwt;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.CheckBoxSelector;
import bus.uigen.widgets.ComboBoxSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.LabelSelector;
import bus.uigen.widgets.NumberFormatSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.ScrollPaneSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.table.TableSelector;

public class GWTToolkit extends VirtualToolkit {

	public GWTToolkit() {
		select();
	}

	// A GWT web client can never specify a direct replicaID
	// public GWTToolkit(String joinDescription, String replicaID, boolean
	// communicationCentralized, boolean widgetsReplicated){
	// init(true, joinDescription, replicaID, communicationCentralized,
	// widgetsReplicated);
	// }

	public GWTToolkit(String joinDescription) {
		init(true, joinDescription, null, true, true, false);
	}

	public GWTToolkit(boolean isDistributed, String id) {
		init(isDistributed, null, id, true, true, false);
	}

	public void select() {
		registerer = new GWTUniversalWidgetRegisterer();
		registerer.registerUniversalWidgetClasses();

		ButtonSelector.setButtonFactory(new GWTButtonFactory());
		FrameSelector.setFrameFactory(new GWTFrameFactory());
		GridLayoutSelector.setGridLayoutFactory(new GWTGridLayoutFactory());
		LabelSelector.setLabelFactory(new GWTLabelFactory());
		PanelSelector.setPanelFactory(new GWTPanelFactory());
		// ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new
		// GWTProxyGWTServerEndFactory());
		TextFieldSelector.setTextFieldFactory(new GWTTextFieldFactory());
		CheckBoxSelector.setCheckBoxFactory(new GWTCheckBoxFactory());
		NumberFormatSelector
				.setNumberFormatFactory(new GWTNumberFormatFactory());
		ComboBoxSelector.setComboBoxFactory(new GWTComboBoxFactory());
		ScrollPaneSelector.setScrollPaneFactory(new GWTScrollPaneFactory());
	}

	public void startFrame(VirtualFrame frame) {
		receiveStartFrameCommand(frame);

		if (frame != null && VirtualToolkit.isDistributedByDefault()) {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + COMMAND_START
					+ frame.getName() + ")");
		}
	}

	public void receiveStartFrameCommand(VirtualFrame frame) {
		// Do nothing
	}

	public void sleep(long milleseconds) {

	}

	public boolean centralizesListeners(String widgetID) {
		return false;
	}
}