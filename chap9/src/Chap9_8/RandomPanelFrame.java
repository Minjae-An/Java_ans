package Chap9_8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class NorthPanel extends JPanel {
    public NorthPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        JButton btn1=new JButton("열기");
        JButton btn2=new JButton("닫기");
        JButton btn3=new JButton("나가기");

        add(btn1);
        add(btn2);
        add(btn3);
    }
}

class CenterPanel extends JPanel{
    public CenterPanel(){
        JLabel[] randomLabel=new JLabel[10];

        setLayout(null);
        setBackground(Color.WHITE);

        for(int i=0; i<randomLabel.length; i++){
            randomLabel[i]=new JLabel("*");
            int x=(int)(Math.random()*300);
            int y=(int)(Math.random()*300);
            randomLabel[i].setForeground(Color.RED);
            randomLabel[i].setOpaque(true);
            randomLabel[i].setSize(5, 5);
            randomLabel[i].setLocation(x, y);
            add(randomLabel[i]);
        }
    }
}

class SouthPanel extends JPanel{
    public SouthPanel(){
        setLayout(new FlowLayout());
        setBackground(Color.YELLOW);

        add(new JButton("Word Input"));
        add(new JTextField(30));
    }
}

public class RandomPanelFrame extends JFrame{
    public RandomPanelFrame(){
        setTitle("여러 개의 패널을 가진 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomPanelFrame();
    }
}
