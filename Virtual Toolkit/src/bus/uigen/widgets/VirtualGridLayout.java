package bus.uigen.widgets;

public interface VirtualGridLayout extends VirtualLayout {
	public static final String COMMAND_LABEL = "VIRTUALGRIDLAYOUT:";

	public int getColumns();

	public int getHgap();

	public int getRows();

	public int getVgap();

	public void setColumns(int cols);

	public void setHgap(int hgap);

	public void setRows(int rows);

	public void setVgap(int vgap);

}