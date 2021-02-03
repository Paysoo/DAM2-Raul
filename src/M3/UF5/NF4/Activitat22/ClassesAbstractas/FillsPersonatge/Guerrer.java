package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Guerrer extends Personatge {

    private double pesMaxim;

    public Guerrer(String nom, int edat, int força, int pVida, int pesMaxim) {
        super();
    }

    public Guerrer(){
    }

    public void atacar(Personatge personatge) {
        int pA = 0;

    }

    public double getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }


}
