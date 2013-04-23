package bus.uigen.widgets.awt;import java.awt.TextArea;import bus.uigen.widgets.TextAreaFactory;import bus.uigen.widgets.VirtualTextArea;public class AWTTextAreaFactory implements TextAreaFactory {	static int id;	public VirtualTextArea createTextArea(String text) {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createAWTTextArea(text);	}	public VirtualTextArea createTextArea() {		/*		 * Container panel = new JPanel(); panel.setName("" + getNewID());		 * //panel.setBackground(Color.white); return panel; //return new		 * Panel(); //return new JPanel();		 */		return createAWTTextArea();	}	public VirtualTextArea createTextArea(String text, int rows, int cols) {		return createAWTTextArea(text, rows, cols);	}	static int getNewID() {		return id++;	}	public static VirtualTextArea createAWTTextArea(String text) {		TextArea textArea = new TextArea(text);		VirtualTextArea toReturn = AWTTextArea.virtualTextArea(textArea);//		toReturn.init();		return toReturn;		// return new Panel();		// return new JPanel();	}	public static VirtualTextArea createAWTTextArea(String text, int rows,			int cols) {		TextArea textArea = new TextArea(text, rows, cols);		VirtualTextArea toReturn = AWTTextArea.virtualTextArea(textArea);//		toReturn.init();		return toReturn;		// return new Panel();		// return new JPanel();	}	public static VirtualTextArea createAWTTextArea() {		TextArea textArea = new TextArea();		VirtualTextArea toReturn = AWTTextArea.virtualTextArea(textArea);//		toReturn.init();		return toReturn;		// return new Panel();		// return new JPanel();	}}