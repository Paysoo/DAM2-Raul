package M3.UF5.NF4.Activitat22.ClassesAbstractas;

import M3.UF5.NF4.Activitat22.Classes.Item;

public abstract class Personatge {
    protected String nom;
    protected int edat;
    protected int força;
    protected int pVida;
    protected Item[] equip = new Item[10];

    public boolean equipar(Personatge personatge, Item item){
        boolean potEquipar = false;
        boolean salir = false;
        int contador = 9;

        do {
            if (personatge.equip[contador] == null) {
                personatge.equip[contador] = item;
                potEquipar = true;
                salir = true;
            } else {
                if (contador >= 0) {
                    contador--;
                } else {
                    salir = true;
                }
            }
        } while (!salir);

        return potEquipar;
    }

    public void beure(Item[] equip){
    }

    public abstract void atacar(Personatge personatge);

    public String mostrarEquip(){

        String equipacion = "| ";
        for (int i = 0; i < this.equip.length; i++) {
            if(!(this.equip[i] == null)) {
                equipacion += this.equip[i].getNom() + " | ";
            }
        }
        return equipacion;
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

        return "[Personatge]\nNom: " + this.nom + "\nEdat: " + this.edat +
                "\nForça: " + this.força + "\nVida: " + this.pVida + "\nEquip: " +
                mostrarEquip();
    }

}


