package com.example.demo.service;

import java.util.Collection;
import java.util.List;


import com.example.demo.model.Serveur;

import dto.ServeurDto;

public interface ServeurService {
	
public Collection<ServeurDto> getAllServeur();
	
	public ServeurDto getById(Long idServeur);
	
	public void saveOrUpdate(Serveur serveur);
	
	public void deleteServeur(Long idRegion);
}
