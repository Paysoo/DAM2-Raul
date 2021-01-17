package M3.UF5.NF3.Activitat14;

import java.util.Scanner;

public class MalditosRomanosTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero de romanos");
        int numRomanos = teclado.nextInt();

        while (numRomanos>0) {
            int raizCuadrada = (int) Math.sqrt(numRomanos);

            int cuadrado = raizCuadrada * raizCuadrada;

            numRomanos -= cuadrado;
            System.out.println(cuadrado);
        }
    }
}
