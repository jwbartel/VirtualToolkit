package test;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public class TestSWTMouseListener implements MouseListener{
	
	public void mouseUp(MouseEvent e){
		//System.out.println("TestSWTMouseListener up");
	}
	
	public void mouseDown(MouseEvent e){
		//System.out.println("TestSWTMouseListener down");
	}
	
	public void mouseDoubleClick(MouseEvent e){
		System.out.println("TestSWTMouseListener double click");
	}
}