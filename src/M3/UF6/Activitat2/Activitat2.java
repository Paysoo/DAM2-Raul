package M3.UF6.Activitat2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activitat2 extends JFrame implements ActionListener {
    JButton bFc;
    JButton bCf;
    JButton bBorrar;
    JLabel l;
    JTextField f;
    JTextField c;

    public static void main(String[] args) {
        M3.UF6.Activitat2.Activitat2 a2 = new M3.UF6.Activitat2.Activitat2();

        a2.setSize(200,100);
        a2.setVisible(true);

    }

    public Activitat2() {
        l = new JLabel("Conversor");
        f = new JTextField(10);
        c = new JTextField(10);
        bFc = new JButton("Pasar de F a C");
        bCf = new JButton("Pasar de C a F");
        bBorrar = new JButton("Borrar");

        setLayout(new FlowLayout());

        bFc.addActionListener(this);
        bCf.addActionListener(this);
        bBorrar.addActionListener(this);

        add(l);
        add(f);
        add(c);
        add(bCf);
        add(bFc);
        add(bBorrar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Pasar de F a C")) {
            int far = Integer.parseInt(f.getText());
            int cel = (far - 32) * 5 / 9;
            c.setText(String.valueOf(cel));
        }
        if(e.getActionCommand().equals("Pasar de C a F")) {
            int cel = Integer.parseInt(c.getText());
            int far = (cel * 9 / 5) + 32;
            f.setText(String.valueOf(far));
        }
        if (e.getActionCommand().equals("Borrar")) {
            f.setText("");
            c.setText("");
        }

    }
}
