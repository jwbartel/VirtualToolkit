package bus.uigen.widgets.swt;

import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import bus.uigen.widgets.Painter;
import bus.uigen.widgets.VirtualContainer;
import bus.uigen.widgets.VirtualDelegatePanel;
import bus.uigen.widgets.awt.DelegatePanel;

public class SWTDelegatePanel extends SWTPanel implements VirtualDelegatePanel, PaintListener {
	
	SWTContainer container;
	ArrayList<Painter> painters = new ArrayList();
	SWTGraphic graphics;
	
	public SWTDelegatePanel (Composite thePanel) {
	
	//	VirtualContainer vc = virtualContainer(thePanel);
	//	super.addToParent(vc);
	}
	public SWTDelegatePanel() {
		graphics = new SWTGraphic();
	}
	
	public void setContainer(SWTContainer swtContainer)
	{
		container = swtContainer;
	}
	
	public void addPainter(Painter painter) {
		painters.add(painter);
	//	getDelegatePanel().addPainter(painter);
		//super.addPaintListener(painter.getVirtualGraphic());
	}
	
	public void paintControl(PaintEvent e)
	{
		graphics = new SWTGraphic(e);
		System.out.println("SWT paintControl!");
		//graphics = new SWTGraphic(e);
		for(int i = 0; i < painters.size(); i++)
		{
			painters.get(i).paint(graphics);
		}
		
	}
	
	public void removePainter(Painter painter) {
		if(painters.contains(painter))
		{
			painters.remove(painter);
		}
		
	//	getDelegatePanel().removePainter(painter);			
	}
	
	public DelegatePanel getDelegatePanel () {
		//return AnAWTComponent.virtualComponent(getScrollPane().getComponent(3));
		return (DelegatePanel) getPhysicalComponent();
	}
	
	public static SWTDelegatePanel virtualDelegatePanel (Control thePanel) {	
		SWTDelegatePanel retVal = (SWTDelegatePanel) SWTComponent.virtualComponent(thePanel);
		//retVal.setjpanel(jpanel);
		return retVal;
	}
	
	public void addToParent(VirtualContainer theParent) 
	{
		System.out.println("SWTDELEGATE addToParent");
	
		super.addToParent(theParent);
		this.getContainer().addPaintListener(this);

	}	

}
