package org.jsantos.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {

    public static void main(String[] args) {

        /// no pertenece a la interfaz collection

        //las llaves son unicas utiliza el metodo hashCode y equals
        Map<String, Object> persona = new HashMap<>();
        System.out.println("contiene elementos? = " + !persona.isEmpty());


        persona.put(null, "1234");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", 30);


        Map<String ,String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "One street");
        direccion.put("numero", "120");


        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);


        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.get("barrio");

        System.out.println("===== Map direccion dentro de un Map");
        System.out.println("El pais de " + nombre + " es: " + pais);
        System.out.println("El pais de " + nombre + " es: " + ciudad);
        System.out.println("El pais de " + nombre + " es: " + barrio);


        String valorApellido = (String) persona.remove("apellido");
        System.out.println("valorApellido = " + valorApellido);
        System.out.println("persona = " + persona);

        boolean b = persona.remove("apellido", "Doe");
        System.out.println("Lo removió ?= " + b);

        boolean b2 = persona.containsKey("apellido");
        System.out.println("Contiene esa llave? = " + b2);

        boolean b3 = persona.containsValue("30");
        System.out.println("Contiene ese valor? = " + b3);


        System.out.println("=== iterando valores =====");

        Collection<Object> valores = persona.values();
        valores.forEach(System.out::println);

        System.out.println("=== iterando llaves =====");

        Set<String> llaves = persona.keySet();
        for (String k: llaves) {
            System.out.println("k = " + k);
        }

        System.out.println("=== iterando con entrySet =====");
        for (Map.Entry<String, Object> par: persona.entrySet()) {
            Object valor = par.getValue();
            if (valor instanceof Map) {
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for (Map.Entry<String, String> parDir: direccionMap.entrySet()){
                    System.out.println(parDir.getKey()+ " = > "+ parDir.getValue());
                }
            } else {

                System.out.println(" + par.getKey() par.getValue() = " + par.getKey() + " " + valor);
            }
        }

        System.out.println("====== Iterando con dos for=======");

        for (String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if (valor instanceof Map){
               Map<String, String> direccionMap = (Map<String, String>)  valor;
                System.out.println("EL pais de " + persona.get("nombre")+ ":"
                    + direccionMap.get("pais"));

                System.out.println("La ciudad de  " + persona.get("nombre")+ ":"
                        + direccionMap.get("ciudad"));
            }else{

            System.out.println( llave + " => " + valor);
            }
        }

        System.out.println("====== Iterando con forEach Java 8 Lambda=======");
        persona.forEach((llave , valor)->{
            System.out.println(llave + " => " + valor);
        });


        System.out.println("total:" + persona.size());
        System.out.println("contiene elementos? = " +!persona.isEmpty());
        persona.replace("edad", "45");

        System.out.println("persona = " + persona);

        boolean p3 =  persona.replace("edad", "45", "50");

        System.out.println("persona = " + p3);
        System.out.println("persona = " + persona);

    }
}
