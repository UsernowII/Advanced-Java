package org.jsantos.hilos.ejercicio;

import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;


    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        //segun el tipo hace una u otra cosa
        try{
            switch (tipo) {
                case LETRA: {
                    for (char letter = 'A'; letter <= 'Z'; ++letter) {
                        System.out.println(letter);

                    }
                }

                case NUMERO: {
                    for (int i = 1; i < 10; i++) {
                        System.out.println(i);
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
