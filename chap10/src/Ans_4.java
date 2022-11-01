import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame4  extends JFrame{
    private JLabel la=new JLabel("Love Java");

    public Frame4(){
        setTitle("Left 키로 문자열 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        la.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    String str=la.getText();
                    str=str.substring(1)+str.charAt(0);
                    la.setText(str);
                }
            }
        });
        c.add(la);

        setSize(300, 300);
        setVisible(true);

        la.setFocusable(true);
        la.requestFocus();
    }
}

public class Ans_4 {
    public static void main(String[] args) {
        new Frame4();
    }
}
