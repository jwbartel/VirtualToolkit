package bus.uigen.widgets.swing;import javax.swing.JDesktopPane;import bus.uigen.widgets.ContainerFactory;import bus.uigen.widgets.DesktopPaneFactory;import bus.uigen.widgets.VirtualContainer;import bus.uigen.widgets.VirtualDesktopPane;public class SwingDesktopPaneFactory implements DesktopPaneFactory,		ContainerFactory {	static int id;	public VirtualDesktopPane createDesktopPane() {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createJDesktopPane();	}	static int getNewID() {		return id++;	}	// public static JPanel createJPanel () {	public static VirtualDesktopPane createJDesktopPane() {		JDesktopPane panel = new JDesktopPane();		panel.setName("" + getNewID());		// panel.setBackground(Color.white);		VirtualDesktopPane toReturn = SwingDesktopPane				.virtualDesktopPane(panel);		toReturn.init();		return toReturn;		// return new Panel();	}	public VirtualContainer createContainer() {		return createJDesktopPane();	}}