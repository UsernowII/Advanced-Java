package org.jsantos.optional.ejemplo;


import java.util.Optional;


public class EjemploOptional {

    public static void main(String[] args) {


        String nombre = "Andres";

        Optional <String> opt = Optional.of(nombre);

        System.out.println("opt = " + opt);

        System.out.println(opt.isPresent());

        if (opt.isPresent()){
            System.out.println("hola " + opt.get());
        }

        System.out.println(opt.isEmpty());

        opt.ifPresent(string -> {
            System.out.println("hola " + string);
        });


        // ahora cuando es Null

        System.out.println("==== EJEMPLO CON NULL====");
        nombre = null;

        opt = Optional.ofNullable(nombre);

        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        opt.ifPresentOrElse((string -> System.out.println("Hola " + string)), () ->{
                System.out.println("No esta presente");
        });

        if (opt.isPresent()){
            System.out.println("hola " + opt.get());
        } else {
            System.out.println("No esta presente");
        }

        System.out.println("==== EJEMPLO CON OPTIONAL NULL====");

        Optional <String > optEmpty = Optional.empty();

        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
