package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EjemploStreamFlatMap {

    public static void main(String[] args) {

        //Map devuelve el dato transformado , devuelve un objeto
        //flatmap devuelve un stream de ese objeto
        Stream <Usuario> nombres = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez", "pepe garcia")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap( u ->{ // filtra el elemento encontrado retorna un stream
                    if(!u.getNombre().equals("pepe")){
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .peek( usuario -> System.out.println(usuario.getNombre()));

        //nombres.forEach(System.out::println);


        System.out.println(nombres.count());


    }
}
