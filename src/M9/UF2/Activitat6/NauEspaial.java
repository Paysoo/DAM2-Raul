package M9.UF2.Activitat6;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.*;
import javax.swing.*;

public class NauEspaial extends javax.swing.JFrame {

    public NauEspaial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));
        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspaial.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        NauEspaial f = new NauEspaial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(1280, 720);
        f.setVisible(true);
    }
}


class PanelNau extends JPanel implements Runnable, KeyListener {
    private int numNaus=3;
    Nau[] nau;
    Nau nauPropia;

    public PanelNau(){
        nau = new Nau[numNaus];
        for (int i=0;i<nau.length;i++) {
            Random rand = new Random();
            int velocitatEnemic=(rand.nextInt(3)+5)*10;
            int posXEnemic=rand.nextInt(100)+30;
            int posYEnemic=rand.nextInt(100)+30;
            int dXEnemic=rand.nextInt(3)+1;
            int dYEnemic=rand.nextInt(3)+1;
            nau[i]= new Nau(i,posXEnemic,posYEnemic,dXEnemic,dYEnemic,velocitatEnemic, "mena_diamante.png");
        }

        Random rand = new Random();
        int velocitat = (rand.nextInt(3)+5)*10;
        nauPropia = new Nau(-1,640,520, 0, 0, velocitat, "pico_diamante.png");

        Thread n = new Thread(this);
        n.start();

        // Listeners per a que el fil principal del programa gestioni esdeveniments del teclat
        addKeyListener(this);
        setFocusable(true);
    }

    public void run() {
        System.out.println("Inici fil repintar");
        while(true) {
            try { Thread.sleep(100);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<nau.length;++i) nau[i].pinta(g);
        nauPropia.pinta(g);

    }

    // Cuando la pulsas y la sueltas
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Cuando la pulsas
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed code = " + e.getKeyCode() + ", char=" + e.getKeyChar());
        if (e.getKeyCode() == 39) {
            nauPropia.setDsx(8);
        }
        if (e.getKeyCode() == 37) {
            nauPropia.setDsx(-8);
        }
    }

    // Cuando sueltas
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            nauPropia.setDsx(0);
        }

        if (e.getKeyCode() == 37) {
            nauPropia.setDsx(0);

        }
    }
}


class Nau extends Thread {
    private int numero;
    private int x,y;
    private int dsx;

    public int getDsx() {
        return dsx;
    }

    private int dsy;

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    private int v;
    private int tx = 10;
    private int ty = 10;
    private String img = "/images/nau.jpg";
    private Image image;

    public Nau(int numero, int x, int y, int dsx, int dsy, int v , String imatge) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        image = new ImageIcon(Nau.class.getResource(imatge)).getImage();
        Thread t = new Thread(this);
        t.start();
    }

    public int velocitat (){
        return v;
    }

    public synchronized void moure() {

        if (this.numero == -1) {
            x = x + dsx;
            // si arriva als marges ...
            if (x >= 1180 - tx || x <= tx) {

            }
                x = 0;

        } else {
            x = x + dsx;
            y = y + dsy;
            // si arriva als marges ...
            if (x >= 1180 - tx || x <= tx)
                dsx = -dsx;
            if (y >= 600 - ty || y <= ty)
                dsy = -dsy;
        }

    }

    public void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
    }


    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
        }
    }
}
