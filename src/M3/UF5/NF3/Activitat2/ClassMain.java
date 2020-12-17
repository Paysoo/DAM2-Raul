package M3.UF5.NF3.Activitat2;

import java.util.Scanner;

public class ClassMain {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tester tester = new Tester();
        System.out.println("Cuantos numeros quieres introducir");
        int longitud = teclado.nextInt();

        int nums[] = new int[longitud];
        int numsTornats[] = new int[longitud];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Introduce un numero entero");
            nums[i] = teclado.nextInt();

            int num = nums[i];
            int numTornat = 0;
            int modulo;

            // Guardo el numero al reves
            while (num > 0) {
                modulo = num % 10;
                numTornat = numTornat * 10 + modulo;
                num /= 10;
            }

            numsTornats[i] = numTornat;

        }

        for (int i = 0; i < nums.length; i++) {
            if (tester.comprobacio(nums[i], numsTornats[i])) {
                System.out.println(nums[i] + " - SI");
            } else {
                System.out.println(nums[i] + " - NO");
            }
        }

    }
//          36
//        904
//        1010
//        37
//        209
//        0
}
