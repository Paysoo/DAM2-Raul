/*
 * File: Parte2.java
 * Author: Raúl Garrido y Aitor Pumar
 * Date: 07/02/2021
 */

package M9.UF2.Activitat4;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Parte2 {

    static class ArrayNums implements Runnable {
        int grupo;
        int[] arrayNums;

        public ArrayNums(int grupo, int[] arrayNums) {
            this.grupo = grupo;
            this.arrayNums = arrayNums;
        }

        public static void main(String[] args) {

            int tamany = 8;
            int[] aleatori = new int[20];
            int fils = 4;
            int arrayNumsOrdenat[];

            ArrayNums[] arrayNums = new ArrayNums[4];

            for (int i = 0; i < aleatori.length; i++) {
                aleatori[i] = (int) (Math.random() * tamany) + 1;
            }

            System.out.println("Nums generats: " + Arrays.toString(aleatori) + "\n");

            int aux = 0;
            int[] auxiliars;
            for (int i = 0; i < arrayNums.length; i++) {
                auxiliars = new int[aleatori.length / 4];
                for (int j = 0; j < auxiliars.length; j++) {
                    auxiliars[j] = aleatori[aux];
                    aux++;
                }
                ArrayNums arrayActual = new ArrayNums(i, auxiliars);
                arrayNums[i] = arrayActual;
            }

            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(fils);

            threadPoolExecutor = executa(arrayNums, threadPoolExecutor);
            threadPoolExecutor.shutdown();

            arrayNumsOrdenat = new int[arrayNums[0].arrayNums.length * 4];

            int aux2;
            for (int i = 0; i < arrayNumsOrdenat.length; i++) {
                aux2 = comprobarMesPetit(arrayNums[0].arrayNums[contador[0]], arrayNums[1].arrayNums[contador[1]],
                        arrayNums[2].arrayNums[contador[2]], arrayNums[3].arrayNums[contador[3]]);
                arrayNumsOrdenat[i] = aux2;
                System.out.println(Arrays.toString(contador));
            }
            System.out.println("Array ordenado: " + Arrays.toString(arrayNumsOrdenat) + "\n");

        }

        @Override
        public void run() {
            int grupoAux;
            int[] arrayNumsAux;

            for (int i = 1; i < arrayNums.length; i++) {
                for (int j = 0; j < arrayNums.length - i; j++) {
                    if (arrayNums[j] > arrayNums[j + 1]) {
                        arrayNumsAux = arrayNums.clone();
                        grupoAux = arrayNums[j];
                        arrayNums[j] = arrayNums[j + 1];
                        arrayNums[j + 1] = grupoAux;
                        System.out.println((grupo + 1) + " " + Arrays.toString(arrayNumsAux) + " ---> " + Arrays.toString(arrayNums));
                    }
                }
            }
            System.out.println("El grupo final es " + Arrays.toString(arrayNums) + "\n");
        }
    }

    static int[] contador = {0, 0, 0, 0};

    private static ThreadPoolExecutor executa(ArrayNums[] arrayNums, ThreadPoolExecutor threadPoolExecutor) {

        for (int i = 0; i < arrayNums.length; i++) {
            threadPoolExecutor.execute(arrayNums[i]);
        }
        return threadPoolExecutor;
    }

    private static int comprobarMesPetit(int arrayNums, int arrayNums1, int arrayNums2, int arrayNums3) {
        int[] test = {arrayNums, arrayNums1,
                arrayNums2, arrayNums3};
        boolean comprueba = false;
        int min = arrayNums;
        int posicio = 0;
        for (int i = 0; i < test.length; i++) {
            if (contador[i] < 4) {
                if (test[i] <= min) {
                    min = test[i];
                    posicio = i;
                    comprueba = true;
                }
            }
        }
        if (comprueba) {
            contador[posicio]++;
        }
        return min;
    }
}

