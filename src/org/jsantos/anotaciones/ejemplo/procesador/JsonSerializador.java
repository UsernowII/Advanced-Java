package org.jsantos.anotaciones.ejemplo.procesador;

import org.jsantos.anotaciones.ejemplo.Init;
import org.jsantos.anotaciones.ejemplo.JsonAtributo;
import org.jsantos.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonSerializador {


    public static void inicializarObjeto(Object objeto){

        if (objeto == null){
            throw new JsonSerializadorException("EL objeto a serializar no puede ser null");
        }

        Method[] metodos = objeto.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(method -> method.isAnnotationPresent(Init.class))
                .forEach(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(objeto);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede iniciar el objeto");
                    }
                });

    }


    public static String convertirJson(Object objeto){

        if (objeto == null){
            throw new JsonSerializadorException("EL objeto a serializar no puede ser null");
        }
        inicializarObjeto(objeto);

        Field[] campos = objeto.getClass().getDeclaredFields();

        return Arrays.stream(campos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("") ?
                            field.getName() : field.getAnnotation(JsonAtributo.class).nombre();

                    try {
                        Object valor = field.get(objeto);
                        if (field.getAnnotation(JsonAtributo.class).capitalizar()
                                && valor instanceof String){
                            String nuevoValor = (String) valor;
                            /*
                            nuevoValor = String.valueOf(nuevoValor.charAt(0)).toUpperCase() +
                                    nuevoValor.substring(1).toLowerCase();
                            field.set(objeto, nuevoValor);
                             */
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0,1).toUpperCase()
                                    + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));

                            field.set(objeto, nuevoValor);

                        }
                        return "\""+ nombre + "\":\"" + field.get(objeto) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error al serializar el json: " + e.getMessage());
                    }

                })
                .reduce("{", (a,b) ->{
                    if("{" .equals(a)){
                        return a + b;

                    }else {
                        return a + ", " + b;
                    }
                }).concat("}");
    }
}
