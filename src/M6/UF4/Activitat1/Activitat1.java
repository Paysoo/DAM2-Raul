package M6.UF4.Activitat1;

import ElsMeusBeans.Comanda;
import ElsMeusBeans.Producte;

public class Activitat1 {

    public static void main(String[] args) {
        Producte[] producte = new Producte[5];
        Comanda comanda = new Comanda();

        // Creo los productos
        producte[0] = new Producte(1, "Verduras", 500, 50, 5);
        producte[1] = new Producte(2, "Carne", 150, 15, 20);
        producte[2] = new Producte(3, "Postre", 70, 10, 3);
        producte[3] = new Producte(4, "Pescado", 100, 10, 30);
        producte[4] = new Producte(5, "Bebida", 2000, 20, 3);


        for (int i = 0; i < producte.length; i++) {
            producte[i].addPropertyChangeListener(comanda);

            //Es canvia l'estoc actual, se li dona valor 2
            producte[i].setStockactual(2);

            if (comanda.isDemana()) {
                System.out.println("Fer comanda en producte: "
                        + producte[i].getDescripcio());
            } else {
                System.out.println("No és necessari fer la comanda en producte: " +
                        producte[i].getDescripcio());
            }
        }

        // Llamo a la funcion para mostrar el stock minimo de todos los productos
        mostrarStockMinim(producte);
    }

    public static void mostrarStockMinim(Producte[] productes){
        for (int i = 0; i < productes.length; i++) {
            System.out.println("Stock minim de " + productes[i].getDescripcio() + ": " + productes[i].getStockminim());        }

    }

}
