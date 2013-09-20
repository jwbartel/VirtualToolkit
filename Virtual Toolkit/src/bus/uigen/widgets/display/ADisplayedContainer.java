package bus.uigen.widgets.display;

import java.util.ArrayList;
import java.util.List;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;

public class ADisplayedContainer extends ADisplayedComponent implements
		DisplayedContainer {
	// VirtualComponent component;
	VirtualContainer container;
	// String name;
	// String className;
	String layoutManagerClassName = "";
	String layoutManagerToString;
	String toString = "";
	int numComponents;
	// int width;
	List<DisplayedComponent> children = new ArrayList<DisplayedComponent>();

	// public String getName() {
	// return name;
	// }
	// public void setName(String name) {
	// this.name = name;
	// }
	// public String getClassName() {
	// return className;
	// }
	// public void setClassName(String className) {
	// this.className = className;
	// }
	// public String getLayoutManagerClassName() {
	// return layoutManagerClassName;
	// }
	// public void setLayoutManagerClassName(String layoutManagerClassName) {
	// this.layoutManagerClassName = layoutManagerClassName;
	// }

	public boolean preGetLayout() {
		return layoutManagerToString != null;
	}

	public String getLayout() {
		return layoutManagerToString;
	}

	public void setLayout(String layoutManagerToString) {
		this.layoutManagerToString = layoutManagerToString;
	}

	// public String getToString() {
	// return toString;
	// }
	// public void setToString(String toString) {
	// this.toString = toString;
	// }
	// public boolean preGetNumComponents() {
	// return container != null;
	// }
	public int getNumComponents() {
		return numComponents;
	}

	public void setNumComponents(int numComponents) {
		this.numComponents = numComponents;
	}

	// public int getWidth() {
	// return width;
	// }
	// public void setWidth(int width) {
	// this.width = width;
	// }
	// public int getHeight() {
	// return height;
	// }
	// public void setHeight(int height) {
	// this.height = height;
	// }
	// int height;
	public ADisplayedContainer(VirtualComponent theComponent) {
		super(theComponent);
		// component = theComponent;
		// setSelfAttributes();
		// if (component instanceof VirtualContainer) {
		container = (VirtualContainer) component;
		// setChildrenAttributes();
		// }

	}

	public ADisplayedContainer(VirtualContainer theComponent) {
		super(theComponent);
		// component = theComponent;
		// setSelfAttributes();
		// if (component instanceof VirtualContainer) {
		container = (VirtualContainer) component;
		setChildrenAttributes();
		// }

	}

	// void setSelfAttributes() {
	// name = component.getName();
	// toString = component.toString();
	// className = component.getClass().getSimpleName();
	// height = component.getHeight();
	// width = component.getWidth();
	// }

	void setChildrenAttributes() {
		children.clear();
		// layoutManagerClassName =
		// container.getLayout().getClass().getSimpleName();
		Object layoutManager = container.getLayout();
		if (layoutManager != null)
			layoutManagerToString = container.getLayout().toString();
		// else
		// layoutManagerToString = "";
		numComponents = container.getComponentCount();
		VirtualComponent[] componentArray = container.getComponents();
		for (int i = 0; i < componentArray.length; i++) {
			VirtualComponent virtualComponent = componentArray[i];
			DisplayedComponent displayedComponent = null;
			if (virtualComponent instanceof VirtualContainer)
				displayedComponent = new ADisplayedContainer(
						(VirtualContainer) virtualComponent);
			else
				displayedComponent = new ADisplayedComponent(virtualComponent);

			children.add(displayedComponent);
		}
	}

	public int size() {
		return children.size();
	}

	public DisplayedComponent get(int i) {
		return children.get(i);
	}

	public void reload() {
		// setSelfAttributes();
		super.reload();
		setChildrenAttributes();
	}

}
