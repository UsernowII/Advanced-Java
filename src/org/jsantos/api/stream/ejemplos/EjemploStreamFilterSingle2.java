package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.Optional;
import java.util.stream.Stream;


public class EjemploStreamFilterSingle2 {

    public static void main(String[] args) {

        //Obteniendo un usuario de la lista
        Usuario usuario = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepito Mendez", "pepe garcia")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter( u -> u.getId().equals(9))
                .findFirst().orElseGet(() -> new Usuario("jhon", "Doe")); // operador terminal



        //nombres.forEach(System.out::println);


        System.out.println(usuario.getNombre().toUpperCase()); // obtenemos un solo objeto



    }
}
