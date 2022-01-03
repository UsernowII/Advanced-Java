package org.jsantos.api.stream.ejemplos;

import org.jsantos.api.stream.ejemplos.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {

    public static void main(String[] args) {


        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario("Andres", "Gomez"));
        lista.add(new Usuario("Jhon", "Doe"));
        lista.add(new Usuario("Lucia", "Perez"));
        lista.add(new Usuario("Sara", "Sarmiento"));
        lista.add(new Usuario("Oscar", "Raniz"));
        lista.add(new Usuario("Joel", "Joto"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("Bruce", "Willis"));


        Stream <String> nombres = lista.stream()
                .map( u ->  u.getNombre().toUpperCase()
                        .concat(" ")
                        .concat( u.getApellido().toUpperCase() ))
                .flatMap(nombre -> {
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);


        System.out.println(lista);

        System.out.println(nombres.count());

    }
}
