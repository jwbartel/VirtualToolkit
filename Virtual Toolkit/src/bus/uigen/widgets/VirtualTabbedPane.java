package bus.uigen.widgets;

import javax.swing.event.ChangeListener;

public interface VirtualTabbedPane extends VirtualContainer {
	public void addTab(String label, VirtualComponent c);

	public void setTitleAt(int index, String label);

	public void setTabPlacement(int placement);
	
	public void setSelectedIndex(int index) ;
	public int getSelectedIndex();
	
	public int getTabCount() ;
	
	public void addChangeLisetner(Object aListener) ;

}
