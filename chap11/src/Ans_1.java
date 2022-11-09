import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{
    private JCheckBox disableBox=new JCheckBox("버튼 비활성화");
    private JCheckBox invisibleBox=new JCheckBox("버튼 감추기");
    private JButton testButton=new JButton("test button");

    public MainFrame(){
        setTitle("CheckBox Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        disableBox.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()==ItemEvent.SELECTED)
                    testButton.setEnabled(false);
                else testButton.setEnabled(true);
            }
        });

        c.add(disableBox);

        invisibleBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED)
                    testButton.setVisible(false);
                else testButton.setVisible(true);
            }
        });

        c.add(invisibleBox);

        c.add(testButton);

        setSize(300, 300);
        setVisible(true);
    }
}

public class Ans_1 {
    public static void main(String[] args) {
        new MainFrame();
    }
}
