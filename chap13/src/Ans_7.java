import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

enum Direction{EAST, WEST, NORTH, SOUTH};

class Snake{
    private Vector<JLabel> v=new Vector<>();
    private final int STANDARD=20;
    private Direction d;

    public Snake(){
        ImageIcon icon=new ImageIcon("media/head.jpg");
        JLabel head=new JLabel(icon);
        head.setSize(icon.getIconWidth(), icon.getIconHeight());
        head.setLocation(100, 100);
        v.add(head);

        ImageIcon icon2=new ImageIcon("media/body.jpg");
        for(int i=1; i<10; i++){
            JLabel body=new JLabel(icon2);
            body.setSize(icon2.getIconWidth(), icon2.getIconHeight());
            body.setLocation(100, 100+STANDARD);
            v.add(body);
        }
    }

    public void setSnake(JPanel p){
        for(JLabel la:v) p.add(la);
    }

    public void move(Direction d){
        for(int i=v.size()-1; i>0; i--){
            JLabel b=v.get(i);
            JLabel a=v.get(i-1);
            b.setLocation(a.getX(), a.getY());
        }

        JLabel head=v.get(0);

        switch(d){
            case EAST:
                head.setLocation(head.getX()+STANDARD, head.getY()); break;
            case WEST:
                head.setLocation(head.getX()-STANDARD, head.getY()); break;
            case NORTH:
                head.setLocation(head.getX(), head.getY()-STANDARD); break;
            case SOUTH:
                head.setLocation(head.getX(), head.getY()+STANDARD); break;
        }
    }
}

class ContentPanel extends JPanel implements Runnable{
    private Snake snake=new Snake();
    private Image img;
    private final long DELAY=200;
    private Direction d;

    public ContentPanel(){
        setLayout(null);


        snake.setSnake(this);
        d=Direction.EAST;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode=e.getKeyCode();

                switch (keyCode){
                    case KeyEvent.VK_LEFT: d=Direction.WEST; break;
                    case KeyEvent.VK_RIGHT: d=Direction.EAST; break;
                    case KeyEvent.VK_DOWN: d=Direction.SOUTH; break;
                    case KeyEvent.VK_UP: d=Direction.NORTH; break;
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        img=new ImageIcon("media/bg.jpg").getImage();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(DELAY);
                snake.move(d);
            }
            catch (InterruptedException e){ return; }
        }
    }
}

class MainFrame7 extends JFrame{
    private ContentPanel contentPanel;
    private Thread snakeThread;

    public MainFrame7(){
        super("스네이크 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel=new ContentPanel();
        setContentPane(contentPanel);

        setSize(400, 400);
        setVisible(true);

        contentPanel.setFocusable(true);
        contentPanel.requestFocus();

        snakeThread=new Thread(contentPanel);
        snakeThread.start();
    }
}

public class Ans_7 {
    public static void main(String[] args) {
        new MainFrame7();
    }
}