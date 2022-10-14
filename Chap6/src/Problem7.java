import java.util.Scanner;
import java.util.StringTokenizer;

// 1
public class Problem7{
	public static void main(String []args) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String str=scanner.nextLine();
			if(str.equals("그만")) break;
			StringTokenizer st=new StringTokenizer(str, " ");
			System.out.println("어절 개수는 "+st.countTokens());
		}
		
		System.out.print("종료합니다...");
		scanner.close();
	}
}





// 2
//public class Problem7 {
//	public static void main(String []args) {
//		Scanner scanner=new Scanner(System.in);
//		
//		while(true) {
//			System.out.print(">>");
//			String str=scanner.nextLine();
//			if(str.equals("그만")) break;
//			String[] strs=str.split(" ");
//			System.out.println("어절 개수는 "+strs.length);
//		}
//		
//		System.out.println("종료합니다...");
//		scanner.close();
//	}
//
//}
