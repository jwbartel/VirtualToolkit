package bus.uigen.widgets.awt;

import java.awt.Event;
import java.awt.MenuComponent;

import bus.uigen.widgets.VirtualMenuComponent;
import bus.uigen.widgets.VirtualMenuContainer;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public abstract class AWTMenuComponent extends CentralUniversalWidget implements
		VirtualMenuComponent {
	// MenuComponent component;
	VirtualMenuContainer parent;

	public AWTMenuComponent(MenuComponent initVal) {
		super(initVal);
		// component = initVal;
	}

	public AWTMenuComponent() {

	}

	/*
	 * public void init (Object val) { component = (MenuComponent) val; }
	 */
	MenuComponent getMenuComponent() {
		return (MenuComponent) component;
	}

	public Object getPhysicalComponent() {
		return component;
	}

	/*
	 * public Object getParent() { return menuComponent.getParent(); }
	 */
	@SuppressWarnings("deprecation")
	public void postEvent(Event event) {
		getMenuComponent().postEvent(event);
	}

	public void setParent(VirtualMenuContainer theParent) {
		parent = theParent;
	}

	public VirtualMenuContainer getParent() {
		return parent;
		// return (VirtualMenu)
		// AUniversalWidget.universalWidget(menuComponent.getParent());
	}

	public static AWTMenuComponent virtualMenuComponent(
			MenuComponent theMenuComponent) {
		return (AWTMenuComponent) CentralUniversalWidget
				.universalWidget(theMenuComponent);
	}

	/*
	 * static transient Hashtable<MenuComponent, AnAWTMenuComponent>
	 * MenuComponentsToVirtualMenuComponents = new Hashtable();
	 * 
	 * public static AnAWTMenuComponent virtualMenuComponent (MenuComponent
	 * theMenuComponent) { if (theMenuComponent == null) return null;
	 * AnAWTMenuComponent vc =
	 * MenuComponentsToVirtualMenuComponents.get(theMenuComponent); if (vc ==
	 * null) {
	 * 
	 * vc = new AnAWTMenuComponent (theMenuComponent);
	 * MenuComponentsToVirtualMenuComponents.put(theMenuComponent, vc); } return
	 * vc;
	 * 
	 * }
	 */
	@Override
	public Object getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolTipText(String s) {
		// TODO Auto-generated method stub

	}

}
