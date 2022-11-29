import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.Math.random;

class MainFrame extends JFrame{
    public MainFrame(){
        setTitle("Make Drawing to Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new RandomCirclePanel());

        setSize(400, 400);
        setVisible(true);
    }
}

class RandomCirclePanel extends JPanel{
    private int x, y, w, h;
    private RandomCircle th=new RandomCircle();
    public RandomCirclePanel(){
        setLayout(null);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JComponent jc=(JComponent)e.getSource();
                x=(int)(random()*jc.getWidth()/2+100);
                y=(int)(random()*jc.getHeight()/2+100);
                w=(int)(random()*jc.getWidth()/4);
                h=(int)(random()*jc.getHeight()/4);

                removeComponentListener(this);
            }
        });

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                th.resumeOperation();
            }

            @Override
            public void mouseExited(MouseEvent e){
                th.stopOperation();
            }
        });

        th.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(new Color(139, 0, 255));
        g.fillOval(x, y, w, h);
    }

    private class RandomCircle extends Thread{
        private boolean isStop=false;

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(300);
                    if(isStop) stopRun();
                    randomLocation();

                    repaint();
                }
                catch(InterruptedException e){ return; }
            }
        }

        private void randomLocation(){
            x=(int)(random()*getWidth()/2+100);
            y=(int)(random()*getHeight()/2+100);
            w=(int)(random()*getWidth()/4);
            h=(int)(random()*getHeight()/4);
        }

        public void stopOperation(){
            isStop=true;
        }

        synchronized private void stopRun(){
            try{
                this.wait();
            }
            catch(InterruptedException e){ return; }
        }

        synchronized public void resumeOperation(){
            if(!isStop) return;

            isStop=false;
            this.notify();
        }
    }
}

public class Ans_10{
    public static void main(String[] args) {
        new MainFrame();
    }
}