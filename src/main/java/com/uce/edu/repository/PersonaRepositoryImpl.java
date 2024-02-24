package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class PersonaRepositoryImpl implements IPersonaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public Persona consultarPorCedula(String cedula) {
        TypedQuery<Persona> myQuery = entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :cedula", Persona.class);
        myQuery.setParameter("cedula",cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.entityManager.remove(this.consultarPorCedula(cedula));
    }

    @Override
    public List<Persona> consultarTodos() {
        TypedQuery<Persona> myQuery = entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
        return myQuery.getResultList();
    }
}
