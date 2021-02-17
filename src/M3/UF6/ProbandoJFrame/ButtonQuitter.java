package M3.UF6.ProbandoJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonQuitter extends JFrame implements ActionListener {
    JButton bQuit = new JButton("Click here to Exit");

    public static void main(String[] args) {
        ButtonQuitter frame = new ButtonQuitter("Button Quitter");

        frame.setSize(200,100);
        frame.setVisible(true);
    }

    public  ButtonQuitter(String title) {
        super(title);
        setLayout(new FlowLayout());
        bQuit.addActionListener(this);
        add(bQuit);
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
