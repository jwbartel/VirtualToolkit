package bus.uigen.widgets.events;

public class VirtualMouseEvent {

	public static final int MouseDown = 3;// SWT.MouseDown; //Value is 3
	public static final int MouseUp = 4;// SWT.MouseUp; //Value is 4
	public static final int MouseDoubleClick = 8;// SWT.MouseDoubleClick;
													// //Value is 8
	public static final int MouseClick = 101;
	public static final int MouseEnter = 6;// SWT.MouseEnter; //Value is 6
	public static final int MouseExit = 7;// SWT.MouseExit; //Value is 7
	public static final int MouseHover = 102;

	public static final int Mouse_Move = 5;// SWT.MouseMove; //value is 5
	public static final int Mouse_Drag = 102;

	// private java.awt.event.MouseEvent awtEvent;
	// private org.eclipse.swt.events.MouseEvent swtEvent;
	// private Component awtSource = new Button(); //just a filler object
	// private Widget swtWidget = new org.eclipse.swt.widgets.Button(new
	// Shell(), SWT.NONE); // just a filler object
	private int type;
	private long when = -1;
	private int modifiers;
	private int x = -1;
	private int y = -1;
	private int clickCount = 0;
	private int button;
	private boolean popUpTrigger = false;
	private Object loc;
	private Object point;
	private int xOnScreen = -1;
	private int yOnScreen = -1;
	private String paramString;

	public VirtualMouseEvent(int type) {
		this.type = type;

	}

	/*
	 * public VirtualMouseEvent(java.awt.event.MouseEvent awtEvent, int type){
	 * this.awtEvent = awtEvent; this.type = type; this.when =
	 * awtEvent.getWhen(); this.modifiers= awtEvent.getModifiers(); this.x =
	 * awtEvent.getX(); this.y = awtEvent.getY(); if(this.type ==
	 * VirtualMouseAdapter.MouseClick) clickCount = 1; if(this.type ==
	 * VirtualMouseAdapter.MouseDoubleClick) clickCount = 2; this.button =
	 * awtEvent.getButton(); this.popUpTrigger = awtEvent.isPopupTrigger(); }
	 * 
	 * public VirtualMouseEvent(org.eclipse.swt.events.MouseEvent swtEvent, int
	 * type){ this.swtEvent = swtEvent; this.type = type; this.when =
	 * swtEvent.time; this.modifiers = swtEvent.stateMask; this.x = swtEvent.x;
	 * this.y = swtEvent.y; if(this.type == VirtualMouseAdapter.MouseClick)
	 * clickCount = 1; if(this.type == VirtualMouseAdapter.MouseDoubleClick)
	 * clickCount = 2; this.button = swtEvent.button; }
	 */

	public int type() {
		return type;
	}

	public long when() {
		return when;
	}

	public void setWhen(long w) {
		when = w;
	}

	public int modifiers() {
		return this.modifiers;
	}

	public void setModifiers(int m) {
		modifiers = m;
	}

	public int getButton() {
		return this.button;
	}

	public void setButton(int b) {
		button = b;
	}

	public int getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(int c) {
		clickCount = c;
	}

	/*
	 * public Point getLocationOnScreen() throws PackageMismatchException{
	 * if(awtEvent == null) throw new PackageMismatchException(
	 * "Cannot call getLocationOnScreen() from the chosen toolkit"); return
	 * awtEvent.getLocationOnScreen(); }
	 */

	public Object getLocationOnScreen() {
		return loc;
	}

	public void setLocationOnScreen(Object l) {
		loc = l;
	}

	/*
	 * public static String getMouseModifiersText(int modifiers){ return
	 * java.awt.event.MouseEvent.getMouseModifiersText(modifiers); }
	 */

	/*
	 * public Point getPoint() throws PackageMismatchException{ if(awtEvent ==
	 * null) throw new
	 * PackageMismatchException("Cannot call getPoint() from the chosen toolkit"
	 * ); return awtEvent.getPoint(); }
	 */

	public Object getPoint() {
		return point;
	}

	public void setPoint(Object p) {
		point = p;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	/*
	 * public int getXOnScreen() throws PackageMismatchException{ if(awtEvent ==
	 * null) throw new
	 * PackageMismatchException("Cannot call getButton() from the chosen toolkit"
	 * ); return awtEvent.getXOnScreen(); }
	 */

	public int getXOnScreen() {
		return xOnScreen;
	}

	public void setXOnScreen(int x) {
		xOnScreen = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*
	 * public int getYOnScreen() throws PackageMismatchException{ if(awtEvent ==
	 * null) throw new
	 * PackageMismatchException("Cannot call getYOnScreen() from the chosen toolkit"
	 * ); return awtEvent.getYOnScreen(); }
	 */

	public int getYOnScreen() {
		return yOnScreen;
	}

	public void setYOnScreen(int y) {
		yOnScreen = y;
	}

	public boolean isPopupTrigger() {
		return popUpTrigger;
	}

	public void setIsPopupTrigger(boolean p) {
		popUpTrigger = p;
	}

	/*
	 * public String paramString() throws PackageMismatchException{ if(awtEvent
	 * == null) throw new
	 * PackageMismatchException("Cannot call paramString() from the chosen toolkit"
	 * ); return awtEvent.paramString(); }
	 */

	public String paramString() {
		return paramString;
	}

	public void setParamString(String p) {
		paramString = p;
	}

	/*
	 * public void translatePoint(int x, int y) throws PackageMismatchException{
	 * if(awtEvent == null) throw new PackageMismatchException(
	 * "Cannot call translatePoint() from the chosen toolkit");
	 * awtEvent.translatePoint(x, y); }
	 */

	/*
	 * public java.awt.event.MouseEvent getAWTMouseEvent(){ if(awtEvent!=null){
	 * return awtEvent; }else{ /*Component source = new Button(); //just a
	 * filler object int id = type; //Need to check for real way to set id in
	 * AWT long when = (long) swtEvent.time; int modifiers = swtEvent.stateMask;
	 * int x = swtEvent.x; int y = swtEvent.y; int clickCount = 0; if(type ==
	 * VirtualMouseAdapter.MouseClick) clickCount = 1; if(type ==
	 * VirtualMouseAdapter.MouseDoubleClick) clickCount = 2; boolean
	 * popUpTrigger = false; //check on popUpTrigger possibility in swt
	 * MouseEvent int button = swtEvent.button; return new
	 * java.awt.event.MouseEvent(awtSource, type, when, modifiers, x, y,
	 * clickCount, popUpTrigger, button); }
	 * 
	 * }
	 * 
	 * public org.eclipse.swt.events.MouseEvent getSWTMouseEvent(){ if(swtEvent
	 * != null){ return swtEvent; }else{ org.eclipse.swt.widgets.Event event =
	 * new org.eclipse.swt.widgets.Event(); event.type = type; event.button =
	 * button; event.count = clickCount; event.stateMask = modifiers; event.time
	 * = (int) when; event.x = x; event.y = y; event.widget = swtWidget;
	 * org.eclipse.swt.events.MouseEvent toReturn = new
	 * org.eclipse.swt.events.MouseEvent(event);
	 * 
	 * return toReturn; } }
	 */

	/*
	 * public int button() throws PackageMismatchException{ if(swtEvent == null)
	 * throw new
	 * PackageMismatchException("Cannot call button() from the chosen toolkit");
	 * return swtEvent.button; }
	 */

	/*
	 * public int x() throws PackageMismatchException{ if(swtEvent == null)
	 * throw new
	 * PackageMismatchException("Cannot call x() from the chosen toolkit");
	 * return swtEvent.x; }
	 */

	/*
	 * public int y() throws PackageMismatchException{ if(swtEvent == null)
	 * throw new
	 * PackageMismatchException("Cannot call y() from the chosen toolkit");
	 * return swtEvent.y; }
	 */

}