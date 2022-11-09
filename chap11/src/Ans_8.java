import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

class MainFrame8 extends JFrame{
    private int imageIndex=0;
    private final String IMAGE_PATH="c:\\Java_ans\\chap11\\images";
    private final Vector<ImageIcon> IMAGE_VECTOR=new Vector<>();
    private JRadioButton leftButton;
    private JRadioButton rightButton;
    private JLabel imageLabel;

    private class NorthPanel extends JPanel{
        public NorthPanel(){
            ButtonGroup group=new ButtonGroup();

            leftButton=new JRadioButton("left", true);
            rightButton=new JRadioButton("right");

            group.add(leftButton);
            group.add(rightButton);

            add(leftButton);
            add(rightButton);
        }
    }

    private class CenterPanel extends JPanel{
        public CenterPanel(){
            imageLabel=new JLabel(IMAGE_VECTOR.get(imageIndex));
            imageLabel.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    if(leftButton.isSelected()){
                        imageLabel.setIcon(IMAGE_VECTOR.get(imageIndex--));
                        if(imageIndex<0) imageIndex=IMAGE_VECTOR.size()-1;
                    }
                    else{
                        imageLabel.setIcon(IMAGE_VECTOR.get(imageIndex++));
                        if(imageIndex>IMAGE_VECTOR.size()-1) imageIndex=0;
                    }
                }
            });

           add(imageLabel);
        }
    }

    public MainFrame8(){
        setTitle("Image Gallery Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c=getContentPane();

        getImages();

        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }

    private void getImages(){
        File[] imageList=new File(IMAGE_PATH).listFiles();
        for(File f:imageList){
            IMAGE_VECTOR.add(new ImageIcon(f.getPath()));
        }
    }
}

public class Ans_8 {
    public static void main(String[] args) {
        new MainFrame8();
    }
}
