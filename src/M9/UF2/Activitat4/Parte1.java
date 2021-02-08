/*
 * File: Parte1.java
 * Author: Raúl Garrido y Aitor Pumar
 * Date: 07/02/2021
 */
package M9.UF2.Activitat4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Parte1 {

    static class Cliente implements Runnable {

        private int[] tiempos = {2, 3, 4, 5, 6, 7, 8};
        private int numCliente;
        private int articulos = (int) (Math.random() * 30) + 1;

        public Cliente(int num) {
            this.numCliente = num;
            System.out.println("Creado cliente " + num + " : " + articulos + " articulos");
        }

        public static void main(String[] args) throws InterruptedException, ExecutionException {

            int numClientes = 50;
            int ms = 3000;
            ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool (5);

            for(int i = 0; i <= numClientes; i++) {
                Cliente task = new Cliente(i);
                Thread.sleep(ms);
                executor.execute(task);
            }
            executor.shutdown();
        }

        @Override
        public void run() {

            int tRandom;

            System.out.println("Cliente " + numCliente + " pasa por caja ...");
            for (int i = 1; i < articulos + 1; i++) {
                tRandom = (int) (Math.random() * 5);
                try {
                    Thread.sleep(tiempos[tRandom] * 1000);
                }catch (InterruptedException e) {
                    System.err.println("ERROR");
                }

                System.out.print("Cliente " + numCliente + " article " + i + "/" + articulos + " (" + tiempos[tRandom] + " segundos)");

                if (i == articulos) {
                    System.out.print(" Final");
                }
                System.out.println();
            }
        }
    }
}
