package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;


import java.util.stream.Stream;


public class EjemploStreamFilterEmpty {

    public static void main(String[] args) {


        long count = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez", "pepe garcia", "")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();

        System.out.println("count " + count);


    }
}
