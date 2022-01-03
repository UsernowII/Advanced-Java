package org.jsantos.optional.ejemplo;

import org.jsantos.optional.ejemplo.models.Computador;
import org.jsantos.optional.ejemplo.models.Fabricante;
import org.jsantos.optional.ejemplo.models.Procesador;
import org.jsantos.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.jsantos.optional.ejemplo.repositorio.Repositorio;


public class EjemploRepositorioMapFilter {

    public static void main(String[] args) {


        Repositorio<Computador> repositorio = new ComputadorRepositorio();


        String fabricante = repositorio.filtrar("asus")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter( f -> "amd".equalsIgnoreCase(f.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");


        System.out.println(fabricante);

    }
}
