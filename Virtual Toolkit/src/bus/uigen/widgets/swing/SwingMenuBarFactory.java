package bus.uigen.widgets.swing;import java.util.Hashtable;import javax.swing.JMenuBar;import bus.uigen.widgets.MenuBarFactory;import bus.uigen.widgets.VirtualMenuBar;public class SwingMenuBarFactory implements MenuBarFactory {	static int id;	public VirtualMenuBar createMenuBar(String text) {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createSwingMenuBar(text);	}	/*	 * public VirtualMenuBar createMenuBar (Object icon) {	 * 	 * return createMenuBar((Icon) icon); }	 */	public VirtualMenuBar createMenuBar() {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createSwingMenuBar();	}	static int getNewID() {		return id++;	}	public static SwingMenuBar createSwingMenuBar(String text) {		JMenuBar menuItem = new JMenuBar();		return virtualMenuBar(menuItem);		// return new Panel();		// return new JPanel();	}	/*	 * public static ASwingMenuBar createSwingMenuBar (Icon icon) { MenuBar	 * menuItem = new MenuBar(icon); return virtualMenuBar(menuItem); //return	 * new Panel(); //return new JPanel(); }	 */	public static SwingMenuBar createSwingMenuBar() {		JMenuBar menuItem = new JMenuBar();		return virtualMenuBar(menuItem);		// return new Panel();		// return new JPanel();	}	static transient Hashtable<JMenuBar, SwingMenuBar> MenuBarsToVirtualMenuBars = new Hashtable<JMenuBar, SwingMenuBar>();	public static SwingMenuBar virtualMenuBar(JMenuBar theMenuBar) {		if (theMenuBar == null)			return null;		SwingMenuBar vc = MenuBarsToVirtualMenuBars.get(theMenuBar);		if (vc == null) {			vc = new SwingMenuBar(theMenuBar);			MenuBarsToVirtualMenuBars.put(theMenuBar, vc);		}		return vc;	}}