import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class GamblingPanel extends JPanel{
    private JLabel[] numberLabel=new JLabel[3];
    private JLabel result=new JLabel("마우스를 클릭할 때마다 게임합니다.");
    private GamblingThread gamblingThread=new GamblingThread();
    private Font labelFont=new Font("Gothic", Font.ITALIC, 30);
    private Color bgColor=new Color(138,43,226);
    public GamblingPanel(){
        setLayout(null);
        for(int i=0; i<numberLabel.length; i++){
            numberLabel[i]=new JLabel("0", SwingConstants.CENTER);
            numberLabel[i].setFont(labelFont);
            numberLabel[i].setSize(50, 30);
            numberLabel[i].setLocation(70+50*i, 50);
            numberLabel[i].setOpaque(true);
            numberLabel[i].setForeground(Color.YELLOW);
            numberLabel[i].setBackground(bgColor);
            add(numberLabel[i]);
        }

        result.setLocation(60, 130);
        result.setSize(200, 50);
        add(result);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                gamblingThread.startGambling();
            }
        });

        gamblingThread.start();
    }


    private class GamblingThread extends Thread{
        boolean gambling=false;
        synchronized public void waitForGambling(){
            if(!gambling){
                try{ this.wait(); }
                catch(InterruptedException e){ return; }
            }
        }

        synchronized public void startGambling(){
            gambling=true;
            this.notify();
        }

        @Override
        public void run(){
            while(true){
                waitForGambling();

                try{
                    for(JLabel la:numberLabel){
                        Thread.sleep(200);
                        int num=(int)(Math.random()*5);
                        la.setText(Integer.toString(num));
                    }
                }catch(InterruptedException e){ return; }

                if(isWin()){
                    result.setText("축하합니다!!");
                    break;
                }
                else result.setText("아쉽군요");

                gambling=false;
            }
        }

        private boolean isWin(){
            String value=numberLabel[0].getText();
            for(int i=1; i<numberLabel.length; i++)
                if(!numberLabel[i].getText().equals(value)) return false;
            return true;
        }
    }
}

class MainFrame9 extends JFrame{
    public MainFrame9(){
        super("스레드를 가진 겜블링");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new GamblingPanel());

        setSize(350, 300);
        setVisible(true);
    }
}

public class Ans_9 {
    public static void main(String[] args) {
     new MainFrame9();
    }
}