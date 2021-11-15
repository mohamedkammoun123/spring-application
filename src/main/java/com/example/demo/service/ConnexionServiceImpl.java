package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.ConnexionRepository;
import com.example.demo.model.Connexion;

@Service
@Transactional
public class ConnexionServiceImpl implements ConnexionService {
	@Autowired
	ConnexionRepository connexionRepostory;
	@Override
	public List<Connexion> getAllConnexion() {
		// TODO Auto-generated method stub
		return (List<Connexion>) connexionRepostory.findAll() ;
	}

	@Override
	public Connexion getById(Long id) {
		// TODO Auto-generated method stub
		return connexionRepostory.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Connexion connexion) {
		connexionRepostory.save(connexion);
		
	}

	@Override
	public void deleteConnexion(Long id) {
		connexionRepostory.deleteById(id);
		
	}

}
