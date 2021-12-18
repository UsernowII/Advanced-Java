package org.jsantos.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

    private String nombre;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombre + " " + nota;
    }


    //interfaz coimparable implementa el metodo compare to
    @Override
    public int compareTo(Alumno a) {
        /*if(this.nombre == null){
            return 0;
        }
        return this.nombre.compareTo(a.nombre);*/

        if(this.nota == a.nota){
            return 0;
        }

        if(this.nota > a.nota) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) &&
                Objects.equals(nota, alumno.nota);
    }


    //representacion del objeto en un objeto de tipo entero
    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
