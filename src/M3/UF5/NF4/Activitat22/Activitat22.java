package M3.UF5.NF4.Activitat22;

import M3.UF5.NF4.Activitat22.Classes.Item;
import M3.UF5.NF4.Activitat22.ClassesAbstractas.FillsPersonatge.Mag;

public class Activitat22 {
    public static void main(String[] args) {

        Item[] equip = new Item[10];

        Item item;

        String nom = "item";
        double pes = 0.1;
        int valor = 10;

        for (int i = 0; i < equip.length; i++) {

            item = new Item();
            item.setNom(nom+i);
            item.setPes(pes+i);
            item.setValor(valor+i);

            equip[i] = item;
        }

        Mag mag = new Mag("Maruja la Pirobruja", 47, 13, 500, equip, 40, 90);

        System.out.println(mag.toString());
    }
}
