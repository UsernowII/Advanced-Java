package org.jsantos.ejemplos.list;

import org.jsantos.ejemplos.modelo.Alumno;


import java.util.*;


public class EjemploListComparableComparator {

    public static void main(String[] args) {

        // compara mediante Equals y HashCode para no repetir elementos
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("pato", 5));
        sa.add(new Alumno("cata", 3));
        sa.add(new Alumno("camila", 2));
        sa.add(new Alumno("zeus", 7));
        sa.add(new Alumno("luci", 6));
        sa.add(new Alumno("sara", 4));



        //Objeto referencia distinta, pero con los mimos valores
        sa.add(new Alumno("sara", 4));
        System.out.println(sa);


        //ordenamiento (usa el compare to )
        //Collections.sort(sa, (a,b)-> b.compareTo(a));
        //sa.sort((a,b)-> b.compareTo(a));
        sa.sort(Comparator.comparing((Alumno a)-> a.getNota()).reversed());
        System.out.println(sa);

        System.out.println("====== Iterando usando Stream forEach Lambda =====");
        sa.forEach(System.out::println);

    }
}
