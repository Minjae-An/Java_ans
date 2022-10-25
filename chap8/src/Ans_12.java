import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Ans_12 {
    public static void main(String[] args) {
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>>");

        Scanner scanner=new Scanner(System.in);
        String path=scanner.nextLine();

        Vector<String> v=new Vector<>();

        try{
            FileReader fr=new FileReader(path);
            scanner=new Scanner(fr);

            while(scanner.hasNext()){
                v.add(scanner.nextLine());
            }

            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        scanner=new Scanner(System.in);

        while(true){
            System.out.print("검색할 단어나 문장>>");
            String searchValue=scanner.nextLine();
            if(searchValue.equals("그만")) break;

            for(int i=0; i<v.size(); i++){
                if(v.get(i).contains(searchValue))
                    System.out.println((i+1)+": "+v.get(i));
            }
        }

        System.out.print("프로그램을 종료합니다.");
        scanner.close();
    }
}
