import java.io.*;
import java.util.Scanner;

public class Ans_6 {
    public static void main(String[] args) {
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        String path1, path2;

        Scanner scanner=new Scanner(System.in);
        System.out.print("첫번째 파일 이름을 입력하세요>>");
        path1=scanner.nextLine();
        System.out.print("두번째 파일 이름을 압력하세요>>");
        path2=scanner.nextLine();

        try{
            FileReader fr=new FileReader(path1);
            FileWriter fw=new FileWriter("appended.txt");

            int c;

            while((c=fr.read())!=-1){
                fw.write(c);
            }

            fr=new FileReader(path2);

            while((c=fr.read())!=-1){
                fw.write(c);
            }

            System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");

            fr.close();
            fw.close();
        }
        catch(Exception e){ e.printStackTrace(); }

        scanner.close();
    }
}
