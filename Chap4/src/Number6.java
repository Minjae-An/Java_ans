import java.util.Scanner;

// &Number5

class Circle{
	private double x,y;
	private int radius;
	
	public Circle(double x, double y, int radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	
	public void show() {
		System.out.println("("+x+","+y+")"+radius);
	}
}


public class Number6 {
	public static void main(String []args) {
		Scanner scanner=new Scanner(System.in);
		Circle c[]=new Circle[3];
		
		for(int i=0; i<c.length; i++) {
			System.out.print("x, y, radius>>");
			double x=scanner.nextDouble();
			double y=scanner.nextDouble();
			int radius=scanner.nextInt();
			c[i]=new Circle(x, y, radius);
		}
		
//		for(int i=0; i<c.length; i++) c[i].show();
		// Number5 answer
		double maxArea=0;
		int index=0;
		
		for(int i=0; i<c.length; i++) {
			if(maxArea<c[i].getArea()) {
				maxArea=c[i].getArea();
				index=i;
			}
		}
		
		System.out.print("가장 면적이 큰 원은 ");
		c[index].show();
		//Number6 answer
		
		scanner.close();
	}

}
