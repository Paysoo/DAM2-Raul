package M3.UF5.NF3.Activitat3;

import java.util.Scanner;

public class CoffeeAverageTester {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el numero de medidas que quieres introducir");
        int numMedidas = teclado.nextInt();

        double medidas[] = new double[numMedidas];
        double sum = 0;
        double media1;

        for (int i = 0; i < medidas.length; i++) {
            System.out.println("Introduce el resultado [PH] de la muestra " + (i+1));
            medidas[i] = teclado.nextDouble();
            sum += medidas[i];
        }

        media1 = sum / numMedidas;

        double numDistante = 0;
        double numAux = 0;

        for (int i = 0; i < medidas.length; i++) {
            for (int j = 0; j < medidas.length; j++) {
                if (numAux < Math.abs(medidas[i] - medidas[j]) )
                    numAux = Math.abs(medidas[i] - medidas[j]);
                    numDistante = medidas[i];
            }
        }

        for (int i = 0; i < medidas.length; i++) {
            System.out.println(medidas[i]);
        }
        System.out.println(numAux + "\nEl numero más disanciado del resto es: " + numDistante);
    }

}

