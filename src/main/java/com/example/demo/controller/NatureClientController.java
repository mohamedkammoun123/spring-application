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
import com.example.demo.service.NatureClientService;

import dto.NatureClientDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class NatureClientController {
	@Autowired
	NatureClientService natureClientService;
	
	@PostMapping("/natureClient")
	public NatureClient save(@RequestBody NatureClient natureClient) {
		natureClientService.saveOrUpdate(natureClient);
		return natureClient;
	}
	
	@GetMapping("/natureClient")
	public Collection<NatureClientDto> list(){
		return natureClientService.getAllNatureClient();
	}
	
	@GetMapping("/natureClient/{id}")
	public NatureClientDto getById(@PathVariable (value = "id") Long id) {
		return natureClientService.getById(id);
		
	}
	
	@DeleteMapping("/natureClient/{id}")
	public String deleteNatureClient(@PathVariable (value = "id") Long id) {
		natureClientService.deleteNatureClient(id);
		return "delete succes idNatureClient = " + id.toString();
	}
}
