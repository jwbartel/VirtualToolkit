package bus.uigen.widgets;

import javax.swing.event.ChangeListener;

public interface VirtualTabbedPane extends VirtualContainer {
	public void addTab(String label, VirtualComponent c);
	void addTab(String title, Object icon, VirtualComponent component, String tip);

	public void setTitleAt(int index, String label);

	public void setTabPlacement(int placement);
	
	public void setSelectedIndex(int index) ;
	public int getSelectedIndex();
	
	public int getTabCount() ;
	
	public void addChangeListener(Object aListener) ;

}
