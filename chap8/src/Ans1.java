import java.util.Scanner;
import java.io.*;

public class Ans1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        FileWriter fw=null;

        System.out.println("전화번호 입력 프로그램입니다.");

       try{
           fw=new FileWriter("c:\\Java_ans\\chap8\\src\\phone.txt");
           while(true){
               System.out.print("이름 전화번호 >> ");
               String str=scanner.nextLine();
               if(str.equals("그만")) break;
               fw.write(str+"\n");
           }

           fw.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       System.out.println("c:\\Java_ans\\chap8\\src\\phone.txt에 저장하였습니다.");

       scanner.close();
    }
}
