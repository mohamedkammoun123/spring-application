package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.ClientServeurRepository;
import com.example.demo.model.UtilisateurServeur;

@Service
@Transactional
public class ClientServeurServiceImpl implements ClientServeurService {
	@Autowired
	ClientServeurRepository clientServeurRepository;

	@Override
	public List<UtilisateurServeur> getAllClientServeur() {
		// TODO Auto-generated method stub
		return (List<UtilisateurServeur>) clientServeurRepository.findAll() ;
	}

	@Override
	public UtilisateurServeur getById(Long id) {
		// TODO Auto-generated method stub
		return clientServeurRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(UtilisateurServeur clientServeur) {
		// TODO Auto-generated method stub
		clientServeurRepository.save(clientServeur);
		
	}

	@Override
	public void deleteClientServeur(Long id) {
		clientServeurRepository.deleteById(id);
		
	}

}
