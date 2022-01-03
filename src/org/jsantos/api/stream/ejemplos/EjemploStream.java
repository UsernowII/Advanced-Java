package org.jsantos.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class EjemploStream {

    public static void main(String[] args) {


        System.out.println("====Stream 1===");
        Stream <String> nombres = Stream.of("pato", "paco", "pepa", "pepe");
        nombres.forEach(System.out::println);

        System.out.println("====Stream 2===");
        String [] arreglo = {"pato", "paco", "pepa", "pepe"};
        Stream <String > nombres2 = Arrays.stream(arreglo);
        nombres2.forEach(System.out::println);

        System.out.println("====Stream 3===");
        Stream <String> nombres3 = Stream.<String>builder().add("pato")
                .add("camila")
                .add("juanes")
                .build();

        nombres3.forEach(System.out::println);

        System.out.println("====Stream 4====");

        List<String> lista = new ArrayList<>();
        lista.add("patricia");
        lista.add("patricio");
        lista.add("pancreas");
        lista.add("palomero");

        Stream<String> nombres4 = lista.stream();
        nombres4.forEach(System.out::println);

        lista.stream().forEach(System.out::println);

    }
}
