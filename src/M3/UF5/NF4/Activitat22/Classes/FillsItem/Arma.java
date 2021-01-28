package M3.UF5.NF4.Activitat22.Classes.FillsItem;

import M3.UF5.NF4.Activitat22.Classes.Item;

public class Arma extends Item {
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

    private int pAtac;
    private String tipus;
}
