import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class MyHashMap {
	
	public static void fillHashMap(HashMap<String, String>dic, int n, Scanner scanner) {
		for(int i=0; i<n; i++) {
			System.out.print(">>");
			String eng=scanner.next();
			String kor=scanner.next();
			
			dic.put(eng, kor);
		}
	}
	
	public static void search(HashMap<String, String>dic, Scanner scanner) {
		while(true) {
			System.out.print(">>");
			String eng=scanner.next();
			if(eng.equals("exit")) break;
			
			String kor=dic.get(eng);
			if(kor==null) {
				System.out.println(eng+"는 없는 단어입니다.");
				continue;
			}
			System.out.println(eng+"는 한국어로 >>"+kor);
		}
	}
	
	public static void printAll(HashMap<String, String>dic) {
		Set<String> keys=dic.keySet();
		Iterator<String> it=keys.iterator();
		
		while(it.hasNext()) {
			String key=it.next();
			String kor=dic.get(key);
			
			System.out.println(key+"는 한국어로 "+kor);
			
		}
	}

	public static void main(String[] args) {
		HashMap<String, String> dic=new HashMap<String, String>();
		Scanner scanner=new Scanner(System.in);
		
		fillHashMap(dic, 3, scanner);
		search(dic, scanner);
		printAll(dic);
	}

}
