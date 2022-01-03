package org.jsantos.optional.ejemplo.repositorio;

import org.jsantos.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {

    Optional<Computador> filtrar (String nombre);
}
