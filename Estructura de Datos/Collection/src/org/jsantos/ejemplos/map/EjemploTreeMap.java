package org.jsantos.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {

    public static void main(String[] args) {

        /// no pertenece a la interfaz collection

        //las llaves son unicas utiliza el metodo hashCode y equals
        // Son ordenados por la llave por defecto
        Map<String, Object> persona = new TreeMap<>((a,b)-> b.compareTo(a));

        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", 30);


        Map<String ,String> direccion = new TreeMap<>(Comparator.comparing(String::length).reversed());
        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "One street");
        direccion.put("numero", "120");


        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);


    }
}
