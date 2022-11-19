import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

class MainFrame3 extends JFrame{
    private ImageIcon icon=new ImageIcon("images/apple.jpg");
    private JLabel imgLabel=new JLabel(icon);
    private int x, y;

    public MainFrame3(){
        super("이미지 레이블 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(null);

        imgLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
        imgLabel.setLocation(100, 100);

        imgLabel.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                x=e.getX();
                y=e.getY();

                imgLabel.setLocation(x, y);
            }
        });
        c.add(imgLabel);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_3 {
    public static void main(String[] args) {
        new MainFrame3();
    }
}
