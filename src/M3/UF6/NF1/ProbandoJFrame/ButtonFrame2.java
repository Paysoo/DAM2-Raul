package M3.UF6.NF1.ProbandoJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame2 extends JFrame implements ActionListener {
    JButton bChange;
    JButton bChange2;

    public static void main(String[] args) {
        M3.UF6.NF1.ProbandoJFrame.ButtonFrame2 bf = new M3.UF6.NF1.ProbandoJFrame.ButtonFrame2();

        bf.setSize(200,100);
        bf.setVisible(true);

    }

    public ButtonFrame2() {
        bChange = new JButton("Click me!");
        bChange2 = new JButton("Click me! 2");
        setLayout(new FlowLayout());
        bChange.addActionListener(this);
        bChange2.addActionListener(this);
        add(bChange);
        add(bChange2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        getContentPane().setBackground(Color.CYAN);
        repaint();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Hello");
    }
}
