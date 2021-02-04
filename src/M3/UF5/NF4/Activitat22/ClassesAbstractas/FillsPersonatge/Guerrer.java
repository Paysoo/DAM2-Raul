package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.Classes.FillsItem.Arma;
import M3.UF5.NF4.Activitat22.Classes.FillsItem.Pocio;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Guerrer extends Personatge {

    private double pesMaxim;

    public Guerrer(String nom, int edat, int força, int pVida, int pesMaxim) {
        super(nom, edat, força, pVida);
        this.pesMaxim = pesMaxim;
    }

    public void atacar(Personatge personatge) {
        boolean sortir = false;
        int contador = 0;
        int armaDistancia = -1;
        boolean atacFet = false;

        do {
            if (!(this.equip[contador] == null) && (this.equip[contador].getClass() == Arma.class )) {
                Arma arma = (Arma) equip[contador];
                if (arma.getTipus().equalsIgnoreCase("Cos a cos")) {
                    personatge.setpVida(personatge.getpVida() - (arma.getpAtac() + 1));

                    System.out.println("El guerrero " +this.nom + " ha atacado a " + personatge.getNom() + " con " + arma.getNom() +
                            " y ha inflingido " + (arma.getpAtac()+1) + " puntos de daño.");
                    atacFet = true;
                    sortir = true;
                } else if (arma.getTipus().equalsIgnoreCase("Distancia")){
                    if (contador < 9) {
                        armaDistancia = contador;
                    } else {
                        personatge.setpVida(personatge.getpVida() - arma.getpAtac());
                        System.out.println("El guerrero " +this.nom + " ha atacado a " + personatge.getNom() + " con " + arma.getNom() +
                                " y ha inflingido " + arma.getpAtac() + " puntos de daño.");
                        atacFet = true;
                        sortir = true;
                    }

                }

            }

            contador++;

        } while (!sortir && contador <= 9);

        if (!atacFet && armaDistancia >= 0) {
            Arma arma2 = (Arma) equip[armaDistancia];
            personatge.setpVida(personatge.getpVida() - arma2.getpAtac());
            System.out.println("El guerrero " + this.nom + " ha atacado a " + personatge.getNom() + " con " + arma2.getNom() +
                    " y ha inflingido " + arma2.getpAtac() + " puntos de daño.");
        } else if (!atacFet){
            personatge.setpVida(personatge.getpVida() - 1);
            System.out.println("El guerrero " +this.nom + " ha atacado a " + personatge.getNom() + " con sus puños y ha inflingido " +
                    1 + " punto de daño.");
        }

    }

    public double getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    public String toString(){
        String str ="---Guerrer-----\n" +  super.toString() + "\nPes maxim: " + this.pesMaxim + "\n---------------";
        return str;
    }

}
