import java.io.*;

public class Ans_8 {
    public static void main(String[] args) {
        File cDir=new File("c:\\");

        File[] files=cDir.listFiles();

        long maxLength=Long.MIN_VALUE;
        File maxLengthFile=null;

        for(File f:files)
            if(f.length()>maxLength){
                maxLengthFile=f;
                maxLength=f.length();
            }

        System.out.println("가장 큰 파일은 "+maxLengthFile.getPath()+" "+maxLength+"바이트");
    }
}
