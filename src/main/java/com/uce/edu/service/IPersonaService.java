package com.uce.edu.service;

import com.uce.edu.repository.modelo.Persona;

import java.util.List;

public interface IPersonaService {
    void guardar(Persona persona);
    void actualizar(Persona persona);
    Persona consultarPorCedula(String cedula);
    void borrarPorCedula(String cedula);

    List<Persona> consultarTodos();
}
