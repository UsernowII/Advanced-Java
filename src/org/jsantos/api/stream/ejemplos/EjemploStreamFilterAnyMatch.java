package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.stream.Stream;


public class EjemploStreamFilterAnyMatch {

    public static void main(String[] args) {

        //Obteniendo un usuario de la lista
        boolean existe = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepito Mendez", "pepe garcia")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch( u -> u.getId().equals(2));// operador terminal


        System.out.println(existe); // obtenemos un solo objeto



    }
}
