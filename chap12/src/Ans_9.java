import javax.swing.*;
import java.awt.*;

class BlueLabel extends JLabel {

    public BlueLabel(){
        super();
        setOpaque(true);
        setBackground(Color.BLUE);
    }
    public BlueLabel(String text){
        super(text);
        setOpaque(true);
        setBackground(Color.BLUE);
    }

   @Override
    public void setBackground(Color color){
        super.setBackground(Color.BLUE);
       setOpaque(true);
   }
}

class MainFrame9 extends JFrame{
    public MainFrame9(){
        setTitle("Blue Label 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        BlueLabel label1=new BlueLabel();
        label1.setFont(new Font("Arial", Font.PLAIN, 10));
        label1.setForeground(Color.YELLOW);
        label1.setText("hello");

        c.add(label1);

        BlueLabel label2=new BlueLabel();
        label2.setFont(new Font("Arial", Font.ITALIC, 50));
        label2.setForeground(Color.MAGENTA);
        label2.setText("Big Hello");

        c.add(label2);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_9 {
    public static void main(String[] args) {
        new MainFrame9();
    }
}
