package M3.UF6.Activitat1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourButtonsTester extends JFrame implements ActionListener {
    JButton bChange;
    JButton bChange2;
    JButton bChange3;
    JButton bChange4;
    //constructor
    public FourButtonsTester(){
        bChange = new JButton("Vermell");
        bChange2 = new JButton("Verd");
        bChange3 = new JButton("Blau");
        bChange4 = new JButton("Gris");
        setLayout(new FlowLayout());

        // register the ButtonFrame object as the listener for the JButton.
        bChange.addActionListener(this);
        bChange2.addActionListener(this);
        bChange3.addActionListener(this);
        bChange4.addActionListener(this);
        bChange.setBackground(Color.red);
        bChange2.setBackground(Color.green);
        bChange3.setBackground(Color.blue);
        bChange4.setBackground(Color.GRAY);
        add(bChange);
        add(bChange2);
        add(bChange3);
        add(bChange4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // listener method reuiered by the interface
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Vermell")){
            getContentPane().setBackground(Color.red);
            repaint();
        }else if(e.getActionCommand().equals("Verd")){
            getContentPane().setBackground(Color.green);
            repaint();
        }else if(e.getActionCommand().equals("Blau")){
            getContentPane().setBackground(Color.blue);
            repaint();
        }else if(e.getActionCommand().equals("Gris")){
            getContentPane().setBackground(Color.GRAY);
            repaint();
        }
    }


    public static void main (String[] args) {
        FourButtonsTester button = new FourButtonsTester();
        button.setSize(400, 300);

        button.setVisible(true);
    }

}