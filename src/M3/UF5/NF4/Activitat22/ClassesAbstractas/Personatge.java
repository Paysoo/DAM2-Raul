package M3.UF5.NF4.Activitat22.ClassesAbstractas;

import M3.UF5.NF4.Activitat22.Classes.Item;

public abstract class Personatge {
    private String nom;
    private int edat;
    private int força;
    private int pVida;
    private Item[] equip = new Item[10];

    public int atacar(Personatge personatge){
        int pA = 0;

        return pA;
    }

    public boolean equipar(Item item){
        boolean espai = false;

        return espai;
    }

    public void beure(Item[] equip){
    }

    public void mostrarEquip(){

        for (int i = 0; i < this.equip.length; i++) {
            if(!(this.equip[i] == null)) {
                String equipament = new StringBuilder().append(this.equip[i].getNom()).append(" ").toString();
            }
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getForça() {
        return força;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public int getpVida() {
        return pVida;
    }

    public void setpVida(int pVida) {
        this.pVida = pVida;
    }

    public Item[] getEquip() {
        return equip;
    }

    public void setEquip(Item[] equip) {
        this.equip = equip;
    }

    public String toString() {
        String equipacion = "| ";
        for (int i = 0; i < this.equip.length; i++) {
            if(!(this.equip[i] == null)) {
                equipacion += this.equip[i].getNom() + " | ";
            }
        }

        return "[Personatge]\nNom: " + this.nom + "\nEdat: " + this.edat + "\nForça: " + this.força + "\nVida: " + this.pVida + "\nEquip: " +
                equipacion;
    }

}


