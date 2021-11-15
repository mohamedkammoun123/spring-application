package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.UtilisateurRepository;
import com.example.demo.model.Utilisateur;

import dto.UtilisateurDto;
import factory.UtilisateurFactory;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepostory;
	
	@Override
	public Collection<UtilisateurDto> getAllUtilisateur() {
		// TODO Auto-generated method stub
		List<Utilisateur>utilisateurs= (List<Utilisateur>) utilisateurRepostory.findAll();
		return UtilisateurFactory.UtilisateursToUtilisateurDtos(utilisateurs);
	}

	@Override
	public UtilisateurDto getById(Long id) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = utilisateurRepostory.findById(id).get();
		return UtilisateurFactory.UtilisateurToUtilisateurDto(utilisateur);
	}

	@Override
	public void saveOrUpdate(Utilisateur utilisateur) {
		utilisateurRepostory.save(utilisateur);
		
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepostory.deleteById(id);
		
	}

}
