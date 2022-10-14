//import java.util.Scanner;
//
//class Person{
//	private String name;
//	private int[] nums=new int[3];
//	
//	public Person(String name) {
//		this.name=name;
//		for(int i=0; i<nums.length; i++)
//			nums[i]=0;
//	}
//	
//	public String getName() {return name;}
//	
//	public void setNums() {
//		for(int i=0; i<nums.length; i++)
//			nums[i]=(int)(Math.random()*3)+1;
//	}
//	
//	public void printNums() {
//		for(int n:nums) {
//			System.out.print("\t"+n);
//		}
//	}
//	
//	public boolean isWin() {
//		if(nums[0]==nums[1] && nums[1]==nums[2]) return true;
//		else return false;
//	}
//}
//
//class GamblingGame{
//	private Person[] players=new Person[2];
//	private Scanner scanner;
//	
//	public GamblingGame() {
//		scanner=new Scanner(System.in);
//	}
//	
//	private void setPlayers() {
//		for(int i=0; i<players.length; i++) {
//			System.out.print((i+1)+"번째 선수 이름>>");
//			String name=scanner.nextLine();
//			
//			players[i]=new Person(name);
//		}
//	}
//	
//	public void run() {
//		setPlayers();
//		
//		mainLoop: while(true) {
//			for(Person p:players) {
//				System.out.print(p.getName()+":<Enter>");
//				scanner.nextLine();
//				p.setNums();
//				p.printNums();
//				if(p.isWin()) {
//					 System.out.println(p.getName()+"이 이겼습니다.");
//					 break mainLoop;
//				}
//				else System.out.println("아쉽군요!");
//				
//			}
//		}
//		
//		scanner.close();
//	}
//	
//}
//
//public class Problem10 {
//	public static void main(String []args) {
//		GamblingGame app=new GamblingGame();
//		app.run();
//	}
//}
