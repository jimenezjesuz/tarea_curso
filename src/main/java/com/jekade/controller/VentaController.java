/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.controller;

import com.jekade.exception.ModeloNotFoundException;
import com.jekade.model.Venta;
import com.jekade.service.IVentaService;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody Venta venta) throws Exception {
        Venta obj = service.registrar(venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> listarPorId(@PathVariable Integer id) throws Exception {
        Venta obj = service.listarPorId(id);

        if (obj == null) {
            throw new ModeloNotFoundException("ID VENTA NO ENCONTRADO: " + id);
        }

        return new ResponseEntity<Venta>(obj, HttpStatus.OK);
    }

}
