import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

class Circle{
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y,int radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    public int getX(){ return x;}
    public int getY(){return y;}
    public int getRadius(){return radius;}
}

class CirclePanel extends JPanel{
    private Vector<Circle> v=new Vector<>();
    private int startX, startY;

    public CirclePanel(){
        setLayout(null);

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                startX=e.getX();
                startY=e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e){
                int endX=e.getX();
                int endY=e.getY();

                int radius=(int)getDistance(startX, startY, endX, endY);
                v.add(new Circle(startX, startY, radius));
                repaint();
            }
        });
    }

    private double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt((double)((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.MAGENTA);
        for(Circle c:v){
            int x=c.getX();
            int y=c.getY();
            int r=c.getRadius();

            g.drawOval(x-r, y-r, 2*r, 2*r);
        }
    }
}

class MainFrame8 extends JFrame {
    public MainFrame8(){
        super("마우스로 원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new CirclePanel());

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_8 {
    public static void main(String[] args) {
        new MainFrame8();
    }
}
