import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyPanel extends JPanel {
    private int x, y;
    private Thread th=new Thread(new RandomCircleThread(this));

    public MyPanel(){
        setLayout(null);

        x=10;
        y=10;

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                th.start();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawOval(x, y, 30, 30);
    }

    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

}

class RandomCircleThread implements Runnable{
    private MyPanel panel;

    public RandomCircleThread(MyPanel panel){
        this.panel=panel;
    }

    @Override
    public void run(){

        while(true){
            try{
                Thread.sleep(500);
                int x=(int)(Math.random()*panel.getWidth()/2+50);
                int y=(int)(Math.random()*panel.getHeight()/2+50);

                panel.setX(x);
                panel.setY(y);
                panel.repaint();

            }
            catch(InterruptedException e){ return; }
        }
    }
}

class MainFrame2 extends JFrame{
    public MainFrame2(){
        super("원을 0.5초 간격으로 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_2 {
    public static void main(String[] args) {
        new MainFrame2();
    }
}
