//package M3.UF6.Activitat1;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class FourButtonsTester extends JFrame implements ActionListener {
//    JButton bGreen;
//    JButton bBlue;
//    JButton bRed;
//    JButton bYellow;
//
//    public static void main(String[] args) {
//        FourButtonsTester bf = new FourButtonsTester();
//
//        bf.setSize(200,100);
//        bf.setVisible(true);
//
//    }
//
//    public FourButtonsTester() {
//        bGreen = new JButton("GREEN");
//        bBlue = new JButton("BLUE");
//        bRed = new JButton("RED");
//        bYellow = new JButton("YELLOW")
//        setLayout(new FlowLayout());
//        bYellow.addActionListener(this);
//        bBlue.addActionListener(this);
//        bRed.addActionListener(this);
//        bGreen.addActionListener(this);
//        add(bBlue);
//        add(bGreen);
//        add(bRed);
//        add(bYellow);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        getContentPane().setBackground(Color.CYAN);
//        repaint();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//        }
//        System.out.println("Hello");
//    }
//}
