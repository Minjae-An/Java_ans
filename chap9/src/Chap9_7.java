import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel{
    public NorthPanel(){
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout());
        add(new JLabel("수식입력"));
        add(new JTextField(30));
    }
}

class CenterPanel extends JPanel{
    public CenterPanel(){
        setLayout(new GridLayout(4, 4, 3, 3));
        for(int i=0; i<=9; i++){
            add(new JButton(i+""));
        }

        add(new JButton("CE"));
        add(new JButton("계산"));

        JButton[] calcBtn=new JButton[4];
        String[] calcSymbols={"+", "-", "X", "/"};

        for(int i=0; i<calcBtn.length; i++){
            calcBtn[i]=new JButton(calcSymbols[i]);
            calcBtn[i].setBackground(Color.CYAN);
            calcBtn[i].setOpaque(true);
            add(calcBtn[i]);
        }
    }
}

class SouthPanel extends JPanel{
    public SouthPanel()
    {
        setBackground(Color.YELLOW);
        setLayout(new FlowLayout());
        add(new JLabel("계산 결과"));
        add(new JTextField(30));
    }
}

public class Chap9_7 extends JFrame{
    public Chap9_7(){
        setTitle("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Chap9_7();
    }
}