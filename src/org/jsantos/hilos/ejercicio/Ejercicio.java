package org.jsantos.hilos.ejercicio;

/*Para la tarea se pide implementar una clase llamada AlfanumericoTarea que implemente
la interface Runnable y tenga como atributo un enum llamado Tipo.
El enum Tipo tiene dos elementos NUMERO Y LETRA.
Si el tipo es NUMERO, mostrara los números del 1 al 10, excluyente el último.
Si el tipo es LETRA, mostrar las letras de la 'A' a la 'Z', inclusivo el último.
Crea un par de hilos de diferentes tipos y ejecutarlos.

 */

public class Ejercicio {

    public static void main(String[] args) {

        AlfanumericoTarea tarea1 = new AlfanumericoTarea(Tipo.LETRA);
        AlfanumericoTarea tarea2 = new AlfanumericoTarea(Tipo.NUMERO);


        Thread t1 = new Thread(tarea1);
        Thread t2 = new Thread(tarea2);

        t1.start();
        t2.start();

    }






}
