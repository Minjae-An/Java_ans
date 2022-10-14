import java.util.Scanner;

class Seat{
	private String name;
	private int number;
	
	public Seat(int number) {
		name="---";
		this.number=number;
	}
	
	public Seat(String name, int number) {
		this.name=name;
		this.number=number;
	}
	
	public String getName() {return name;}
	public int getNumber() {return number;}
	
	public void setName(String name) {
		this.name=name;
	}
	
}

class SeatSet{
	private Seat seats[];
	private String setName;
	private int seatNumber;
	
	public SeatSet(String setName, int seatNumber) {
		this.setName=setName;
		this.seatNumber=seatNumber;
		
		seats=new Seat[seatNumber];
		for(int i=0; i<seats.length; i++)
			seats[i]=new Seat(i);
	}
	
	public void showSeatSet() {
		System.out.print(setName+">> ");
		for(int i=0; i<seats.length; i++)
			System.out.print(seats[i].getName()+" ");
		System.out.println();
	}
	
	public String getSetName() {
		return setName;
	}
	
	public void setSeat(String name, int seatNum) {
		seats[seatNum-1].setName(name);
	}
	
	public boolean isFull() {
		for(int i=0; i<seats.length; i++)
			if(seats[i].getName().equals("---")) return false;
			
		return true;
	}
	
	public boolean cancelReserve(String name) {
		for(int i=0; i<seats.length; i++)
			if(seats[i].getName().equals(name)) {
				seats[i].setName("---");
				return true;
			}
		
		return false;
	}
	
	
}

class ReserveSystem{
	private SeatSet sets[];
	private int setNumber;
	private Scanner scanner;
	
	public ReserveSystem(){
		scanner=new Scanner(System.in);
		
		setNumber=3;
		sets=new SeatSet[3];
		sets[0]=new SeatSet("S", 10);
		sets[1]=new SeatSet("A", 10);
		sets[2]=new SeatSet("B", 10);
		
	}
	
	private void showMenu() {
		System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
	}
	
	private void reserve() {
		System.out.print("좌석구분 ");
		for(int i=0; i<sets.length; i++) {
			System.out.print(sets[i].getSetName()+"("+(i+1)+") ");
		}
		
		System.out.print(">>");
		
		int choiceNumber=scanner.nextInt();
		scanner.nextLine();
		
		choiceNumber-=1;
		
		if(sets[choiceNumber].isFull()) {
			System.out.println("해당 좌석은 만석입니다.");
			return;
		}
		
		sets[choiceNumber].showSeatSet();
		
		System.out.print("이름>>");
		String name=scanner.nextLine();
		System.out.print("번호>>");
		int seatNum=scanner.nextInt();
		scanner.nextLine();
		
		sets[choiceNumber].setSeat(name, seatNum);
	}
	
	private void lookup() {
		for(int i=0; i<sets.length; i++) {
			sets[i].showSeatSet();
		}
		
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	private void cancel() {
		System.out.print("좌석 S:1, A:2, B:3>>");
		int choiceNumber=scanner.nextInt();
		scanner.nextLine();
		
		choiceNumber-=1;
		sets[choiceNumber].showSeatSet();
		
		System.out.print("이름>>");
		String name=scanner.nextLine();
		
		boolean success=sets[choiceNumber].cancelReserve(name);
		
		if(!success) System.out.println("해당 좌석은 공석입니다.");
	}
	
	public void run() {
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		while(true) {
			showMenu();
			int menu=scanner.nextInt();
			scanner.nextLine();
			
			if(menu==1) reserve();
			else if(menu==2) lookup();
			else if(menu==3) cancel();
			else break;
		}
		
		scanner.close();
	}
}

public class Number12 {
	public static void main(String []args) {
		ReserveSystem system=new ReserveSystem();
		system.run();
	}

}
