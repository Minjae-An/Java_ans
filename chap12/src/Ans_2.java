import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class MainFrame2 extends JFrame{
    private ContentPanel panel=new ContentPanel();

    public MainFrame2(){
        super("이미지 위에 원 드래깅 가능");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new ContentPanel());

        setSize(300, 300);
        setVisible(true);
    }

    private class ContentPanel extends JPanel{
        private ImageIcon icon=new ImageIcon("images\\back.jpg");
        private Image img=icon.getImage();
        private int x, y;

        public ContentPanel(){
            setLayout(null);

            x=100;
            y=100;

           addMouseMotionListener(new MouseAdapter() {
               @Override
               public void mouseDragged(MouseEvent e) {
                   x=e.getX();
                   y=e.getY();

                   repaint();
               }
           });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 20, 20);
        }
    }
}


public class Ans_2 {
    public static void main(String[] args) {
        new MainFrame2();
    }
}