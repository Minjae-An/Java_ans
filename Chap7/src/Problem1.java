import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Problem1 {
	public static void main(String []args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("정수(-1이 입력될 때까지)>> ");
		Vector<Integer> v=new Vector<>();
		
		while(true) {
			try {
				int n=scanner.nextInt();
				if(n==-1) break;
				v.add(n);
			}
			catch(Exception e) {
				e.getStackTrace();
				break;
			}
		}
		
		System.out.print("가장 큰 수는 "+Collections.max(v));
		scanner.close();
	}
}
