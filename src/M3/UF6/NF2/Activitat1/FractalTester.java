package M3.UF6.NF2.Activitat1;

import java.util.Scanner;

public class FractalTester {
    private static int sumaTotal = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int longitud;
        int contador = 1;
        longitud = teclado.nextInt();

    // FORMA NO RECURSIVA
//        while (longitud > 1) {
//            longitud = (int) Math.floor(longitud / 2);
//            contador *= 4;
//            sumaTotal += longitud * contador * 4;
//        }
//        System.out.println(sumaTotal);

        System.out.println(calcularRecursivament(longitud, contador));
    }

    // FORMA RECURSIVA
    public static int calcularRecursivament(int longitud, int contador){

        sumaTotal += longitud * contador * 4;

        if (longitud <= 1) {
            return sumaTotal;
        } else {
            return calcularRecursivament((int)Math.floor(longitud/2), contador*4);
        }

    }
}
