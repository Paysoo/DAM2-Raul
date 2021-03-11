package M9.UF2.Activitat7;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Activitat7NauEspacial extends javax.swing.JFrame {

    public Activitat7NauEspacial() {
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
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Activitat7NauEspacial.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        Activitat7NauEspacial f = new Activitat7NauEspacial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(1200, 800);
        f.setVisible(true);
    }
}


class PanelNau extends JPanel implements Runnable, KeyListener {
    private int numNaus = 3;
    Nau[] nau;
    Proyectil[] proyectiles = new Proyectil[6];
    Nau nauPropia;

    public PanelNau() {
        nau = new Nau[numNaus];
        for (int i = 0; i < nau.length; i++) {
            Random rand = new Random();
            int velocitat = (rand.nextInt(3) + 5) * 10;
            int posX = rand.nextInt(100) + 30;
            int posY = rand.nextInt(100) + 30;
            int dX = rand.nextInt(3) + 1;
            int dY = rand.nextInt(3) + 1;
            String nomNau = Integer.toString(i);
            nau[i] = new Nau(nomNau, posX, posY, dX, dY, velocitat, "paloma1");
        }

        // Creo la nau propia
        nauPropia = new Nau("NauNostra", 200, (800 - 350), 0, 0, 100, "revolver");

        // Creo fil per anar pintant cada 0,1 segons el joc per pantalla
        Thread n = new Thread(this);
        n.start();

        // Creo listeners per a que el fil principal del programa gestioni
        // esdeveniments del teclat
        addKeyListener(this);
        setFocusable(true);

    }

    public void run() {
        System.out.println("Inici fil repintar");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            } // espero 0,1 segons
            //System.out.println("Repintant");
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < nau.length; ++i) {
            if (nau[i] != null) {
                nau[i].pinta(g);
            }
        }
        ;
        nauPropia.pinta(g);
        for (int i = 0; i < proyectiles.length; i++) {
            if (proyectiles[i] != null) {
                proyectiles[i].pinta(g);
                if (proyectiles[i].hit(nau)) {
                    proyectiles[i].finalitza();
                    proyectiles[i] = null;
                }

            }
            if (proyectiles[i] != null && proyectiles[i].getY() < 0 - 104){
                proyectiles[i] = null;
                System.out.println("proyectil " + i + " eliminado");
            }
            if (nauPropia.muere(nau)) {
                nauPropia.finalitza();
                nauPropia = null;
                System.exit(1);
            }
        }
    }


    // Metodes necesaris per gestionar esdeveniments del teclat
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
        if (e.getKeyCode() == 37) {
            nauPropia.esquerra();
        } //System.out.println("a l'esquerra"); }

        if (e.getKeyCode() == 39) {
            nauPropia.dreta();
        } //System.out.println("a la dreta"); }

        if (e.getKeyCode() == 32) {
            int posicionArrayProyectiles = 0;
            boolean disparoHecho = false;
            do {
                if (proyectiles[posicionArrayProyectiles] == null) {
                    nauPropia.dispara(posicionArrayProyectiles, proyectiles);
                    disparoHecho = true;
                }
                posicionArrayProyectiles++;
            } while (!disparoHecho && posicionArrayProyectiles < proyectiles.length);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            nauPropia.para();
        }

        if (e.getKeyCode() == 39) {
            nauPropia.para();
        }

    }
}


class Nau extends Thread {
    private String nomNau;
    private int x, y;
    private int dsx, dsy, v;
    private int tx = 10;
    private int ty = 10;
    private boolean fi = false;

    private String img = "/images/nau.jpg";
    private Image image;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Nau(String nomNau, int x, int y, int dsx, int dsy, int v, String imatge) {
        this.nomNau = nomNau;
        this.x = x;
        this.y = y;
        this.dsx = dsx;
        this.dsy = dsy;
        this.v = v;
        image = new ImageIcon(Nau.class.getResource(imatge + ".png")).getImage();
        Thread t = new Thread(this);
        t.start();
    }

    public void moure() {
        x = x + dsx;
        y = y + dsy;
        // si arriva als marges ...
        if (x >= 1200 - 160 - tx || x <= tx) dsx = -dsx;
        if (y >= 800 - 104 - ty || y <= ty) dsy = -dsy;
    }

    public void pinta(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, null);
    }

    public boolean muere(Nau[] naus) {
        boolean muerto = false;
        for (int i = 0; i < naus.length; i++) {
            if (naus[i] != null) {
                if ((((this.x + 80) - (naus[i].getX() + 80) <= 40) && ((this.y + 156) - (naus[i].getY() + 52) <= 77))
                        || ((this.x - 80) - (naus[i].getX() - 80) <= 30) && ((this.y - 156) - (naus[i].getY() - 52) <= 41)) {
                    naus[i] = null;
                    muerto = true;
                }
            }
        }
        return muerto;
    }

    public void run() {
        while (!fi) {
            //System.out.println("Movent nau numero " + this.nomNau);
            try {
                Thread.sleep(this.v);
            } catch (Exception e) {
            }
            moure();
        }
    }

    public void esquerra() {
        this.dsx = -40;
    }

    public void dreta() {
        this.dsx = 40;
    }

    public void dispara(int posicionEnArray, Proyectil[] proyectiles) {

        proyectiles[posicionEnArray] = new Proyectil(this.nomNau, this.x + 15, 311, 0, -30, 100, "bala");
    }

    public void para() {
        this.dsx = 0;
    }

    public void finalitza() {
        this.fi = true;
    }
}

class Proyectil extends Thread {
    private String nomProyectil;

    public int getY() {
        return y;
    }

    private int x, y;
    private int dsx, dsy, v;
    private int tx = 10;
    private int ty = 10;
    private boolean fi = false;

    private String img = "/images/nau.jpg";
    private Image image;

    public Proyectil(String nomProyectil, int x, int y, int dsx, int dsy, int v, String imatge) {
        this.nomProyectil = nomProyectil;
        this.x = x;
        this.y = y;
        this.dsx = dsx;
        this.dsy = dsy;
        this.v = v;
        image = new ImageIcon(Nau.class.getResource(imatge + ".png")).getImage();
        Thread t = new Thread(this);
        t.start();
    }


    public void moure() {
        x = x + dsx;
        y = y + dsy;

    }

    public void pinta(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, null);
    }


    public void run() {
        while (!fi) {
            //System.out.println("Movent nau numero " + this.nomNau);
            try {
                Thread.sleep(this.v);
            } catch (Exception e) {
            }
            moure();
        }
    }

    public boolean hit(Nau[] naus) {
        boolean hitt = false;
        for (int i = 0; i < naus.length; i++) {
            if (naus[i] != null) {
                if ((((this.x + 15) - (naus[i].getX() + 80) <= 30) && ((this.y + 41) - (naus[i].getY() + 52) <= 41))
                        || ((this.x - 15) - (naus[i].getX() - 80) <= 30) && ((this.y - 41) - (naus[i].getY() - 52) <= 41)) {
                    naus[i] = null;
                    hitt = true;
                }
            }
        }
        return hitt;
    }

    public void finalitza() {
        this.fi = true;
    }
}