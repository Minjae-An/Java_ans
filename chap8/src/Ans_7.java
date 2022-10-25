import java.io.*;

public class Ans_7 {
    public static void main(String[] args) {
        String src="a.jpg";
        String dest="b.jpg";

        System.out.println(src+"를 "+dest+"로 복사합니다.");
        System.out.println("10%마다 *를 출력합니다.");

        long count=0;

        File srcFile=new File(src);
        long size=srcFile.length()/10;

        int b;
        try{
            FileInputStream fi=new FileInputStream(src);
            FileOutputStream fout=new FileOutputStream(dest);

            while((b=fi.read())!=-1){
                fout.write(b);
                count++;
                if(count%size==0) System.out.print("*");
            }
            fi.close();
            fout.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
