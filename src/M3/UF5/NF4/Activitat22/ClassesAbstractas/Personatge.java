package M3.UF5.NF4.Activitat22.ClassesAbstractas;

import M3.UF5.NF4.Activitat22.Classes.FillsItem.Pocio;
import M3.UF5.NF4.Activitat22.Classes.Item;

import java.util.Arrays;

public abstract class Personatge {
    protected String nom;
    protected int edat;
    protected int força;
    protected int pVida;
    protected Item[] equip = new Item[10];

    public Personatge(String nom, int edat, int força, int pVida) {
        this.nom = nom;
        this.edat = edat;
        this.força = força;
        this.pVida = pVida;
    }

    public boolean equipar(Item item){
        boolean potEquipar = false;
        boolean salir = false;
        int contador = 0;

        do {
            if (this.equip[contador] == null) {
                this.equip[contador] = item;
                System.out.println(this.equip[contador].getNom() + " equipado correctamente en el inventario de " +
                        this.nom + ".");
                potEquipar = true;
                salir = true;
            } else {
                if (contador < 9) {
                    contador++;
                } else {
                    System.out.println("No hay espacio en el invetario de " + this.nom + ".");
                    salir = true;
                }
            }
        } while (!salir);

        System.out.println("Equip de " + this.getNom() + ":\n[ "+ mostrarEquip() + "]");

        return potEquipar;
    }

    public void beure() {
        boolean sortir = false;
        int contador = 0;

        System.out.println("Vida de " + this.getNom() + " -- " + this.getpVida());

        while (!sortir && contador < 9) {
            if (!(this.equip[contador] == null) && (this.equip[contador].getClass() == Pocio.class )) {
                Pocio pocio = (Pocio) equip[contador];
                int efecte = pocio.getEfecte();
                this.pVida += efecte;
                sortir = true;

                this.equip[contador] = null;

                System.out.print(this.nom + " ha ingerido " + pocio.getNom());

                if (efecte > 0) {
                    System.out.println(" y ha recuperado " + pocio.getEfecte() + " puntos de vida.");
                } else {
                    System.out.println(" y ha perdido " + pocio.getEfecte() + " puntos de vida.");
                }
                System.out.println("Vida de " + this.getNom() + " -- " + this.getpVida());
                System.out.println(pocio.getNom() + " ha desaparecido del inventario de " + this.getNom() + ".");

            } else {
                contador++;
            }
        }

    }

    public abstract void atacar(Personatge personatge);

    public String mostrarEquip() {

        String equipacion = "| ";
        for (int i = 0; i < this.equip.length; i++) {
            if(!(this.equip[i] == null)) {
                equipacion += this.equip[i].getNom() + " | ";
            }
        }
        return equipacion;
    }

    public void ordenarEquip(){
        for (int i = 0; i < (this.equip.length - 1); i++) {
            for (int j = i + 1; j < this.equip.length; j++) {
                if ((this.equip[i] != null) && (this.equip[j] != null)){
                    if (this.equip[i].getValor() < this.equip[j].getValor()) {
                        Item aux = this.equip[i];
                        this.equip[i] = this.equip[j];
                        this.equip[j] = aux;
                    }
                }
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

        return "[Personatge]\nNom: " + this.nom + "\nEdat: " + this.edat +
                "\nForça: " + this.força + "\nVida: " + this.pVida;
    }

}


