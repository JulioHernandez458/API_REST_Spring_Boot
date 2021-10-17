package com.dao;

import com.models.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonaDaoImp implements PersonaDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<Persona> obtenerPersonas() {
        String query = "FROM Persona";
        return entityManager.createQuery(query).getResultList();
    }
    
    @Override
    @Transactional
    public void registrar(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    @Transactional
    public void actualizar(Persona persona) {
        entityManager.merge(persona);
                //update(persona);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Persona usuario = entityManager.find(Persona.class, id);
        entityManager.remove(usuario);
    }

    @Override
    @Transactional
    public List<Persona> buscarPersona(Integer id) {
        String query = "FROM Persona WHERE id = :id";
        
        List<Persona> lista = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        
        return lista;
    }

}
