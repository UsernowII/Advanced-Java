package org.jsantos.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        //ejecución multi hilo simultanea
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());



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


        Callable<Integer> tarea2 = () ->{
            System.out.println("Iniciando tarea 3");
            TimeUnit.MILLISECONDS.sleep(1000);
            return 10;
        };

        Future <String> resultado = executor.submit(tarea);
        Future <String> resultado2 = executor.submit(tarea);
        Future <Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continuando con la ejecución del main");

        while ( !(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.printf("Resultado 1: %s - Resultado 2: %s - Resultado3: %s%n",
                    resultado.isDone() ? "Finalizo" : "en proceso",
                    resultado2.isDone() ? "Finalizo" : "en proceso",
                    resultado3.isDone() ? "Finalizo" : "en proceso"
                    );
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("Obtenemos resultado1 de la tarea: " + resultado.get());
        System.out.println("Finalizo la tarea 1: " + resultado.isDone());

        System.out.println("Obtenemos resultado de la tarea: " + resultado2.get());
        System.out.println("Finalizo la 2: " + resultado2.isDone());

        System.out.println("Obtenemos resultado de la tarea: " + resultado3.get());
        System.out.println("Finalizo la 3: " + resultado3.isDone());
    }
}
