import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame1 extends JFrame{
    private JLabel la=new JLabel("사랑해");

    public Frame1(){
        setTitle("마우스 올리기 내리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        la.setSize(50, 20);
        la.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                la.setText("Love Java");
            }

            public void mouseExited(MouseEvent e){
                la.setText("사랑해");
            }
        });

        c.add(la);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans1 {
    public static void main(String[] args) {
        new Frame1();
    }
}
