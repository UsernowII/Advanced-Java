package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;


public class EjemploStreamDistinctUsuario {

    public static void main(String[] args) {

        //Map devuelve el dato transformado
        Stream<Usuario> nombres = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez", "pepe garcia",
                        "pato Guzman","pato Guzman","pato Guzman")

                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);

        // Se repiten los usuarios porque son diferentes instancias
        // se implementa el  método equals para comparar los valores de cada objeto
    }
}
