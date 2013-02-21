package bus.uigen.widgets.swt;

import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.MenuContainer;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import bus.uigen.widgets.UniversalWidgetRegisterer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public class SWTUniversalWidgetRegisterer implements UniversalWidgetRegisterer {

	static boolean registered = false;

	public void registerUniversalWidgetClasses() {
		if (registered)
			return;
		registered = true;
		CentralUniversalWidget.register(org.eclipse.swt.widgets.Button.class,
				SWTButton.class);
		CentralUniversalWidget.register(Shell.class, SWTShell.class);
		CentralUniversalWidget.register(org.eclipse.swt.widgets.Display.class,
				SWTFrame.class);
		CentralUniversalWidget.register(Label.class, SWTLabel.class);
		CentralUniversalWidget.register(StyledText.class, SWTTextField.class);
		CentralUniversalWidget.register(Combo.class, SWTComboBox.class);
		CentralUniversalWidget.register(Tree.class, SWTTree.class);
		CentralUniversalWidget.register(MenuComponent.class,
				SWTMenuComponent.class);
		CentralUniversalWidget.register(MenuContainer.class,
				SWTMenuContainer.class);
		CentralUniversalWidget.register(MenuItem.class, SWTMenuItem.class);
		CentralUniversalWidget.register(Menu.class, SWTMenu.class);
		CentralUniversalWidget.register(MenuBar.class, SWTMenuBar.class);

		/*
		 * CentralUniversalWidget.register (Component.class,
		 * AWTComponent.class); CentralUniversalWidget.register
		 * (Container.class, AWTContainer.class);
		 * CentralUniversalWidget.register (Applet.class, AWTContainer.class);
		 * // do we need this? CentralUniversalWidget.register (Frame.class,
		 * AWTFrame.class); CentralUniversalWidget.register (JFrame.class,
		 * SwingFrame.class); CentralUniversalWidget.register (Display.class,
		 * SWTFrame.class); //register (JPanel.class, ASwingPanel.class);
		 * CentralUniversalWidget.register (JToolBar.class, SwingToolBar.class);
		 * CentralUniversalWidget.register (JFrame.class, SwingFrame.class);
		 * CentralUniversalWidget.register (JInternalFrame.class,
		 * SwingInternalFrame.class); CentralUniversalWidget.register
		 * (JDesktopPane.class, SwingDesktopPane.class);
		 * CentralUniversalWidget.register (JFormattedTextField.class,
		 * SwingFormattedTextField.class); CentralUniversalWidget.register
		 * (JTextArea.class, SwingTextArea.class);
		 * CentralUniversalWidget.register (JEditorPane.class,
		 * SwingEditorPane.class); CentralUniversalWidget.register
		 * (TextArea.class, AWTTextArea.class); CentralUniversalWidget.register
		 * (JCheckBox.class, SwingCheckBox.class);
		 * CentralUniversalWidget.register (JSlider.class, SwingSlider.class);
		 * CentralUniversalWidget.register (JSpinner.class, SwingSpinner.class);
		 * CentralUniversalWidget.register (JPasswordField.class,
		 * SwingPasswordField.class); CentralUniversalWidget.register
		 * (JRadioButton.class, SwingRadioButton.class);
		 * CentralUniversalWidget.register (JSlider.class, SwingSlider.class);
		 * CentralUniversalWidget.register (JProgressBar.class,
		 * SwingProgressBar.class); CentralUniversalWidget.register
		 * (JSplitPane.class, SwingSplitPane.class);
		 * CentralUniversalWidget.register (JScrollPane.class,
		 * SwingScrollPane.class); CentralUniversalWidget.register
		 * (ScrollPane.class, AWTScrollPane.class);
		 * CentralUniversalWidget.register (JTabbedPane.class,
		 * SwingTabbedPane.class); CentralUniversalWidget.register (JTree.class,
		 * SwingTree.class); CentralUniversalWidget.register (JTable.class,
		 * SwingTable.class); CentralUniversalWidget.register (JList.class,
		 * SwingList.class); CentralUniversalWidget.register (JPopupMenu.class,
		 * SwingPopupMenu.class); CentralUniversalWidget.register
		 * (PopupMenu.class, AWTPopupMenu.class);
		 * CentralUniversalWidget.register (DelegateJPanel.class,
		 * SwingDelegatePanel.class); CentralUniversalWidget.register
		 * (DelegatePanel.class, AWTDelegatePanel.class);
		 */
	}
}
