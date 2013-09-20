package bus.uigen.widgets.gwt;

import bus.uigen.widgets.UniversalWidgetRegisterer;

public class GWTUniversalWidgetRegisterer implements UniversalWidgetRegisterer {

	static boolean registered = false;

	public void registerUniversalWidgetClasses() {
		if (registered)
			return;
		registered = true;

		/*
		 * CentralUniversalWidget.register (Button.class, AWTButton.class);
		 * CentralUniversalWidget.register
		 * (org.eclipse.swt.widgets.Button.class, SWTButton.class);
		 * CentralUniversalWidget.register (Component.class,
		 * AWTComponent.class); CentralUniversalWidget.register
		 * (Container.class, AWTContainer.class);
		 * CentralUniversalWidget.register (Shell.class, SWTShell.class);
		 * CentralUniversalWidget.register (Applet.class, AWTContainer.class);
		 * // do we need this? CentralUniversalWidget.register (Frame.class,
		 * AWTFrame.class); CentralUniversalWidget.register (JFrame.class,
		 * SwingFrame.class); CentralUniversalWidget.register (Display.class,
		 * SWTFrame.class); CentralUniversalWidget.register (JButton.class,
		 * SwingButton.class); //register (JPanel.class, ASwingPanel.class);
		 * CentralUniversalWidget.register (JLabel.class, SwingLabel.class);
		 * CentralUniversalWidget.register (Label.class, AWTLabel.class);
		 * CentralUniversalWidget.register (JToolBar.class, SwingToolBar.class);
		 * CentralUniversalWidget.register (JFrame.class, SwingFrame.class);
		 * CentralUniversalWidget.register (JInternalFrame.class,
		 * SwingInternalFrame.class); CentralUniversalWidget.register
		 * (JDesktopPane.class, SwingDesktopPane.class);
		 * CentralUniversalWidget.register (JFormattedTextField.class,
		 * SwingFormattedTextField.class); CentralUniversalWidget.register
		 * (JTextField.class, SwingTextField.class);
		 * CentralUniversalWidget.register (TextField.class,
		 * AWTTextField.class); CentralUniversalWidget.register
		 * (JTextArea.class, SwingTextArea.class);
		 * CentralUniversalWidget.register (JEditorPane.class,
		 * SwingEditorPane.class); CentralUniversalWidget.register
		 * (TextArea.class, AWTTextArea.class); CentralUniversalWidget.register
		 * (JButton.class, SwingButton.class); CentralUniversalWidget.register
		 * (Button.class, AWTButton.class); CentralUniversalWidget.register
		 * (JCheckBox.class, SwingCheckBox.class);
		 * CentralUniversalWidget.register (JSlider.class, SwingSlider.class);
		 * CentralUniversalWidget.register (JComboBox.class,
		 * SwingComboBox.class); CentralUniversalWidget.register
		 * (JSpinner.class, SwingSpinner.class); CentralUniversalWidget.register
		 * (JPasswordField.class, SwingPasswordField.class);
		 * CentralUniversalWidget.register (JRadioButton.class,
		 * SwingRadioButton.class); CentralUniversalWidget.register
		 * (JSlider.class, SwingSlider.class); CentralUniversalWidget.register
		 * (JProgressBar.class, SwingProgressBar.class);
		 * CentralUniversalWidget.register (JSplitPane.class,
		 * SwingSplitPane.class); CentralUniversalWidget.register
		 * (JScrollPane.class, SwingScrollPane.class);
		 * CentralUniversalWidget.register (ScrollPane.class,
		 * AWTScrollPane.class); CentralUniversalWidget.register
		 * (JTabbedPane.class, SwingTabbedPane.class);
		 * CentralUniversalWidget.register (JTree.class, SwingTree.class);
		 * CentralUniversalWidget.register (JTable.class, SwingTable.class);
		 * CentralUniversalWidget.register (JList.class, SwingList.class);
		 * CentralUniversalWidget.register (MenuComponent.class,
		 * AWTMenuComponent.class); CentralUniversalWidget.register
		 * (MenuContainer.class, AWTMenuContainer.class);
		 * CentralUniversalWidget.register (MenuItem.class, AWTMenuItem.class);
		 * CentralUniversalWidget.register (JMenuItem.class,
		 * SwingMenuItem.class); CentralUniversalWidget.register (Menu.class,
		 * AWTMenu.class); CentralUniversalWidget.register (JMenu.class,
		 * SwingMenu.class); CentralUniversalWidget.register (JPopupMenu.class,
		 * SwingPopupMenu.class); CentralUniversalWidget.register
		 * (PopupMenu.class, AWTPopupMenu.class);
		 * CentralUniversalWidget.register (MenuBar.class, AWTMenuBar.class);
		 * CentralUniversalWidget.register (DelegateJPanel.class,
		 * SwingDelegatePanel.class); CentralUniversalWidget.register
		 * (DelegatePanel.class, AWTDelegatePanel.class);
		 */
	}
}
