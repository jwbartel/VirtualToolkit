package test;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class TestSWT {
	public static void main (String args[]){
		final Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setText("Canvas Example");
	    shell.setLayout(new FillLayout());
	   
	    Canvas canvas = new Canvas(shell, SWT.NONE);

	    canvas.addPaintListener(new PaintListener() {
	      public void paintControl(PaintEvent e) {
	    	  Display display2 = e.display;
	    /*	  Font font = new Font(display2,"Arial",24,SWT.BOLD | SWT.ITALIC); 
	    	  e.gc.setFont(font);
	    	  e.gc.drawString("Hello!", 5, 5);
	    	  font = new Font(display2,"Arial",24,SWT.BOLD + SWT.ITALIC); 
	    	  e.gc.setFont(font);
	    	  e.gc.drawString("Hello!", 45, 45);
	    	//  e.gc.draw
	      //  e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_RED));
	     //   e.gc.fillRectangle(30, 40, 400, 200);
	    	  e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_RED));
	    	  e.gc.fillOval(100,100,40,40);
	    	  e.gc.setLineStyle(SWT.LINE_DASH);
	    	  e.gc.drawRectangle(150,150, 40,40);
	    	  e.gc.setLineStyle(SWT.LINE_DOT);
	    	  e.gc.drawRectangle(250,250, 40,40);
	    	  e.gc.setLineStyle(SWT.LINE_DASHDOT);
	    	  e.gc.drawRectangle(350,350, 40,40);*/
	    	  
	    	  e.gc.drawRectangle(10,10,100,100);
	    	  Device dev = display.getCurrent();
	    	  Color newColor = new Color(dev, 0, 0, 0);
	    	  e.gc.setBackground(newColor);
	      }
	    });

	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }
	    //
}

