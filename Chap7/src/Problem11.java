import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;

class Nation{
	private String country;
	private String capital;
	
	public Nation(String country, String capital) {
		this.country=country;
		this.capital=capital;
	}
	
	public String getCountry() {return country;}
	public String getCapital() {return capital;}
}

public class Problem11 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		Vector<Nation> v=new Vector<>();
		HashMap<String, String> map=new HashMap<>();
		
		String[] countries= {"중국", "미국", "영국", "그리스", "뉴질랜드", "쿠바"};
		String[] capitals= {"베이징", "워싱턴", "런던", "그리스시티", "뉴질랜드시티", "하바나"};
		
		Nation[] examples=new Nation[5];
		for(int i=0; i<examples.length; i++) {
			examples[i]=new Nation(countries[i], capitals[i]);
			v.add(examples[i]);
			map.put(countries[i], capitals[i]);
		}
		
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		boolean isFinish=false;
		
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>>");
			int menu=Integer.valueOf(in.nextLine());
			
			
			switch(menu) {
			case 1:
				System.out.println("현재 "+v.size()+"개의 나라와 수도가 입력되어 있습니다.");
				// System.out.println("현재 "+map.size()+"개의 나라와 수도가 입력되어 있습니다.");
				while(true) {
					System.out.print("나라와 수도 입력"+(v.size()+1)+">>");
					// System.out.print("나라와 수도 입력"+(map.size()+1)+">>");
					String str=in.nextLine();
					if(str.equals("그만")) break;
					
					String[] info=str.split(" ");
					
					boolean isContain=false;
					
					for(int i=0; i<v.size(); i++) {
						if(v.get(i).getCountry().equals(info[0])) {
							isContain=true;
							break;
						}
					}
					
					if(isContain) {
						System.out.println(info[0]+"는 이미 있습니다!");
						continue;
					}
					
//					if(map.containsKey(info[0])) {
//						System.out.println(info[0]+"는 이미 있습니다!");
//						continue;
//					}
					
					v.add(new Nation(info[0], info[1]));
					// map.put(info[0], info[1]);
				}
				break;
				
			case 2:
				while(true) {
					int quizNumber=(int)(Math.random()*v.size());
					// int quizNumber=(int)(Math.random()*map.size());
					
//					Set<String> keys=map.keySet();
//					Iterator<String> it=keys.iterator();
//					
//					int cnt=0;
//					String key="";
//					while(cnt<quizNumber) {
//						key=it.next();
//						cnt++;
//					}
//					
//					System.out.print(key+"의 수도는? ");
					
					
					System.out.print(v.get(quizNumber).getCountry()+"의 수도는? ");
					String answer=in.nextLine();
					if(answer.equals("그만")) break;
					
					if(v.get(quizNumber).getCapital().equals(answer))
						System.out.println("정답!!");
					else
						System.out.println("아닙니다!!");
					
//					if(answer.equals(map.get(key)))
//						System.out.println("정답!!");
//					else
//						System.out.println("아닙니다!!");
					
				}
				break;
				
			case 3: isFinish=true; break;
			}
			
			if(isFinish) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
			
	}

}
