package com.uce.edu.service;

import com.uce.edu.repository.IPersonaRepository;
import com.uce.edu.repository.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{
    @Autowired
    private IPersonaRepository iPersonaRepository;
    @Override
    public void guardar(Persona persona) {
        this.iPersonaRepository.insertar(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.iPersonaRepository.actualizar(persona);
    }

    @Override
    public Persona consultarPorCedula(String cedula) {
        return this.iPersonaRepository.consultarPorCedula(cedula);
    }

    @Override
    public void borrarPorCedula(String cedula) {
        this.iPersonaRepository.eliminarPorCedula(cedula);
    }

    @Override
    public List<Persona> consultarTodos() {
        return this.iPersonaRepository.consultarTodos();
    }
}
