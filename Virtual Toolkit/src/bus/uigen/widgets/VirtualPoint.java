package bus.uigen.widgets;

public class VirtualPoint {
	private int x, y;
	
	public VirtualPoint(){
		x = 0;
		y = 0;
	}
	
	public VirtualPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public VirtualPoint(VirtualPoint p){
		this.x = p.x;
		this.y = p.y;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof VirtualPoint){
			VirtualPoint p = (VirtualPoint) obj;
			return p.x == x && p.y == y;
		}
		return false;
	}
	
	public VirtualPoint getLocation(){
		return new VirtualPoint(this);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(double x, double y){
		this.x = (int) x;
		this.y = (int) y;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(VirtualPoint p){
		this.x = p.x;
		this.y = p.y;
	}
	
	@Override
	public String toString(){
		return this.getClass().getName()+"[x="+x+",y="+y+"]";
	}
}
