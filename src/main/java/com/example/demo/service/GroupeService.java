package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import com.example.demo.model.Groupe;

import dto.GroupeDto;

public interface GroupeService {
	
public Collection<GroupeDto> getAllGroupes();
	
	public GroupeDto getById(Long id);
	
	public void saveOrUpdate(Groupe groupe);
	
	public void deleteGroupe(Long id);
}
