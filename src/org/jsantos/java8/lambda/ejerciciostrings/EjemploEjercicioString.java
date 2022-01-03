package org.jsantos.java8.lambda.ejerciciostrings;

public class EjemploEjercicioString {

    public static void main(String[] args) {


        Frase format = frase -> {
            return frase.replace(".", "")
                    .replace(" ","")
                    .replace(",","")
                    .toUpperCase();
        };

        System.out.println(format.convertir("hola puto raniz manco"));

    }
}
