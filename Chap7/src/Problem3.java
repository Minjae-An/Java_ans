import java.util.Scanner;
import java.util.HashMap;

public class Problem3 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		HashMap<String, Integer> nations=new HashMap<>();
		
		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
		
		while(true) {
			try {
				System.out.print("나라 이름, 인구>>");
				String name=in.next();
				if(name.equals("그만")) break;
				int population=in.nextInt();
				in.nextLine();
				nations.put(name, population);
			}catch(Exception e) {
				e.getStackTrace();
				return;
			}
		}
		
		in.nextLine();
		
		while(true) {
			System.out.print("인구 검색>>");
			String key=in.nextLine();
			if(key.equals("그만")) break;
			if(nations.get(key)!=null) System.out.println(key+"의 인구는 "+nations.get(key));
			else System.out.println(key+" 나라는 없습니다.");
		}
	}

}
