import java.io.*;

public class Ans_9 {
    public static void main(String[] args) {
        String path="c:\\Java_ans\\chap8\\src";

        File parent=new File(path);

        File[] files=parent.listFiles();
        int deletedFileNumber=0;

        for(File f: files){
            if(f.getName().contains(".txt")){
                System.out.println(f.getPath()+" 삭제");
                f.delete();
                deletedFileNumber++;
            }
        }

        System.out.println("총 "+deletedFileNumber+"개의 .txt 파일을 삭제하였습니다.");

    }
}
