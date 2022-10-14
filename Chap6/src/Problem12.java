import java.util.Scanner;

class Person{
	private String name;
	private int[] nums=new int[3];
	
	public Person(String name) {
		this.name=name;
		for(int i=0; i<nums.length; i++)
			nums[i]=0;
	}
	
	public String getName() {return name;}
	
	public void setNums() {
		for(int i=0; i<nums.length; i++)
			nums[i]=(int)(Math.random()*3)+1;
	}
	
	public void printNums() {
		for(int n:nums) {
			System.out.print("\t"+n);
		}
	}
	
	public boolean isWin() {
		if(nums[0]==nums[1] && nums[1]==nums[2]) return true;
		else return false;
	}
}

class GamblingGame{
	private Person[] players;
	private Scanner scanner;
	
	public GamblingGame() {
		scanner=new Scanner(System.in);
	}
	
	private void setPlayerNumber() {
		while(true) {
			try {
				System.out.print("겜블링 게임에 참여할 선수 숫자>>");
				int n=Integer.parseInt(scanner.nextLine());
				players=new Person[n];
				break;
			}
			catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
		}
	}
	
	private void setPlayers() {
		for(int i=0; i<players.length; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			String name=scanner.nextLine();
			
			players[i]=new Person(name);
		}
	}
	
	public void run() {
		setPlayerNumber();
		setPlayers();
		
		boolean gameEnd=false;
		
		while(true) {
			for(Person p:players) {
				System.out.print(p.getName()+":<Enter>");
				scanner.nextLine();
				p.setNums();
				p.printNums();
				if(p.isWin()) {
					 System.out.println(p.getName()+"이 이겼습니다.");
					 gameEnd=true;
					 break;
				}
				else System.out.println("\t아쉽군요!");
				
			}
			
			if(gameEnd) break;
		}
		scanner.close();
	}
	
}

public class Problem12 {
	public static void main(String []args) {
		GamblingGame app=new GamblingGame();
		app.run();
	}
}
