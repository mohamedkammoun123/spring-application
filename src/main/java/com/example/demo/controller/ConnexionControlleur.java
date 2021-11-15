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

import com.example.demo.model.Client;
import com.example.demo.model.Connexion;
import com.example.demo.service.ConnexionService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class ConnexionControlleur {
	
	@Autowired
	ConnexionService connexionService;
	
	@PostMapping("/connexion")
	public Connexion save(@RequestBody Connexion connexion) {
		connexionService.saveOrUpdate(connexion);
		return connexion;
	}
	
	@GetMapping("/connexion")
	public List<Connexion> list(){
		return connexionService.getAllConnexion();
	}
	
	@GetMapping("/connexion/{id}")
	public Connexion getById(@PathVariable (value = "id") Long id) {
		return connexionService.getById(id);
		
	}
	
	@DeleteMapping("/connexion/{id}")
	public String deleteConnexion(@PathVariable (value = "id") Long id) {
		connexionService.deleteConnexion(id);
		return "delete succes idConnexion = " + id.toString();
	}
}
