import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class MainFrame7 extends JFrame {
    private ContentPanel contentPanel=new ContentPanel();

    public MainFrame7(){
        super("마우스로 폐다각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);

        setSize(300, 300);
        setVisible(true);
    }

    private class ContentPanel extends JPanel{
        private ArrayList<Integer> xList=new ArrayList<>();
        private ArrayList<Integer> yList=new ArrayList<>();
        public ContentPanel(){
            setLayout(null);

            addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    xList.add(e.getX());
                    yList.add(e.getY());
                    repaint();
                }
            });
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setColor(Color.MAGENTA);

           int[] x=new int[xList.size()];
           int[] y=new int[yList.size()];

           for(int i=0; i<xList.size(); i++){
               x[i]=xList.get(i).intValue();
               y[i]=yList.get(i).intValue();
           }

           g.drawPolygon(x, y, xList.size());
        }
    }
}

public class Ans_7 {
    public static void main(String[] args) {
        new MainFrame7();
    }
}
