/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jekade.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jekade.exception.ModeloNotFoundException;
import com.jekade.model.Persona;
import com.jekade.service.IPersonaService;

/**
 *
 * @author solucionesit
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception {
		List<Persona> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable Integer id) {
		Persona p = service.listarPorId(id);
		if (p == null) {
			throw new ModeloNotFoundException("No existe persona con este id:" + id);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registra(@RequestBody Persona persona) throws Exception {
		Persona obj = service.registrar(persona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Persona> modificar(@RequestBody Persona persona) throws Exception {
		Persona obj = service.modificar(persona);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Persona obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
