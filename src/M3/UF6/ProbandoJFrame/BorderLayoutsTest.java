package M3.UF6.ProbandoJFrame;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutsTest extends JFrame {
    public static void main(String[] args) {

        BorderLayoutsTest frame = new BorderLayoutsTest("Hello");
        frame.setVisible(true);

    }

    BorderLayoutsTest(String title) {
        super(title);
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JButton btnNorth = new JButton("NORTH");
        add(btnNorth, BorderLayout.NORTH);
        JButton btnSouth = new JButton("SOUTH");
        add(btnSouth, BorderLayout.SOUTH);
        JButton btnWest = new JButton("WEST");
        add(btnWest, BorderLayout.WEST);
        JButton btnEast = new JButton("EAST");
        add(btnEast, BorderLayout.EAST);
        JButton btnCenter = new JButton("CENTER");
        add(btnCenter, BorderLayout.CENTER);



    }
}