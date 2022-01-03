package org.jsantos.api.stream.ejemplos.ejercicios;

public class Ejercicio4Producto {

    private int cantidad;
    private double precio;

    public Ejercicio4Producto(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
