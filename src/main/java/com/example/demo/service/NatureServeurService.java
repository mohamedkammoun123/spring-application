package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import com.example.demo.model.NatureServeur;

import dto.NatureServeurDto;

public interface NatureServeurService {
	
	public Collection<NatureServeurDto> getAllNatureServeur();
	
	public NatureServeurDto getById(Long id);
	
	public void saveOrUpdate(NatureServeur natureServeur);
	
	public void deleteNatureServeur(Long id);
}
