import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class Problem4 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		Vector<Integer> v=new Vector<>();
		
		while(true) {
			System.out.print("강수량 입력 (0 입력시 종료)>>");
			int rain=in.nextInt();
			in.nextLine();
			if(rain==0) break;
			
			v.add(rain);
			
			int sum=0;
			
			Iterator<Integer> it=v.iterator();
			while(it.hasNext()) {
				int value=it.next();
				System.out.print(value+" ");
				sum+=value;
			}
			
			System.out.println();
			System.out.println("현재 평균 "+sum/v.size());
		}
	}

}
