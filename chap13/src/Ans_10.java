import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
* 패널에 일정 딜레이로 랜덤하게 타원을 그리게하는 스레드 클래스
* */
class RandomOvalThread extends Thread{
    private RandomOvalPanel rp;
    /* repaint 를 호출할 패널 */
    private final long DELAY=300;
    /* 지연시간 */

    public RandomOvalThread(RandomOvalPanel rp){
        this.rp=rp;
    }

    /* 이 메서드를 호출할 경우 스레드에 wait 가 걸린다*/
    synchronized public void pauseOperate(){
        try{ this.wait(); }
        catch(InterruptedException e){ return; }
    }

    /* 이 메서드를 호출할 경우 스레드에 notify*/
    synchronized public void startOperate(){
        this.notify();
    }

    @Override
    public void run(){
        while(true){
            try{
                /*
                wait 가 걸려있는 상태에서
                패널에 마우스리스너를 부착하여 mouseEntered 이벤트가 발생할 경우
                해당 마우스 리스너에서 startOperate 메서드를 호출하여 아래 코드를 실행
                */

                Thread.sleep(DELAY);
                rp.repaint(); // 패널의 repaint 를 호출하여 랜덤한 위치에 타원 생성
            }
            catch(InterruptedException e){ break; }
        }
    }
}

/*
랜덤하게 타원이 그려지는 패널
*/
class RandomOvalPanel extends JPanel {
    private Color c=new Color(138,43,226);
    public RandomOvalPanel(){
        setLayout(null);
    }

    // 호출 시 패널내 랜덤한 위치에 타원이 그려진다.
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(c);
        int x=(int)(Math.random()*getWidth());
        int y=(int)(Math.random()*getHeight());
        int w=(int)(Math.random()*getWidth()/2);
        int h=(int)(Math.random()*getHeight()/2);

        g.fillOval(x, y, w, h);
    }
}
class MainFrame10 extends JFrame{
    private RandomOvalPanel rp=new RandomOvalPanel();
    private RandomOvalThread randomOvalThread=new RandomOvalThread(rp);
    public MainFrame10(){
        super("Make Drawing to Start");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(rp);

        rp.addMouseListener(new MouseAdapter(){
            // 이 이벤트 발생시 스레드 notify
            @Override
            public void mouseEntered(MouseEvent e){
                randomOvalThread.startOperate();
            }

            // 이 이벤트 발생시 스레드 wait
            @Override
            public void mouseExited(MouseEvent e){
                randomOvalThread.pauseOperate();
            }
        });

        setSize(400, 400);
        setVisible(true);

        // 스레드 작동 시작
        randomOvalThread.start();
    }
}

public class Ans_10 {
    public static void main(String[] args) {
        new MainFrame10();
    }
}
