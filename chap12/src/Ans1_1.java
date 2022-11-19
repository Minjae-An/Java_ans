import javax.swing.*;
import java.awt.*;

class MainFrame1By1 extends JFrame{
    private ImageIcon icon=new ImageIcon("images\\back.jpg");
    private Image img=icon.getImage();
    private MyPanel panel=new MyPanel();

    public MainFrame1By1(){
        super("이미지 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new FlowLayout());
        panel.add(new JButton("Hide/Show"));
        setContentPane(panel);

        setSize(300, 300);
        setVisible(true);
    }

    private class MyPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Ans1_1 {
    public static void main(String[] args) {
        new MainFrame1By1();
    }
}
