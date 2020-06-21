/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service;

import com.jekade.model.Venta;

/**
 *
 * @author solucionesit
 */
public interface IVentaService {

    Venta listarPorId(Integer id);

    Venta registrar(Venta venta) throws Exception;

}
