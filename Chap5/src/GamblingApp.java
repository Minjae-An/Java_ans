// Chap6_10
import java.util.Scanner;

//	annotations are professor's code

class Player{
	private String name;
	private int[] playerNumber;
	private Scanner scanner=new Scanner(System.in);
	
	public Player(String name) {
		this.name=name;
		playerNumber=new int[3];
	}
	
	public String getName() {return name;}
	
	public void setPlayerNumber() {
		for(int i=0; i<playerNumber.length; i++)
			playerNumber[i]=(int)(Math.random()*3+1);
	}
	
	public int[] getPlayerNumber() {return playerNumber;}
	
	public void printPlayerNumber() {
		for(int num:playerNumber)
			System.out.print("\t"+num);
	}
	
	public boolean turn() {
		System.out.print("["+name+"]<Enter>");
		scanner.nextLine();
		int[] n=new int[3];
		for(int i=0; i<n.length; i++)
			n[i]=(int)(Math.random()*3+1);
		
		for(int i=0; i<n.length; i++)
			System.out.print("\t"+n[i]);
		
		for(int i=0; i<n.length; i++)
			if(n[0]!=n[i]) {
				System.out.println("아쉽군요!");
				return false;
			}
		
		System.out.println(name+"님이 이겼습니다!");
		return true;
	}

}

class Game{
	private Player[] players;
	private Scanner scanner;
	
	public Game() {
		players=new Player[2];
		scanner=new Scanner(System.in);
	}
	
	private void makePlayers() {
		String playerName;
		
		for(int i=0; i<players.length; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			playerName=scanner.nextLine();
			players[i]=new Player(playerName);
		}
	}
	
	private boolean isWinner(Player p) {
		int[] numbers=p.getPlayerNumber();
		
		for(int i=0; i<numbers.length-1; i++)
			if(numbers[i]!=numbers[i+1]) return false;
		
		return true;
	}
	
	private void startGame() {
//		while(true) {
//			boolean isGameFinish=false;
//			
//			for(Player p:players) {
//				System.out.println("["+p.getName()+"]:<Enter>");
//				scanner.nextLine();
//				p.setPlayerNumber();
//				
//				p.printPlayerNumber();
//				
//				System.out.print("\t");
//				
//				if(isWinner(p)) {
//					System.out.println(p.getName()+"님이 이겼습니다!");
//					isGameFinish=true;
//					break;
//				}else {
//					System.out.println("아쉽군요!");
//				}
//			}
//			
//			if(isGameFinish) break;
//		}
		
		int index=0;
		while(true) {
			if(players[index].turn()) {
				break;
			}
			else {
				index++;
				index%=players.length;
			}
		}
	}
	
	public void run() {
		makePlayers();
		startGame();
		scanner.close();
	}
	
}


public class GamblingApp {
	public static void main(String []args) {
		Game game=new Game();
		game.run();
	}
}
