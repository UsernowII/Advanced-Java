package org.jsantos.java8.lambda;

import org.jsantos.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class EjemploConsumer {

    public static void main(String[] args) {

        Consumer<Date> consumer = date ->{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(format.format(date));
        };


        consumer.accept(new Date () );


        BiConsumer<String, Integer> consumerBi = (nombre, edad) ->{
            System.out.println(nombre + ", tiene " + edad + " años");
        };


        consumerBi.accept("Jhon", 29);


        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hola mundo Lambda");


        List<String> nombres = Arrays.asList("Andres", "pepe", "Luz", "Sara");

        System.out.println("==Implementacion consumer===");
        nombres.forEach(consumer2);

        System.out.println("==Implementacion consumer al vuelo===");
        nombres.forEach( nombre -> System.out.println(nombre));

        Supplier <Usuario> creaUsuario = () -> new Usuario();
        Usuario usuario = creaUsuario.get();


        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) ->{
          persona.setNombre(nombre);
        };

        BiConsumer<Usuario, String> asignarNombre2 = Usuario::setNombre;

        asignarNombre.accept(usuario, "Jhon");
        System.out.println("usuario con nombre = " + usuario.getNombre());


        Supplier<String> proveedor = () -> {
            return "Hola mundo Lambda Supplier";
        };

        System.out.println(proveedor.get());
    }


}
