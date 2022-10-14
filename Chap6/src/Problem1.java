
class MyPoint{
	private int x;
	private int y;
	
	public MyPoint(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	@Override
	public boolean equals(Object obj) {
		MyPoint p=(MyPoint)obj;
		
		if(this.x==p.getX() && this.y==p.getY()) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "Point("+this.x+","+this.y+")";
	}
}

public class Problem1 {
	public static void main(String []args) {
		MyPoint p=new MyPoint(3,50);
		MyPoint q=new MyPoint(4,50);
		System.out.println(p);
		
		if(p.equals(q))
			System.out.println("같은 점");
		else
			System.out.println("다른 점");
	}

}
