package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.model.Client;

import dto.ClientDto;
import factory.ClientFactory;



@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepostory;
	
	@Override
	public Collection<ClientDto> getAllClient() {
		List<Client> clients =(List<Client>) clientRepostory.findAll();
		return ClientFactory.clientsToClientDtos(clients);
		
	}

	@Override
	public ClientDto getById(Long id) {
		Client client=clientRepostory.findById(id).get();
		return ClientFactory.clientToClientDto(client);
	}

	@Override
	public void saveOrUpdate(Client etudiant) {
		clientRepostory.save(etudiant);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepostory.deleteById(id);
		
	}
	
	
	
}
