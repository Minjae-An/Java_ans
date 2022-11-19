import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame1By2 extends JFrame {
    private MyPanel panel=new MyPanel();

    public MainFrame1By2(){
        super("이미지 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);

        setSize(300, 300);
        setVisible(true);
    }

    private class MyPanel extends JPanel{
        private ImageIcon icon=new ImageIcon("images\\back.jpg");
        private Image img=icon.getImage();
        private JButton btn=new JButton("Hide/Show");
        private boolean showFlag=true;

        public MyPanel(){
            setLayout(new FlowLayout());

            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(showFlag){
                        showFlag=!showFlag;
                        MyPanel.this.repaint();
                    }
                }
            });
            add(btn);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(showFlag) g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}

public class Ans1_2 {
    public static void main(String[] args) {
        new MainFrame1By2();
    }
}
