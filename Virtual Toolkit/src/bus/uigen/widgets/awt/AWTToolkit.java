package bus.uigen.widgets.awt;

import bus.uigen.widgets.ButtonGroupSelector;
import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.CheckBoxSelector;
import bus.uigen.widgets.ComboBoxSelector;
import bus.uigen.widgets.DesktopPaneSelector;
import bus.uigen.widgets.FlowLayoutSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.InternalFrameSelector;
import bus.uigen.widgets.LabelSelector;
import bus.uigen.widgets.MenuBarSelector;
import bus.uigen.widgets.MenuItemSelector;
import bus.uigen.widgets.MenuSelector;
import bus.uigen.widgets.NumberFormatSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.PasswordFieldSelector;
import bus.uigen.widgets.PopupMenuSelector;
import bus.uigen.widgets.RadioButtonSelector;
import bus.uigen.widgets.ScrollPaneSelector;
import bus.uigen.widgets.SliderSelector;
import bus.uigen.widgets.SplitPaneSelector;
import bus.uigen.widgets.TextAreaSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.ToolBarSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.swing.SwingButtonGroupFactory;
import bus.uigen.widgets.swing.SwingCheckBoxFactory;
import bus.uigen.widgets.swing.SwingComboBoxFactory;
import bus.uigen.widgets.swing.SwingDesktopPaneFactory;
import bus.uigen.widgets.swing.SwingInternalFrameFactory;
import bus.uigen.widgets.swing.SwingPasswordFieldFactory;
import bus.uigen.widgets.swing.SwingRadioButtonFactory;
import bus.uigen.widgets.swing.SwingScrollableTableFactory;
import bus.uigen.widgets.swing.SwingSliderFactory;
import bus.uigen.widgets.swing.SwingSplitPaneFactory;
import bus.uigen.widgets.swing.SwingTableFactory;
import bus.uigen.widgets.swing.SwingToolBarFactory;
import bus.uigen.widgets.swing.SwingTreeFactory;
import bus.uigen.widgets.table.ScrollableTableSelector;
import bus.uigen.widgets.table.TableSelector;
import bus.uigen.widgets.tree.TreeSelector;

public class AWTToolkit extends VirtualToolkit {

	public AWTToolkit() {
		select();
	}

	public AWTToolkit(String joinDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated) {
		init(true, joinDescription, replicaID, communicationCentralized,
				widgetsReplicated, false);
	}

	public AWTToolkit(String joinDescription, boolean communicationCentralized,
			boolean widgetsReplicated) {
		init(true, joinDescription, null, communicationCentralized,
				widgetsReplicated, false);
	}

	public AWTToolkit(boolean isDistributed, String id) {
		init(isDistributed, null, id, true, true, false);
	}

	public void select() {
		maybeRegisterWidgets();
		FrameSelector.setFrameFactory(new AWTFrameFactory());
		InternalFrameSelector
				.setInternalFrameFactory(new SwingInternalFrameFactory());
		ButtonGroupSelector
				.setButtonGroupFactory(new SwingButtonGroupFactory());
		ButtonSelector.setButtonFactory(new AWTButtonFactory());
		CheckBoxSelector.setCheckBoxFactory(new SwingCheckBoxFactory());
		ComboBoxSelector.setComboBoxFactory(new SwingComboBoxFactory());
		DesktopPaneSelector
				.setDesktopPaneFactory(new SwingDesktopPaneFactory());
		FlowLayoutSelector.setFlowLayoutFactory(new AWTFlowLayoutFactory());
		GridLayoutSelector.setGridLayoutFactory(new AWTGridLayoutFactory());
		LabelSelector.setLabelFactory(new AWTLabelFactory());
		MenuBarSelector.setMenuBarFactory(new AWTMenuBarFactory());
		MenuItemSelector.setMenuItemFactory(new AWTMenuItemFactory());
		MenuSelector.setMenuFactory(new AWTMenuFactory());
		NumberFormatSelector
				.setNumberFormatFactory(new AWTNumberFormatFactory());
		PanelSelector.setPanelFactory(new AWTPanelFactory());
		PopupMenuSelector.setMenuFactory(new AWTPopupMenuFactory());
		// ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new
		// NonGWTProxyGWTServerEndFactory());
		PasswordFieldSelector
				.setPasswordFieldFactory(new SwingPasswordFieldFactory());
		RadioButtonSelector
				.setRadioButtonFactory(new SwingRadioButtonFactory());
		ScrollableTableSelector
				.setScrollableTableFactory(new SwingScrollableTableFactory());
		ScrollPaneSelector.setScrollPaneFactory(new AWTScrollPaneFactory());
		SliderSelector.setSliderFactory(new SwingSliderFactory());
		SplitPaneSelector.setSplitPaneFactory(new SwingSplitPaneFactory());
		TableSelector.setTableFactory(new SwingTableFactory());
		TextAreaSelector.setTextAreaFactory(new AWTTextAreaFactory());
		TextFieldSelector.setTextFieldFactory(new AWTTextFieldFactory());
		ToolBarSelector.setToolBarFactory(new SwingToolBarFactory());
		TreeSelector.setTreeFactory(new SwingTreeFactory());
		TableSelector.setTableFactory(new SwingTableFactory());
	}

	public boolean maybeRegisterWidgets() {
		boolean toReturn = super.maybeRegisterWidgets();

		registerer = new AWTUniversalWidgetRegisterer();
		registerer.registerUniversalWidgetClasses();

		return toReturn;
	}

	public void startFrame(VirtualFrame frame) {
		receiveStartFrameCommand(frame);

		if (frame != null && VirtualToolkit.isDistributedByDefault()) {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + COMMAND_START
					+ frame.getName() + ")");
		}
	}

	public void receiveStartFrameCommand(VirtualFrame frame) {
		if (frame != null) {
			frame.setVisible(true);
		}
	}

	public boolean centralizesListeners(String widgetID) {
		return false;
	}
}