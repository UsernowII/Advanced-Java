package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class EjemploStreamDistinctUsuarioSum {

    public static void main(String[] args) {

        //Map devuelve el dato transformado
        IntStream largoNombres = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez", "pepe garcia",
                        "pato Guzman","pato Guzman","pato Guzman")

                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .peek( u-> System.out.println(u.toString()))
                .mapToInt( u -> u.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);

        // Se repiten los usuarios porque son diferentes instancias
        // se implementa el  método equals para comparar los valores de cada objeto

        //System.out.println(largoNombres.sum());

        IntSummaryStatistics stats = largoNombres.summaryStatistics();

        System.out.println("largoNombres = " + stats.getSum());
        System.out.println("Maximo= " + stats.getMax());
        System.out.println("Promedio= " + stats.getAverage());
    }
}
