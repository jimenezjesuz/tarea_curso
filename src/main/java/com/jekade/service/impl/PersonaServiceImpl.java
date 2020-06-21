/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service.impl;

import com.jekade.model.Persona;
import com.jekade.repo.IGenericRepo;
import com.jekade.repo.IPersonaRepo;
import com.jekade.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solucionesit
 */
@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return repo;
    }

}
