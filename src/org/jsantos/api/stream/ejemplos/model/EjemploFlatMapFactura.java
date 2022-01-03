package org.jsantos.api.stream.ejemplos.model;

import java.util.Arrays;
import java.util.List;

public class EjemploFlatMapFactura {

    public static void main(String[] args) {


        Usuario usuario1 = new Usuario("Jhon", "Doe");
        Usuario usuario2 = new Usuario("Pepe", "Perez");

        usuario1.addFactura(new Factura("compras tecnologías"));
        usuario1.addFactura(new Factura("compras muebles"));


        usuario2.addFactura(new Factura("Bicicleta"));
        usuario2.addFactura(new Factura("Notebook Gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        usuarios.stream().flatMap( u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion()
                        .concat(" :cliente ")
                        .concat(f.getUsuario().toString())));

        /*
        for (Usuario u: usuarios){
            for (Factura f: u.getFacturas()) {
                System.out.println(f.getDescripcion());
            }
        }
        */



    }
}
