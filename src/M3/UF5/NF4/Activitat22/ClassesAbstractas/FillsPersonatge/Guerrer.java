package M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge;

import M3.UF5.NF4.Activitat22.ClassesAbstractas.Personatge;

public class Guerrer extends Personatge {
    public double getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    private double pesMaxim;

}
