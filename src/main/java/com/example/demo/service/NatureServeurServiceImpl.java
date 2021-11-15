package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.NatureServeurRepository;
import com.example.demo.model.NatureServeur;

import dto.NatureServeurDto;
import factory.NatureServeurFactory;

@Service
@Transactional
public class NatureServeurServiceImpl implements NatureServeurService{
	@Autowired
	NatureServeurRepository natureServeurRepostory;

	@Override
	public Collection<NatureServeurDto> getAllNatureServeur() {
		List<NatureServeur> natureServeurs = (List<NatureServeur>) natureServeurRepostory.findAll();
		return NatureServeurFactory.natureServeursToNatureServeurDtos(natureServeurs);
	}

	@Override
	public NatureServeurDto getById(Long id) {
		NatureServeur natureServeur = natureServeurRepostory.findById(id).get();
		return NatureServeurFactory.natureServeurToNatureServeurDto(natureServeur);
	}

	@Override
	public void saveOrUpdate(NatureServeur natureServeur) {
		natureServeurRepostory.save(natureServeur);
		
	}

	@Override
	public void deleteNatureServeur(Long id) {
		natureServeurRepostory.deleteById(id);
		
	}

}
