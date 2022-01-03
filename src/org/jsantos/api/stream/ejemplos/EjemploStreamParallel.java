package org.jsantos.api.stream.ejemplos;

import org.jsantos.api.stream.ejemplos.model.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {

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

        long t1 = System.currentTimeMillis();

        String  resultado = lista.stream()
                .parallel()
                .map( u -> u.toString().toUpperCase())
                .peek( n ->{
                    System.out.println("Nombre del thread: " + Thread.currentThread().getName()
                    + " - " + n);
                })
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                        .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2-t1));
        System.out.println(resultado);



    }
}
