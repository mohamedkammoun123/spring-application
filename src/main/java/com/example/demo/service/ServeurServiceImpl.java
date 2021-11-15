package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.ServeurRepository;
import com.example.demo.model.Serveur;

import dto.ServeurDto;
import factory.ServeurFactory;


@Service
@Transactional
public class ServeurServiceImpl implements ServeurService{
	@Autowired
	ServeurRepository serveurRepostory;
	
	@Override
	public Collection<ServeurDto> getAllServeur() {
		List<Serveur> serveurs = (List<Serveur>) serveurRepostory.findAll();
		return ServeurFactory.ServeursToServeurDtos(serveurs);
	}

	@Override
	public ServeurDto getById(Long idServeur) {
		Serveur serveur = serveurRepostory.findById(idServeur).get();
		return ServeurFactory.ServeurToServeurDto(serveur);
	}

	@Override
	public void saveOrUpdate(Serveur serveur) {
		serveurRepostory.save(serveur);
		
	}

	@Override
	public void deleteServeur(Long idServeur) {
		serveurRepostory.deleteById(idServeur);
		
	}

}
