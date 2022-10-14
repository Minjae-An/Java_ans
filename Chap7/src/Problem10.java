import java.util.Scanner;
import java.util.Vector;

abstract class Shape{
	abstract void paint();
}

class Line extends Shape{
	
	@Override
	public void paint() {
		System.out.println("Line");
	}
}

class Circle extends Shape{
	
	@Override
	public void paint() {
		System.out.println("Circle");
	}
}

class Rect extends Shape{
	
	@Override
	public void paint() {
		System.out.println("Rect");
	}
}

class GraphicEditor{
	private Vector<Shape> v;
	private Scanner in;
	
	public GraphicEditor() {
		v=new Vector<>();
		in=new Scanner(System.in);
	}
	
	public void insert(Shape s) {
		v.add(s);
	}
	
	public boolean deleteShape(int index) {
		if(index<0 || index>v.size()-1) return false;
		else {
			v.remove(index);
			return true;
		}
	}
	
	public void showAll() {
		for(Shape s:v)
			s.paint();
	}
	
	public void run() {
		System.out.println("그래픽 에디터 beauty를 실행합니다.");
		
		boolean finish=false;
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			int menu=in.nextInt();
			in.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int menu2=in.nextInt();
				in.nextLine();
				
				switch(menu2) {
				case 1: insert(new Line()); break;
				case 2: insert(new Rect()); break;
				case 3: insert(new Circle()); break;
				}
				
				break;
				
			case 2:
				System.out.print("삭제할 도형의 위치>>");
				int index=in.nextInt();
				in.nextLine();
				if(!deleteShape(index)) System.out.println("삭제할 수 없습니다.");
				break;
				
			case 3:
				showAll();
				break;
				
			case 4:
				finish=true;
				break;
			}
			
			if(finish) {
				System.out.println("beauty를 종료합니다.");
				break;
			}
		}
		
	}
}

public class Problem10 {
	public static void main(String []args) {
		GraphicEditor ge=new GraphicEditor();
		ge.run();
	}

}
