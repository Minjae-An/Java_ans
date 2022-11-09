import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class MainFrame7 extends JFrame {
    private JSlider fontSizeSlider;
    private JLabel text = new JLabel("I Love Java");

    public MainFrame7() {
        setTitle("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        fontSizeSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        fontSizeSlider.setValue(text.getFont().getSize());
        fontSizeSlider.setPaintTicks(true);
        fontSizeSlider.setPaintLabels(true);
        fontSizeSlider.setPaintTrack(true);
        fontSizeSlider.setMajorTickSpacing(20);
        fontSizeSlider.setMinorTickSpacing(5);
        fontSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = fontSizeSlider.getValue();
                text.setFont(new Font("Arial", Font.PLAIN, fontSize));
            }
        });

        c.add(fontSizeSlider, BorderLayout.NORTH);

        text.setFont(new Font("Arial", Font.PLAIN, 10));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(text, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_7 {
    public static void main(String[] args) {
        new MainFrame7();
    }
}
