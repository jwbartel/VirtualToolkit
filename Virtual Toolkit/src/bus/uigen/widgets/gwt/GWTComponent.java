package bus.uigen.widgets.gwt;

import java.util.ArrayList;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDimension;
import bus.uigen.widgets.VirtualPoint;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

import com.google.gwt.user.client.ui.Widget;

public abstract class GWTComponent implements VirtualComponent {
	protected Object component;
	protected String ID;

	ArrayList<Object> mouseListeners = new ArrayList<Object>();
	ArrayList<Object> mouseMoveListeners = new ArrayList<Object>();
	ArrayList<Object> focusListeners = new ArrayList<Object>();
	VirtualContainer parent;

	public GWTComponent() {

	}

	public GWTComponent(Widget theWidget) {
		// super (theWidget);
		component = theWidget;

	}

	public Widget getWidget() {
		return (Widget) component;
	}

	public void init() {

	}

	@Override
	public void addKeyListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPaintListener(Object g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToParent(VirtualContainer theParent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doLayout() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getBackground() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualDimension getMinimumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VirtualContainer getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPhysicalComponent() {
		return component;
	}

	@Override
	public VirtualDimension getPreferredSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFocusListener(Object Listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseListener(Object Listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMouseMoveListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void revalidate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignmentX(float x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignmentY(float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBackground(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setForeground(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBorder(Object border) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBounds(int newX, int newY, int newWidth, int newHeight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCursor(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCursor(int newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocation(int newX, int newY) {
		// TODO Auto-generated method stub

	}

	public void setLocation(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void setMaximumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(VirtualContainer theParent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreferredSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	public void setSize(int width, int height) {
		execSetSize(width, height);
		if (VirtualToolkit.isDistributedByDefault()) {
			String widgetID = this.getName();
			VirtualToolkit.sendCommandByDefault(VirtualContainer.COMMAND_LABEL
					+ widgetID + SET_SIZE_COMMAND + width + "," + height + ")");
		}

	}

	public void execSetSize(int width, int height) {
		getWidget().setPixelSize(width, height);
	}

	@Override
	public void setSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisible(boolean newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public Object getFont() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getFontMetrics(Object f) {
		return null;
	}

	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToolTipText(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualDimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VirtualDimension getMaximumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(Object c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserObject(Object newVal) {
		// TODO Auto-generated method stub

	}

	public void setHorizontalAlignment(int x) {
		/*
		 * if(getWidget().getParent() instanceof HasHorizontalAlignment){ if(x
		 * == SwingConstants.LEFT){ ((HasHorizontalAlignment)
		 * getWidget().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT); }else
		 * if(x == SwingConstants.RIGHT){ ((HasHorizontalAlignment)
		 * getWidget().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT); }else
		 * if(x == SwingConstants.CENTER){ ((HasHorizontalAlignment)
		 * getWidget().
		 * getParent()).setHorizontalAlignment(HasHorizontalAlignment
		 * .ALIGN_CENTER); }else{ ((HasHorizontalAlignment)
		 * getWidget().getParent
		 * ()).setHorizontalAlignment(HasHorizontalAlignment.ALIGN_DEFAULT); } }
		 */
	}

	public void setVerticalAlignment(int alignment) {
		/*
		 * if(getWidget().getParent() instanceof HasVerticalAlignment){
		 * if(alignment == SwingConstants.BOTTOM){ ((HasVerticalAlignment)
		 * getWidget
		 * ().getParent()).setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM
		 * ); }else if(alignment == SwingConstants.CENTER){
		 * ((HasVerticalAlignment)
		 * getWidget().getParent()).setVerticalAlignment(
		 * HasVerticalAlignment.ALIGN_MIDDLE); }else if(alignment ==
		 * SwingConstants.TOP){ ((HasVerticalAlignment)
		 * getWidget().getParent()).
		 * setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP); }else{
		 * ((HasVerticalAlignment)
		 * getWidget().getParent()).setVerticalAlignment(
		 * HasVerticalAlignment.ALIGN_MIDDLE); } }
		 */
	}

	@Override
	public void addFocusListener(VirtualFocusListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		// TODO Auto-generated method stub

	}

	public void addMouseTrackListener(VirtualMouseListener listener) {
		addMouseListener(listener);
	}

	@Override
	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
		// TODO Auto-generated method stub

	}

	public boolean isDisposed() {
		return true;
	}

	public String getName() {
		return ID;
	}

	public void setName(String newVal) {
		String oldName = this.ID;
		execSetName(newVal);

		String command = VirtualComponent.COMMAND_LABEL + oldName
				+ VirtualComponent.SET_NAME_COMMAND + ID + ")";
		VirtualToolkit.sendCommandByDefault(command);
	}

	public void execSetName(String newVal) {
		VirtualToolkit.defaultReassociate(ID, newVal, this);
		this.ID = newVal;
	}

	public void addMouseListener(Object listener) {

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VirtualPoint getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}