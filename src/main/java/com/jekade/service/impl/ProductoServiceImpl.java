/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service.impl;

import com.jekade.model.Persona;
import com.jekade.model.Producto;
import com.jekade.repo.IGenericRepo;
import com.jekade.repo.IProductoRepo;
import com.jekade.service.IProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solucionesit
 */
@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    @Autowired
    private IProductoRepo repo;

   @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }

}
