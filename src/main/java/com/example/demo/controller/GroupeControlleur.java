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
import com.example.demo.model.Groupe;
import com.example.demo.service.GroupeService;

import dto.GroupeDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class GroupeControlleur {
	
	@Autowired
	GroupeService groupeService;
	
	@PostMapping("/groupes")
	public Groupe save(@RequestBody Groupe groupe) {
		groupeService.saveOrUpdate(groupe);
		System.out.println(groupe + "add");
		return groupe;
	}
	
	@GetMapping("/groupes")
	public Collection<GroupeDto> list(){
		return groupeService.getAllGroupes();
	}
	
	@GetMapping("/groupes/{id}")
	public GroupeDto getById(@PathVariable (value = "id") Long id) {
		System.out.println(groupeService.getById(id));
		return groupeService.getById(id);
		
	}
	
	@DeleteMapping("/groupe/{id}")
	public String deleteGroupe(@PathVariable (value = "id") Long id) {
		groupeService.deleteGroupe(id);
		return "delete succes idClient = " + id.toString();
	}
}
