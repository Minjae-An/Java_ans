import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Ans_10 {
    public static void main(String[] args) {
        String path="c:\\Java_ans\\chap8\\phone.txt";

        HashMap<String, String> map=new HashMap<>();
        Scanner scanner;
        try{
            FileReader fr=new FileReader(path);
            scanner=new Scanner(fr);

            while(scanner.hasNext()){
                String str=scanner.nextLine();
                String[] info=str.split(" ");
                String name=info[0];
                String tel=info[1];

                map.put(name, tel);
            }

            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("총 "+map.size()+"개의 전화번호를 읽었습니다.");
        scanner=new Scanner(System.in);

        while(true){
            System.out.print("이름>>");
            String name=scanner.nextLine();
            if(name.equals("그만")) break;
            if(map.get(name)==null) System.out.println("찾는 이름이 없습니다.");
            else System.out.println(map.get(name));
        }
    }
}
