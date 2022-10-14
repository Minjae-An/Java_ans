import java.util.Calendar;
import java.util.Scanner;

public class Problem6 {
	public static void main(String []args) {
		System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
		String[] name= {"안민재", "박민재"};
		int[] value=new int[2];
		Scanner scanner=new Scanner(System.in);
		
		for(int i=0; i<name.length; i++) {
			int val1, val2;
			
			System.out.print(name[i]+" 시작 <Enter>키>>");
			scanner.nextLine();
			Calendar c=Calendar.getInstance();
			val1=c.get(Calendar.SECOND);
			System.out.println("현재 초 시간 = "+val1);
			
			System.out.println("10초 예상 후 <Enter>키>>");
			scanner.nextLine();
			c=Calendar.getInstance();
			val2=c.get(Calendar.SECOND);
			System.out.println("현재 초 시간 = "+val2);
			
			
			if(val2<val1) val2+=60;
			value[i]=val2-val1;
		}
		
		for(int i=0; i<name.length; i++)
			System.out.print(name[i]+"의 결과 "+value[i]+", ");
		
		if(value[0]<value[1]) System.out.print("승자는 "+name[0]);
		else if(value[0]==value[1]) System.out.print("비겼음");
		else System.out.print("승자는 "+name[1]);
		
		scanner.close();
	}
}
