package org.jsantos.optional.ejemplo;

import org.jsantos.optional.ejemplo.models.Computador;
import org.jsantos.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.jsantos.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {

    public static void main(String[] args) {


        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Optional<Computador> pc = repositorio.filtrar("asus");

        if (pc.isPresent() ){
            System.out.println(pc.get());
        } else{
            System.out.println("No se encontró");
        }


        //Funcional

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontró"));

    }
}
