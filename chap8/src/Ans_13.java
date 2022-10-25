import java.io.*;
import java.util.Scanner;

class FileSearcher{
    private File current;
    private Scanner scanner;

    public FileSearcher(){
        try{
            current=new File("c:\\");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        scanner=new Scanner(System.in);
    }

    public void run(){
        System.out.println("***** 파일 탐색기입니다 *****");

        while(true){
            File[] subFiles=current.listFiles();

            System.out.println("\t["+current.getPath()+"]");

            for(File f:subFiles){

                if(f.isFile()) System.out.print("file\t");
                else if(f.isDirectory()) System.out.print("dir\t");

                System.out.printf("%d바이트\t", f.length());

                System.out.printf("%-30s\n", f.getName());
            }

            System.out.print(">>");
            String next=scanner.nextLine();
            if(next.equals("그만")) break;

            boolean isExist=false;

            if(next.equals("..")){
                if(!current.getPath().equals("c:\\")){
                    current=new File(current.getParent());
                    isExist=true;
                }
                else continue;
            }
            else{
                for(File f:subFiles)
                    if(f.getName().equals(next)){
                        current=new File(f.getPath());
                        isExist=true;
                        break;
                    }

                if(!isExist) System.out.println("해당 파일이 하위 디렉터리에 존재하지 않습니다.");
            }
        }

        scanner.close();
    }
}

public class Ans_13 {
    public static void main(String[] args) {
        FileSearcher fs=new FileSearcher();
        fs.run();
    }
}
