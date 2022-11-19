import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class BubbleLabel extends JLabel implements Runnable{

    public BubbleLabel(ImageIcon icon){
        super(icon);
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(20);
                int y=getY();
                if(y==0){
                    getParent().remove(this);
                    break;
                }
                setLocation(getX(), y-5);
            }
            catch(InterruptedException e){
                return;
            }
        }
    }
}

class MainFrame6 extends JFrame{
    private ImageIcon icon=new ImageIcon("media/bubble.png");

    public MainFrame6(){
        super("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(null);
        c.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int x=e.getX();
                int y=e.getY();

                BubbleLabel label=new BubbleLabel(icon);
                label.setSize(icon.getIconWidth(), icon.getIconHeight());
                label.setLocation(x, y);
                getContentPane().add(label);
                Thread th=new Thread(label);
                th.start();
            }
        });

        setSize(300, 300);
        setVisible(true);
    }
}



public class Ans_6 {
    public static void main(String[] args) {
        new MainFrame6();
    }
}