package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Connexion;
public interface ConnexionService {

	public List<Connexion> getAllConnexion();
	
	public Connexion getById(Long id);
	
	public void saveOrUpdate(Connexion connexion);
	
	public void deleteConnexion(Long id);
}
