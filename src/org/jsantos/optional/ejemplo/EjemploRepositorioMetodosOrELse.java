package org.jsantos.optional.ejemplo;

import org.jsantos.optional.ejemplo.models.Computador;
import org.jsantos.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.jsantos.optional.ejemplo.repositorio.Repositorio;


public class EjemploRepositorioMetodosOrELse {

    public static void main(String[] args) {


        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador defecto = new Computador("HP omen", "L7889");

        // orElse devuelve el optional
        Computador pc = repositorio.filtrar("asus3").orElse(valorDefecto());
        System.out.println(pc);

        pc = repositorio.filtrar("mackbook5").orElseGet(
                //()-> new Computador("HP omen2", "L7889")
                ()-> valorDefecto()
        );
        System.out.println(pc);

    }


    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP omen2", "L7889");

    }

    //OrElseGet nunca llama el método u objeto por defecto si está presente
}
