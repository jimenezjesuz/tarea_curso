/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service.impl;

import com.jekade.repo.IGenericRepo;
import com.jekade.service.ICRUD;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> listar() {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T registrar(T obj) {
        return getRepo().save(obj);
    }

    @Override
    public T modificar(T obj) {
        return getRepo().save(obj);
    }

    @Override
    public void eliminar(ID id) {
        getRepo().deleteById(id);
    }

}
