package bus.uigen.widgets.events;

public class VirtualFocusEvent {

	public final static int Focus_gain = 15;// SWT.FocusIn;
	public final static int Focus_lost = 16;// SWT.FocusOut;

	private int type;
	private long when;

	public VirtualFocusEvent() {

	}

	public int id() {
		return type;
	}

	public long when() {
		return when;
	}

	public void setId(int id) {
		this.type = id;
	}

	public void setWhen(long w) {
		this.when = w;
	}

	public boolean isTemporary() {// throws PackageMismatchException{
		// if(awtComponent == null)
		// throw new
		// PackageMismatchException("Cannot call isTemporary() from the chosen toolkit");
		// return awtComponent.isTemporary();
		return false;
	}

	public Object getOppositeComponent() {
		// if(awtComponent!=null){
		// return awtComponent.getOppositeComponent();
		// }else{
		return null;
		// }
	}

	public String paramString() {// throws PackageMismatchException{
		// if(awtComponent == null)
		// throw new
		// PackageMismatchException("Cannot call paramString() from the chosen toolkit");
		// return awtComponent.paramString();
		return null;
	}

	public int type() {
		return type;
	}

}