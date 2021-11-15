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

import com.example.demo.model.TypeAcces;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.UtilisateurService;

import dto.UtilisateurDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class UtilisateurControlleur {
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@PostMapping("/utilisateur")
	public Utilisateur save(@RequestBody Utilisateur utilisateur) {
		utilisateurService.saveOrUpdate(utilisateur);
		return utilisateur;
	}
	
	@GetMapping("/utilisateur")
	public Collection<UtilisateurDto> list(){
		return utilisateurService.getAllUtilisateur();
	}
	
	@GetMapping("/utilisateur/{id}")
	public UtilisateurDto getById(@PathVariable (value = "id") Long id) {
		return utilisateurService.getById(id);
		
	}
	
	@DeleteMapping("/utilisateur/{id}")
	public String deleteTypeAcces(@PathVariable (value = "id") Long id) {
		utilisateurService.deleteUtilisateur(id);
		return "delete succes idUtilisateur = " + id.toString();
	}
	
}
