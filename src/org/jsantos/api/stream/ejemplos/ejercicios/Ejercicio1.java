package org.jsantos.api.stream.ejemplos.ejercicios;
/*
 En un arreglo de 100 elementos del 1 al 100, del tipo int,
 utilizando el api stream se pide eliminar los divisibles en 10,
 luego convertir los elementos restante del flujo en tipo double y dividirlos en 2,
 para finalmente devolver la suma total de todos ellos usando el operador terminal reduce.
 El resultado debería ser 2250.0
 */


import java.util.Arrays;


public class Ejercicio1 {

    public static void main(String[] args) {

        int [] arreglo  = new int[100];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = i+1;
        }


        double total = Arrays.stream(arreglo)
                .filter( number -> number % 10 != 0)
                .mapToDouble( number -> number /2)
                .reduce(0, (a,b) -> a+b);


        System.out.println(total);

    }
}
