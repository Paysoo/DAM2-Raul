package M3.UF6.NF1.ProbandoJFrame;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JButton buton;
    public static void main(String[] args) {

        MyFrame frame = new MyFrame("Hello");
        frame.setVisible(true);

    }

    MyFrame(String title) {
        super(title);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3,2,20,20));
        buton = new JButton("Hello Swing!");
        add(buton);

        buton = new JButton("Hello Swing Mates");
        add(buton);

        buton = new JButton("Goodbye Swing Mates");
        add(buton);

        buton = new JButton("LALALA Swing Mates");
        add(buton);

        buton = new JButton("Hello12!");
        add(buton);

        buton = new JButton("Hello12!");
        add(buton);

    }
}
