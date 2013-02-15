package bus.uigen.widgets.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import bus.uigen.widgets.ButtonSelector;
import bus.uigen.widgets.ComboBoxSelector;
import bus.uigen.widgets.FlowLayoutSelector;
import bus.uigen.widgets.FrameSelector;
import bus.uigen.widgets.GridLayoutSelector;
import bus.uigen.widgets.LabelSelector;
import bus.uigen.widgets.MenuBarSelector;
import bus.uigen.widgets.MenuItemSelector;
import bus.uigen.widgets.MenuSelector;
import bus.uigen.widgets.NumberFormatSelector;
import bus.uigen.widgets.PanelSelector;
import bus.uigen.widgets.TextFieldSelector;
import bus.uigen.widgets.VirtualFrame;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.awt.AWTNumberFormatFactory;
import bus.uigen.widgets.table.ScrollableTableSelector;
import bus.uigen.widgets.table.TableSelector;
import bus.uigen.widgets.tree.TreeSelector;

public class SWTToolkit extends VirtualToolkit {
	static Runnable swtFrameStarter = null;

	public SWTToolkit() {
		select();
	}

	public SWTToolkit(String joinDescription, String replicaID,
			boolean communicationCentralized, boolean widgetsReplicated) {
		init(true, joinDescription, replicaID, communicationCentralized,
				widgetsReplicated, false);
	}

	public SWTToolkit(String joinDescription, boolean communicationCentralized,
			boolean widgetsReplicated) {
		init(true, joinDescription, null, communicationCentralized,
				widgetsReplicated, false);
	}

	public SWTToolkit(boolean isDistributed, String id) {
		init(isDistributed, null, id, true, true, false);
	}

	public void select() {
		maybeRegisterWidgets();
		FrameSelector.setFrameFactory(new SWTFrameFactory());
		// InternalFrameSelector.setInternalFrameFactory(new
		// SwingInternalFrameFactory());
		// ButtonGroupSelector.setButtonGroupFactory(new
		// SwingButtonGroupFactory());
		ButtonSelector.setButtonFactory(new SWTButtonFactory());
		// CheckBoxSelector.setCheckBoxFactory(new SwingCheckBoxFactory());
		ComboBoxSelector.setComboBoxFactory(new SWTComboBoxFactory());
		// DesktopPaneSelector.setDesktopPaneFactory(new
		// SwingDesktopPaneFactory());
		GridLayoutSelector.setGridLayoutFactory(new SWTGridLayoutFactory());
		LabelSelector.setLabelFactory(new SWTLabelFactory());
		MenuBarSelector.setMenuBarFactory(new SWTMenuBarFactory());
		MenuItemSelector.setMenuItemFactory(new SWTMenuItemFactory());
		MenuSelector.setMenuFactory(new SWTMenuFactory());
		PanelSelector.setPanelFactory(new SWTPanelFactory());
		// ProxyGWTServerEndSelector.setProxyGWTServerEndFactory(new
		// NonGWTProxyGWTServerEndFactory());
		// PasswordFieldSelector.setPasswordFieldFactory(new
		// SwingPasswordFieldFactory());
		// RadioButtonSelector.setRadioButtonFactory(new
		// SwingRadioButtonFactory());
		ScrollableTableSelector
				.setScrollableTableFactory(new SWTScrollableTableFactory());
		// ScrollPaneSelector.setScrollPaneFactory(new AWTScrollPaneFactory());
		// SliderSelector.setSliderFactory(new SwingSliderFactory());
		// SplitPaneSelector.setSplitPaneFactory(new SwingSplitPaneFactory());
		// TableSelector.setTableFactory(new SwingTableFactory());
		TextFieldSelector.setTextFieldFactory(new SWTTextFieldFactory());
		// TextAreaSelector.setTextAreaFactory(new AWTTextAreaFactory());
		// TextFieldSelector.setTextFieldFactory(new AWTTextFieldFactory());
		// ToolBarSelector.setToolBarFactory(new SwingToolBarFactory());
		TreeSelector.setTreeFactory(new SWTTreeFactory());
		TableSelector.setTableFactory(new SWTTableFactory());
		FlowLayoutSelector.setFlowLayoutFactory(new SWTFlowLayoutFactory());
		NumberFormatSelector
				.setNumberFormatFactory(new AWTNumberFormatFactory());

	}

	public boolean maybeRegisterWidgets() {
		boolean toReturn = super.maybeRegisterWidgets();

		registerer = new SWTUniversalWidgetRegisterer();
		registerer.registerUniversalWidgetClasses();

		return toReturn;
	}

	private class SWTFrameStarter implements Runnable {
		VirtualFrame frame;

		public SWTFrameStarter(VirtualFrame frame) {
			this.frame = frame;
		}

		public void run() {
			// maybeRegisterWidgets();
			frame.setVisible(true);
			frame.pack();
			Display display = (Display) frame.getPhysicalComponent();
			Shell shell = (Shell) frame.getContentPane().getPhysicalComponent();
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			display.dispose();
		}
	}

	class ToolkitStarter extends Thread {
		String frameID;

		public ToolkitStarter(String frameID) {
			this.frameID = frameID;
		}

		public void run() {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + COMMAND_START
					+ frameID + ")");
		}
	}

	public void startFrame(VirtualFrame frame) {
		// maybeRegisterWidgets();
		/*
		 * frame.setVisible(true); frame.pack(); Display display = (Display)
		 * frame.getPhysicalComponent(); Shell shell = (Shell)
		 * frame.getContentPane().getPhysicalComponent(); shell.open(); while
		 * (!shell.isDisposed()){ if (!display.readAndDispatch())
		 * display.sleep(); } display.dispose();
		 */
		if (frame != null && VirtualToolkit.isDistributedByDefault()) {
			ToolkitStarter starter = new ToolkitStarter(frame.getName());
			starter.start();
		}

		while (true) {
			boolean ready = readyToStartFrame();
			if (ready) {
				swtFrameStarter.run();
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	boolean readyToStartFrame() {
		return swtFrameStarter != null;
	}

	public void receiveStartFrameCommand(VirtualFrame frame) {
		swtFrameStarter = new SWTFrameStarter(frame);
	}

	public boolean centralizesListeners(String widgetID) {
		return false;
	}
}