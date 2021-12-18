package org.jsantos.ejemplos.set;

import org.jsantos.ejemplos.modelo.Alumno;

import java.util.*;


public class EjemploHashSetUnicidad {

    public static void main(String[] args) {

        // compara mediante Equals y HashCode para no repetir elementos
        Set<Alumno> sa = new HashSet<>();
        //List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("pato", 5));
        sa.add(new Alumno("cata", 3));
        sa.add(new Alumno("camila", 2));
        sa.add(new Alumno("zeus", 7));
        sa.add(new Alumno("luci", 6));
        sa.add(new Alumno("sara", 4));


        //Objeto referencia distinta, pero con los mimos valores
        sa.add(new Alumno("sara", 4));
        System.out.println(sa);


        System.out.println("====== Iterando usando for each =====");
        for (Alumno a:sa) {
            System.out.println(a);
        }

        System.out.println("====== Iterando usando while y el iterator =====");

        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()){
            Alumno a = it.next();
            System.out.println(a);
        }

        // no se puede usar en un SET
        /*
        System.out.println("====== Iterando usando for Clasico =====");

        for (int i = 0; i <sa.size() ; i++) {
            Alumno a = sa.get(i);
            System.out.println(a.getNombre());
        }

         */

        System.out.println("====== Iterando usando Stream forEach Lambda =====");
        sa.forEach(alumno -> System.out.println(alumno.getNombre()));

    }
}
