package M9.UF2.Activitat1;

import java.util.*;
import java.util.concurrent.*;

public class ProcessosYFils {

    static class Sumar implements Callable<Integer> { // Cambio el nombre de la clase a Sumar
        private int operador1;
        private int operador2;

        public Sumar(int operador1, int operador2) {
            this.operador1 = operador1;
            this.operador2 = operador2;
        }

        @Override
        public Integer call() throws Exception {
            return operador1 + operador2; // Cambio la operación * a +
        }
    }

    public static void main(String[] args) throws
            InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5); //Cambio de 2 a 5 hilos
        List<Sumar> llistaTasques= new ArrayList<Sumar>();

        for (int i = 0; i < 25; i++) { // Cambio de 10 a 25 tasques
            Sumar calcula = new Sumar((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);
        }

        List <Future<Integer>> llistaResultats;
        llistaResultats = executor.invokeAll(llistaTasques);

        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);

            try {
                System.out.println("Resultat tasca "+ i + " és:" +
                        resultat.get());
            } catch (InterruptedException | ExecutionException e) {

            }
        }
    }
}

