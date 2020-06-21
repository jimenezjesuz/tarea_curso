/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service;

import java.util.List;

/**
 *
 * @author solucionesit
 * @param <T>
 * @param <ID>
 */
public interface ICRUD<T, ID> {

    List<T> listar();

    T listarPorId(ID id);

    T registrar(T obj);

    T modificar(T obj);

    void eliminar(ID id);
}
