package com.sahfer.itisjapo.dao;

import com.googlecode.objectify.Key;
import com.sahfer.itisjapo.entity.Persona;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class PersonaDao {
    public void guardarPersona(Persona persona) {
        ofy().save().entity(persona).now();
    }

    public Persona getPersonaByID(String id) {
        Key key = Key.create(Persona.class, id);
        Persona entity = (Persona) ofy().load().key(key).now();
        return entity;
    }
}
