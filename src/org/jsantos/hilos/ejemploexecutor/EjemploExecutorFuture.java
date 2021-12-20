package org.jsantos.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Runnable tarea = () ->{ No devuelve valor
        Callable<String> tarea = () ->{
            System.out.println("Inicio de la tarea ...");
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea ...");
            return "Algún resultado importante de la tarea";
        };

        Future <String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del main 1");

        while ( !resultado.isDone()){
            System.out.println("Ejecutantdo tarea ...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println(resultado.isDone());

        System.out.println(resultado.get()); // EL get espera que finalize, puede recibir de ejecución
        System.out.println(resultado.isDone());
    }
}
