package com.example.demo.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

import dto.ClientDto;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/clients")
	public Client save(@RequestBody Client client,BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
		//System.out.println("abcddd");
		if(client.getId()!=null) {
			bindingResult.addError(new FieldError("Client","code","Post error"));
			throw new MethodArgumentNotValidException(null, bindingResult);
		}
		System.out.println("abc");
		clientService.saveOrUpdate(client);
		System.out.println("abc1");
		return client;
	}
	
	@GetMapping("/clients")
	public Collection<ClientDto> list(){
		return clientService.getAllClient();
	}
	
	@GetMapping("/clients/{id}")
	public ClientDto getById(@PathVariable (value = "id") Long id) {
		return clientService.getById(id);
		
	}
	
	@DeleteMapping("/clients/{id}")
	public String deleteClient(@PathVariable (value = "id") Long id) {
		clientService.deleteClient(id);
		return "delete succes idClient = " + id.toString();
	}
}
