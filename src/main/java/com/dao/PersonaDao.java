package com.dao;

import com.models.Persona;

import java.util.List;

public interface PersonaDao {

    List<Persona> obtenerPersonas();
    
    void registrar(Persona persona);

    void actualizar(Persona persona);

    void eliminar(Integer id);

    List<Persona> buscarPersona(Integer id);
}
