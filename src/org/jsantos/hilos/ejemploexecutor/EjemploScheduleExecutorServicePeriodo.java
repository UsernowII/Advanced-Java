package org.jsantos.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduleExecutorServicePeriodo {

    public static void main(String[] args) throws InterruptedException {


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main . . .");

        //instancia cuenta regresiva
        CountDownLatch lock = new CountDownLatch(5);

        AtomicInteger contador = new AtomicInteger(5);

        // Se repite cada periodo de tiempo especificado
        Future<?> future = executorService.scheduleAtFixedRate( () ->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                //lock.countDown();
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hola mundo tarea programada ....");
        },1000, 2000,TimeUnit.MILLISECONDS );

        //lock.await();
        //future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);

        while(contador.get() > 0){
            if (contador.get() == 0){
                future.cancel(true);
                contador.getAndDecrement();
            }
        }
        System.out.println("Alguna otra tarea en el main . . .");
        executorService.shutdown();

    }
}
