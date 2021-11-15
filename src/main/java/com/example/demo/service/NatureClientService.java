package com.example.demo.service;

import java.util.Collection;
import java.util.List;


import com.example.demo.model.NatureClient;

import dto.NatureClientDto;

public interface NatureClientService {
	
	public Collection<NatureClientDto> getAllNatureClient();
	
	public NatureClientDto getById(Long id);
	
	public void saveOrUpdate(NatureClient natureClient);
	
	public void deleteNatureClient(Long id);
}
