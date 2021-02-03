package M3.UF5.NF4.Activitat22.Classes.FillsItem;

import M3.UF5.NF4.Activitat22.Classes.Item;

public class Arma extends Item {

    private int pAtac;
    private String tipus;

    public Arma(String nom, double pes, int valor, int pAtac, String tipus) {
        super(nom, pes, valor);
        this.pAtac = pAtac;
        this.tipus = tipus;

    }

    public int getpAtac() {
        return pAtac;
    }

    public void setpAtac(int pAtac) {
        this.pAtac = pAtac;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

}
