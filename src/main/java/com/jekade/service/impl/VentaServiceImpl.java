/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.service.impl;

import com.jekade.model.Venta;
import com.jekade.repo.IVentaRepo;
import com.jekade.service.IVentaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solucionesit
 */
@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepo repo;

    @Override
    public Venta listarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Venta registrar(Venta venta) throws Exception {
        venta.getDetalleVentaList().forEach(det -> det.setIdVenta(venta));
        return repo.save(venta);
    }


}
