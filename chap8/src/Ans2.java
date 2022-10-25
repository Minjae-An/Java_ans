import java.util.Scanner;
import java.io.*;

public class Ans2 {
    public static void main(String[] args) {
        final String PATH=".\\src\\phone.txt";
        System.out.println(PATH+"를 출력합니다.");

        try{
            FileReader fr=new FileReader(PATH);
            Scanner scanner=new Scanner(fr);

            System.out.println(scanner.nextLine());
            fr.close();
            scanner.close();
        }
        catch(Exception e){e.printStackTrace();}
    }


}
