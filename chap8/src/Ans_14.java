import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class FileSearcher2{
    private Scanner scanner;
    private File current;
    private File[] sub;

    public FileSearcher2(){
        scanner=new Scanner(System.in);
        current=new File("c:\\");
    }

    public void mkdir(String newDirName){
        File newDir=new File(current.getPath()+newDirName);
        newDir.mkdir();
    }

    public boolean renameElement(String oldName, String newName){

        for(File f:sub){
            if(f.getName().equals(oldName)){
                f.renameTo(new File(current.getPath()+"\\"+newName));
                return true;
            }
        }

        return false;
    }

    public void showCurrentDir(){
        sub=current.listFiles();

        System.out.println("\t["+current.getPath()+"]");

        for(File f:sub){
            if(f.isFile()) System.out.print("file\t");
            else if(f.isDirectory()) System.out.print("dir\t");

            System.out.printf("%30d바이트", f.length());

            System.out.println("\t"+f.getName());
        }
    }

    public void run(){
        System.out.println("***** 파일 탐색기입니다. *****");

        while(true){
            showCurrentDir();
            System.out.print(">>");
            StringTokenizer st=new StringTokenizer(scanner.nextLine());

            String cmd=st.nextToken();

            if(cmd.equals("그만")) break;
            else if(cmd.equals("..")){
                if(!current.getPath().equals("c:\\"))
                    current=new File(current.getParent());
            }
            else if(cmd.equals("mkdir")){
                String newDirName=st.nextToken();
                mkdir(newDirName);
            }
            else if(cmd.equals("rename")) {
                if(st.countTokens()!=2){
                    while(st.countTokens()!=3){
                        System.out.print(">>");
                        st=new StringTokenizer(scanner.nextLine());
                    }

                    st.nextToken();
                }
                String oldName=st.nextToken();
                String newName=st.nextToken();

                if(renameElement(oldName, newName))
                    System.out.println(oldName+"를 "+newName+" 이름 변경하였습니다.");
                else System.out.println("해당 파일은 현재 하위 디렉터리에 존재하지 않습니다.");
            }
            else{
                boolean isExist=false;

                for(File f:sub){
                    if(f.getName().equals(cmd)){
                        isExist=true;
                        current=new File(f.getPath());
                        break;
                    }
                }

                if(!isExist) System.out.println("해당 파일이 서브디렉터리에 존재하지 않습니다.");
            }
        }
    }
}

public class Ans_14 {
    public static void main(String[] args) {
        FileSearcher2 fs2=new FileSearcher2();
        fs2.run();
    }
}
