package bus.uigen.widgets.swing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;

import bus.uigen.widgets.UniversalWidgetRegisterer;
import bus.uigen.widgets.awt.AWTUniversalWidgetRegisterer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SwingUniversalWidgetRegisterer extends
		AWTUniversalWidgetRegisterer implements UniversalWidgetRegisterer {

	public void registerUniversalWidgetClasses() {
		if (registered)
			return;
		super.registerUniversalWidgetClasses();
		registered = true;
		CentralUniversalWidget.register(JFrame.class, SwingFrame.class);
		CentralUniversalWidget.register(JButton.class, SwingButton.class);
		// register (JPanel.class, ASwingPanel.class);
		CentralUniversalWidget.register(JLabel.class, SwingLabel.class);
		CentralUniversalWidget.register(JToolBar.class, SwingToolBar.class);
		CentralUniversalWidget.register(JFrame.class, SwingFrame.class);
		CentralUniversalWidget.register(JInternalFrame.class,
				SwingInternalFrame.class);
		CentralUniversalWidget.register(JDesktopPane.class,
				SwingDesktopPane.class);
		CentralUniversalWidget.register(JFormattedTextField.class,
				SwingFormattedTextField.class);
		CentralUniversalWidget.register(JTextField.class, SwingTextField.class);
		CentralUniversalWidget.register(JTextArea.class, SwingTextArea.class);
		CentralUniversalWidget.register(JEditorPane.class,
				SwingEditorPane.class);
		CentralUniversalWidget.register(JButton.class, SwingButton.class);
		CentralUniversalWidget.register(JCheckBox.class, SwingCheckBox.class);
		CentralUniversalWidget.register(JSlider.class, SwingSlider.class);
		CentralUniversalWidget.register(JComboBox.class, SwingComboBox.class);
		CentralUniversalWidget.register(JSpinner.class, SwingSpinner.class);
		CentralUniversalWidget.register(JPasswordField.class,
				SwingPasswordField.class);
		CentralUniversalWidget.register(JRadioButton.class,
				SwingRadioButton.class);
		CentralUniversalWidget.register(JSlider.class, SwingSlider.class);
		CentralUniversalWidget.register(JProgressBar.class,
				SwingProgressBar.class);
		CentralUniversalWidget.register(JSplitPane.class, SwingSplitPane.class);
		CentralUniversalWidget.register(JScrollPane.class,
				SwingScrollPane.class);
		CentralUniversalWidget.register(JTabbedPane.class,
				SwingTabbedPane.class);
		CentralUniversalWidget.register(JTree.class, SwingTree.class);
		CentralUniversalWidget.register(JTable.class, SwingTable.class);
		CentralUniversalWidget.register(JList.class, SwingList.class);
		CentralUniversalWidget.register(JMenuItem.class, SwingMenuItem.class);
		CentralUniversalWidget.register(JMenu.class, SwingMenu.class);
		CentralUniversalWidget.register(JPopupMenu.class, SwingPopupMenu.class);
		CentralUniversalWidget.register(DelegateJPanel.class,
				SwingDelegatePanel.class);
	}

}
