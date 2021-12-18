package org.jsantos.ejemplos.list;

import org.jsantos.ejemplos.modelo.Alumno;


import java.util.LinkedList;
import java.util.ListIterator;


public class EjemploLinkedList {

    public static void main(String[] args) {

        // compara mediante Equals y HashCode para no repetir elementos
        LinkedList<Alumno> enlazada = new LinkedList<>();

        System.out.println(enlazada + ",size = " + enlazada.size());
        System.out.println("Esta vacia = " + enlazada.isEmpty());
        enlazada.add(new Alumno("pato", 5));
        enlazada.add(new Alumno("cata", 3));
        enlazada.add(new Alumno("camila", 2));
        enlazada.add(new Alumno("zeus", 7));
        enlazada.add(new Alumno("luci", 6));


        System.out.println(enlazada + ",size = " + enlazada.size());

        enlazada.addFirst(new Alumno("zeus", 6));
        enlazada.addLast(new Alumno("atena", 7));

        System.out.println(enlazada + ",size = " + enlazada.size());

        System.out.println("Primero = " + enlazada.getFirst()); // si no lo encuentra lanza una excepción
        System.out.println("Ultimo = " + enlazada.peekLast()); // si no lo encuentra retorna null
        System.out.println("Indice 2 = " + enlazada.get(2));


        // Alumno pato = enlazada.pop();
        Alumno pato = enlazada.removeFirst();// si no lo encuentra lanza una excepción
        Alumno pato2 = enlazada.poll(); // si no lo encuentra retorna null
        enlazada.removeLast();
        System.out.println("enlazada size = " + enlazada.size());


        enlazada.remove(new Alumno("camila", 2)); // elimina el primer elemento por defecto

        System.out.println("enlazada size = " + enlazada.size());

        Alumno lucas = new Alumno("Lucas", 5);
        enlazada.addLast(lucas);

        System.out.println("enlazada = " + enlazada);
        System.out.println("enlazada size = " + enlazada.size());
        System.out.println("Indice de lucas = " + enlazada.indexOf(lucas));

        enlazada.remove(3);

        System.out.println("enlazada = " + enlazada);

        enlazada.set(2, new Alumno("lalo", 7)); // remplazar por indice
        System.out.println("enlazada = " + enlazada);


        ListIterator<Alumno> li = enlazada.listIterator();

        System.out.println("====== Next ======");

        while(li.hasNext()){
            Alumno al = li.next();
            System.out.println(al);

        }

        System.out.println("====== Previous ======");

        while (li.hasPrevious()){
            Alumno al = li.previous();
            System.out.println(al);
        }

    }

}
