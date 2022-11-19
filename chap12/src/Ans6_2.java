import javax.swing.*;
import java.awt.*;

class MainFrame6By2 extends JFrame{


    public MainFrame6By2(){
        super("그래픽 다각형 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new ContentPanel());

        setSize(300, 300);
        setVisible(true);
    }

    private class ContentPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            int count = 10;
            for(int i=0; i<10; i++) {
                int halfWidth = this.getWidth() / 2;
                int halfHeight = this.getHeight() / 2;
                int fullWidth = this.getWidth();
                int fullHeight = this.getHeight();
                int calc = count * i;

                g.drawLine(calc, halfHeight, halfWidth, calc);
                g.drawLine(halfWidth, calc, fullWidth - calc, halfHeight);
                g.drawLine(fullWidth - calc, halfHeight, halfWidth, fullHeight - calc);
                g.drawLine(halfWidth, fullHeight - calc, calc, halfHeight);
            }
            /* 답안 참고해서 하였음 */
        }
    }
}

public class Ans6_2 {
    public static void main(String[] args) {
        new MainFrame6By2();
    }
}
