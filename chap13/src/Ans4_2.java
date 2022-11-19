import javax.swing.*;
import java.awt.*;

class VibrateThread2 implements Runnable{
    private JLabel label;

    public VibrateThread2(JLabel label){
        this.label=label;
    }
    @Override
    public void run(){
        while(true){
            label.setLocation(100, 100);;
            label.setLocation(95, 100);
            label.setLocation(100, 95);
            label.setLocation(100, 100);
        }
    }
}

class MainFrame4_2 extends JFrame{
    private JLabel label=new JLabel("진동하는 레이블");
    private Thread th=new Thread(new VibrateThread2(label));

    public MainFrame4_2(){
        super("진동하는 레이블 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(null);

        label.setSize(100, 100);
        label.setLocation(100, 100);
        c.add(label);

        setSize(300, 300);
        setVisible(true);

        th.start();
    }
}

public class Ans4_2 {
    public static void main(String[] args) {
        new MainFrame4_2();
    }
}
