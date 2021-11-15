package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.TypeAccesRepository;
import com.example.demo.model.TypeAcces;

import dto.TypeAccesDto;
import factory.TypeAccesFactory;

@Service
@Transactional
public class TypeAccesServiceImpl implements TypeAccesService {
	
	@Autowired
	TypeAccesRepository typeAccesRepostory;
	
	@Override
	public Collection<TypeAccesDto> getAllTypeAcces() {
		List<TypeAcces> typeAccess = (List<TypeAcces>) typeAccesRepostory.findAll();
		return TypeAccesFactory.typeAccessToTypeAccesDtos(typeAccess);
	}

	@Override
	public TypeAccesDto getById(Long idTypeAcces) {
		TypeAcces typeAcces = typeAccesRepostory.findById(idTypeAcces).get();
		return TypeAccesFactory.typeAccesToTypeAccesDto(typeAcces);
	}

	@Override
	public void saveOrUpdate(TypeAcces typeAcces) {
		// TODO Auto-generated method stub
		typeAccesRepostory.save(typeAcces);
		
	}

	@Override
	public void deleteTypeAcces(Long idTypeAcces) {
		// TODO Auto-generated method stub
		typeAccesRepostory.deleteById(idTypeAcces);
		
	}

}
