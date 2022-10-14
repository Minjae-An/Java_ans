// 교재 4-OpenChallenge
import java.util.Scanner;

class Player{
	private String name;
	private String word;
	private static Scanner scanner=new Scanner(System.in);
	
	public Player(String name) {
		this.name=name;
	}
	
	public void getWordFromUser() {
		System.out.print(name+">>");
		word=scanner.nextLine();
	}
	
	public String getName() {return name;}
	public String getWord() {return word;}
	
	public boolean checkSuccess(String word) {
		int lastIndex=word.length()-1;
		char lastChar=word.charAt(lastIndex);
		char firstChar=this.word.charAt(0);
		
		if(lastChar==firstChar) return true;
		else return false;
	}
}

public class WordGameApp {
	private Player players[];
	
	
	public void run() {
		Scanner in=new Scanner(System.in);
		
		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		int playerNumber=in.nextInt();
		in.nextLine();
		players=new Player[playerNumber];
		
		for(int i=0; i<playerNumber; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			String name=in.nextLine();
			players[i]=new Player(name);
		}
		
		System.out.println("시작하는 단어는 아버지입니다");
		String word="아버지";
		
		int index=0;
		while(true) {
			players[index].getWordFromUser();
			if(players[index].checkSuccess(word)) {
				word=players[index].getWord();
				index++;
				if(index==playerNumber) index=0;
			}else {
				System.out.print(players[index].getName()+"이 졌습니다.");
				break;
				
			}
		}
		
		in.close();
	}
	
	public static void main(String []args) {
		WordGameApp newGame=new WordGameApp();
		newGame.run();
	}

}
