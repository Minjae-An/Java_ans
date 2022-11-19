import java.awt.*;
import javax.swing.*;

class MainFrame6By1 extends JFrame{
    private ContentPanel contentPanel=new ContentPanel();

    public MainFrame6By1(){
        super("격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);

        setSize(300, 300);
        setVisible(true);
    }

    private class ContentPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int w=getWidth();
            int h=getHeight();

            for(int i=0; i<w; i+=w/10)
                for(int j=0; j<h; j+=h/10){
                    g.drawLine(0, j, w, j);
                    g.drawLine(i, 0, i, h);
                }
        }
    }
}

public class Ans6_1 {
    public static void main(String[] args) {
        new MainFrame6By1();
    }
}

