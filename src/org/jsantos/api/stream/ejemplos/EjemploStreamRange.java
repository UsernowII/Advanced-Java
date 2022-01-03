package org.jsantos.api.stream.ejemplos;


import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class EjemploStreamRange {

    public static void main(String[] args) {


        IntStream num = IntStream.range(5,20).peek(System.out::println); // en un rango , el segundo valor no se incluye dentro del rango

        // range no incluye el ultimo valor
        // rangeClose se incluye el ultimo valor


        //int resultado = num.reduce( 0, (a,b) -> a + b);
        //System.out.println( resultado);

        //int resultado2 = num.sum();
        //System.out.println(resultado2);

        IntSummaryStatistics stats = num.summaryStatistics();
        System.out.println("Maximo: " + stats.getMax());
        System.out.println("Minimo: " + stats.getMin());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
        System.out.println("Total: " + stats.getCount());








    }
}
