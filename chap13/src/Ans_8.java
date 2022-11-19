import javax.swing.*;
import java.awt.*;

class SnowLabel extends JLabel implements Runnable{
    public SnowLabel(){
        setSize(20, 20);
    }

    @Override
    public void run(){
        int x=(int)(Math.random()*getParent().getWidth());

        setLocation(x, 0);

        while(true){
            try{
                Thread.sleep(100);
                if(getY()==getParent().getHeight()){
                    getParent().remove(this);
                    break;
                }
                setLocation(getX(), getY()+5);
            }
            catch(InterruptedException e){ return; }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, getWidth(), getHeight());
    }
}
class MainFrame8 extends JFrame{
    private ImageIcon icon=new ImageIcon("media/back.jpg");
    private Image img=icon.getImage();
    private ContentPanel contentPane;

    public MainFrame8(){
        super("눈 내리는 샤갈의 마을");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 400);
        setVisible(true);

        contentPane=new ContentPanel();
        setContentPane(contentPane);
        Thread th=new Thread(contentPane);
        th.start();
    }
    private class ContentPanel extends JPanel implements Runnable{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getParent().getWidth(), getParent().getHeight(), this);
        }

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(500);
                    SnowLabel sLabel=new SnowLabel();
                    Thread th=new Thread(sLabel);
                    add(sLabel);
                    th.start();
                }
                catch(InterruptedException e){ return; }
            }
        }
    }
}


public class Ans_8 {
    public static void main(String[] args) {
        new MainFrame8();
    }
}
