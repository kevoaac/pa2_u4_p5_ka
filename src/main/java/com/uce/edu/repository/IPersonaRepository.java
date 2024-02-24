package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Persona;

import java.util.List;

public interface IPersonaRepository {
    void insertar(Persona persona);
    void actualizar(Persona persona);
    Persona consultarPorCedula(String cedula);
    void eliminarPorCedula(String cedula);

    List<Persona> consultarTodos();
}
