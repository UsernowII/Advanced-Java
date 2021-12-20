package org.jsantos.hilos.ejemplos;

import org.jsantos.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {

    public static void main(String[] args) {


        new Thread(new ViajeTarea("Isla de pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
