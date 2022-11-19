import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TimerLabel extends JLabel implements Runnable{
    private Calendar c;

    public void setTimer(){
        c=Calendar.getInstance();
        Date now=c.getTime();
        SimpleDateFormat df=new SimpleDateFormat("kk:mm:ss");
        setFont(new Font("Gothic", Font.ITALIC, 50));
        setText(df.format(now));
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                setTimer();
            }
            catch(InterruptedException e){ return; }
        }
    }
}

class MainFrame3 extends JFrame{
    private TimerLabel timerLabel=new TimerLabel();
    private Thread th=new Thread(timerLabel);

    public MainFrame3(){
        super("디지털 시계 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        c.add(timerLabel);

        setSize(300, 300);
        setVisible(true);

        th.start();
    }
}

public class Ans_3 {
    public static void main(String[] args) {
        new MainFrame3();
    }
}
