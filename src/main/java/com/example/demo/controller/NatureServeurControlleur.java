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

import com.example.demo.model.NatureClient;
import com.example.demo.model.NatureServeur;
import com.example.demo.service.NatureClientService;
import com.example.demo.service.NatureServeurService;

import dto.NatureServeurDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class NatureServeurControlleur {
	
	@Autowired
	NatureServeurService natureServeurService;
	
	@PostMapping("/natureServeur")
	public NatureServeur save(@RequestBody NatureServeur natureServeur) {
		natureServeurService.saveOrUpdate(natureServeur);
		return natureServeur;
	}
	
	@GetMapping("/natureServeur")
	public Collection<NatureServeurDto> list(){
		return natureServeurService.getAllNatureServeur();
	}
	
	@GetMapping("/natureServeur/{id}")
	public NatureServeurDto getById(@PathVariable (value = "id") Long id) {
		return natureServeurService.getById(id);
		
	}
	
	@DeleteMapping("/natureServeur/{id}")
	public String deleteNatureServeur(@PathVariable (value = "id") Long id) {
		natureServeurService.deleteNatureServeur(id);
		return "delete succes idNatureServeur = " + id.toString();
	}
}
