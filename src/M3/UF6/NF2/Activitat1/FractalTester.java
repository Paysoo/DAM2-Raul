package M3.UF6.NF2.Activitat1;

import java.util.Scanner;

public class FractalTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int longitud;
        int contador = 1;
        longitud = teclado.nextInt();
        int sumaTotal = longitud * 4;

        while (longitud > 1) {
            longitud = (int) Math.floor(longitud / 2);
            contador *= 4;
            sumaTotal += longitud * contador * 4;
        }
        System.out.println(sumaTotal);
    }
}
