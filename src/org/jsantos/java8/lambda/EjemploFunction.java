package org.jsantos.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {

    public static void main(String[] args) {


        Function <String, String> f1 = param -> "Puto raniz " + param;

        String resultado = f1.apply("perro manco dont respect");
        System.out.println(resultado);

        Function<String, String> f2 = String::toUpperCase;

        System.out.println(f2.apply("tu papa"));

        BiFunction <String, String, String > f3 = (a,b) -> a.toUpperCase().concat(b.toUpperCase());

        String r2 = f3.apply("Jhon", " Santos");
        System.out.println(r2);

        BiFunction <String, String, Integer> f4 = (a,b) -> a.compareTo(b);

        BiFunction <String, String, Integer> f5 = String::compareTo;

        BiFunction <String, String, String> f6 = String::concat;

        System.out.println(f4.apply("oscar", "jhon erick"));
        System.out.println(f5.apply("oscar", "jhon erick"));
        System.out.println(f6.apply("oscar", " raniz"));

    }
}
