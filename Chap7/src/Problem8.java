import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Problem8 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		HashMap<String, Integer>map=new HashMap<>();
		
		System.out.println("** 포인트 관리 프로그램입니다. **");
		
		while(true) {
			try {
				System.out.print("이름과 포인트 입력>>");
				String str=in.nextLine();
				if(str.equals("그만")) break;
				String[] info=str.split(" ");
				String name=info[0];
				Integer score=Integer.parseInt(info[1]);
				
				if(map.containsKey(name))
					map.replace(name, map.get(name), map.get(name)+score);
				else
					map.put(name, score);
				
				Set<String> keys=map.keySet();
				Iterator<String> it=keys.iterator();
				while(it.hasNext()) {
					String key=it.next();
					System.out.print("("+key+","+map.get(key)+")");
				}
				
				System.out.println();
			}catch(Exception e) {
				System.out.println("입력이 잘못 됐습니다. 다시 입력하세요");
				continue;
			}
		}
		
		in.close();
	}

}
