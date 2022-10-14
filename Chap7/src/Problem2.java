import java.util.Scanner;
import java.util.ArrayList;

public class Problem2 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		ArrayList<Character> list=new ArrayList<>();
		
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for(int i=0; i<6; i++) {
			char grade=in.next().charAt(0);
			list.add(grade);
		}
		
		double sum=0;
		
		for(Character ch:list) {
			switch(ch) {
			case 'A':
				sum+=4.0;
				break;
				
			case 'B':
				sum+=3.0;
				break;
				
			case 'C':
				sum+=2.0;
				break;
				
			case 'D':
				sum+=1.0;
				break;
			}
		}
		
		System.out.print(sum/list.size());
		
	}
}
