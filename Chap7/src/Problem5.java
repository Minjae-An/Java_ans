import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

class Student{
	private String name;
	private String major;
	private int id;
	private double avg;
	
	public Student(String name, String major,int id, double avg) {
		this.name=name;
		this.major=major;
		this.id=id;
		this.avg=avg;
	}
	
	public String getName() {return name;}
	public String getMajor() {return major;}
	public int getId() {return id;}
	public double getAvg() {return avg;}
	
	public void showInfo() {
		System.out.println("이름: "+name);
		System.out.println("전공: "+major);
		System.out.println("학번: "+id);
		System.out.println("학점평균: "+avg);
	}
	
	public void showinfo2() {
		System.out.println(name+", "+major+", "+id+", "+avg);
	}
}

public class Problem5 {
	public static void main(String []args) {
		ArrayList<Student> list=new ArrayList<>();
		HashMap<String, Student> map=new HashMap<>();
		Scanner in=new Scanner(System.in);
		
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		
		for(int i=0; i<4; i++) {
			System.out.print(">>");
			String[] info=in.nextLine().split(",");
			String name=info[0].trim();
			String major=info[1].trim();
			int id=Integer.parseInt(info[2].trim());
			double avg=Double.parseDouble(info[3].trim());
			
			//list.add(new Student(name, major, id, avg));
			map.put(name, new Student(name, major, id, avg));
		}
		
		System.out.println("-----------------------------------");
		
		Set<String> keySet=map.keySet();
		Iterator<String> it=keySet.iterator();
		
		while(it.hasNext()) {
			String key=it.next();
			map.get(key).showInfo();
			System.out.println("-----------------------------------");
		}
		
		
		while(true) {
			System.out.print("학생 이름>>");
			String name=in.nextLine();
			if(name.equals("그만")) break;
			
			if(map.containsKey(name))
				map.get(name).showinfo2();
					
		}
		
		in.close();
	}

}
