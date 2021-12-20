package org.jsantos.hilos.ejemplos;

import org.jsantos.hilos.ejemplos.Thread.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {


        Thread hilo = new NombreThread("Jhon Doe");
        System.out.println("hilo = " + hilo.getState());
        hilo.start();
        //Thread.sleep(100);


        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();

        Thread hilo3 = new NombreThread("Pepe");
        hilo3.start();

        System.out.println("hilo = " + hilo.getState());


    }
}
