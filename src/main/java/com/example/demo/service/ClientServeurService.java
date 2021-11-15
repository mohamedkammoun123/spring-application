package com.example.demo.service;


import java.util.List;


import com.example.demo.model.UtilisateurServeur;



public interface ClientServeurService {
	
	public List<UtilisateurServeur> getAllClientServeur();
	
	public UtilisateurServeur getById(Long id);
	
	public void saveOrUpdate(UtilisateurServeur clientServeur);
	
	public void deleteClientServeur(Long id);
	
}
