package org.jsantos.anotaciones.ejemplo;

import org.jsantos.anotaciones.ejemplo.model.Producto;
import org.jsantos.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;


public class EjemploAnotacion {

    public static void main(String[] args) {


        Producto p = new Producto();

        p.setFecha(LocalDate.now());
        p.setNombre("Mesa de centro roble");
        p.setPrecio(1000L);


        System.out.println("Json Serializador = " + JsonSerializador.convertirJson(p));



    }
}
