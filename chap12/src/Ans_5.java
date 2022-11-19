import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class MainFrame5 extends JFrame{
    private ImageIcon icon=new ImageIcon("images\\apple.jpg");
    private Image img=icon.getImage();
    private ContentPanel contentPanel=new ContentPanel();
    private int imgWidth=icon.getIconWidth();
    private int imgHeight=icon.getIconHeight();

    public MainFrame5(){
        super("그래픽 이미지 확대 축소 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);

        setSize(300, 300);
        setVisible(true);

        contentPanel.setFocusable(true);
        contentPanel.requestFocus();
    }

    private class ContentPanel extends JPanel{
        public ContentPanel(){
            setLayout(null);

            addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){
                    if(e.getKeyChar()=='+'){
                        imgWidth*=1.1;
                        imgHeight*=1.1;
                    }
                    else if(e.getKeyChar()=='-'){
                        imgWidth*=0.9;
                        imgHeight*=0.9;
                    }
                    repaint();
                }
            });
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 10, 10, imgWidth, imgHeight, this);
        }
    }

}

public class Ans_5 {
    public static void main(String[] args) {
        new MainFrame5();
    }
}
