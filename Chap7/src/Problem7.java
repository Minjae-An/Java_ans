import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Problem7 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		HashMap<String, Double> map=new HashMap<>();
		
		System.out.println("미래장학금관리시스템입니다.");
		for(int i=0; i<5; i++) {
			try {
				System.out.print("이름과 학점>>");
				String[] info=in.nextLine().split(" ");
				String name=info[0];
				Double score=Double.parseDouble(info[1]);
				map.put(name, score);
			}catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				i--;
			}
		}
		
		Set<String> keys=map.keySet();
		Iterator<String> it=keys.iterator();
		
		System.out.print("장학생 선발 기준 학점 입력>>");
		double standard=in.nextDouble();
		in.nextLine();
		
		System.out.print("장학생 명단 : ");
		
		while(it.hasNext()) {
			String key=it.next();
			if(map.get(key)>=standard)
				System.out.print(key+" ");
		}
	}

}
