package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Serveur;
import com.example.demo.model.TypeAcces;
import com.example.demo.service.TypeAccesService;

import dto.TypeAccesDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class TypeAccesControlleur {
	
	@Autowired
	TypeAccesService typeAccesService;
	
	@PostMapping("/saveTypeAcces")
	public TypeAcces save(@RequestBody TypeAcces typeAcces) {
		typeAccesService.saveOrUpdate(typeAcces);
		return typeAcces;
	}
	
	@GetMapping("/typeAcces")
	public Collection<TypeAccesDto> list(){
		return typeAccesService.getAllTypeAcces();
	}
	
	@GetMapping("/typeAcces/{id}")
	public TypeAccesDto getById(@PathVariable (value = "id") Long id) {
		return typeAccesService.getById(id);
		
	}
	
	@DeleteMapping("/typeAcces/{id}")
	public String deleteTypeAcces(@PathVariable (value = "id") Long id) {
		typeAccesService.deleteTypeAcces(id);
		return "delete succes idServeur = " + id.toString();
	}
	
}
