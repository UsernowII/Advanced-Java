package org.jsantos.api.stream.ejemplos;


import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EjemploStreamFilterSingle {

    public static void main(String[] args) {

        //Map devuelve el dato transformado
        Stream <Usuario> nombres = Stream
                .of("pato Guzman", "paco Gonzalez", "pepa Pig", "pepe Mendez", "pepe garcia")
                .map (nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter( u ->{
                    return u.getNombre().equals("pepe");
                })
                .peek( usuario -> System.out.println(usuario.getNombre()));

        //nombres.forEach(System.out::println);

        Optional < Usuario > usuario = nombres.findFirst();
        //System.out.println(usuario.orElseThrow());
        //System.out.println(usuario.orElse(new Usuario("john", "Doe")).getNombre().toUpperCase()); // obtenemos un solo objeto
        //System.out.println(usuario.orElseGet( ()-> new Usuario("john", "Doe")).getNombre());
        if(usuario.isPresent()){
            System.out.println(usuario.get().getNombre());
        }else{
            System.out.println("no se encontró el objeto");
        }



    }
}
