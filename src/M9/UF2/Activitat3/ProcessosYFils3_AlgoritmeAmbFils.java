package M9.UF2.Activitat3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ProcessosYFils3_AlgoritmeAmbFils extends RecursiveTask<Long> {
    long numero;
    public ProcessosYFils3_AlgoritmeAmbFils(long numero){
        this.numero=numero;
    }
    @Override
    protected Long compute() {
        // ATENCIO **1** double calcul = java.lang.Math.cos(54879854);
        if(numero <= 1) return numero;
        ProcessosYFils3_AlgoritmeAmbFils fib1 = new ProcessosYFils3_AlgoritmeAmbFils(numero-1);
        //fib1.fork();
        ProcessosYFils3_AlgoritmeAmbFils fib2 = new ProcessosYFils3_AlgoritmeAmbFils(numero-2);
        fib2.fork();
        return fib1.compute()+ fib2.join();
    }
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Calculat:  " + pool.invoke(new ProcessosYFils3_AlgoritmeAmbFils(35)));
    }
}



