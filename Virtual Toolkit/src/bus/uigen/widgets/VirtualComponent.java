package bus.uigen.widgets;

import bus.uigen.widgets.events.VirtualFocusListener;
import bus.uigen.widgets.events.VirtualMouseListener;
import bus.uigen.widgets.events.VirtualMouseMoveListener;

public interface VirtualComponent extends UniversalWidget {
	public static final String COMMAND_LABEL = "VIRTUALCOMPONENT:";
	public static final String SET_SIZE_COMMAND = ".setSize(";
	public static final String SET_NAME_COMMAND = ".setName(";

	public void init();

	// public void init (Object c);
	// public void init (Component c);
	public VirtualContainer getParent();

	public Object getPhysicalComponent();

	public void setParent(VirtualContainer theParent);

	public void addToParent(VirtualContainer theParent);

	public void invalidate();

	public void repaint();

	public void doLayout();

	public void setBackground(Object newVal);

	public void setForeground(Object newVal);

	// public void setBackground(Color newVal);
	public Object getBackground();

	// public void addMouseListener (Object mouseListener);
	public void setEnabled(boolean newVal);

	public void setMaximumSize(VirtualDimension d);

	public void validate();

	public void revalidate();

	public void setVisible(boolean newVal);

	public void setSize(int newWidth, int newHeight);

	public void execSetSize(int width, int height);

	public void setBounds(int newX, int newY, int newWidth, int newHeight);

	public VirtualDimension getMinimumSize();

	public VirtualDimension getMaximumSize();

	public int getHeight();

	public int getWidth();

	public void setSize(VirtualDimension d);

	// public void setSize(Dimension d);
	public void setMinimumSize(VirtualDimension d);

	// public void setMinimumSize(Dimension d);
	public void setAlignmentX(float x);

	public void setAlignmentY(float y);

	public void setPreferredSize(VirtualDimension d);

	// public void setPreferredSize(Dimension d);
	public void resize(int width, int height);

	public VirtualDimension getSize();

	public void setCursor(Object newVal);

	// public void setCursor(Cursor newVal);
	public void setCursor(int newVal);

	public void setLocation(int newX, int newY);

	public void setLocation(Object newVal);

	public int getX();

	public int getY();

	public VirtualPoint getLocation();

	public String getName();

	public void setName(String newVal);

	public void execSetName(String newVal);

	public boolean isVisible();

	public VirtualDimension getPreferredSize();

	public void setBorder(Object border);

	// public void setBorder(Border border);
	// public void setToolTipText(String s);
	// public void addFocusListener(Object listener);
	// public void addFocusListener(FocusListener listener);
	public void addKeyListener(Object listener);

	// public void addKeyListener(KeyListener listener);

	public void addMouseListener(VirtualMouseListener listener);

	public void addMouseListener(Object listener);

	public void addMouseTrackListener(VirtualMouseListener listener);

	public void addMouseMoveListener(VirtualMouseMoveListener listener);

	public void removeMouseListener(Object Listener);

	public void removeMouseMoveListener(Object listener);

	public void addFocusListener(VirtualFocusListener listener);

	public void removeFocusListener(Object Listener);

	public void addPaintListener(Object g);

	// public void addPaintListener(VirtualGraphic g);

	public void pack();

	/*
	 * public void setFont(Font f); public Font getFont();
	 */

	public boolean isDisposed();

}
