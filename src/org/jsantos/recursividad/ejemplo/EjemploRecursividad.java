package org.jsantos.recursividad.ejemplo;

import org.jsantos.recursividad.ejemplo.model.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {

    public static void main(String[] args) {

        Componente pc = new Componente("Gabinete PC ATX");
        Componente fuente = new Componente("Fuente de poder 750w");
        Componente motherBoard = new Componente("Board ATX Asus");
        Componente cpu = new Componente("Ryzen 5600x");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador Stock");
        Componente tarjetaVideo = new Componente("RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia Gpu RTX");
        Componente gpuRam1 = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32 GB");
        Componente ssd = new Componente("Disco SSD 1t");


        cpu.addComponente(ventilador)
                .addComponente(disipador);

        tarjetaVideo.addComponente(gpu)
                .addComponente(gpuRam1)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);

        motherBoard.addComponente(cpu)
                .addComponente(tarjetaVideo)
                .addComponente(ram)
                .addComponente(ssd);

        pc.addComponente(fuente)
                .addComponente(motherBoard)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));


        //metodoRecursivo(pc, 0);
        metodoRecursivoJava8(pc, 0).forEach( c -> {
            System.out.println("\t".repeat(c.getNivel()) + c.getNombre());
        });
    }



    public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(Stream.of(c),
            c.getHijos().stream().flatMap(hijo ->metodoRecursivoJava8(hijo, nivel +1)));


    }


    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("\t".repeat(nivel) +c.getNombre());
        if (c.tieneHijos()){
            for (Componente hijo: c.getHijos()) {
                metodoRecursivo(hijo, nivel +1);
            }
        }
    }
}
