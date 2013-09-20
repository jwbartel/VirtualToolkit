package bus.uigen.widgets.forwarder;

import java.awt.FontMetrics;

import bus.uigen.widgets.VirtualComponent;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDimension;
import bus.uigen.widgets.VirtualPoint;
import bus.uigen.widgets.VirtualToolkit;
import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;
import bus.uigen.widgets.universal.CentralUniversalWidget;

public abstract class ForwarderComponent extends CentralUniversalWidget
		implements VirtualComponent {

	@Override
	public void setToolTipText(String s) {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "setToolTipText("
		// + s + ")");
	}

	@Override
	public void setFont(Object f) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getFont() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FontMetrics getFontMetrics(Object f) {
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public VirtualContainer getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPhysicalComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	VirtualContainer parent;

	@Override
	public void setParent(VirtualContainer theParent) {
		this.parent = theParent;
	}

	@Override
	public void addToParent(VirtualContainer theParent) {
		parent.execAdd(this);
	}

	@Override
	public void invalidate() {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "invalidate()");
	}

	@Override
	public void repaint() {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "repaint()");
	}

	@Override
	public void doLayout() {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "doLayout()");
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
	public Object getBackground() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnabled(boolean newVal) {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "setEnabled(" +
		// newVal + ")");
	}

	@Override
	public void setMaximumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate() {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "validate()");
	}

	@Override
	public void revalidate() {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "revalidate()");
	}

	@Override
	public void setVisible(boolean newVal) {
		if (VirtualToolkit.isDistributedByDefault()) {
			// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + getName() +
			// ".setVisible(" + newVal + ")");
		}
	}

	int width, height;

	@Override
	public void setSize(int newWidth, int newHeight) {
		if (VirtualToolkit.isDistributedByDefault()) {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + this.getName()
					+ SET_SIZE_COMMAND + newWidth + "," + newHeight + ")");
		}
		execSetSize(newWidth, newHeight);
	}

	@Override
	public void execSetSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void setBounds(int newX, int newY, int newWidth, int newHeight) {
		/*
		 * VirtualToolkit.sendCommandByDefault( COMMAND_LABEL + "setBounds(" +
		 * newX + "," + newY + "," + newWidth + "," + newHeight + ")" );
		 */

	}

	@Override
	public VirtualDimension getMinimumSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMinimumSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlignmentX(float x) {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "setAlignmentX("
		// + x + ")");
	}

	@Override
	public void setAlignmentY(float y) {
		// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + "setAlignmentY("
		// + y + ")");
	}

	@Override
	public void setPreferredSize(VirtualDimension d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// VirtualToolkit.sendCommandByDefault( COMMAND_LABEL + "resize(" +
		// width + "," + height + ")" );
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
	public void setCursor(Object newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCursor(int newVal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocation(int newX, int newY) {
		// VirtualToolkit.sendCommandByDefault( COMMAND_LABEL + "setLocation(" +
		// newX + "," + newY + ")" );
	}

	@Override
	public void setLocation(Object newVal) {
		// TODO Auto-generated method stub

	}

	String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String newVal) {
		if (VirtualToolkit.isDistributedByDefault()) {
			VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + this.getName()
					+ SET_NAME_COMMAND + newVal + ")");
		}
		execSetName(newVal);
	}

	@Override
	public void execSetName(String newVal) {
		String oldVal = this.name;
		this.name = newVal;
		VirtualToolkit.defaultReassociate(oldVal, newVal, this);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VirtualDimension getPreferredSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBorder(Object border) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addKeyListener(Object listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseTrackListener(VirtualMouseListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
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
	public void addFocusListener(VirtualFocusListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFocusListener(Object Listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPaintListener(Object g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pack() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
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
