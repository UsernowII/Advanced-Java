package org.jsantos.api.stream.ejemplos.ejercicios;


/*
Obtener el número mayor de un arreglo, pero utilizando programación funcional,
 implementando la expresión lambda Function<T, R> (que viene predefinida) con el api stream y operador reduce.
 */

import java.util.Arrays;
import java.util.function.Function;

public class Ejercicio2 {

    public static void main(String[] args) {


        Function<Integer [], Integer>  maximo = n -> Arrays.stream(n)
                .reduce(0, (a , b) -> a > b ? a : b);


        Integer [] arreglo = new Integer[]{1, 25, 33, 74, 15, 66, 72};

        int resultado = maximo.apply(arreglo);

        System.out.println("resultado = " + resultado);
    }
}
