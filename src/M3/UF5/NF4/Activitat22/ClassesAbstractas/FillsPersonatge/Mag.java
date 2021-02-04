package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.Classes.FillsItem.Arma;
import M3.UF5.NF4.Activitat22.Classes.Item;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Mag extends Personatge {
    private int pMagia;
    private int coneixement;

    public Mag(String nom, int edat, int força, int pVida, int pMagia, int coneixement) {
        super(nom, edat, força, pVida);
        this.pMagia = pMagia;
        this.coneixement = coneixement;
    }

    public void atacar(Personatge personatge) {
        boolean sortir = false;
        int contador = 0;
        boolean atacFet = false;

        do {
            if (!(this.equip[contador] == null) && (this.equip[contador].getClass() == Arma.class)) {
                Arma arma = (Arma) equip[contador];
                if (arma.getTipus().equalsIgnoreCase("Magica")) {
                    personatge.setpVida(personatge.getpVida() - arma.getpAtac());
                    System.out.println("El mago " + this.nom + " ha atacado a " + personatge.getNom() + " con " + arma.getNom() +
                            " y ha inflingido " + arma.getpAtac() + " puntos de daño.");
                    atacFet = true;
                    sortir = true;
                }
            }

            contador++;

        } while (!sortir && contador <= 9);

        if (!atacFet) {
            System.out.println("El mago " + this.nom + " no ha podido atacar a " + personatge.getNom() +
                    " porque no tiene armas magicas en su inventario.");
        }

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
        String str = "-----Mag-------\n" + super.toString() + "\nMagia: " + this.pMagia +
                "\nConeixement: " + this.coneixement + "\n---------------";
        return str;
    }


}
