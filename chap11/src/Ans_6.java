import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MainFrame6 extends JFrame{
    private JTextArea ta;
    private JSlider textNumberSlider;

    public MainFrame6(){
        setTitle("TextArea Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();

        ta=new JTextArea(10, 20);
        ta.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
               if(ta.getText().length()>=100){
                   ta.setEnabled(false);
               }
               else{
                   ta.setEnabled(true);
                   textNumberSlider.setValue(ta.getText().length());
               }
            }
        });
        c.add(ta, BorderLayout.NORTH);

        textNumberSlider=new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        textNumberSlider.setPaintTrack(true);
        textNumberSlider.setPaintTicks(true);
        textNumberSlider.setPaintLabels(true);
        textNumberSlider.setMinorTickSpacing(5);
        textNumberSlider.setMajorTickSpacing(20);
        textNumberSlider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                ta.setText(ta.getText().substring(0, textNumberSlider.getValue()));
                ta.setEnabled(true);
            }
        });

        c.add(textNumberSlider, BorderLayout.SOUTH);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_6 {
    public static void main(String[] args) {
        new MainFrame6();
    }
}
