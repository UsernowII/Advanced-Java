package org.jsantos.optional.ejemplo.repositorio;

import org.jsantos.optional.ejemplo.models.Computador;
import org.jsantos.optional.ejemplo.models.Fabricante;
import org.jsantos.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{

    private List<Computador> dataSource ;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("Ryzen9-9800", new Fabricante("AMD"));
        Computador asus = new Computador("Asus", "G5002");
        asus.setProcesador(proc);

        dataSource.add(asus);
        dataSource.add(new Computador("MackBook Pro", "MVVKJ24"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream()
                .filter(pc -> pc.getNombre().toLowerCase().contains(nombre.toLowerCase() ))
                .findFirst();
        /*for (Computador c : dataSource) {
            if (c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }

        return Optional.empty();

         */
    }
}
