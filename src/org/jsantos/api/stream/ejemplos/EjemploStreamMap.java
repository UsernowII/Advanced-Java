package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EjemploStreamMap {

    public static void main(String[] args) {

        //Map devuelve el dato transformado
        Stream <Usuario> nombres = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek( usuario -> {
                    System.out.println(usuario.getNombre());})
                .map( usuario -> {
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return  usuario;
                });
        //nombres.forEach(System.out::println);

        List< Usuario > lista = nombres.collect(Collectors.toList());
        System.out.println(" FOR EACH");
        lista.forEach( usuario -> {
            System.out.println(usuario.getApellido());
        });


    }
}
