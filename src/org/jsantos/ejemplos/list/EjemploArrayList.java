package org.jsantos.ejemplos.list;

import org.jsantos.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;


public class EjemploArrayList {

    public static void main(String[] args) {

        // compara mediante Equals y HashCode para no repetir elementos
        List<Alumno> al = new ArrayList<>();

        System.out.println(al + ",size = " + al.size());
        System.out.println("Esta vacia = " + al.isEmpty());
        al.add(new Alumno("pato", 5));
        al.add(new Alumno("cata", 3));
        al.add(new Alumno("camila", 2));
        al.add(2,new Alumno("zeus", 7));
        al.set(3,new Alumno("luci", 6));


        System.out.println(al + ",size = " + al.size());

        //al.remove(new Alumno("zeus",7)); // con el método equals
        al.remove(1);

        System.out.println(al + ",size = " + al.size());


        boolean b = al.contains(new Alumno("pato", 5));

        System.out.println("La lista contiene a pato = " + b);


        Object a [] = al.toArray();
        for (int i = 0; i < a.length ; i++) {
            System.out.println("Desde el arreglo= " + a[i]);
        }

    }

}
