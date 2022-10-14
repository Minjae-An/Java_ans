import java.util.Scanner;

class Day{
	private String work;
	public void set(String work) {this.work=work;}
	public String get() {return work;}
	public void show() {
		if(work==null) System.out.println("없습니다.");
		else System.out.println(work+"입니다.");
	}
}

class MonthSchedule{
	private Day schedules[];
	private int number;
	
	public MonthSchedule(int number) {
		schedules=new Day[number];
		this.number=number;
		
		for(int i=0; i<schedules.length; i++) {
			schedules[i]=new Day();
			schedules[i].set(null);
		}
			
	}
	
	public void input(int day, String work) {
		schedules[day-1].set(work);
	}
	
	public void view(int day) {
		System.out.println(day+"일의 할 일은 "+schedules[day-1].get()+"입니다.");
	}
	
	public void finish() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("이번달 스케줄 관리 프로그램.");
		while(true) {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			int menu=scanner.nextInt();
			if(menu==1) {
				System.out.print("날짜(1~30)?");
				int day=scanner.nextInt();
				scanner.nextLine();
				System.out.print("할일(빈칸없이입력)?");
				String work=scanner.nextLine();
				
				input(day, work);
			}
			else if(menu==2) {
				System.out.print("날짜(1~30)?");
				int day=scanner.nextInt();
				view(day);
			}
			else {
				finish();
				break;
			}
			
			System.out.println();
		}
	}
	
}
public class Number7 {
	public static void main(String []args) {
		MonthSchedule april=new MonthSchedule(30);
		april.run();
	}
}
