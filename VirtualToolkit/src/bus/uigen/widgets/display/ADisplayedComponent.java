package bus.uigen.widgets.display;

import bus.uigen.widgets.VirtualComponent;

public class ADisplayedComponent implements DisplayedComponent {
	VirtualComponent component;
	// VirtualContainer container;
	String name;
	String className;
	// String layoutManagerClassName = "";
	// String layoutManagerToString = "";
	String toString = "";
	// int numComponents ;
	int width;

	// List<DisplayedComponent> children = new ArrayList();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	// public String getLayoutManagerClassName() {
	// return layoutManagerClassName;
	// }
	// public void setLayoutManagerClassName(String layoutManagerClassName) {
	// this.layoutManagerClassName = layoutManagerClassName;
	// }
	// public boolean preGetLayout() {
	// return container != null;
	// }
	// public String getLayout() {
	// return layoutManagerToString;
	// }
	// public void setLayout(String layoutManagerToString) {
	// this.layoutManagerToString = layoutManagerToString;
	// }
	// public String getToString() {
	// return toString;
	// }
	// public void setToString(String toString) {
	// this.toString = toString;
	// }
	// public boolean preGetNumComponents() {
	// return container != null;
	// }
	// public int getNumComponents() {
	// return numComponents;
	// }
	// public void setNumComponents(int numComponents) {
	// this.numComponents = numComponents;
	// }
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	int height;

	public ADisplayedComponent(VirtualComponent theComponent) {
		component = theComponent;
		setSelfAttributes();
		// if (component instanceof VirtualContainer) {
		// container = (VirtualContainer) component;
		// setChildrenAttributes();
		// }

	}

	void setSelfAttributes() {
		name = component.getName();
		toString = component.toString();
		className = component.getClass().getSimpleName();
		height = component.getHeight();
		width = component.getWidth();
	}

	// void setChildrenAttributes() {
	// children.clear();
	// layoutManagerClassName =
	// container.getLayout().getClass().getSimpleName();
	// layoutManagerToString = container.getLayout().toString();
	// numComponents = container.getComponentCount();
	// VirtualComponent[] componentArray = container.getComponents();
	// for (int i = 0; i < componentArray.length; i++) {
	// DisplayedComponent displayedComponent = new
	// ADisplayedComponent(componentArray[i]);
	// children.add(displayedComponent);
	// }
	// }
	//
	// public int size() {
	// return children.size();
	// }
	// public DisplayedComponent get(int i) {
	// return children.get(i);
	// }
	public void reload() {
		setSelfAttributes();
		// setChildrenAttributes();
	}

}
