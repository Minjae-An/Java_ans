import java.util.Calendar;

public class Problem5 {
	public static void main(String []args) {
		Calendar c=Calendar.getInstance();
		
		System.out.println("현재 시간은 "+c.get(Calendar.HOUR_OF_DAY)+"시 "+c.get(Calendar.MINUTE)+"분입니다.");
		
		int value=c.get(Calendar.HOUR_OF_DAY);
		
		if(value>=4 &&value<12)
			System.out.println("Good Morning");
		else if(value<18)
			System.out.println("Good Afternoon");
		else if(value<22)
			System.out.println("Good Evening");
		else
			System.out.println("Good Night");
	}

}
