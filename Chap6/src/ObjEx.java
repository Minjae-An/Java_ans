import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point{
	private int x,y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+"("+x+","+y+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		Point po=(Point)obj;
		if(this.x==po.x && this.y==po.y) return true;
		else return false;
	}
}

public class ObjEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getPackageName());
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		System.out.println(obj);
	}
	
	public static void main(String []args) {
//		Point p=new Point(2,3);
//		//print(p);
//		//print("hello");
//		System.out.println(p.equals(new Point(5,2)));
		
//		Scanner scanner=new Scanner(System.in);
//		System.out.print(">>");
//		String line=scanner.nextLine();
//		StringTokenizer st=new StringTokenizer(line, "&=");
//		System.out.println(st.countTokens());
//		
//		while(st.hasMoreTokens()) {
//			String token=st.nextToken();
//			System.out.println(token);
//		}
		
		Calendar c=Calendar.getInstance();
		System.out.print("현재 시간은 ");
		System.out.print(c.get(Calendar.YEAR)+"년 ");
		System.out.print(c.get(Calendar.MONTH)+1+"월 ");
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+"일");
		
		
		
	}
}
