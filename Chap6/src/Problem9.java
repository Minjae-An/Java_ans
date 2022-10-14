import java.util.Scanner;

public class Problem9 {
	public static void main(String []args) {
		int user, computer;
		user=computer=0;
		Scanner in=new Scanner(System.in);
		
		String[] options= {"가위", "바위", "보"};
		
		while(true) {
			try {
				System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
				user=in.nextInt();
				in.nextLine();
				if(user<1 || user>4) throw new Exception();
				if(user==4) break;
				computer=(int)(Math.random()*3);
				
				System.out.println("철수("+options[user-1]+") : "+"컴퓨터("+options[computer]+")");
				
				computer+=1;
				
				if(user==1 && computer==3 || user==2 && computer==1 || user==3 && computer==2)
					System.out.println("철수가 이겼습니다");
				else if(user==computer) System.out.println("비겼습니다.");
				else System.out.println("컴퓨터가 이겼습니다.");
				
				
			}
			catch(Exception e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요");
			}
			
		}
	}
}
