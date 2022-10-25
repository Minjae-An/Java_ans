import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Ans_11 {
    public static void main(String[] args) {
        Scanner scanner;
        Vector<String> v=new Vector<>();

        try{
            FileReader fr=new FileReader("words.txt");
            scanner=new Scanner(fr);

            while(scanner.hasNext()){
                v.add(scanner.nextLine());
            }

            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다.");

        scanner=new Scanner(System.in);

        while(true){
            System.out.print("단어>>");
            String str=scanner.nextLine();
            if(str.equals("그만")) break;

            boolean isExist=false;

            for(String s:v)
                if(s.indexOf(str)==0){
                    System.out.println(s);
                    isExist=true;
                }

            if(!isExist) System.out.println("발견할 수 없음");
        }

        System.out.print("종료합니다...");
        scanner.close();
    }
}
