package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.stream.Stream;


public class EjemploStreamFilterCount {

    public static void main(String[] args) {

        //Obteniendo un usuario de la lista
        long count = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepito Mendez", "pepe garcia")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .count();// operador terminal


        System.out.println(count); // obtenemos un solo objeto

        

    }
}
