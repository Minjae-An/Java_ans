import java.util.Scanner;

class Add{
	private int a,b;
	
	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	public int calculate() {
		return a+b;
	}
}

class Sub{
	private int a,b;
	
	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	public int calculate() {
		return a-b;
	}
}

class Mul{
	private int a,b;
	
	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	public int calculate() {
		return a*b;
	}
}

class Div{
	private int a,b;
	
	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	public int calculate() {
		return a/b;
	}
}

public class Number11 {
	public static void main(String []args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>>");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		String operator=scanner.next();
		
		switch(operator.charAt(0)) {
		case '+':
			Add adder=new Add();
			adder.setValue(a, b);
			System.out.print(adder.calculate());
			break;
			
		case '-':
			Sub subber=new Sub();
			subber.setValue(a,b);
			System.out.print(subber.calculate());
			break;
			
		case '*':
			Mul multiplyer=new Mul();
			multiplyer.setValue(a, b);
			System.out.print(multiplyer.calculate());
			break;
			
		case '/':
			Div divisor=new Div();
			divisor.setValue(a, b);
			System.out.print(divisor.calculate());
			break;
		}
		
		scanner.close();
	}

}
