import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class MainFrame5 extends JFrame{
    private JLabel valueLabel=new JLabel();
    private JSlider slider=new JSlider(JSlider.HORIZONTAL, 100, 200, 150);

    public MainFrame5(){
        setTitle("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        valueLabel.setOpaque(true);
        valueLabel.setBackground(Color.GREEN);

        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);

        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e){
                valueLabel.setText(String.valueOf(slider.getValue()));
            }
        });

        c.add(slider);
        c.add(valueLabel);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_5 {
    public static void main(String[] args) {
        new MainFrame5();
    }
}
