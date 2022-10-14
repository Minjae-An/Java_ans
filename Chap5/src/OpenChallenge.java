import java.util.Scanner;

abstract class GameObject{
	protected int distance;
	protected int x,y;
	
	public GameObject(int startX, int startY, int distance) {
		this.x=startX;
		this.y=startY;
		this.distance=distance;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean collide(GameObject p) {
		if(this.x==p.getX() && this.y==p.getY()) return true;
		else return false;
	}
	
	protected abstract void move();
	protected abstract char getShape();
}

class Bear extends GameObject{
	private Scanner in;
	
	public Bear(int startX, int startY, int distance, Scanner scanner) {
		super(startX, startY, distance);
		in=scanner;
	}
	
	private boolean checkInput(char next) {
		if(next=='a' || next=='s' || next=='d' || next=='f')
			return true;
		else return false;
	}
	
	
	public void move() {
		System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
		char next=' ';
		
		while(true) {
			next=in.nextLine().charAt(0);
			if(checkInput(next)) break;
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
			}
		}
		
		switch(next) {
			case 'a':
				x-=distance;
				if(x<0) x=19;
				break;
				
			case 's':
				y+=distance;
				if(y>=10) y=0;
				break;
				
			case 'd':
				y-=distance;
				if(y<0) y=9;
				break;
				
			case 'f':
				x+=distance;
				if(x>=20) x=0;
				break;
		}
	}
	
	public char getShape() {return 'B';}
}

class Fish extends GameObject{
	private int count;
	
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	
	public void setCount(int count) {
		this.count=count;
	}
	
	public void move() {
		if(count<3) return;
		else {
			int direct=(int)(Math.random()*4);
			
			switch(direct) {
				case 0:
					x-=1;
					if(x<0) x=19;
					break;
					
				case 1:
					y+=1;
					if(y>=10) y=0;
					break;
					
				case 2:
					y-=1;
					if(y<0) y=9;
					break;
					
				case 3:
					x+=1;
					if(x>19) x=0;
					break;
			}
		}
	}
	
	public char getShape() {return '@';}
	
	
}

class GameApp{
	private final int row=10;
	private final int col=20;
	private char[][] gameTable;
	private Bear player1;
	private Fish player2;
	private Scanner scanner;
	
	public GameApp() {
		gameTable=new char[row][col];
		scanner=new Scanner(System.in);
		
		int r=(int)(Math.random()*row);
		int c=(int)(Math.random()*col);
		int distance=1;
		
		player1=new Bear(c, r, distance, scanner);
		
		r=(int)(Math.random()*row);
		c=(int)(Math.random()*col);
		
		player2=new Fish(c, r, distance);
		
		for(int i=0; i<gameTable.length; i++)
			for(int j=0; j<gameTable[i].length; j++) {
				if(i==player1.getY() && j==player1.getX())
					gameTable[i][j]=player1.getShape();
				else if(i==player2.getY() && j==player2.getX())
					gameTable[i][j]=player2.getShape();
				else gameTable[i][j]='-';
			}
	}
	
	public void erasePreLocation() {
		gameTable[player1.getY()][player1.getX()]='-';
		gameTable[player2.getY()][player2.getX()]='-';
	}
	
	public void setPlayersLocation() {
		int x, y;
		x=player2.getX();
		y=player2.getY();
		
		gameTable[y][x]=player2.getShape();
		
		x=player1.getX();
		y=player1.getY();
		
		gameTable[y][x]=player1.getShape();
		
	}
	
	public void printGameTable() {
		for(int i=0; i<gameTable.length; i++) {
			for(int j=0; j<gameTable[i].length; j++)
				System.out.print(gameTable[i][j]);
			System.out.println();
		}
			
				
	}
	
	public void run() {
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
		
		int count=0;
		
		while(true) {
			printGameTable();
			erasePreLocation();
			player1.move();
			player2.setCount(count%5);
			player2.move();
			
			setPlayersLocation();
			
			if(player1.collide(player2)) {
				printGameTable();
				break;
			}
			count++;
		}
		
		System.out.println("Bear Wins!!");
		scanner.close();
	}
}


public class OpenChallenge {
	public static void main(String []args) {
		GameApp app=new GameApp();
		app.run();
	}

}
