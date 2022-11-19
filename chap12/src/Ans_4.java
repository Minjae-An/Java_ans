import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

class MainFrame4 extends JFrame{
    private ImageIcon icon=new ImageIcon("images\\apple.jpg");
    private Image img=icon.getImage();
    private final int ICON_WIDTH=icon.getIconWidth(), ICON_HEIGHT=icon.getIconHeight();
    private int x, y;
    private ContentPanel contentPanel=new ContentPanel();

    public MainFrame4(){
        super("이미지 레이블 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPanel);

        setSize(300, 300);
        setVisible(true);
    }

    private class ContentPanel extends JPanel{
        public ContentPanel(){
            setLayout(null);

            addMouseMotionListener(new MouseMotionAdapter(){
                @Override
                public void mouseDragged(MouseEvent e){
                    x=e.getX();
                    y=e.getY();

                    repaint();
                }
            });
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, x, y, ICON_WIDTH, ICON_HEIGHT, this);
        }
    }
}

public class Ans_4 {
    public static void main(String[] args) {
        new MainFrame4();
    }
}
