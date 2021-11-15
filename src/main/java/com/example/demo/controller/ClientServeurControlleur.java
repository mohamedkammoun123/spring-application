package com.example.demo.controller;

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

import com.example.demo.model.UtilisateurServeur;
import com.example.demo.service.ClientServeurService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class ClientServeurControlleur {
	@Autowired
	ClientServeurService clientServeurService;
	
	@PostMapping("/ClientServeur")
	public UtilisateurServeur save(@RequestBody UtilisateurServeur ClientServeur) {
		clientServeurService.saveOrUpdate(ClientServeur);
		return ClientServeur;
	}
	
	@GetMapping("/ClientServeur")
	public List<UtilisateurServeur> list(){
		return clientServeurService.getAllClientServeur();
	}
	
	@GetMapping("/ClientServeur/{id}")
	public UtilisateurServeur getById(@PathVariable (value = "id") Long id) {
		return clientServeurService.getById(id);
		
	}
	
	@DeleteMapping("/ClientServeur/{id}")
	public String deleteClientServeur(@PathVariable (value = "id") Long id) {
		clientServeurService.deleteClientServeur(id);
		return "delete succes idClientServeur = " + id.toString();
	}
	
}
