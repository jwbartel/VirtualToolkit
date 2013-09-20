package bus.uigen.widgets.test.general;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class TestAWTMouseListener implements MouseListener{
	
	public void mouseClicked(MouseEvent e){
		System.out.println("TestAWTMouseListener clicked");
	}
	
	public void mouseExited(MouseEvent e){
		//System.out.println("TestAWTMouseListener exited");
	}
	
	public void mouseEntered(MouseEvent e){
		//System.out.println("TestAWTMouseListener entered");
	}
	
	public void mousePressed(MouseEvent e){
		//System.out.println("TestAWTMouseListener pressed");
	}
	
	public void mouseReleased(MouseEvent e){
		//System.out.println("TestAWTMouseListener released");
	}
}