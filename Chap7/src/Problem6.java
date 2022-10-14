import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

class Location{
	private String name;
	private int degree;
	private int latitude;
	
	public Location(String name, int degree, int latitude) {
		this.name=name;
		this.degree=degree;
		this.latitude=latitude;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDegree() {return degree;}
	public int getLatitude() {return latitude;}
	
	public void printInfo() {
		System.out.println(name+"\t"+degree+"\t"+latitude);
	}
}

public class Problem6 {
	public static void main(String []args) {
		Scanner in=new Scanner(System.in);
		HashMap<String, Location> map=new HashMap<>();
		
		System.out.println("도시, 경도, 위도를 입력하세요.");
		
		for(int i=0; i<4; i++) {
			try {
				System.out.print(">>");
				StringTokenizer st=new StringTokenizer(in.nextLine(), ", ");
				String name=st.nextToken();
				int degree=Integer.parseInt(st.nextToken());
				int latitude=Integer.parseInt(st.nextToken());
				
				map.put(name, new Location(name, degree, latitude));
			}catch(Exception e){
				System.out.println("잘못된 입력입니다.");
				i--;
			}
		}
		
		System.out.println("-----------------------------------------");
		
		Set<String> keys=map.keySet();
		Iterator<String> it=keys.iterator();
		
		while(it.hasNext()) {
			String key=it.next();
			map.get(key).printInfo();
		}
		
		System.out.println("-----------------------------------------");
		
		while(true) {
			System.out.print("도시 이름>>");
			String key=in.nextLine();
			if(key.equals("그만")) break;
			if(map.containsKey(key))
				map.get(key).printInfo();
			else System.out.println(key+"는 없습니다.");
		}
		
		in.close();
	}
	

}
