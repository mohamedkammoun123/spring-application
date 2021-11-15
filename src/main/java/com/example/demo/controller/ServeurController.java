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

import com.example.demo.model.Client;
import com.example.demo.model.Serveur;
import com.example.demo.service.ServeurService;

import dto.ServeurDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class ServeurController {
	@Autowired
	ServeurService serveurService;
	
	@PostMapping("/serveur")
	public Serveur save(@RequestBody Serveur serveur) {
		serveurService.saveOrUpdate(serveur);
		return serveur;
	}
	
	@GetMapping("/serveur")
	public Collection<ServeurDto> list(){
		System.out.println("Get is succes");
		return serveurService.getAllServeur();
	}
	
	@GetMapping("/serveur/{id}")
	public ServeurDto getById(@PathVariable (value = "id") Long id) {
		return serveurService.getById(id);
		
	}
	
	@DeleteMapping("/serveur/{id}")
	public String deleteClient(@PathVariable (value = "id") Long id) {
		serveurService.deleteServeur(id);
		return "delete succes idServeur = " + id.toString();
	}
}
