package M3.UF5.NF4.Activitat22.Classes.FillsItem;

import M3.UF5.NF4.Activitat22.Classes.Item;

public class Pocio extends Item {
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getEfecte() {
        return efecte;
    }

    public void setEfecte(int efecte) {
        this.efecte = efecte;
    }

    private String descripcio;
    private int efecte;
}
