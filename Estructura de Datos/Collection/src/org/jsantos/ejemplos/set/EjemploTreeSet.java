package org.jsantos.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {

    public static void main(String[] args) {

        // tienen un costo de rendimiento porque son ordenados
        // Son ordenados
        Set<String> ts = new TreeSet<>((a,b) -> { // compare to de la Z a la A
                return b.compareTo(a);
        });
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");


        System.out.println("ts = " + ts);


        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder()); // orden reverso

        numeros.add(1);
        numeros.add(3);
        numeros.add(4);
        numeros.add(2);
        numeros.add(5);
        numeros.add(10);

        System.out.println("numeros = " + numeros);
    }
}
