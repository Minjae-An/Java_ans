import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Frame7 extends JFrame{
    private JLabel la=new JLabel("Love Java");
    private final int ADJ_SIZE=5;

    public Frame7(){
        setTitle("마우스 휠을 굴려 폰트 크기를 조절");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        la.setFont(new Font("Arial", Font.PLAIN, 10));
        la.addMouseWheelListener(new AdjFontSizeWheelListener());

        c.add(la);

        setSize(400, 400);
        setVisible(true);
    }

    private class AdjFontSizeWheelListener implements MouseWheelListener{
        public void mouseWheelMoved(MouseWheelEvent e){
            int n=e.getWheelRotation();
            int size=la.getFont().getSize();

            if(n<0){
                if(size-ADJ_SIZE<=0) return;
                la.setFont(new Font("Arial", Font.PLAIN, size-ADJ_SIZE));
            }
            else la.setFont(new Font("Arial", Font.PLAIN, size+ADJ_SIZE));
        }
    }
}

public class Ans_7 {
    public static void main(String[] args) {
        new Frame7();
    }
}
