import java.util.Scanner;
import java.util.ArrayList;

class QuizVoca{
	private String eng;
	private String kor;
	
	public QuizVoca(String eng, String kor) {
		this.eng=eng;
		this.kor=kor;
	}
	
	public String getEng() {return eng;}
	public String getKor() {return kor;}
}

class TestApp{
	private ArrayList<QuizVoca> list;
	private Scanner in;
	
	public TestApp() {
		list=new ArrayList<>();
		in=new Scanner(System.in);
	}
	
	private int getVocaNum() {return list.size();}
	
	private void insert(QuizVoca newVoca) {
		list.add(newVoca);
	}
	
	private void startQuiz() {
		System.out.println("현재 "+list.size()+"개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
		
		while(true) {
			try {
				int answerIndex=(int)(Math.random()*list.size());
				
				int[] quizNumbers=new int[3];
				for(int i=0; i<quizNumbers.length; i++) {
					quizNumbers[i]=(int)(Math.random()*list.size());
					if(quizNumbers[i]==answerIndex) i--;
				}
				
				int answerNumber=(int)(Math.random()*4);
				
				System.out.println(list.get(answerIndex).getEng()+"?");
				
				int index=0;
				
				for(int i=0; i<4; i++) {
					if(i==answerNumber) System.out.print("("+(i+1)+")"+list.get(answerIndex).getKor()+" ");
					else System.out.print("("+(i+1)+")"+list.get(quizNumbers[index++]).getKor()+" ");
				}
				System.out.print(":>");
				
				int answer=Integer.valueOf(in.nextLine());
				if(answer==-1) break;
				
				if(answer-1==answerNumber) {
					System.out.println("Excellent !!");
				}
				else System.out.println("No. !!");
				
			}
			catch(Exception e) {
				System.out.println("숫자를 입력하세요 !!");
				continue;
			}
		}
	}
	
	private void insertVoca() {
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			System.out.print("영어 한글 입력 >> ");
			String str=in.nextLine();
			if(str.equals("그만")) break;
			
			String[] info=str.split(" ");
			list.add(new QuizVoca(info[0], info[1]));
		}
	}
	
	public void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"명품영어\" 입니다. ****");
		boolean isFinish=false;
		
		String[] engs= {"eye", "human", "fault", "emotion", "painting", "animal"};
		String[] kors= {"눈", "인간", "오류", "감정", "그림", "동물"};
		
		for(int i=0; i<engs.length; i++) {
			list.add(new QuizVoca(engs[i], kors[i]));
		}
		
		while(true) {
			try {
				System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>>");
				int menu=Integer.valueOf(in.nextLine());
				if(menu<1 || menu>3) throw new Exception();
				
				switch(menu) {
				case 1: startQuiz(); break;
				case 2: insertVoca(); break;
				case 3: isFinish=true; break;
				}
				
				if(isFinish) break;
				System.out.println();
			}
			catch(Exception e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}
		}
		
		System.out.println("\"명품영어\"를 종료합니다.");
		in.close();
	}
}

public class Problem12 {
	public static void main(String []args) {
		TestApp app=new TestApp();
		app.run();
	}
}
