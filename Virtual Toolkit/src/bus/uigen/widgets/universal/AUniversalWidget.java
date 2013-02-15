package bus.uigen.widgets.universal;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuComponent;
import java.awt.MenuContainer;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Hashtable;

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

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import bus.uigen.widgets.UniversalWidget;
import bus.uigen.widgets.awt.AWTButton;
import bus.uigen.widgets.awt.AWTComponent;
import bus.uigen.widgets.awt.AWTContainer;
import bus.uigen.widgets.awt.AWTDelegatePanel;
import bus.uigen.widgets.awt.AWTFrame;
import bus.uigen.widgets.awt.AWTLabel;
import bus.uigen.widgets.awt.AWTMenu;
import bus.uigen.widgets.awt.AWTMenuBar;
import bus.uigen.widgets.awt.AWTMenuComponent;
import bus.uigen.widgets.awt.AWTMenuContainer;
import bus.uigen.widgets.awt.AWTMenuItem;
import bus.uigen.widgets.awt.AWTPopupMenu;
import bus.uigen.widgets.awt.AWTScrollPane;
import bus.uigen.widgets.awt.AWTTextArea;
import bus.uigen.widgets.awt.AWTTextField;
import bus.uigen.widgets.awt.DelegatePanel;
import bus.uigen.widgets.swing.DelegateJPanel;
import bus.uigen.widgets.swing.SwingButton;
import bus.uigen.widgets.swing.SwingCheckBox;
import bus.uigen.widgets.swing.SwingComboBox;
import bus.uigen.widgets.swing.SwingDelegatePanel;
import bus.uigen.widgets.swing.SwingDesktopPane;
import bus.uigen.widgets.swing.SwingEditorPane;
import bus.uigen.widgets.swing.SwingFormattedTextField;
import bus.uigen.widgets.swing.SwingFrame;
import bus.uigen.widgets.swing.SwingInternalFrame;
import bus.uigen.widgets.swing.SwingLabel;
import bus.uigen.widgets.swing.SwingList;
import bus.uigen.widgets.swing.SwingMenu;
import bus.uigen.widgets.swing.SwingMenuItem;
import bus.uigen.widgets.swing.SwingPasswordField;
import bus.uigen.widgets.swing.SwingPopupMenu;
import bus.uigen.widgets.swing.SwingProgressBar;
import bus.uigen.widgets.swing.SwingRadioButton;
import bus.uigen.widgets.swing.SwingScrollPane;
import bus.uigen.widgets.swing.SwingSlider;
import bus.uigen.widgets.swing.SwingSpinner;
import bus.uigen.widgets.swing.SwingSplitPane;
import bus.uigen.widgets.swing.SwingTabbedPane;
import bus.uigen.widgets.swing.SwingTable;
import bus.uigen.widgets.swing.SwingTextArea;
import bus.uigen.widgets.swing.SwingTextField;
import bus.uigen.widgets.swing.SwingToolBar;
import bus.uigen.widgets.swing.SwingTree;
import bus.uigen.widgets.swt.SWTButton;
import bus.uigen.widgets.swt.SWTFrame;
import bus.uigen.widgets.swt.SWTShell;

public class AUniversalWidget {
	protected Object component;
	Object userObject;

	public AUniversalWidget(Object theComponent) {
		init(theComponent);
	}

	public AUniversalWidget() {

	}

	public void init(Object theComponent) {
		component = theComponent;
	}

	public Object getUserObject() {
		return userObject;

	}

	public void setUserObject(Object newVal) {
		userObject = newVal;
	}

	public Object getWidget() {
		return component;
	}

	static transient Hashtable<Object, UniversalWidget> componentsToUniversalWidgets = new Hashtable<Object, UniversalWidget>();
	static transient Hashtable<Class, Class> componentClassToUniversalWidgetClass = new Hashtable<Class, Class>();

	public static UniversalWidget existingUniversalWidget(Object c) {
		return componentsToUniversalWidgets.get(c);

	}

	public static void register(Object c, UniversalWidget vc) {
		componentsToUniversalWidgets.put(c, vc);
	}

	public static Class getVirtualClass(Class c) {
		Class virtualClass = componentClassToUniversalWidgetClass.get(c);
		Class superClass = c.getSuperclass();
		if (virtualClass != null)
			return virtualClass;
		else if (superClass != null)
			return getVirtualClass(superClass);
		else
			return null;
	}

	public static UniversalWidget universalWidget(Object c) {
		if (c == null)
			return null;
		registerUniversalWidgetClasses();
		UniversalWidget vc = componentsToUniversalWidgets.get(c);
		if (vc == null) {
			try {
				// Class virtualClass =
				// componentClassToUniversalWidgetClass.get(c.getClass());
				Class virtualClass = getVirtualClass(c.getClass());
				if (virtualClass == null)
					vc = null;
				else {
					vc = (UniversalWidget) virtualClass.newInstance();
					vc.init(c);
				}

				if (c instanceof JLabel)
					vc = new SwingLabel((JLabel) c);
				/*
				 * else if (c instanceof Container) vc = new
				 * AnAWTContainer((Container) c); else if (c instanceof Frame)
				 * vc = new AnAWTFrame ((Frame) c); else if (c instanceof
				 * JTextField) vc = new ASwingTextField ((JTextField) c); else
				 * if (c instanceof JButton) vc = new ASwingButton ((JButton)
				 * c); else if (c instanceof JSlider) vc = new ASwingSlider
				 * ((JSlider) c); else if (c instanceof JTree) vc = new
				 * ASwingTree ((JTree) c); else vc = new AnAWTComponent(c);
				 */
				componentsToUniversalWidgets.put(c, vc);
			} catch (Exception e) {
				System.out
						.println("Probably need to bind virtual class to physical one in Universal Widget");
				e.printStackTrace();
				vc = null;
				// vc = new AnAWTComponent(c);
			}

		}

		return vc;

	}

	public static void register(Class componentClass, Class virtualClass) {
		componentClassToUniversalWidgetClass.put(componentClass, virtualClass);
	}

	static boolean registered = false;

	public static void registerUniversalWidgetClasses() {
		if (registered)
			return;
		registered = true;
		register(Button.class, AWTButton.class);
		register(org.eclipse.swt.widgets.Button.class, SWTButton.class);
		register(Component.class, AWTComponent.class);
		register(Container.class, AWTContainer.class);
		register(Shell.class, SWTShell.class);
		register(Applet.class, AWTContainer.class); // do we need this?
		register(Frame.class, AWTFrame.class);
		register(JFrame.class, SwingFrame.class);
		register(Display.class, SWTFrame.class);
		register(JButton.class, SwingButton.class);
		// register (JPanel.class, ASwingPanel.class);
		register(JLabel.class, SwingLabel.class);
		register(Label.class, AWTLabel.class);
		register(JToolBar.class, SwingToolBar.class);
		register(JFrame.class, SwingFrame.class);
		register(JInternalFrame.class, SwingInternalFrame.class);
		register(JDesktopPane.class, SwingDesktopPane.class);
		register(JFormattedTextField.class, SwingFormattedTextField.class);
		register(JTextField.class, SwingTextField.class);
		register(TextField.class, AWTTextField.class);
		register(JTextArea.class, SwingTextArea.class);
		register(JEditorPane.class, SwingEditorPane.class);
		register(TextArea.class, AWTTextArea.class);
		register(JButton.class, SwingButton.class);
		register(Button.class, AWTButton.class);
		register(JCheckBox.class, SwingCheckBox.class);
		register(JSlider.class, SwingSlider.class);
		register(JComboBox.class, SwingComboBox.class);
		register(JSpinner.class, SwingSpinner.class);
		register(JPasswordField.class, SwingPasswordField.class);
		register(JRadioButton.class, SwingRadioButton.class);
		register(JSlider.class, SwingSlider.class);
		register(JProgressBar.class, SwingProgressBar.class);
		register(JSplitPane.class, SwingSplitPane.class);
		register(JScrollPane.class, SwingScrollPane.class);
		register(ScrollPane.class, AWTScrollPane.class);
		register(JTabbedPane.class, SwingTabbedPane.class);
		register(JTree.class, SwingTree.class);
		register(JTable.class, SwingTable.class);
		register(JList.class, SwingList.class);
		register(MenuComponent.class, AWTMenuComponent.class);
		register(MenuContainer.class, AWTMenuContainer.class);
		register(MenuItem.class, AWTMenuItem.class);
		register(JMenuItem.class, SwingMenuItem.class);
		register(Menu.class, AWTMenu.class);
		register(JMenu.class, SwingMenu.class);
		register(JPopupMenu.class, SwingPopupMenu.class);
		register(PopupMenu.class, AWTPopupMenu.class);
		register(MenuBar.class, AWTMenuBar.class);
		register(DelegateJPanel.class, SwingDelegatePanel.class);
		register(DelegatePanel.class, AWTDelegatePanel.class);

	}

}
