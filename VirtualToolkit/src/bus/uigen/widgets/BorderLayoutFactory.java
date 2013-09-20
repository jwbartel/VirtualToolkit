package bus.uigen.widgets;

public class BorderLayoutFactory implements LayoutManagerFactory {
	// static int id;
	public Object createLayoutManager() {
		/*
		 * Container panel = new JPanel(); panel.setName("" + getNewID());
		 * //panel.setBackground(Color.white); return panel; //return new
		 * Panel(); //return new JPanel();
		 */
		return createBorderLayout();
	}

	public static Object createBorderLayout() {
		// LayoutManager layout = new BorderLayout();
		// layout.setName("" + getNewID());
		// panel.setBackground(Color.white);

		return null;

		// return layout;
		// return new Panel();
		// return new JPanel();
	}

}
