package org.jsantos.hilos.ejemploexecutor;

import org.jsantos.hilos.ejemplosync.Panaderia;
import org.jsantos.hilos.ejemplosync.runnable.Consumidor;
import org.jsantos.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        //ejecución multi hilo simultanea
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);


        Future <?> futuro1 = executor.submit(productor);
        Future <?> futuro2 = executor.submit(consumidor);


        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());


        executor.shutdown();
        System.out.println("Continuando con la ejecución del main");



        System.out.println("Obtenemos resultado1 de la tarea: " + futuro1.get());
        System.out.println("Finalizo la tarea 1: " + futuro1.isDone());

        System.out.println("Obtenemos resultado de la tarea: " + futuro2.get());
        System.out.println("Finalizo la 2: " + futuro2.isDone());

    }
}
