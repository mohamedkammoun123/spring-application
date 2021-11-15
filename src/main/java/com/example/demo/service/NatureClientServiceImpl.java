package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.NatureClientRepository;
import com.example.demo.model.NatureClient;

import dto.NatureClientDto;
import factory.NatureClientFactory;


@Service
@Transactional
public class NatureClientServiceImpl implements NatureClientService {
	
	@Autowired
	NatureClientRepository natureClientRepostory;

	@Override
	public Collection<NatureClientDto> getAllNatureClient() {
		List<NatureClient> natureClients = (List<NatureClient>) natureClientRepostory.findAll();
		return NatureClientFactory.NatureClientsToNatureClientDtos(natureClients);
	}

	@Override
	public NatureClientDto getById(Long id) {
		NatureClient natureClient=natureClientRepostory.findById(id).get();
		return NatureClientFactory.NatureClientToNatureClientDto(natureClient);
	}

	@Override
	public void saveOrUpdate(NatureClient natureClient) {
		natureClientRepostory.save(natureClient);
		
	}

	@Override
	public void deleteNatureClient(Long id) {
		natureClientRepostory.deleteById(id);
		
	}

}
