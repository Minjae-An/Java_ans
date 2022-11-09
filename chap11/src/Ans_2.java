import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainFrame2 extends JFrame{
    private JTextField tf=new JTextField(10);
    private JComboBox<String> cb=new JComboBox<>();

    public MainFrame2(){
        setTitle("JTextField and JComboBox ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        tf.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JTextField field=(JTextField)e.getSource();
                cb.addItem(field.getText());
                field.setText("");
            }
        });

        c.add(tf);
        c.add(cb);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_2 {
    public static void main(String[] args) {
        new MainFrame2();
    }
}
