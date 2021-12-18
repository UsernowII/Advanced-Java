package org.jsantos.ejemplos.set;

import org.jsantos.ejemplos.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {

    public static void main(String[] args) {

        // todos los objetos deben ser comparables
        //Set<Alumno> sa = new TreeSet<>((a,b)-> a.getNombre().compareTo(b.getNombre()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNota).reversed());
        sa.add(new Alumno("pato", 5));
        sa.add(new Alumno("cata", 3));
        sa.add(new Alumno("camila", 2));
        sa.add(new Alumno("zeus", 7));
        sa.add(new Alumno("luci", 6));
        sa.add(new Alumno("sara", 4));

        // método compare-to retorna 0 si está repetido (en este caso compara por nombre)
        sa.add(new Alumno("sara", 4));
        System.out.println(sa);
    }
}
