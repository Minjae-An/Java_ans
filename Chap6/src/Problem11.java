import java.util.Scanner;

public class Problem11 {
	public static void main(String []args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print(">>");
		String str=scanner.nextLine();
		StringBuffer sb=new StringBuffer(str);
		
		System.out.println(sb);
		
		while(true) {	
			try {
				System.out.print("명령: ");
				String s=scanner.nextLine();
				if(s.equals("그만")) break;
				String[] cmd=s.split("!");
				if(cmd[0]=="" || cmd[1]=="") throw new Exception();
				if(!str.contains(cmd[0])) {
					System.out.println("찾을 수 없습니다.");
					continue;
				}
				
				int index=sb.indexOf(cmd[0]);
				sb=sb.replace(index, index+cmd[0].length(), cmd[1]);
				System.out.println(sb);
			}
			catch(Exception e) {
				System.out.println("잘못된 명령입니다.");
				continue;
			}
		}
		
		System.out.println("종료합니다.");
		scanner.close();
	}

}
