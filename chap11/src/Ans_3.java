import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainFrame3 extends JFrame{
    private JTextField input=new JTextField(10);
    private JButton calcBtn=new JButton("계산");
    private JTextField[] resultFields=new JTextField[8];
    private final String[] MONETARY_UNIT={"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    private final int[] MONETARY_UNIT_VALUES={50000,10000, 1000, 500, 100, 50, 10, 1};

    public MainFrame3(){
        setTitle("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(null);

        JLabel inputLabel=new JLabel("금액");
        inputLabel.setLocation(20, 20);
        inputLabel.setSize(50, 20);
        c.add(inputLabel);

        input.setLocation(100, 20);
        input.setSize(100, 20);
        c.add(input);

        calcBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int inputValue=Integer.parseInt(input.getText());

                for(int i=0; i<resultFields.length; i++){
                    resultFields[i].setText(String.valueOf(inputValue/MONETARY_UNIT_VALUES[i]));
                    inputValue-=MONETARY_UNIT_VALUES[i]*(inputValue/MONETARY_UNIT_VALUES[i]);
                }

                input.setText("");
            }
        });

        calcBtn.setLocation(210, 20);
        calcBtn.setSize(70, 20);
        c.add(calcBtn);

        for(int i=0; i<resultFields.length; i++){
            JLabel unitLabel=new JLabel(MONETARY_UNIT[i]);
            unitLabel.setLocation(50, 50+20*i);
            unitLabel.setSize(50, 20);
            c.add(unitLabel);
            resultFields[i]=new JTextField(10);
            resultFields[i].setHorizontalAlignment(SwingConstants.CENTER);
            resultFields[i].setLocation(120, 50+20*i);
            resultFields[i].setSize(70, 20);
            c.add(resultFields[i]);
        }

        c.setBackground(Color.PINK);
        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_3 {
    public static void main(String[] args) {
        new MainFrame3();
    }
}
