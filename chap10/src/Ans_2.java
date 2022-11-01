import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame2 extends JFrame{
    public Frame2()
    {
        setTitle("드래깅동안 YELLOW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Component c=(Component)e.getSource();
                c.setBackground(Color.GREEN);
            }
        });

        c.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                Component c=(Component)e.getSource();
                c.setBackground(Color.YELLOW);
            }
        });

        c.setBackground(Color.GREEN);
        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_2 {
    public static void main(String[] args) {
        new Frame2();
    }
}
