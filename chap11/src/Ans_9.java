import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainFrame9 extends JFrame{
    private ImageIcon[] choiceIcons=new ImageIcon[3];
    private JButton[] choiceButton=new JButton[3];
    private JLabel usersChoice=new JLabel();
    private JLabel comsChoice=new JLabel();
    private JLabel winner=new JLabel();
    private int userIndex, comIndex;

    private class NorthPanel extends JPanel{
        private ActionListener actionListener;
        public NorthPanel(){
            choiceIcons[0]=new ImageIcon("c:\\Java_ans\\chap11\\images\\bawi.jpg");
            choiceIcons[1]=new ImageIcon("c:\\Java_ans\\chap11\\images\\gawi.jpg");
            choiceIcons[2]=new ImageIcon("c:\\Java_ans\\chap11\\images\\bo.jpg");

            actionListener=new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JButton b=(JButton)e.getSource();
                   for(int i=0; i<choiceIcons.length; i++){
                       if(choiceIcons[i].equals(b.getIcon())){
                           userIndex=i;
                           break;
                       }
                   }

                   usersChoice.setIcon(choiceIcons[userIndex]);

                    comIndex=(int)(Math.random()*3);
                    comsChoice.setIcon(choiceIcons[comIndex]);

                    if(getWinner(userIndex, comIndex)==-1)
                        winner.setText("Me !!!");
                    else if(getWinner(userIndex, comIndex)==0)
                        winner.setText("Same !!!");
                    else winner.setText("Computer !!!");
                }
            };

            for(int i=0; i<choiceButton.length; i++){
                choiceButton[i]=new JButton(choiceIcons[i]);
                choiceButton[i].addActionListener(actionListener);
                add(choiceButton[i]);
            }

            setBackground(Color.GRAY);
        }
    }

    private class CenterPanel extends JPanel{
        public CenterPanel(){
            winner.setOpaque(true);
            winner.setForeground(Color.RED);

            add(usersChoice);
            add(new JLabel("me"));
            add(comsChoice);
            add(new JLabel("com"));
            add(winner);

            setBackground(Color.YELLOW);
        }
    }

    private int getWinner(int userIndex, int comIndex){
        if(userIndex==0 && comIndex==1 || userIndex==1 && comIndex==2
        || userIndex==2 && comIndex==0) return -1;
        else if(userIndex==comIndex) return 0;
        else return 1;
    }

    public MainFrame9(){
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);

        setSize(400, 400);
        setVisible(true);
    }
}

public class Ans_9 {
    public static void main(String[] args) {
        new MainFrame9();
    }
}
