import java.util.Scanner;
import java.util.HashMap;
import java.util.Vector;

class Student1{
	private String name;
	private int id;
	private String tel;
	
	public Student1(String name, int id, String tel) {
		this.name=name;
		this.id=id;
		this.tel=tel;
	}
	
	public String getName() {return name;}
	public int getId() {return id;}
	public String getTel() {return tel;}
}

public class MyStudent {
	
	public static void search(Vector<Student1> v) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.print("이름>>");
			String name=scanner.next();
			if(name.equals("그만")) break;
			
			int i=0;
			
			for(i=0; i<v.size(); i++) {
				Student1 st=v.get(i);
				if(st.getName().equals(name)) {
					System.out.println(name+"의 학번 "+st.getId()+", 전화번호는 "+st.getTel());
					break;
				}
			}
			
			if(i==v.size()) System.out.println(name+"은 없는 학생입니다.");
		}
		
		scanner.close();
	}
	
	public static void search(HashMap<String, Student1>map) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			System.out.print("이름>>");
			String name=scanner.next();
			if(name.equals("그만")) break;
			
			if(map.get(name)!=null) {
				Student1 st=map.get(name);
				System.out.println(name+"의 학번 "+st.getId()+", 전화번호는 "+st.getTel());
			}
			else System.out.println(name+"은 없는 학생입니다.");
		}
		
		scanner.close();
	}

	public static void main(String[] args) {
//		Vector<Student1> v=new Vector<Student1>();
//		
//		v.add(new Student1("안민재", 3, "2222"));
//		v.add(new Student1("김민재", 90, "7777"));
//		v.add(new Student1("박민재", 66, "1111"));
//		search(v);
		
		HashMap<String, Student1> map=new HashMap<String, Student1>();
		map.put("안민재", new Student1("안민재", 3, "2222"));
		map.put("김민재", new Student1("김민재", 90, "7777"));
		map.put("박민재", new Student1("박민재", 66, "1111"));
		search(map);
		

	}

}
