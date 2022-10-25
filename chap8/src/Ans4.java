import java.io.*;
import java.util.Scanner;

public class Ans4 {
    public static void main(String[] args) {
        String path="c:\\windows\\system.ini";

        int index=1;

        try{
            FileReader fr=new FileReader(path);
            Scanner scanner=new Scanner(fr);
            while(scanner.hasNext()){
                String str=(index++)+": "+scanner.nextLine();
                System.out.println(str);
            }

            scanner.close();
            fr.close();
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
