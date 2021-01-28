package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Mag extends Personatge {
    public int getpMagia() {
        return pMagia;
    }

    public void setpMagia(int pMagia) {
        this.pMagia = pMagia;
    }

    public int getConeixement() {
        return coneixement;
    }

    public void setConeixement(int coneixement) {
        this.coneixement = coneixement;
    }

    private int pMagia;
    private int coneixement;
}
