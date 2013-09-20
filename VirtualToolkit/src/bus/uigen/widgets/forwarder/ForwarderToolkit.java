package bus.uigen.widgets.forwarder;

import java.util.ArrayList;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.PipingReplica;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.WidgetServerSelector;
import bus.uigen.widgets.distributed.ProgramDescription;

public class ForwarderToolkit extends VirtualToolkit {
	public final static String NAME_SUFFIX = "CentralCallSynchronizer";

	String id;
	boolean isCentralProgram;

	public ForwarderToolkit() {
		select();
	}

	public ForwarderToolkit(String joinDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {
		this.isCentralProgram = isCentralProgram;
		init(true, joinDescription, replicaID, communicationCentralized,
				widgetsReplicated, isCentralProgram);
	}

	public ForwarderToolkit(String joinDescription,
			boolean communicationCentralized, boolean widgetsReplicated,
			boolean isCentralProgram) {
		this.isCentralProgram = isCentralProgram;
		init(true, joinDescription, null, communicationCentralized,
				widgetsReplicated, isCentralProgram);
	}

	public ForwarderToolkit(ProgramDescription programDescription,
			PipingReplica pipingReplica) {
		select();
		this.programDescription = programDescription;
		id = programDescription.getKind() + NAME_SUFFIX;
		widgetServer = WidgetServerSelector.createWidgetServer(pipingReplica);
		widgetServer.setID(id);
		pipingReplica.setCentralWidgetServer(widgetServer);
	}

	public String getNameOnServer() {
		String retVal = widgetServer.getNameOnServer();
		if (retVal != null)
			return retVal;
		return super.getNameOnServer();
	}

	public String getID() {
		return id;
	}

	public void select() {
		maybeRegisterWidgets();
		FrameSelector.setFrameFactory(new ForwarderFrameFactory());
		// InternalFrameSelector.setInternalFrameFactory(new
		// SwingInternalFrameFactory());
		// ButtonGroupSelector.setButtonGroupFactory(new
		// SwingButtonGroupFactory());
		ButtonSelector.setButtonFactory(new ForwarderButtonFactory());
		// CheckBoxSelector.setCheckBoxFactory(new SwingCheckBoxFactory());
		// ComboBoxSelector.setComboBoxFactory(new SwingComboBoxFactory());
		// DesktopPaneSelector.setDesktopPaneFactory(new
		// SwingDesktopPaneFactory());
		// FlowLayoutSelector.setFlowLayoutFactory(new AWTFlowLayoutFactory());
		GridLayoutSelector
				.setGridLayoutFactory(new ForwarderGridLayoutFactory());
		// LabelSelector.setLabelFactory(new AWTLabelFactory());
		// MenuBarSelector.setMenuBarFactory(new AWTMenuBarFactory());
		// MenuItemSelector.setMenuItemFactory(new AWTMenuItemFactory());
		// MenuSelector.setMenuFactory(new AWTMenuFactory());
		// NumberFormatSelector.setNumberFormatFactory(new
		// AWTNumberFormatFactory());
		// PanelSelector.setPanelFactory(new AWTPanelFactory());
		// PopupMenuSelector.setMenuFactory(new AWTPopupMenuFactory());
		// ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new
		// NonGWTProxyGWTServerEndFactory());
		// PasswordFieldSelector.setPasswordFieldFactory(new
		// SwingPasswordFieldFactory());
		// RadioButtonSelector.setRadioButtonFactory(new
		// SwingRadioButtonFactory());
		// ScrollableTableSelector.setScrollableTableFactory(new
		// SwingScrollableTableFactory());
		// ScrollPaneSelector.setScrollPaneFactory(new AWTScrollPaneFactory());
		// SliderSelector.setSliderFactory(new SwingSliderFactory());
		// SplitPaneSelector.setSplitPaneFactory(new SwingSplitPaneFactory());
		// TableSelector.setTableFactory(new SwingTableFactory());
		// TextAreaSelector.setTextAreaFactory(new AWTTextAreaFactory());
		TextFieldSelector.setTextFieldFactory(new ForwarderTextFieldFactory());
		// ToolBarSelector.setToolBarFactory(new SwingToolBarFactory());
		// TreeSelector.setTreeFactory(new SwingTreeFactory());
		// TableSelector.setTableFactory(new SwingTableFactory());
	}

	@Override
	public void startFrame(VirtualFrame frame) {
		receiveStartFrameCommand(frame);
		if (VirtualToolkit.isDistributedByDefault()) {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + COMMAND_START
					+ frame.getName() + ")");
		}
	}

	@Override
	public void receiveStartFrameCommand(VirtualFrame frame) {
		// TODO Auto-generated method stub
	}

	public boolean centralizesListeners(String widgetID) {
		if (!isDistributed())
			return false;

		ArrayList<String> centralizedListenerWidgets = widgetServer
				.getCentralizedListenerWidgets();
		return centralizedListenerWidgets != null
				&& centralizedListenerWidgets.contains(widgetID);

	}
}
