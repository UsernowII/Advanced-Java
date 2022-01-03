package org.jsantos.java8.lambda.ejerciciocontador;


import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {

    Map <String, Integer> contarPalabras (String frase);
}
