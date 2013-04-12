package bus.uigen.widgets.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import bus.uigen.widgets.VirtualGraphic;
import bus.uigen.widgets.VirtualGraphicObject;

public class SWTGraphic implements VirtualGraphic{
//	ArrayList<VirtualGraphicObject> drawnElements = new ArrayList<VirtualGraphicObject>();
	PaintEvent pEvent;

	
	public SWTGraphic(PaintEvent paintEvent)
	{
		
		pEvent = paintEvent;
//		pEvent.gc.setBackground(pEvent.display.getSystemColor(SWT.COLOR_BLACK));
	}
	
	public SWTGraphic() {
		
	}

	public void paintControl(PaintEvent e){
/*		
		for(int i=0; i<drawnElements.size(); i++){
			paintObject(e.gc, drawnElements.get(i));
		}
	*/	
	}
	
	public void setPaintEvent(PaintEvent paintEvent)
	{
		pEvent = paintEvent;
	}
	
	public void drawLine(int x1, int y1, int x2, int y2) {
		pEvent.gc.drawLine(x1,y1,x2,y2);
		// TODO Auto-generated method stub
		
	}

	public void drawOval(int x1, int y1, int width, int height) {
		pEvent.gc.drawOval(x1, y1, width, height);
		
	}

	public void drawRectangle(int x1, int y1, int width, int height) {
		pEvent.gc.drawRectangle(x1, y1, width, height);
		
	}

	public void setColor(float r, float g, float b, float a) {
		// TODO Auto-generated method stub
		
	}

	public void setColor(int r, int g, int b) {
		// TODO Auto-generated method stub
		Device dev = Display.getCurrent();
		Color col = new Color(dev,r,g,b);
		pEvent.gc.setForeground(col);
		pEvent.gc.setBackground(col);
		
	}

	public void fill(VirtualGraphicObject vo) {
		vo.fill(pEvent.gc);
	}

	public void setLineWidth(int thickness) {
		pEvent.gc.setLineWidth(thickness);
	}

	public void setDashed(int thickness) {
		// TODO Auto-generated method stub
		pEvent.gc.setLineStyle(SWT.LINE_DASH);
		 setLineWidth(thickness);
	}

	public void setDotted(int thickness) {
		// TODO Auto-generated method stub
		pEvent.gc.setLineStyle(SWT.LINE_DOT);
		setLineWidth(thickness);
	}

	public void setSolid(int thickness) {
		// TODO Auto-generated method stub
		pEvent.gc.setLineStyle(SWT.LINE_SOLID);
		setLineWidth(thickness);
	}

	public void setFont(String fontName, String[] params, int size) {
		
		if (params.length > 0)
		{
			int paramsInt = 0;
			for (String currentParam: params)
			{
				System.out.println(currentParam);
				currentParam = currentParam.toLowerCase();
				System.out.println(currentParam);
				if (currentParam.equals("italic"))
					paramsInt+= SWT.ITALIC;
				else if (currentParam.equals("bold"))
					paramsInt+= SWT.BOLD;
				
				else if (currentParam.equals("normal"))
					paramsInt+= SWT.NORMAL;
				
			}
		//	pEvent.gc.setFont(font);
			
			Font currentFont = new Font(pEvent.display, fontName, size, paramsInt);
			System.out.println(paramsInt);
			pEvent.gc.setFont(currentFont);
//			Font font = new Font();
//			Font font = new Font(pEvent.display,"Arial",14,SWT.BOLD | SWT.ITALIC); 
//			pEvent.gc.setFont(font);
		}	
		
	}
	
	public void drawString(String text, int x, int y)
	{
		pEvent.gc.drawString(text, x, y);
	}

	

	
}