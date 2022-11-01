import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame6 extends JFrame{
    private JLabel la=new JLabel("C");
    private Container c;

    public Frame6(){
        setTitle("클릭 연습용 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c=getContentPane();
        c.setLayout(null);

        la.setSize(50, 20);
        la.setLocation(100, 100);
        la.addMouseListener(new ClickListener());

        c.add(la);

        setSize(400, 400);
        setVisible(true);
    }

    private class ClickListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            int x=(int)(Math.random()*c.getWidth());
            int y=(int)(Math.random()*c.getHeight());

            la.setLocation(x, y);
        }
    }
}


public class Ans_6 {
    public static void main(String[] args) {
        new Frame6();
    }
}
