package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.GroupeRepository;
import com.example.demo.model.Groupe;

import dto.GroupeDto;
import factory.GroupeFactory;

@Service
@Transactional
public class GroupeServiceImpl implements GroupeService {
	
	@Autowired
	GroupeRepository groupeRepository;
	
	@Override
	public Collection<GroupeDto> getAllGroupes() {
		List<Groupe> groupes = (List<Groupe>) groupeRepository.findAll();
		return GroupeFactory.groupesToGroupeDtos(groupes);
	}

	@Override
	public GroupeDto getById(Long id) {
		Groupe groupe = groupeRepository.findById(id).get();
		return GroupeFactory.groupeToGroupeDto(groupe);
	}

	@Override
	public void saveOrUpdate(Groupe groupe) {
		// TODO Auto-generated method stub
		groupeRepository.save(groupe);
	}

	@Override
	public void deleteGroupe(Long id) {
		// TODO Auto-generated method stub
		groupeRepository.deleteById(id);
		
	}

}
