package OpenChallenge;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class HangMan{
    private Vector<String> wordVector;
    private Scanner scanner;
    private final String WORDFILEPATH="c:\\Java_ans\\chap8\\words.txt";

    public HangMan()
    {
        wordVector=new Vector<>();
    }

    private void getWords()
    {
        try{
            FileReader fr=new FileReader(WORDFILEPATH);
            scanner=new Scanner(fr);

            while(scanner.hasNext()){
                wordVector.add(scanner.nextLine());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run()
    {
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        getWords();
        scanner=new Scanner(System.in);

        while(true){
            int quizWordIndex=(int)(Math.random()*wordVector.size());
            String quizWord=wordVector.get(quizWordIndex);

            int[] quizLetterIndex=new int[2];

            quizLetterIndex[0]=(int)(Math.random()*quizWord.length());
            while(quizLetterIndex[1]==quizLetterIndex[0]){
                quizLetterIndex[1]=(int)(Math.random()*quizWord.length());
            }

            for(int i=0; i<quizWord.length(); i++){
                if(i==quizLetterIndex[0] || i==quizLetterIndex[1])
                    System.out.print("-");
                else System.out.print(quizWord.charAt(i));
            }

            System.out.println();

            boolean[] isCorrect=new boolean[2];

            int i;

            for(i=0; i<5; i++){

                if(i!=0){
                    for(int j=0; j<quizWord.length(); j++){
                        if(j==quizLetterIndex[0]){
                            if(isCorrect[0]) System.out.print(quizWord.charAt(j));
                            else System.out.print("-");
                        }
                        else if(j==quizLetterIndex[1]){
                            if(isCorrect[1]) System.out.print(quizWord.charAt(j));
                            else System.out.print("-");
                        }
                        else System.out.print(quizWord.charAt(j));
                    }
                    System.out.println();
                }

                System.out.print(">>");
                char c=scanner.nextLine().charAt(0);

                if(c==quizWord.charAt(quizLetterIndex[0])) isCorrect[0]=true;
                else if(c==quizWord.charAt(quizLetterIndex[1])) isCorrect[1]=true;

                if(isCorrect[0] && isCorrect[1]) break;
            }

            if(i==5){
                System.out.println("5번 실패하였습니다.");
                System.out.println(quizWord);
            }

            boolean wantToContinue=false;

            while(true){
                System.out.print("Next(y/n)?");
                char c=scanner.nextLine().charAt(0);
                if(c=='y'){
                    wantToContinue=true;
                    break;
                }
                else if(c=='n') break;
                else System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
            }

            if(!wantToContinue) break;
        }
    }
}

public class HangManApp{
    public static void main(String[] args) {
        HangMan newGame=new HangMan();
        newGame.run();
    }
}