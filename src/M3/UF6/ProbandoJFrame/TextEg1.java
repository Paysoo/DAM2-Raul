package M3.UF6.ProbandoJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEg1 extends JFrame implements ActionListener{
    JTextField inText;
    JTextField outText;
    JButton passText;

    public  static void main(String[] args) {
        TextEg1 intText = new TextEg1("TextField");
        intText.setSize(300,100);
        intText.setVisible(true);

    }

    public TextEg1(String title) {
        super(title);
        inText = new JTextField(15);
        setLayout(new FlowLayout());
        outText = new JTextField(15);
        outText.setEditable(false);
        setLayout(new FlowLayout());
        passText = new JButton("Pasar text");
        setLayout(new FlowLayout());
        passText.addActionListener(this);
        add(passText);
        add(inText);
        add(outText);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name = inText.getText();
        outText.setText(name);
        repaint();
    }
}
