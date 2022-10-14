import java.util.Scanner;

class Dictionary{
	private static String[]kor= {"사랑", "아기", "돈", "미래", "희망"};
	private static String[]eng= {"love", "baby", "money", "future", "hope"};
	public static String kor2Eng(String word) {
		boolean success=false;
		
		for(int i=0; i<kor.length; i++) {
			if(kor[i].equals(word)) {
				return eng[i];
			}
		}
		
		return null;
	}
}

class DicApp{
	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.print("한글 단어?");
			String kor=scanner.nextLine();
			if(kor.equals("그만")) break;
			
			String eng=Dictionary.kor2Eng(kor);
			if(eng==null) System.out.println(kor+"는 저의 사전에 없습니다.");
			else System.out.println(kor+"는 "+eng);
		}
	}
}

public class Number10 {
	public static void main(String []args) {
		DicApp app=new DicApp();
		app.run();
	}

}
