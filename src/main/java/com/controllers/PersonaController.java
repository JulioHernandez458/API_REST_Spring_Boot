package com.controllers;

import com.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.dao.PersonaDao;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;


    @RequestMapping(value = "api/personas", method = RequestMethod.GET)
    public List<Persona> getPersonas() {
        return personaDao.obtenerPersonas();
    }

    
    @RequestMapping(value = "api/personas", method = RequestMethod.POST)
    public void registrarPersona(@RequestBody Persona persona) {
        personaDao.registrar(persona);
    }
    
    @RequestMapping(value = "api/personas/{id}", method = RequestMethod.PUT)
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona persona) {
        List<Persona> personaEncontrada = personaDao.buscarPersona(id);
        if(personaEncontrada.isEmpty()){
            return null;
        }else{
            persona.setId( personaEncontrada.get(0).getId() );
            personaDao.actualizar(persona);
            return persona;   
        }
        
    }

    @RequestMapping(value = "api/personas/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Integer id) {
       personaDao.eliminar(id);
    }
    
    @RequestMapping(value = "api/personas/{id}", method = RequestMethod.GET)
    public List<Persona> buscarPersona(@PathVariable Integer id) {
        return personaDao.buscarPersona(id);
    }

}
