package org.jsantos.api.stream.ejemplos;


import java.util.stream.Stream;


public class EjemploStreamReduce {

    public static void main(String[] args) {


        Stream<String> nombres = Stream.of("pato Guzman", "paco gonzalez", "pepa Pig", "pepe Mendez",
                        "paco gonzalez", "paco gonzalez", "paco gonzalez")
                        .distinct();// elimina las coincidencias



        String resultado = nombres.reduce( "Resultado de la concatenación",(a,b) -> a + "+ " +b);
        System.out.println( resultado);






    }
}
