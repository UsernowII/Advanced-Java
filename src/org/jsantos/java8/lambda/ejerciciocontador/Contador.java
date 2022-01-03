package org.jsantos.java8.lambda.ejerciciocontador;


/*
Para la tarea se pide como requerimiento escribir una expresión lambda que cuenta
 la cantidad de veces que se repiten las palabras de una frase y devuelva la mas repetida,
 según lo siguiente:

La expresión lambda debe recibir por argumento una frase u oración y devolver un objeto Map
que contenga la palabra mas repetida de la frase como llave y la cantidad de veces que se repite como valor.
 */


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Contador {


    public static void main(String[] args) {

        ContadorPalabras contador = frase -> {
            // Limpiamos la frase eliminando los puntos, comas y dejamos todo en minisculas
            // luego con split convertimos la frase en un arreglo para iterarlo.
            frase.replace(".", "")
                    .replace(",", "")
                    .toLowerCase();
            String[] arregloFrases = frase.split(" ");
            // con un for doble iteramos cada palabra y la comparamos con cada una del arreglo.
            // así podemos calcular el máximo que se repite una palabra
            // definimos dos variables importantes la palabra mas repetida y el max o cantidad de veces que se repite la palabra

            int max = 0;
            String palabra = null;
            for (int i = 0; i < arregloFrases.length; i++) {
                int cantidad = 0;
                for (int j = 0; j < arregloFrases.length; j++) {
                    if (arregloFrases[i].equalsIgnoreCase(arregloFrases[j])) {
                        cantidad++;
                    }
                }

                if (cantidad > max) {
                    max = cantidad;
                    palabra = arregloFrases[i];


                }
            }
            return Collections.singletonMap(palabra, max);

            // finalmente devolvemos el resultado de la palabra mas repetida y el  numero de veces que se repite en un Map
            // donde la llave es la palabra y max la cantidad.

        };

        contador.contarPalabras("Yo ni te conozco, ni te he visto, ni se tu nombre")
                .forEach( (k,v) ->{
                    System.out.println("La palabra " + k +" se repite " + v);
                });

    }
       
}
