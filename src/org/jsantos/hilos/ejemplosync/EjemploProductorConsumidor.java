package org.jsantos.hilos.ejemplosync;

import org.jsantos.hilos.ejemplosync.Panaderia;
import org.jsantos.hilos.ejemplosync.runnable.Consumidor;
import org.jsantos.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {

    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();

        new Thread(new Panadero(panaderia)).start();

        new Thread(new Consumidor(panaderia)).start();
    }
}
