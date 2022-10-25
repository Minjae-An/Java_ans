import java.io.*;
import java.util.Scanner;

public class Ans5 {
    public static void main(String[] args) {
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        Scanner scanner=new Scanner(System.in);
        String path1, path2;

        System.out.print("첫번째 파일 이름을 입력하세요>>");
        path1=scanner.nextLine();
        System.out.print("두번째 파일 이름을 입력하세요>>");
        path2=scanner.nextLine();

        try{
            FileInputStream fi=new FileInputStream(path1);
            FileInputStream fi2=new FileInputStream(path2);

            int c1, c2;
            boolean isSame=true;

            System.out.println(path1+"와 "+path2+"를 비교합니다.");

            while((c1=fi.read())!=-1 && (c2=fi2.read())!=-1){
                if(c1!=c2){
                    isSame=false;
                    break;
                }
            }

            if(isSame) System.out.println("파일이 같습니다.");
            else System.out.println("파일이 다릅니다.");

            fi.close();
            fi2.close();
        }
        catch(Exception e){ e.printStackTrace(); }

        scanner.close();
    }
}
