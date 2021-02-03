package M3.UF5.NF4.Activitat22;

import M3.UF5.NF4.Activitat22.Classes.FillsItem.Arma;
import M3.UF5.NF4.Activitat22.Classes.FillsItem.Pocio;
import M3.UF5.NF4.Activitat22.Classes.Item;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge.Guerrer;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge.Mag;

public class Activitat22 {
    public static void main(String[] args) {

        Item[] equip = new Item[10];

        String nom = "item";
        double pes = 0.1;
        int valor = 10;

//        for (int i = 0; i < equip.length; i++) {
//
//            item = new Item("nom" + i, pes+i,valor+i);
//            equip[i] = item;
//        }

        Item item = new Item("Cofre", 3.1, 5000);
        Item item1 = new Item("Anell de rubi", 0.02,2300);

        Arma arma = new Arma("Espasa llarga", 3.1, 5000, 6, "Cos a cos");
        Arma arma1 = new Arma("Vareta magica", 0.125, 3200, 3, "Magica");
        Arma arma2 = new Arma("Arc de marfil", 1, 2800, 2, "Distancia");

        Pocio pocio = new Pocio("Hidromel", 0.2, 200, "Pocio de vida", 2);
        Pocio pocio1 = new Pocio("Suc d'escorpi", 0.125, 3200, "Veri", -2);

        Mag mag = new Mag("Benalises", 90, 3, 18, 26, 12);
        Mag mag1 = new Mag("Pedralba", 120, 4, 15, 21, 9);

        Guerrer guerrer = new Guerrer("Argelaga", 35, 12, 20, 120);
        Guerrer guerrer1 = new Guerrer("Matoll", 42, 15, 22, 112);

        if (mag.equipar(mag, item1)) {
            System.out.println("Item equipado correctamente");
        } else {
            System.out.println("No se ha podido equipar el item");
        }

        System.out.println(mag.toString());
    }
}
