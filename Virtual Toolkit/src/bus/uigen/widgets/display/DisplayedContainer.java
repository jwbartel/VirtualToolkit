package bus.uigen.widgets.display;

public interface DisplayedContainer extends DisplayedComponent {

	// public String getName();
	//
	// public void setName(String name);
	//
	// public String getClassName();
	//
	// public void setClassName(String className);

	// public String getLayoutManagerClassName();
	//
	// public void setLayoutManagerClassName(String layoutManagerClassName);

	public String getLayout();

	public void setLayout(String layoutManagerToString);

	// public String getToString();
	//
	// public void setToString(String toString);

	public int getNumComponents();

	public void setNumComponents(int numComponents);

	// public int getWidth();
	//
	// public void setWidth(int width);
	//
	// public int getHeight();
	//
	// public void setHeight(int height);

}