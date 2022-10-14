import java.util.Scanner;

class Phone{
	private String name;
	private String tel;
	
	public Phone(String name, String tel) {
		this.name=name;
		this.tel=tel;
	}
	
	public String getName() {return name;}
	public String getTel() {return tel;}
}

class PhoneBook{
	private int number;
	private Phone tels[];
	private Scanner scanner;
	
	
	public void input() {
		
		for(int i=0; i<tels.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name=scanner.next();
			String tel=scanner.nextLine();
			
			tels[i]=new Phone(name, tel);
		}
		
		System.out.println("저장되었습니다..");
	}
	
	public void search() {
		while(true) {
			System.out.print("검색할 이름>>");
			String name=scanner.nextLine();
			if(name.equals("그만")) break;
			
			boolean success=false;
			for(int i=0; i<tels.length; i++)
				if(tels[i].getName().equals(name)) {
					System.out.println(tels[i].getName()+"의 번호는 "+tels[i].getTel()+" 입니다.");
					success=true;
					break;
				}
			
			if(!success) System.out.println(name+"이 없습니다.");
		}
	}
	
	public void run() {
		scanner=new Scanner(System.in);
		
		System.out.print("인원수>>");
		number=scanner.nextInt();
		tels=new Phone[number];
		
		input();
		search();
		
		scanner.close();
	}
}

public class Number8 {
	public static void main(String []args) {
		PhoneBook book=new PhoneBook();
		book.run();
	}
}
