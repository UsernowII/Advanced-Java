package org.jsantos.api.stream.ejemplos.ejercicios;


import java.util.Arrays;

/*
Aplanar un arreglo bidimensional en un nivel y eliminar repetidos usando el api stream.

Aplanar un arreglo significa quitar los elementos del arreglo anidado y dejarlos en el arreglo de primer nivel.
 */
public class Ejercicio3 {

    public static void main(String[] args) {


        String[][] lenguajes = {{"java", "groovy"},
                {"php"}, {"c#", "python", "groovy"},
                {"java", "javascript", "kotlin"},
                {"javascript"}, {}};

        // resultado {"java", "groovy", "php", "c#", "python", "javascript", "kotlin"};


        Arrays.stream(lenguajes)
                .flatMap(a -> Arrays.stream(a))
                .distinct()
                .forEach(System.out::println);

    }
}
