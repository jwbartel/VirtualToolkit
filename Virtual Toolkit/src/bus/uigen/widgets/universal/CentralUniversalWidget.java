package bus.uigen.widgets.universal;

import java.util.Hashtable;

import javax.swing.JLabel;

import bus.uigen.widgets.UniversalWidget;
import bus.uigen.widgets.swing.SwingLabel;

public class CentralUniversalWidget {
	protected Object component;
	Object userObject;

	public CentralUniversalWidget(Object theComponent) {
		init(theComponent);
	}

	public CentralUniversalWidget() {

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
		// registerUniversalWidgetClasses();
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
	/*
	 * static boolean registered = false; public static void
	 * registerUniversalWidgetClasses() { if (registered) return; registered =
	 * true; register (Button.class, AWTButton.class); register
	 * (org.eclipse.swt.widgets.Button.class, SWTButton.class); register
	 * (Component.class, AWTComponent.class); register (Container.class,
	 * AWTContainer.class); register (Shell.class, SWTShell.class); register
	 * (Applet.class, AWTContainer.class); // do we need this? register
	 * (Frame.class, AWTFrame.class); register (JFrame.class, SwingFrame.class);
	 * register (Display.class, SWTFrame.class); register (JButton.class,
	 * SwingButton.class); //register (JPanel.class, ASwingPanel.class);
	 * register (JLabel.class, SwingLabel.class); register (Label.class,
	 * AWTLabel.class); register (JToolBar.class, SwingToolBar.class); register
	 * (JFrame.class, SwingFrame.class); register (JInternalFrame.class,
	 * SwingInternalFrame.class); register (JDesktopPane.class,
	 * SwingDesktopPane.class); register (JFormattedTextField.class,
	 * SwingFormattedTextField.class); register (JTextField.class,
	 * SwingTextField.class); register (TextField.class, AWTTextField.class);
	 * register (JTextArea.class, SwingTextArea.class); register
	 * (JEditorPane.class, SwingEditorPane.class); register (TextArea.class,
	 * AWTTextArea.class); register (JButton.class, SwingButton.class); register
	 * (Button.class, AWTButton.class); register (JCheckBox.class,
	 * SwingCheckBox.class); register (JSlider.class, SwingSlider.class);
	 * register (JComboBox.class, SwingComboBox.class); register
	 * (JSpinner.class, SwingSpinner.class); register (JPasswordField.class,
	 * SwingPasswordField.class); register (JRadioButton.class,
	 * SwingRadioButton.class); register (JSlider.class, SwingSlider.class);
	 * register (JProgressBar.class, SwingProgressBar.class); register
	 * (JSplitPane.class, SwingSplitPane.class); register (JScrollPane.class,
	 * SwingScrollPane.class); register (ScrollPane.class, AWTScrollPane.class);
	 * register (JTabbedPane.class, SwingTabbedPane.class); register
	 * (JTree.class, SwingTree.class); register (JTable.class,
	 * SwingTable.class); register (JList.class, SwingList.class); register
	 * (MenuComponent.class, AWTMenuComponent.class); register
	 * (MenuContainer.class, AWTMenuContainer.class); register (MenuItem.class,
	 * AWTMenuItem.class); register (JMenuItem.class, SwingMenuItem.class);
	 * register (Menu.class, AWTMenu.class); register (JMenu.class,
	 * SwingMenu.class); register (JPopupMenu.class, SwingPopupMenu.class);
	 * register (PopupMenu.class, AWTPopupMenu.class); register (MenuBar.class,
	 * AWTMenuBar.class); register (DelegateJPanel.class,
	 * SwingDelegatePanel.class); register (DelegatePanel.class,
	 * AWTDelegatePanel.class);
	 * 
	 * 
	 * }
	 */

}
