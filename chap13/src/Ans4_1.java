import javax.swing.*;

class VibrateFrame extends JFrame{
    private Thread th=new Thread(new VibrateThread(this));

    public VibrateFrame(){
        super("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300, 300);
        setVisible(true);

        th.start();
    }
}

class VibrateThread implements Runnable{
    private JFrame frame;

    public VibrateThread(JFrame frame){
        this.frame=frame;
    }

    @Override
    public void run(){
        while(true){
            frame.setLocation(90, 90);
            frame.setLocation(95, 90);
            frame.setLocation(90, 90);
            frame.setLocation(90, 95);
        }
    }
}

public class Ans4_1 {
    public static void main(String[] args) {
        new VibrateFrame();
    }
}
