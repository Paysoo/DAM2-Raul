package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.Classes.Item;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Mag extends Personatge {
    private int pMagia;
    private int coneixement;

    public Mag(String nom, int edat, int força, int pVida, Item[] equip, int pMagia, int coneixement) {
        this.setNom(nom);
        this.setEdat(edat);
        this.setForça(força);
        this.setpVida(pVida);
        this.setEquip(equip);
        this.pMagia = pMagia;
        this.coneixement = coneixement;
    }

    public int getpMagia() { return pMagia; }

    public void setpMagia(int pMagia) {
        this.pMagia = pMagia;
    }

    public int getConeixement() {
        return coneixement;
    }

    public void setConeixement(int coneixement) {
        this.coneixement = coneixement;
    }

    public String toString(){
        String str = new StringBuilder().append(super.toString()).append("\nMagia: " + this.pMagia +
                "\nConeixement: " + this.coneixement).toString();
        return str;
    }
}
