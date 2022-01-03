package org.jsantos.optional.ejemplo;

import org.jsantos.optional.ejemplo.models.Computador;
import org.jsantos.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.jsantos.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;


public class EjemploRepositorioMetodosOrELseThrow {

    public static void main(String[] args) {


        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador defecto = new Computador("HP omen", "L7889");

        // orElseThrow arroja una excepción
        Computador pc = repositorio.filtrar("asus").orElseThrow();
        System.out.println(pc);

        // recibe una lambda como argumento
        pc = repositorio.filtrar("asus").orElseThrow(
                () -> new IllegalStateException()
        );
        System.out.println(pc);

        System.out.println("Ejemplo buscando una extension de archivo");

        String archivo = "documento.pdf";

        String extension = Optional.ofNullable(archivo)
                .filter( a -> a.contains("."))
                .map( a -> a.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow();

        System.out.println("extension = " + extension);

    }
}
