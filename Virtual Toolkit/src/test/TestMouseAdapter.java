package test;

import bus.uigen.widgets.events.VirtualMouseEvent;
import bus.uigen.widgets.events.VirtualMouseListener;

public class TestMouseAdapter implements VirtualMouseListener{
	public void mouseClicked(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter clicked");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseExited(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter exited");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseExit(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter exit");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseEntered(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter entered");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseEnter(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter enter");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mousePressed(VirtualMouseEvent e){
		try{
			//System.out.println("TestMouseAdapter pressed");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseDown(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter down");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseReleased(VirtualMouseEvent e){
		try{
			//System.out.println("TestMouseAdapter released");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseUp(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter up");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseDoubleClick(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter double clicked");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void mouseHover(VirtualMouseEvent e){
		try{
			System.out.println("TestMouseAdapter hover");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}