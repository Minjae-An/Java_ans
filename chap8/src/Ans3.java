import java.io.*;

public class Ans3 {
    public static void main(String[] args) {
        String path = "c:\\windows\\system.ini";

        try{
            FileReader fr=new FileReader(path);
            int c;
            while((c=fr.read())!=-1){
                c=Character.toUpperCase(c);
                System.out.print((char)c);
            }

            fr.close();
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
