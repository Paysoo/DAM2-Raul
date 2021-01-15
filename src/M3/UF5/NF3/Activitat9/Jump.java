package M3.UF5.NF3.Activitat9;

import java.util.Arrays;
import java.util.Scanner;

public class Jump {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double[] notas = new double[7];

        for (int i = 0; i < notas.length; i++) {
        notas[i] = teclado.nextDouble();
        }

//        JumpTester jumpTester = new JumpTester();

        Arrays.sort(notas);
        double suma = 0.0;
        for (int i = 0; i < notas.length; i++) {
        if (i != 0 && i != 1 && i != 5 && i!=6) {
        suma += notas[i];
        }
        }
        double notaFinal = suma * 2;

        System.out.println(suma);

        for (int i = 0; i < notas.length; i++) {
        System.out.println(notas[i]);
        }
        System.out.println(notaFinal);

//        jumpTester.notaFinal(suma);
//
//        for (int i = 0; i < notas.length; i++) {
//            System.out.println(notas[i]);
//        }

        }
        }
/* 4,4
9,9
6,6
5,5
7,7
3,3
9,9 */

/* 7,5
7,0
7,5
7,5
7,5
8,0
7,5
 */