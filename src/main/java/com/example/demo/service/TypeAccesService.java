package com.example.demo.service;

import java.util.Collection;
import java.util.List;


import com.example.demo.model.TypeAcces;

import dto.TypeAccesDto;

public interface TypeAccesService {
	
	public Collection<TypeAccesDto> getAllTypeAcces();
	
	public TypeAccesDto getById(Long idTypeAcces);
	
	public void saveOrUpdate(TypeAcces typeAcces);
	
	public void deleteTypeAcces(Long idTypeAcces);
}
