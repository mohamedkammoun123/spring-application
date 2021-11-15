package com.example.demo.service;

import com.example.demo.model.Client;

import dto.ClientDto;

import java.util.Collection;


public interface ClientService {
	
	public Collection<ClientDto> getAllClient();
	
	public ClientDto getById(Long id);
	
	public void saveOrUpdate(Client client);
	
	public void deleteClient(Long id);
}
