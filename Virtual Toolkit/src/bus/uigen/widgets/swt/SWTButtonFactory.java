package bus.uigen.widgets.swt;import javax.swing.Icon;import bus.uigen.widgets.ButtonFactory;import bus.uigen.widgets.VirtualButton;public class SWTButtonFactory implements ButtonFactory {	static int id;	public VirtualButton createButton(String text) {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createJButton(text);	}	public VirtualButton createButton(Object icon) {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createJButton((Icon) icon);	}	public VirtualButton createButton() {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createJButton();	}	static int getNewID() {		return id++;	}	/*	 * public static SWTButton createJButton (String text) { Button button = new	 * Button(text); return SWTButton.virtualButton(button); //return new	 * Panel(); //return new JPanel(); }	 */	public static SWTButton createJButton(String text) {		return new SWTButton(text);	}	/*	 * public static SWTButton createJButton (Icon icon) { Button button = new	 * Button(icon.toString()); return SWTButton.virtualButton(button); //return	 * new Panel(); //return new JPanel(); }	 */	public static SWTButton createJButton(Icon icon) { // what is an icon?		return new SWTButton();	}	/*	 * public static SWTButton createJButton () { Button button = new Button();	 * return SWTButton.virtualButton(button); //return new Panel(); //return	 * new JPanel(); }	 */	public static SWTButton createJButton() {		return new SWTButton();	}}