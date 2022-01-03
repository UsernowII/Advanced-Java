package org.jsantos.api.stream.ejemplos.ejercicios;

/*
 Para una lista de productos List<Producto>
 de 3 a 5 elementos, se pide calcular el importe (precio por cantidad) y sumarlos.

 La clase Producto debe tener el atributo precio del tipo double y cantidad int,
 entonces utilizando stream convertir la lista de productos en el gran total del tipo double.
 */

import java.util.Arrays;
import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args) {


        List<Ejercicio4Producto> facturas = Arrays.asList(new Ejercicio4Producto(2,150000),
                (new Ejercicio4Producto(3,52000)),
                (new Ejercicio4Producto(2,25000)),
                (new Ejercicio4Producto(4,10000))   );


        double total = facturas.stream()
                .mapToDouble( factura -> factura.getPrecio() * factura.getCantidad())
                .peek(System.out::println)
                .sum();


        System.out.println("====TOTAL====");
        System.out.println(total);
    }
}
