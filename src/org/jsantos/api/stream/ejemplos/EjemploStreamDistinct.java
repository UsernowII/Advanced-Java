package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;


public class EjemploStreamDistinct {

    public static void main(String[] args) {


        Stream<String> nombres = Stream.of("pato Guzman", "paco gonzalez", "pepa Pig", "pepe Mendez",
                        "paco gonzalez", "paco gonzalez", "paco gonzalez")
                .distinct(); // elimina las coincidencias


        nombres.forEach(n -> System.out.println(n));




    }
}
