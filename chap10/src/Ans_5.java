import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame5 extends JFrame{
    private final int ADJ_SIZE=5;
    private JLabel la=new JLabel("Love Java");

    public Frame5(){
        setTitle("+, - 키로 폰트 크기 조절");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        la.setFont(new Font("Arial", Font.PLAIN, 10));
        la.addKeyListener(new FontAdjListener());
        c.add(la);

        setSize(400, 400);
        setVisible(true);

        la.setFocusable(true);
        la.requestFocus();
    }

    private class FontAdjListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyChar()=='+'){
                int size=la.getFont().getSize();
                la.setFont(new Font("Arial", Font.PLAIN, size+ADJ_SIZE));
            }
            else if(e.getKeyCode()==KeyEvent.VK_MINUS){
                int size=la.getFont().getSize();
                if(size-ADJ_SIZE<=0) return;
                la.setFont(new Font("Arial", Font.PLAIN, size-ADJ_SIZE));
            }
        }
    }
}

public class Ans_5 {
    public static void main(String[] args) {
        new Frame5();
    }
}
