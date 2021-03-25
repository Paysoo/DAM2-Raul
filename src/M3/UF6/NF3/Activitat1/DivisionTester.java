package M3.UF6.NF3.Activitat1;

import java.util.Scanner;

public class DivisionTester {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        boolean sortir = false;
        String divisor;
        String numerator;
        int result;

        while (!sortir) {
            System.out.println("Introduce el numerador");
            numerator = teclado.next();

            if (numerator.charAt(0) == 'q' || numerator.charAt(0) == 'Q') {
                sortir = true;
            } else {
                System.out.println("Introduce el divisor");
                divisor = teclado.next();

                try {
                    result = Integer.valueOf(numerator) / Integer.valueOf(divisor);
                    System.out.println(numerator + " / " + divisor + " = " + result);
                } catch (Exception e) {
                    System.out.println("No se ha podido dividir " + numerator + " entre " + divisor);
                }
            }
            System.out.println();
        }
    }
}
